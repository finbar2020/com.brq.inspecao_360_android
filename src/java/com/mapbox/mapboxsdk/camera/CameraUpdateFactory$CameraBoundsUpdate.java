package com.mapbox.mapboxsdk.camera;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import java.util.Arrays;

final class CameraUpdateFactory$CameraBoundsUpdate implements CameraUpdate {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final Double bearing;
   private final LatLngBounds bounds;
   private final int[] padding;
   private final Double tilt;

   CameraUpdateFactory$CameraBoundsUpdate(LatLngBounds var1, Double var2, Double var3, int var4, int var5, int var6, int var7) {
      this(var1, var2, var3, new int[]{var4, var5, var6, var7});
   }

   CameraUpdateFactory$CameraBoundsUpdate(LatLngBounds var1, Double var2, Double var3, int[] var4) {
      this.bounds = var1;
      this.padding = var4;
      this.bearing = var2;
      this.tilt = var3;
   }

   public boolean equals(@Nullable Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null) {
         if (this.getClass() != var1.getClass()) {
            return false;
         } else {
            CameraUpdateFactory$CameraBoundsUpdate var2 = (CameraUpdateFactory$CameraBoundsUpdate)var1;
            return !this.bounds.equals(var2.bounds) ? false : Arrays.equals(this.padding, var2.padding);
         }
      } else {
         return false;
      }
   }

   public LatLngBounds getBounds() {
      return this.bounds;
   }

   public CameraPosition getCameraPosition(@NonNull MapboxMap var1) {
      return this.bearing == null && this.tilt == null ? var1.getCameraForLatLngBounds(this.bounds, this.padding) : var1.getCameraForLatLngBounds(this.bounds, this.padding, this.bearing, this.tilt);
   }

   public int[] getPadding() {
      return this.padding;
   }

   public int hashCode() {
      return 31 * this.bounds.hashCode() + Arrays.hashCode(this.padding);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("CameraBoundsUpdate{bounds=");
      var1.append(this.bounds);
      var1.append(", padding=");
      var1.append(Arrays.toString(this.padding));
      var1.append('}');
      return var1.toString();
   }
}
