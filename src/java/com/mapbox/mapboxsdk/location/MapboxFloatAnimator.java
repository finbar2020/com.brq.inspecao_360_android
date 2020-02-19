package com.mapbox.mapboxsdk.location;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;
import android.support.annotation.NonNull;
import com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener;

class MapboxFloatAnimator extends MapboxAnimator {
   MapboxFloatAnimator(Float var1, Float var2, AnimationsValueChangeListener var3, int var4) {
      super(var1, var2, var3, var4);
   }

   @NonNull
   TypeEvaluator provideEvaluator() {
      return new FloatEvaluator();
   }
}
