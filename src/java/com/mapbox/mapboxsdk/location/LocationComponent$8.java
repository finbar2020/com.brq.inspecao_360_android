package com.mapbox.mapboxsdk.location;

import java.util.Iterator;

class LocationComponent$8 implements OnCameraTrackingChangedListener {
   // $FF: synthetic field
   final LocationComponent this$0;

   LocationComponent$8(LocationComponent var1) {
      this.this$0 = var1;
   }

   public void onCameraTrackingChanged(int var1) {
      LocationComponent.access$200(this.this$0).cancelZoomAnimation();
      LocationComponent.access$200(this.this$0).cancelTiltAnimation();
      LocationComponent.access$1200(this.this$0);
      Iterator var2 = LocationComponent.access$1100(this.this$0).iterator();

      while(var2.hasNext()) {
         ((OnCameraTrackingChangedListener)var2.next()).onCameraTrackingChanged(var1);
      }

   }

   public void onCameraTrackingDismissed() {
      Iterator var1 = LocationComponent.access$1100(this.this$0).iterator();

      while(var1.hasNext()) {
         ((OnCameraTrackingChangedListener)var1.next()).onCameraTrackingDismissed();
      }

   }
}
