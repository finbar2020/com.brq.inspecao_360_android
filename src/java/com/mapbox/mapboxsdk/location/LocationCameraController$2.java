package com.mapbox.mapboxsdk.location;

import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener;

class LocationCameraController$2 implements AnimationsValueChangeListener {
   // $FF: synthetic field
   final LocationCameraController this$0;

   LocationCameraController$2(LocationCameraController var1) {
      this.this$0 = var1;
   }

   public void onNewAnimationValue(LatLng var1) {
      LocationCameraController.access$200(this.this$0, var1);
   }
}
