package com.aurelhubert.ahbottomnavigation;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationBehavior.2;
import com.aurelhubert.ahbottomnavigation.R.styleable;

public class AHBottomNavigationBehavior extends VerticalScrollingBehavior {
   private static final int ANIM_DURATION = 300;
   private static final Interpolator INTERPOLATOR = new LinearOutSlowInInterpolator();
   private boolean behaviorTranslationEnabled = true;
   private boolean fabBottomMarginInitialized = false;
   private float fabDefaultBottomMargin = 0.0F;
   private float fabTargetOffset = 0.0F;
   private FloatingActionButton floatingActionButton;
   private boolean hidden = false;
   private int mSnackbarHeight = -1;
   private TabLayout mTabLayout;
   private int mTabLayoutId;
   private int navigationBarHeight = 0;
   private AHBottomNavigation.OnNavigationPositionListener navigationPositionListener;
   private float snackBarY = 0.0F;
   private SnackbarLayout snackbarLayout;
   private float targetOffset = 0.0F;
   private ViewPropertyAnimatorCompat translationAnimator;
   private ObjectAnimator translationObjectAnimator;

   public AHBottomNavigationBehavior() {
   }

   public AHBottomNavigationBehavior(Context var1, AttributeSet var2) {
      super(var1, var2);
      TypedArray var3 = var1.obtainStyledAttributes(var2, styleable.AHBottomNavigationBehavior_Params);
      this.mTabLayoutId = var3.getResourceId(styleable.AHBottomNavigationBehavior_Params_tabLayoutId, -1);
      var3.recycle();
   }

   public AHBottomNavigationBehavior(boolean var1, int var2) {
      this.behaviorTranslationEnabled = var1;
      this.navigationBarHeight = var2;
   }

   // $FF: synthetic method
   static AHBottomNavigation.OnNavigationPositionListener access$000(AHBottomNavigationBehavior var0) {
      return var0.navigationPositionListener;
   }

   // $FF: synthetic method
   static float access$100(AHBottomNavigationBehavior var0) {
      return var0.snackBarY;
   }

   // $FF: synthetic method
   static SnackbarLayout access$200(AHBottomNavigationBehavior var0) {
      return var0.snackbarLayout;
   }

   // $FF: synthetic method
   static float access$300(AHBottomNavigationBehavior var0) {
      return var0.targetOffset;
   }

   // $FF: synthetic method
   static float access$302(AHBottomNavigationBehavior var0, float var1) {
      var0.targetOffset = var1;
      return var1;
   }

   private void animateOffset(View var1, int var2, boolean var3, boolean var4) {
      if (this.behaviorTranslationEnabled || var3) {
         if (VERSION.SDK_INT < 19) {
            this.ensureOrCancelObjectAnimation(var1, var2, var4);
            this.translationObjectAnimator.start();
         } else {
            this.ensureOrCancelAnimator(var1, var4);
            this.translationAnimator.translationY((float)var2).start();
         }
      }
   }

   private void ensureOrCancelAnimator(View var1, boolean var2) {
      ViewPropertyAnimatorCompat var3 = this.translationAnimator;
      long var4 = 300L;
      if (var3 == null) {
         this.translationAnimator = ViewCompat.animate(var1);
         ViewPropertyAnimatorCompat var7 = this.translationAnimator;
         if (!var2) {
            var4 = 0L;
         }

         var7.setDuration(var4);
         this.translationAnimator.setUpdateListener(new AHBottomNavigationBehavior$1(this));
         this.translationAnimator.setInterpolator(INTERPOLATOR);
      } else {
         if (!var2) {
            var4 = 0L;
         }

         var3.setDuration(var4);
         this.translationAnimator.cancel();
      }
   }

   private void ensureOrCancelObjectAnimation(View var1, int var2, boolean var3) {
      ObjectAnimator var4 = this.translationObjectAnimator;
      if (var4 != null) {
         var4.cancel();
      }

      Property var5 = View.TRANSLATION_Y;
      float[] var6 = new float[]{(float)var2};
      this.translationObjectAnimator = ObjectAnimator.ofFloat(var1, var5, var6);
      ObjectAnimator var7 = this.translationObjectAnimator;
      long var8;
      if (var3) {
         var8 = 300L;
      } else {
         var8 = 0L;
      }

      var7.setDuration(var8);
      this.translationObjectAnimator.setInterpolator(INTERPOLATOR);
      this.translationObjectAnimator.addUpdateListener(new 2(this, var1));
   }

   private TabLayout findTabLayout(View var1) {
      int var2 = this.mTabLayoutId;
      return var2 == 0 ? null : (TabLayout)var1.findViewById(var2);
   }

   public static AHBottomNavigationBehavior from(View var0) {
      LayoutParams var1 = var0.getLayoutParams();
      if (var1 instanceof android.support.design.widget.CoordinatorLayout.LayoutParams) {
         Behavior var2 = ((android.support.design.widget.CoordinatorLayout.LayoutParams)var1).getBehavior();
         if (var2 instanceof AHBottomNavigationBehavior) {
            return (AHBottomNavigationBehavior)var2;
         } else {
            throw new IllegalArgumentException("The view is not associated with AHBottomNavigationBehavior");
         }
      } else {
         throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
      }
   }

   private void handleDirection(View var1, int var2) {
      if (this.behaviorTranslationEnabled) {
         if (var2 == -1 && this.hidden) {
            this.hidden = false;
            this.animateOffset(var1, 0, false, true);
         } else {
            if (var2 == 1 && !this.hidden) {
               this.hidden = true;
               this.animateOffset(var1, var1.getHeight(), false, true);
            }

         }
      }
   }

   public void hideView(View var1, int var2, boolean var3) {
      if (!this.hidden) {
         this.hidden = true;
         this.animateOffset(var1, var2, true, var3);
      }

   }

   public boolean isHidden() {
      return this.hidden;
   }

   public boolean layoutDependsOn(CoordinatorLayout var1, View var2, View var3) {
      if (var3 != null && var3 instanceof SnackbarLayout) {
         this.updateSnackbar(var2, var3);
         return true;
      } else {
         return super.layoutDependsOn(var1, var2, var3);
      }
   }

   public boolean onDependentViewChanged(CoordinatorLayout var1, View var2, View var3) {
      return super.onDependentViewChanged(var1, var2, var3);
   }

   public void onDependentViewRemoved(CoordinatorLayout var1, View var2, View var3) {
      super.onDependentViewRemoved(var1, var2, var3);
   }

   public void onDirectionNestedPreScroll(CoordinatorLayout var1, View var2, View var3, int var4, int var5, int[] var6, int var7) {
   }

   public boolean onLayoutChild(CoordinatorLayout var1, View var2, int var3) {
      boolean var4 = super.onLayoutChild(var1, var2, var3);
      if (this.mTabLayout == null && this.mTabLayoutId != -1) {
         this.mTabLayout = this.findTabLayout(var2);
      }

      return var4;
   }

   protected boolean onNestedDirectionFling(CoordinatorLayout var1, View var2, View var3, float var4, float var5, int var6) {
      return false;
   }

   public void onNestedScroll(CoordinatorLayout var1, View var2, View var3, int var4, int var5, int var6, int var7) {
      super.onNestedScroll(var1, var2, var3, var4, var5, var6, var7);
      if (var5 < 0) {
         this.handleDirection(var2, -1);
      } else {
         if (var5 > 0) {
            this.handleDirection(var2, 1);
         }

      }
   }

   public void onNestedVerticalOverScroll(CoordinatorLayout var1, View var2, int var3, int var4, int var5) {
   }

   public boolean onStartNestedScroll(CoordinatorLayout var1, View var2, View var3, View var4, int var5) {
      return var5 == 2 || super.onStartNestedScroll(var1, var2, var3, var4, var5);
   }

   public void removeOnNavigationPositionListener() {
      this.navigationPositionListener = null;
   }

   public void resetOffset(View var1, boolean var2) {
      if (this.hidden) {
         this.hidden = false;
         this.animateOffset(var1, 0, true, var2);
      }

   }

   public void setBehaviorTranslationEnabled(boolean var1, int var2) {
      this.behaviorTranslationEnabled = var1;
      this.navigationBarHeight = var2;
   }

   public void setOnNavigationPositionListener(AHBottomNavigation.OnNavigationPositionListener var1) {
      this.navigationPositionListener = var1;
   }

   public void setTabLayoutId(int var1) {
      this.mTabLayoutId = var1;
   }

   public void updateSnackbar(View var1, View var2) {
      if (var2 != null && var2 instanceof SnackbarLayout) {
         this.snackbarLayout = (SnackbarLayout)var2;
         if (this.mSnackbarHeight == -1) {
            this.mSnackbarHeight = var2.getHeight();
         }

         int var3 = (int)((float)var1.getMeasuredHeight() - var1.getTranslationY());
         if (VERSION.SDK_INT < 21) {
            var1.bringToFront();
         }

         if (var2.getLayoutParams() instanceof MarginLayoutParams) {
            MarginLayoutParams var4 = (MarginLayoutParams)var2.getLayoutParams();
            var4.setMargins(var4.leftMargin, var4.topMargin, var4.rightMargin, var3);
            var2.requestLayout();
         }
      }

   }
}
