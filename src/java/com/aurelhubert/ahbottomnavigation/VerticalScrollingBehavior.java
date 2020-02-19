package com.aurelhubert.ahbottomnavigation;

import android.content.Context;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;

public abstract class VerticalScrollingBehavior extends Behavior {
   private int mOverScrollDirection = 0;
   private int mScrollDirection = 0;
   private int mTotalDy = 0;
   private int mTotalDyUnconsumed = 0;

   public VerticalScrollingBehavior() {
   }

   public VerticalScrollingBehavior(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public int getOverScrollDirection() {
      return this.mOverScrollDirection;
   }

   public int getScrollDirection() {
      return this.mScrollDirection;
   }

   public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout var1, View var2, WindowInsetsCompat var3) {
      return super.onApplyWindowInsets(var1, var2, var3);
   }

   public abstract void onDirectionNestedPreScroll(CoordinatorLayout var1, View var2, View var3, int var4, int var5, int[] var6, int var7);

   protected abstract boolean onNestedDirectionFling(CoordinatorLayout var1, View var2, View var3, float var4, float var5, int var6);

   public boolean onNestedFling(CoordinatorLayout var1, View var2, View var3, float var4, float var5, boolean var6) {
      super.onNestedFling(var1, var2, var3, var4, var5, var6);
      byte var8;
      if (var5 > 0.0F) {
         var8 = 1;
      } else {
         var8 = -1;
      }

      this.mScrollDirection = var8;
      return this.onNestedDirectionFling(var1, var2, var3, var4, var5, this.mScrollDirection);
   }

   public boolean onNestedPreFling(CoordinatorLayout var1, View var2, View var3, float var4, float var5) {
      return super.onNestedPreFling(var1, var2, var3, var4, var5);
   }

   public void onNestedPreScroll(CoordinatorLayout var1, View var2, View var3, int var4, int var5, int[] var6) {
      super.onNestedPreScroll(var1, var2, var3, var4, var5, var6);
      if (var5 > 0 && this.mTotalDy < 0) {
         this.mTotalDy = 0;
         this.mScrollDirection = 1;
      } else if (var5 < 0 && this.mTotalDy > 0) {
         this.mTotalDy = 0;
         this.mScrollDirection = -1;
      }

      this.mTotalDy += var5;
      this.onDirectionNestedPreScroll(var1, var2, var3, var4, var5, var6, this.mScrollDirection);
   }

   public void onNestedScroll(CoordinatorLayout var1, View var2, View var3, int var4, int var5, int var6, int var7) {
      super.onNestedScroll(var1, var2, var3, var4, var5, var6, var7);
      if (var7 > 0 && this.mTotalDyUnconsumed < 0) {
         this.mTotalDyUnconsumed = 0;
         this.mOverScrollDirection = 1;
      } else if (var7 < 0 && this.mTotalDyUnconsumed > 0) {
         this.mTotalDyUnconsumed = 0;
         this.mOverScrollDirection = -1;
      }

      this.mTotalDyUnconsumed += var7;
      this.onNestedVerticalOverScroll(var1, var2, this.mOverScrollDirection, var5, this.mTotalDyUnconsumed);
   }

   public void onNestedScrollAccepted(CoordinatorLayout var1, View var2, View var3, View var4, int var5) {
      super.onNestedScrollAccepted(var1, var2, var3, var4, var5);
   }

   public abstract void onNestedVerticalOverScroll(CoordinatorLayout var1, View var2, int var3, int var4, int var5);

   public Parcelable onSaveInstanceState(CoordinatorLayout var1, View var2) {
      return super.onSaveInstanceState(var1, var2);
   }

   public boolean onStartNestedScroll(CoordinatorLayout var1, View var2, View var3, View var4, int var5) {
      return (var5 & 2) != 0;
   }

   public void onStopNestedScroll(CoordinatorLayout var1, View var2, View var3) {
      super.onStopNestedScroll(var1, var2, var3);
   }
}
