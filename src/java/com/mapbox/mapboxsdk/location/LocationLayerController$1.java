package com.mapbox.mapboxsdk.location;

import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener;

class LocationLayerController$1 implements AnimationsValueChangeListener {
   // $FF: synthetic field
   final LocationLayerController this$0;

   LocationLayerController$1(LocationLayerController var1) {
      this.this$0 = var1;
   }

   public void onNewAnimationValue(LatLng var1) {
      Point var2 = Point.fromLngLat(var1.getLongitude(), var1.getLatitude());
      LocationLayerController.access$000(this.this$0, var2);
   }
}
