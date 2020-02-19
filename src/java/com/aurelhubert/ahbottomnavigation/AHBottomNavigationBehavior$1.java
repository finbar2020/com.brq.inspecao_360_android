package com.aurelhubert.ahbottomnavigation;

import android.support.v4.view.ViewPropertyAnimatorUpdateListener;
import android.view.View;

class AHBottomNavigationBehavior$1 implements ViewPropertyAnimatorUpdateListener {
   // $FF: synthetic field
   final AHBottomNavigationBehavior this$0;

   AHBottomNavigationBehavior$1(AHBottomNavigationBehavior var1) {
      this.this$0 = var1;
   }

   public void onAnimationUpdate(View var1) {
      if (AHBottomNavigationBehavior.access$000(this.this$0) != null) {
         AHBottomNavigationBehavior.access$000(this.this$0).onPositionChange((int)((float)var1.getMeasuredHeight() - var1.getTranslationY() + AHBottomNavigationBehavior.access$100(this.this$0)));
      }

   }
}
