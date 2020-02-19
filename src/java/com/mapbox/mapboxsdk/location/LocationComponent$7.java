package com.mapbox.mapboxsdk.location;

class LocationComponent$7 implements CompassListener {
   // $FF: synthetic field
   final LocationComponent this$0;

   LocationComponent$7(LocationComponent var1) {
      this.this$0 = var1;
   }

   public void onCompassAccuracyChange(int var1) {
   }

   public void onCompassChanged(float var1) {
      LocationComponent.access$900(this.this$0, var1);
   }
}
