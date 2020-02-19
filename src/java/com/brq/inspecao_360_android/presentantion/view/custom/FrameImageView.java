package com.brq.inspecao_360_android.presentantion.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;

public class FrameImageView extends ImageView {
   private int _xDelta;
   private int _yDelta;
   private ScaleGestureDetector mScaleDetector;
   private float mScaleFactor = 1.0F;

   public FrameImageView(Context var1) {
      super(var1);
   }

   public FrameImageView(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public FrameImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   private void scaleView(ScaleGestureDetector var1) {
      this.mScaleFactor *= var1.getScaleFactor();
      this.mScaleFactor = Math.max(0.1F, Math.min(this.mScaleFactor, 5.0F));
      this.setScaleX(this.getScaleX() * this.mScaleFactor);
      this.setScaleY(this.getScaleY() * this.mScaleFactor);
   }

   private void setListener() {
      this.mScaleDetector = new ScaleGestureDetector(this.getContext(), new OnScaleGestureListener() {
         public boolean onScale(ScaleGestureDetector var1) {
            FrameImageView.this.scaleView(var1);
            return true;
         }

         public boolean onScaleBegin(ScaleGestureDetector var1) {
            return true;
         }

         public void onScaleEnd(ScaleGestureDetector var1) {
         }
      });
      this.setOnTouchListener(new OnTouchListener() {
         public boolean onTouch(View var1, MotionEvent var2) {
            int var3 = (int)var2.getRawX();
            int var4 = (int)var2.getRawY();
            FrameImageView.this.mScaleDetector.onTouchEvent(var2);
            int var6 = 255 & var2.getAction();
            if (var6 != 0) {
               if (var6 != 1) {
                  if (var6 == 2) {
                     LayoutParams var10 = (LayoutParams)var1.getLayoutParams();
                     if (var2.getPointerCount() == 1) {
                        var10.leftMargin = var3 - FrameImageView.this._xDelta;
                        var10.rightMargin = -(var3 - FrameImageView.this._xDelta);
                        var10.topMargin = var4 - FrameImageView.this._yDelta;
                        var10.bottomMargin = -(var4 - FrameImageView.this._yDelta);
                     }

                     var1.setLayoutParams(var10);
                     return true;
                  }

                  if (var6 != 5) {
                     return true;
                  }
               }
            } else {
               LayoutParams var7 = (LayoutParams)var1.getLayoutParams();
               FrameImageView.this._xDelta = var3 - var7.leftMargin;
               FrameImageView.this._yDelta = var4 - var7.topMargin;
            }

            return true;
         }
      });
   }

   public int getLeftX() {
      return Math.round(this.getX() + (float)((this.getWidth() - this.getScaledWidth()) / 2));
   }

   public int getScaledHeight() {
      return Math.round((float)this.getHeight() * this.getScaleY());
   }

   public int getScaledMarginBottom() {
      return Math.round((float)(((LayoutParams)this.getLayoutParams()).bottomMargin + (this.getHeight() - this.getScaledHeight()) / 2));
   }

   public int getScaledMarginLeft() {
      return Math.round((float)(((LayoutParams)this.getLayoutParams()).leftMargin + (this.getWidth() - this.getScaledWidth()) / 2));
   }

   public int getScaledMarginRight() {
      return Math.round((float)(((LayoutParams)this.getLayoutParams()).rightMargin + (this.getWidth() - this.getScaledWidth()) / 2));
   }

   public int getScaledMarginTop() {
      return Math.round((float)(((LayoutParams)this.getLayoutParams()).topMargin + (this.getHeight() - this.getScaledHeight()) / 2));
   }

   public int getScaledRadius() {
      return this.getScaledWidth() / 2;
   }

   public int getScaledWidth() {
      return Math.round((float)this.getWidth() * this.getScaleX());
   }

   public int getTopY() {
      return Math.round(this.getY() + (float)((this.getHeight() - this.getScaledHeight()) / 2));
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
   }
}
