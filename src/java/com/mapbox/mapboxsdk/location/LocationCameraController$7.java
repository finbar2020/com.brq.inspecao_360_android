package com.mapbox.mapboxsdk.location;

import android.support.annotation.NonNull;
import com.mapbox.android.gestures.MoveGestureDetector;
import com.mapbox.mapboxsdk.maps.MapboxMap.OnMoveListener;

class LocationCameraController$7 implements OnMoveListener {
   private boolean interrupt;
   // $FF: synthetic field
   final LocationCameraController this$0;

   LocationCameraController$7(LocationCameraController var1) {
      this.this$0 = var1;
   }

   public void onMove(@NonNull MoveGestureDetector var1) {
      if (this.interrupt) {
         var1.interrupt();
      } else {
         if (LocationCameraController.access$800(this.this$0) || LocationCameraController.access$900(this.this$0)) {
            this.this$0.setCameraMode(8);
            var1.interrupt();
         }

      }
   }

   public void onMoveBegin(@NonNull MoveGestureDetector var1) {
      if (LocationCameraController.access$700(this.this$0).trackingGesturesManagement() && var1.getPointersCount() > 1 && var1.getMoveThreshold() != LocationCameraController.access$700(this.this$0).trackingMultiFingerMoveThreshold() && LocationCameraController.access$800(this.this$0)) {
         var1.setMoveThreshold(LocationCameraController.access$700(this.this$0).trackingMultiFingerMoveThreshold());
         this.interrupt = true;
      } else {
         this.this$0.setCameraMode(8);
      }
   }

   public void onMoveEnd(@NonNull MoveGestureDetector var1) {
      if (LocationCameraController.access$700(this.this$0).trackingGesturesManagement() && !this.interrupt && LocationCameraController.access$800(this.this$0)) {
         var1.setMoveThreshold(LocationCameraController.access$700(this.this$0).trackingInitialMoveThreshold());
      }

      this.interrupt = false;
   }
}
