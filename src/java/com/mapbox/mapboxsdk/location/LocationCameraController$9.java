package com.mapbox.mapboxsdk.location;

import com.mapbox.mapboxsdk.maps.MapboxMap.OnFlingListener;

class LocationCameraController$9 implements OnFlingListener {
   // $FF: synthetic field
   final LocationCameraController this$0;

   LocationCameraController$9(LocationCameraController var1) {
      this.this$0 = var1;
   }

   public void onFling() {
      this.this$0.setCameraMode(8);
   }
}
