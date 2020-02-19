package com.mapbox.mapboxsdk.location;

import com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener;

class LocationCameraController$4 implements AnimationsValueChangeListener {
   // $FF: synthetic field
   final LocationCameraController this$0;

   LocationCameraController$4(LocationCameraController var1) {
      this.this$0 = var1;
   }

   public void onNewAnimationValue(Float var1) {
      if (LocationCameraController.access$100(this.this$0) == 32 || LocationCameraController.access$100(this.this$0) == 16) {
         LocationCameraController.access$400(this.this$0, var1);
      }

   }
}
