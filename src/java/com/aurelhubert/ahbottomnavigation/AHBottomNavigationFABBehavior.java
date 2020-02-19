package com.aurelhubert.ahbottomnavigation;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public class AHBottomNavigationFABBehavior extends Behavior {
   private long lastSnackbarUpdate = 0L;
   private int navigationBarHeight = 0;

   public AHBottomNavigationFABBehavior(int var1) {
      this.navigationBarHeight = var1;
   }

   private void updateFloatingActionButton(FloatingActionButton var1, View var2) {
      if (var1 != null && var2 != null && var2 instanceof SnackbarLayout) {
         this.lastSnackbarUpdate = System.currentTimeMillis();
         int var4 = ((MarginLayoutParams)var1.getLayoutParams()).bottomMargin;
         var1.setY(var2.getY() - (float)var4);
      } else {
         if (var1 != null && var2 != null && var2 instanceof AHBottomNavigation) {
            if (System.currentTimeMillis() - this.lastSnackbarUpdate < 30L) {
               return;
            }

            int var3 = ((MarginLayoutParams)var1.getLayoutParams()).bottomMargin;
            var1.setY(var2.getY() - (float)var3);
         }

      }
   }

   public boolean layoutDependsOn(CoordinatorLayout var1, FloatingActionButton var2, View var3) {
      if (var3 != null && var3 instanceof SnackbarLayout) {
         return true;
      } else {
         return var3 != null && var3 instanceof AHBottomNavigation ? true : super.layoutDependsOn(var1, var2, var3);
      }
   }

   public boolean onDependentViewChanged(CoordinatorLayout var1, FloatingActionButton var2, View var3) {
      this.updateFloatingActionButton(var2, var3);
      return super.onDependentViewChanged(var1, var2, var3);
   }
}
