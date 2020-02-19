package com.mapbox.mapboxsdk.location;

import android.support.annotation.NonNull;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapboxMap.OnMapClickListener;
import java.util.Iterator;

class LocationComponent$3 implements OnMapClickListener {
   // $FF: synthetic field
   final LocationComponent this$0;

   LocationComponent$3(LocationComponent var1) {
      this.this$0 = var1;
   }

   public boolean onMapClick(@NonNull LatLng var1) {
      if (!LocationComponent.access$400(this.this$0).isEmpty() && LocationComponent.access$500(this.this$0).onMapClick(var1)) {
         Iterator var2 = LocationComponent.access$400(this.this$0).iterator();

         while(var2.hasNext()) {
            ((OnLocationClickListener)var2.next()).onLocationComponentClick();
         }

         return true;
      } else {
         return false;
      }
   }
}
