package com.mapbox.mapboxsdk.location;

import java.util.Iterator;

class LocationComponent$5 implements OnLocationStaleListener {
   // $FF: synthetic field
   final LocationComponent this$0;

   LocationComponent$5(LocationComponent var1) {
      this.this$0 = var1;
   }

   public void onStaleStateChange(boolean var1) {
      LocationComponent.access$500(this.this$0).setLocationsStale(var1);
      Iterator var2 = LocationComponent.access$700(this.this$0).iterator();

      while(var2.hasNext()) {
         ((OnLocationStaleListener)var2.next()).onStaleStateChange(var1);
      }

   }
}
