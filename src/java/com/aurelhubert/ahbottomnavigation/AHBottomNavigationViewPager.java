package com.aurelhubert.ahbottomnavigation;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class AHBottomNavigationViewPager extends ViewPager {
   private boolean enabled = false;

   public AHBottomNavigationViewPager(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      return this.enabled ? super.onInterceptTouchEvent(var1) : false;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      return this.enabled ? super.onTouchEvent(var1) : false;
   }

   public void setPagingEnabled(boolean var1) {
      this.enabled = var1;
   }
}
