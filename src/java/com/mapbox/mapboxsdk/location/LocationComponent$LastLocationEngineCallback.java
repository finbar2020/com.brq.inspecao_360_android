package com.mapbox.mapboxsdk.location;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.mapbox.android.core.location.LocationEngineCallback;
import com.mapbox.android.core.location.LocationEngineResult;
import com.mapbox.mapboxsdk.log.Logger;
import java.lang.ref.WeakReference;

@VisibleForTesting
final class LocationComponent$LastLocationEngineCallback implements LocationEngineCallback {
   private final WeakReference componentWeakReference;

   LocationComponent$LastLocationEngineCallback(LocationComponent var1) {
      this.componentWeakReference = new WeakReference(var1);
   }

   public void onFailure(@NonNull Exception var1) {
      Logger.e("Mbgl-LocationComponent", "Failed to obtain last location update", var1);
   }

   public void onSuccess(LocationEngineResult var1) {
      LocationComponent var2 = (LocationComponent)this.componentWeakReference.get();
      if (var2 != null) {
         LocationComponent.access$1000(var2, var1.getLastLocation(), true);
      }

   }
}
