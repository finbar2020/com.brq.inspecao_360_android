package com.mapbox.mapboxsdk.camera;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mapbox.mapboxsdk.camera.CameraPosition.Builder;
import com.mapbox.mapboxsdk.maps.MapboxMap;

final class CameraUpdateFactory$ZoomUpdate implements CameraUpdate {
   static final int ZOOM_BY = 2;
   static final int ZOOM_IN = 0;
   static final int ZOOM_OUT = 1;
   static final int ZOOM_TO = 3;
   static final int ZOOM_TO_POINT = 4;
   private final int type;
   private float x;
   private float y;
   private final double zoom;

   CameraUpdateFactory$ZoomUpdate(double var1, float var3, float var4) {
      this.type = 4;
      this.zoom = var1;
      this.x = var3;
      this.y = var4;
   }

   CameraUpdateFactory$ZoomUpdate(int var1) {
      this.type = var1;
      this.zoom = 0.0D;
   }

   CameraUpdateFactory$ZoomUpdate(int var1, double var2) {
      this.type = var1;
      this.zoom = var2;
   }

   public boolean equals(@Nullable Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null) {
         if (this.getClass() != var1.getClass()) {
            return false;
         } else {
            CameraUpdateFactory$ZoomUpdate var2 = (CameraUpdateFactory$ZoomUpdate)var1;
            if (this.type != var2.type) {
               return false;
            } else if (Double.compare(var2.zoom, this.zoom) != 0) {
               return false;
            } else if (Float.compare(var2.x, this.x) != 0) {
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
      CameraPosition var2 = var1.getCameraPosition();
      return this.getType() != 4 ? (new Builder(var2)).zoom(this.transformZoom(var2.zoom)).build() : (new Builder(var2)).zoom(this.transformZoom(var2.zoom)).target(var1.getProjection().fromScreenLocation(new PointF(this.getX(), this.getY()))).build();
   }

   public int getType() {
      return this.type;
   }

   public float getX() {
      return this.x;
   }

   public float getY() {
      return this.y;
   }

   public double getZoom() {
      return this.zoom;
   }

   public int hashCode() {
      int var1 = this.type;
      long var2 = Double.doubleToLongBits(this.zoom);
      int var4 = 31 * (var1 * 31 + (int)(var2 ^ var2 >>> 32));
      float var5 = this.x;
      int var6;
      if (var5 != 0.0F) {
         var6 = Float.floatToIntBits(var5);
      } else {
         var6 = 0;
      }

      int var7 = 31 * (var4 + var6);
      float var8 = this.y;
      float var11;
      int var9 = (var11 = var8 - 0.0F) == 0.0F ? 0 : (var11 < 0.0F ? -1 : 1);
      int var10 = 0;
      if (var9 != 0) {
         var10 = Float.floatToIntBits(var8);
      }

      return var7 + var10;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("ZoomUpdate{type=");
      var1.append(this.type);
      var1.append(", zoom=");
      var1.append(this.zoom);
      var1.append(", x=");
      var1.append(this.x);
      var1.append(", y=");
      var1.append(this.y);
      var1.append('}');
      return var1.toString();
   }

   double transformZoom(double var1) {
      int var3 = this.getType();
      double var4;
      if (var3 != 0) {
         if (var3 != 1) {
            double var6;
            if (var3 != 2) {
               if (var3 == 3) {
                  return this.getZoom();
               }

               if (var3 != 4) {
                  return var1;
               }

               var6 = this.getZoom();
            } else {
               var6 = this.getZoom();
            }

            return var1 + var6;
         }

         var4 = var1 - 1.0D;
         if (var4 < 0.0D) {
            return 0.0D;
         }
      } else {
         var4 = var1 + 1.0D;
      }

      return var4;
   }
}
