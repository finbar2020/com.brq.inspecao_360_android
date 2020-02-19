package com.mapbox.mapboxsdk.location;

import com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener;

class LocationCameraController$3 implements AnimationsValueChangeListener {
   // $FF: synthetic field
   final LocationCameraController this$0;

   LocationCameraController$3(LocationCameraController var1) {
      this.this$0 = var1;
   }

   public void onNewAnimationValue(Float var1) {
      boolean var2;
      if (LocationCameraController.access$100(this.this$0) == 36 && LocationCameraController.access$300(this.this$0).getCameraPosition().bearing == 0.0D) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (!var2) {
         LocationCameraController.access$400(this.this$0, var1);
      }

   }
}
