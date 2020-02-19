package com.mapbox.mapboxsdk.location;

import java.util.Iterator;

class LocationComponent$9 implements OnRenderModeChangedListener {
   // $FF: synthetic field
   final LocationComponent this$0;

   LocationComponent$9(LocationComponent var1) {
      this.this$0 = var1;
   }

   public void onRenderModeChanged(int var1) {
      LocationComponent.access$1200(this.this$0);
      Iterator var2 = LocationComponent.access$1300(this.this$0).iterator();

      while(var2.hasNext()) {
         ((OnRenderModeChangedListener)var2.next()).onRenderModeChanged(var1);
      }

   }
}
