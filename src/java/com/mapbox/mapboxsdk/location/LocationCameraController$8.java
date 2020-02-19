package com.mapbox.mapboxsdk.location;

import android.support.annotation.NonNull;
import com.mapbox.android.gestures.RotateGestureDetector;
import com.mapbox.mapboxsdk.maps.MapboxMap.OnRotateListener;

class LocationCameraController$8 implements OnRotateListener {
   // $FF: synthetic field
   final LocationCameraController this$0;

   LocationCameraController$8(LocationCameraController var1) {
      this.this$0 = var1;
   }

   public void onRotate(@NonNull RotateGestureDetector var1) {
   }

   public void onRotateBegin(@NonNull RotateGestureDetector var1) {
      if (LocationCameraController.access$900(this.this$0)) {
         this.this$0.setCameraMode(8);
      }

   }

   public void onRotateEnd(@NonNull RotateGestureDetector var1) {
   }
}
