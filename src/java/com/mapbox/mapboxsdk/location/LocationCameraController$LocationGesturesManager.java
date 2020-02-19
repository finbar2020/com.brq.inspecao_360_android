package com.mapbox.mapboxsdk.location;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import com.mapbox.android.gestures.AndroidGesturesManager;

class LocationCameraController$LocationGesturesManager extends AndroidGesturesManager {
   // $FF: synthetic field
   final LocationCameraController this$0;

   LocationCameraController$LocationGesturesManager(LocationCameraController var1, Context var2) {
      super(var2);
      this.this$0 = var1;
   }

   public boolean onTouchEvent(@Nullable MotionEvent var1) {
      if (var1 != null && var1.getActionMasked() == 1) {
         LocationCameraController.access$1000(this.this$0);
      }

      return super.onTouchEvent(var1);
   }
}
