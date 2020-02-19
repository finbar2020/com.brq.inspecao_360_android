package com.mapbox.mapboxsdk.camera;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mapbox.mapboxsdk.camera.CameraPosition.Builder;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Projection;
import com.mapbox.mapboxsdk.maps.UiSettings;

final class CameraUpdateFactory$CameraMoveUpdate implements CameraUpdate {
   private float x;
   private float y;

   CameraUpdateFactory$CameraMoveUpdate(float var1, float var2) {
      this.x = var1;
      this.y = var2;
   }

   public boolean equals(@Nullable Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null) {
         if (this.getClass() != var1.getClass()) {
            return false;
         } else {
            CameraUpdateFactory$CameraMoveUpdate var2 = (CameraUpdateFactory$CameraMoveUpdate)var1;
            if (Float.compare(var2.x, this.x) != 0) {
               return false;
            } else {
               return Float.compare(var2.y, this.y) == 0;
            }
         }
      } else {
         return false;
      }
   }

   public CameraPosition getCameraPosition(@NonNull MapboxMap var1) {
      UiSettings var2 = var1.getUiSettings();
      Projection var3 = var1.getProjection();
      float var4 = var2.getWidth();
      float var5 = var2.getHeight();
      int[] var6 = var1.getPadding();
      LatLng var7 = var3.fromScreenLocation(new PointF((var4 - (float)var6[0] + (float)var6[1]) / 2.0F + this.x, (var5 + (float)var6[1] - (float)var6[3]) / 2.0F + this.y));
      CameraPosition var8 = var1.getCameraPosition();
      return (new Builder()).target(var7).zoom(var8.zoom).tilt(var8.tilt).bearing(var8.bearing).build();
   }

   public int hashCode() {
      float var1 = this.x;
      int var2;
      if (var1 != 0.0F) {
         var2 = Float.floatToIntBits(var1);
      } else {
         var2 = 0;
      }

      int var3 = var2 * 31;
      float var4 = this.y;
      float var7;
      int var5 = (var7 = var4 - 0.0F) == 0.0F ? 0 : (var7 < 0.0F ? -1 : 1);
      int var6 = 0;
      if (var5 != 0) {
         var6 = Float.floatToIntBits(var4);
      }

      return var3 + var6;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("CameraMoveUpdate{x=");
      var1.append(this.x);
      var1.append(", y=");
      var1.append(this.y);
      var1.append('}');
      return var1.toString();
   }
}
