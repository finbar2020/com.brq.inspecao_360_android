package com.mapbox.mapboxsdk.camera;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mapbox.mapboxsdk.camera.CameraPosition.Builder;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapboxMap;

final class CameraUpdateFactory$CameraPositionUpdate implements CameraUpdate {
   private final double bearing;
   private final LatLng target;
   private final double tilt;
   private final double zoom;

   CameraUpdateFactory$CameraPositionUpdate(double var1, LatLng var3, double var4, double var6) {
      this.bearing = var1;
      this.target = var3;
      this.tilt = var4;
      this.zoom = var6;
   }

   public boolean equals(@Nullable Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null) {
         if (this.getClass() != var1.getClass()) {
            return false;
         } else {
            CameraUpdateFactory$CameraPositionUpdate var2 = (CameraUpdateFactory$CameraPositionUpdate)var1;
            if (Double.compare(var2.bearing, this.bearing) != 0) {
               return false;
            } else if (Double.compare(var2.tilt, this.tilt) != 0) {
               return false;
            } else if (Double.compare(var2.zoom, this.zoom) != 0) {
               return false;
            } else {
               LatLng var3 = this.target;
               if (var3 != null) {
                  return var3.equals(var2.target);
               } else {
                  return var2.target == null;
               }
            }
         }
      } else {
         return false;
      }
   }

   public double getBearing() {
      return this.bearing;
   }

   public CameraPosition getCameraPosition(@NonNull MapboxMap var1) {
      CameraPosition var2 = var1.getCameraPosition();
      return this.target == null ? (new Builder(this)).target(var2.target).build() : (new Builder(this)).build();
   }

   public LatLng getTarget() {
      return this.target;
   }

   public double getTilt() {
      return this.tilt;
   }

   public double getZoom() {
      return this.zoom;
   }

   public int hashCode() {
      long var1 = Double.doubleToLongBits(this.bearing);
      int var3 = 31 * (int)(var1 ^ var1 >>> 32);
      LatLng var4 = this.target;
      int var5;
      if (var4 != null) {
         var5 = var4.hashCode();
      } else {
         var5 = 0;
      }

      int var6 = var3 + var5;
      long var7 = Double.doubleToLongBits(this.tilt);
      int var9 = var6 * 31 + (int)(var7 ^ var7 >>> 32);
      long var10 = Double.doubleToLongBits(this.zoom);
      return var9 * 31 + (int)(var10 ^ var10 >>> 32);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("CameraPositionUpdate{bearing=");
      var1.append(this.bearing);
      var1.append(", target=");
      var1.append(this.target);
      var1.append(", tilt=");
      var1.append(this.tilt);
      var1.append(", zoom=");
      var1.append(this.zoom);
      var1.append('}');
      return var1.toString();
   }
}
