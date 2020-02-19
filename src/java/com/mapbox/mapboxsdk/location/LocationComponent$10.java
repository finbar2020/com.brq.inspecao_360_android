package com.mapbox.mapboxsdk.location;

import com.mapbox.mapboxsdk.maps.MapboxMap.OnDeveloperAnimationListener;

class LocationComponent$10 implements OnDeveloperAnimationListener {
   // $FF: synthetic field
   final LocationComponent this$0;

   LocationComponent$10(LocationComponent var1) {
      this.this$0 = var1;
   }

   public void onDeveloperAnimationStarted() {
      if (LocationComponent.access$1400(this.this$0) && LocationComponent.access$1500(this.this$0)) {
         this.this$0.setCameraMode(8);
      }

   }
}
