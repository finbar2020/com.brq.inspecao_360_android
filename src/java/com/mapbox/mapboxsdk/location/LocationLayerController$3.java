package com.mapbox.mapboxsdk.location;

import com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener;

class LocationLayerController$3 implements AnimationsValueChangeListener {
   // $FF: synthetic field
   final LocationLayerController this$0;

   LocationLayerController$3(LocationLayerController var1) {
      this.this$0 = var1;
   }

   public void onNewAnimationValue(Float var1) {
      LocationLayerController.access$100(this.this$0, "mapbox-property-compass-bearing", var1);
   }
}
