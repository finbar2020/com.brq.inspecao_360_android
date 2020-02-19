package com.mapbox.mapboxsdk.location;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import com.mapbox.mapboxsdk.log.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class LocationComponentCompassEngine implements CompassEngine, SensorEventListener {
   private static final float ALPHA = 0.45F;
   static final int SENSOR_DELAY_MICROS = 100000;
   private static final String TAG = "Mbgl-LocationComponentCompassEngine";
   private final List compassListeners = new ArrayList();
   @Nullable
   private Sensor compassSensor;
   private long compassUpdateNextTimestamp;
   @Nullable
   private Sensor gravitySensor;
   @Nullable
   private float[] gravityValues = new float[3];
   private int lastAccuracySensorStatus;
   private float lastHeading;
   @Nullable
   private Sensor magneticFieldSensor;
   @Nullable
   private float[] magneticValues = new float[3];
   @NonNull
   private float[] rotationMatrix = new float[9];
   private float[] rotationVectorValue;
   @NonNull
   private final SensorManager sensorManager;
   @NonNull
   private float[] truncatedRotationVectorValue = new float[4];
   @NonNull
   private final WindowManager windowManager;

   LocationComponentCompassEngine(@NonNull WindowManager var1, @NonNull SensorManager var2) {
      this.windowManager = var1;
      this.sensorManager = var2;
      this.compassSensor = var2.getDefaultSensor(11);
      if (this.compassSensor == null) {
         if (this.isGyroscopeAvailable()) {
            Logger.d("Mbgl-LocationComponentCompassEngine", "Rotation vector sensor not supported on device, falling back to orientation.");
            this.compassSensor = var2.getDefaultSensor(3);
            return;
         }

         Logger.d("Mbgl-LocationComponentCompassEngine", "Rotation vector sensor not supported on device, falling back to accelerometer and magnetic field.");
         this.gravitySensor = var2.getDefaultSensor(1);
         this.magneticFieldSensor = var2.getDefaultSensor(2);
      }

   }

   @NonNull
   private float[] getRotationVectorFromSensorEvent(@NonNull SensorEvent var1) {
      if (var1.values.length > 4) {
         System.arraycopy(var1.values, 0, this.truncatedRotationVectorValue, 0, 4);
         return this.truncatedRotationVectorValue;
      } else {
         return var1.values;
      }
   }

   private boolean isCompassSensorAvailable() {
      return this.compassSensor != null;
   }

   private boolean isGyroscopeAvailable() {
      return this.sensorManager.getDefaultSensor(4) != null;
   }

   @NonNull
   private float[] lowPassFilter(@NonNull float[] var1, @Nullable float[] var2) {
      if (var2 == null) {
         return var1;
      } else {
         for(int var3 = 0; var3 < var1.length; ++var3) {
            var2[var3] += 0.45F * (var1[var3] - var2[var3]);
         }

         return var2;
      }
   }

   private void notifyCompassChangeListeners(float var1) {
      Iterator var2 = this.compassListeners.iterator();

      while(var2.hasNext()) {
         ((CompassListener)var2.next()).onCompassChanged(var1);
      }

      this.lastHeading = var1;
   }

   private void registerSensorListeners() {
      if (this.isCompassSensorAvailable()) {
         this.sensorManager.registerListener(this, this.compassSensor, 100000);
      } else {
         this.sensorManager.registerListener(this, this.gravitySensor, 100000);
         this.sensorManager.registerListener(this, this.magneticFieldSensor, 100000);
      }
   }

   private void unregisterSensorListeners() {
      if (this.isCompassSensorAvailable()) {
         this.sensorManager.unregisterListener(this, this.compassSensor);
      } else {
         this.sensorManager.unregisterListener(this, this.gravitySensor);
         this.sensorManager.unregisterListener(this, this.magneticFieldSensor);
      }
   }

   private void updateOrientation() {
      float[] var1 = this.rotationVectorValue;
      if (var1 != null) {
         SensorManager.getRotationMatrixFromVector(this.rotationMatrix, var1);
      } else {
         SensorManager.getRotationMatrix(this.rotationMatrix, (float[])null, this.gravityValues, this.magneticValues);
      }

      int var3 = this.windowManager.getDefaultDisplay().getRotation();
      short var4 = 131;
      short var5 = 129;
      if (var3 != 1) {
         if (var3 != 2) {
            if (var3 != 3) {
               var4 = 1;
               var5 = 3;
            } else {
               var5 = 1;
            }
         } else {
            var4 = 129;
            var5 = 131;
         }
      } else {
         var4 = 3;
      }

      float[] var6 = new float[9];
      SensorManager.remapCoordinateSystem(this.rotationMatrix, var4, var5, var6);
      float[] var8 = new float[3];
      SensorManager.getOrientation(var6, var8);
      this.notifyCompassChangeListeners((float)Math.toDegrees((double)var8[0]));
   }

   public void addCompassListener(@NonNull CompassListener var1) {
      if (this.compassListeners.isEmpty()) {
         this.registerSensorListeners();
      }

      this.compassListeners.add(var1);
   }

   public int getLastAccuracySensorStatus() {
      return this.lastAccuracySensorStatus;
   }

   public float getLastHeading() {
      return this.lastHeading;
   }

   public void onAccuracyChanged(Sensor var1, int var2) {
      if (this.lastAccuracySensorStatus != var2) {
         Iterator var3 = this.compassListeners.iterator();

         while(var3.hasNext()) {
            ((CompassListener)var3.next()).onCompassAccuracyChange(var2);
         }

         this.lastAccuracySensorStatus = var2;
      }

   }

   public void onSensorChanged(@NonNull SensorEvent var1) {
      long var2 = SystemClock.elapsedRealtime();
      if (var2 >= this.compassUpdateNextTimestamp) {
         if (this.lastAccuracySensorStatus == 0) {
            Logger.d("Mbgl-LocationComponentCompassEngine", "Compass sensor is unreliable, device calibration is needed.");
         } else {
            if (var1.sensor.getType() == 11) {
               this.rotationVectorValue = this.getRotationVectorFromSensorEvent(var1);
               this.updateOrientation();
            } else if (var1.sensor.getType() == 3) {
               this.notifyCompassChangeListeners((360.0F + var1.values[0]) % 360.0F);
            } else if (var1.sensor.getType() == 1) {
               this.gravityValues = this.lowPassFilter(this.getRotationVectorFromSensorEvent(var1), this.gravityValues);
               this.updateOrientation();
            } else if (var1.sensor.getType() == 2) {
               this.magneticValues = this.lowPassFilter(this.getRotationVectorFromSensorEvent(var1), this.magneticValues);
               this.updateOrientation();
            }

            this.compassUpdateNextTimestamp = var2 + 500L;
         }
      }
   }

   public void removeCompassListener(@NonNull CompassListener var1) {
      this.compassListeners.remove(var1);
      if (this.compassListeners.isEmpty()) {
         this.unregisterSensorListeners();
      }

   }
}
