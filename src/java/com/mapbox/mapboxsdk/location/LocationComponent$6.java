package com.mapbox.mapboxsdk.location;

class LocationComponent$6 implements OnCameraMoveInvalidateListener {
   // $FF: synthetic field
   final LocationComponent this$0;

   LocationComponent$6(LocationComponent var1) {
      this.this$0 = var1;
   }

   public void onInvalidateCameraMove() {
      LocationComponent.access$800(this.this$0).onCameraMove();
   }
}
