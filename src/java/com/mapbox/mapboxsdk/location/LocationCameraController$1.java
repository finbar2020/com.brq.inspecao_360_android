package com.mapbox.mapboxsdk.location;

import com.mapbox.mapboxsdk.maps.MapboxMap.CancelableCallback;

class LocationCameraController$1 implements CancelableCallback {
   // $FF: synthetic field
   final LocationCameraController this$0;
   // $FF: synthetic field
   final OnLocationCameraTransitionListener val$internalTransitionListener;

   LocationCameraController$1(LocationCameraController var1, OnLocationCameraTransitionListener var2) {
      this.this$0 = var1;
      this.val$internalTransitionListener = var2;
   }

   public void onCancel() {
      LocationCameraController.access$002(this.this$0, false);
      OnLocationCameraTransitionListener var2 = this.val$internalTransitionListener;
      if (var2 != null) {
         var2.onLocationCameraTransitionCanceled(LocationCameraController.access$100(this.this$0));
      }

   }

   public void onFinish() {
      LocationCameraController.access$002(this.this$0, false);
      OnLocationCameraTransitionListener var2 = this.val$internalTransitionListener;
      if (var2 != null) {
         var2.onLocationCameraTransitionFinished(LocationCameraController.access$100(this.this$0));
      }

   }
}
