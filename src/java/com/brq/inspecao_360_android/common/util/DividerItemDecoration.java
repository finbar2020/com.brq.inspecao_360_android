package com.brq.inspecao_360_android.common.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

public class DividerItemDecoration extends ItemDecoration {
   private static final int[] ATTRS = new int[]{16843284};
   public static final int HORIZONTAL_LIST = 0;
   public static final int VERTICAL_LIST = 1;
   private Drawable mDivider;
   private int mOrientation;

   public DividerItemDecoration(Context var1, int var2) {
      TypedArray var3 = var1.obtainStyledAttributes(ATTRS);
      this.mDivider = var3.getDrawable(0);
      var3.recycle();
      this.setOrientation(var2);
   }

   public void drawHorizontal(Canvas var1, RecyclerView var2) {
      int var3 = var2.getPaddingTop();
      int var4 = var2.getHeight() - var2.getPaddingBottom();
      int var5 = var2.getChildCount();

      for(int var6 = 0; var6 < var5; ++var6) {
         View var7 = var2.getChildAt(var6);
         LayoutParams var8 = (LayoutParams)var7.getLayoutParams();
         int var9 = var7.getRight() + var8.rightMargin;
         int var10 = var9 + this.mDivider.getIntrinsicHeight();
         this.mDivider.setBounds(var9, var3, var10, var4);
         this.mDivider.draw(var1);
      }

   }

   public void drawVertical(Canvas var1, RecyclerView var2) {
      int var3 = var2.getPaddingLeft();
      int var4 = var2.getWidth() - var2.getPaddingRight();
      int var5 = var2.getChildCount();

      for(int var6 = 0; var6 < var5; ++var6) {
         View var7 = var2.getChildAt(var6);
         LayoutParams var8 = (LayoutParams)var7.getLayoutParams();
         int var9 = var7.getBottom() + var8.bottomMargin;
         int var10 = var9 + this.mDivider.getIntrinsicHeight();
         this.mDivider.setBounds(var3, var9, var4, var10);
         this.mDivider.draw(var1);
      }

   }

   public void getItemOffsets(Rect var1, int var2, RecyclerView var3) {
      if (this.mOrientation == 1) {
         var1.set(0, 0, 0, this.mDivider.getIntrinsicHeight());
      } else {
         var1.set(0, 0, this.mDivider.getIntrinsicWidth(), 0);
      }
   }

   public void onDraw(Canvas var1, RecyclerView var2) {
      if (this.mOrientation == 1) {
         this.drawVertical(var1, var2);
      } else {
         this.drawHorizontal(var1, var2);
      }
   }

   public void setOrientation(int var1) {
      if (var1 != 0 && var1 != 1) {
         throw new IllegalArgumentException("invalid orientation");
      } else {
         this.mOrientation = var1;
      }
   }
}
