package com.mapbox.mapboxsdk.location;

import com.mapbox.mapboxsdk.camera.CameraPosition;

class LocationComponent$CameraTransitionListener implements OnLocationCameraTransitionListener {
   private final OnLocationCameraTransitionListener externalListener;
   // $FF: synthetic field
   final LocationComponent this$0;

   private LocationComponent$CameraTransitionListener(LocationComponent var1, OnLocationCameraTransitionListener var2) {
      this.this$0 = var1;
      this.externalListener = var2;
   }

   // $FF: synthetic method
   LocationComponent$CameraTransitionListener(LocationComponent var1, OnLocationCameraTransitionListener var2, LocationComponent$1 var3) {
      this(var1, var2);
   }

   private void reset(int var1) {
      LocationAnimatorCoordinator var2 = LocationComponent.access$200(this.this$0);
      CameraPosition var3 = LocationComponent.access$100(this.this$0).getCameraPosition();
      boolean var4;
      if (var1 == 36) {
         var4 = true;
      } else {
         var4 = false;
      }

      var2.resetAllCameraAnimations(var3, var4);
   }

   public void onLocationCameraTransitionCanceled(int var1) {
      OnLocationCameraTransitionListener var2 = this.externalListener;
      if (var2 != null) {
         var2.onLocationCameraTransitionCanceled(var1);
      }

      this.reset(var1);
   }

   public void onLocationCameraTransitionFinished(int var1) {
      OnLocationCameraTransitionListener var2 = this.externalListener;
      if (var2 != null) {
         var2.onLocationCameraTransitionFinished(var1);
      }

      this.reset(var1);
   }
}
