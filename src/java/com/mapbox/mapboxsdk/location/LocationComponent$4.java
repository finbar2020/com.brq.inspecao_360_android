package com.mapbox.mapboxsdk.location;

import android.support.annotation.NonNull;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapboxMap.OnMapLongClickListener;
import java.util.Iterator;

class LocationComponent$4 implements OnMapLongClickListener {
   // $FF: synthetic field
   final LocationComponent this$0;

   LocationComponent$4(LocationComponent var1) {
      this.this$0 = var1;
   }

   public boolean onMapLongClick(@NonNull LatLng var1) {
      if (!LocationComponent.access$600(this.this$0).isEmpty() && LocationComponent.access$500(this.this$0).onMapClick(var1)) {
         Iterator var2 = LocationComponent.access$600(this.this$0).iterator();

         while(var2.hasNext()) {
            ((OnLocationLongClickListener)var2.next()).onLocationComponentLongClick();
         }

         return true;
      } else {
         return false;
      }
   }
}
