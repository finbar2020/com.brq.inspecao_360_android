package com.brq.inspecao_360_android.common.view;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.IntRange;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.brq.inspecao_360_android.common.view.CounterFab.1;
import com.brq.inspecao_360_android.common.view.CounterFab.SavedState;

public class CounterFab extends FloatingActionButton {
   private static final Interpolator ANIMATION_INTERPOLATOR = new OvershootInterpolator();
   private static final int MASK_COLOR = Color.parseColor("#ce3633");
   private static final int MAX_COUNT = 99;
   private static final String MAX_COUNT_TEXT = "99+";
   private static final int TEXT_PADDING_DP = 1;
   private static final int TEXT_SIZE_DP = 13;
   private final Property ANIMATION_PROPERTY;
   private final int mAnimationDuration;
   private float mAnimationFactor;
   private ObjectAnimator mAnimator;
   private final Rect mCircleBounds;
   private final Paint mCirclePaint;
   private final Rect mContentBounds;
   private int mCount;
   private final Paint mMaskPaint;
   private String mText;
   private float mTextHeight;
   private final Paint mTextPaint;
   private final float mTextSize;

   public CounterFab(Context var1) {
      this(var1, (AttributeSet)null, 0);
   }

   public CounterFab(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public CounterFab(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.ANIMATION_PROPERTY = new 1(this, Float.class, "animation");
      this.setUseCompatPadding(false);
      float var4 = this.getResources().getDisplayMetrics().density;
      this.mTextSize = 13.0F * var4;
      float var5 = var4 * 1.0F;
      this.mAnimationDuration = this.getResources().getInteger(17694720);
      this.mAnimationFactor = 1.0F;
      this.mTextPaint = new Paint(1);
      this.mTextPaint.setStyle(Style.STROKE);
      this.mTextPaint.setColor(-1);
      this.mTextPaint.setTextSize(this.mTextSize);
      this.mTextPaint.setTextAlign(Align.CENTER);
      this.mTextPaint.setTypeface(Typeface.SANS_SERIF);
      this.mCirclePaint = new Paint(1);
      this.mCirclePaint.setStyle(Style.FILL);
      ColorStateList var7 = this.getBackgroundTintList();
      if (var7 != null) {
         this.mCirclePaint.setColor(var7.getDefaultColor());
      } else {
         Drawable var8 = this.getBackground();
         if (var8 instanceof ColorDrawable) {
            ColorDrawable var11 = (ColorDrawable)var8;
            this.mCirclePaint.setColor(var11.getColor());
         }
      }

      this.mMaskPaint = new Paint(1);
      this.mMaskPaint.setStyle(Style.FILL);
      this.mMaskPaint.setColor(MASK_COLOR);
      Rect var9 = new Rect();
      this.mTextPaint.getTextBounds("99+", 0, 3, var9);
      this.mTextHeight = (float)var9.height();
      int var10 = (int)(2.0F * (var5 + Math.max(this.mTextPaint.measureText("99+"), this.mTextHeight) / 2.0F));
      this.mCircleBounds = new Rect(0, 0, var10, var10);
      this.mContentBounds = new Rect();
      this.onCountChanged();
   }

   // $FF: synthetic method
   static float access$002(CounterFab var0, float var1) {
      var0.mAnimationFactor = var1;
      return var1;
   }

   private boolean isAnimating() {
      ObjectAnimator var1 = this.mAnimator;
      return var1 != null && var1.isRunning();
   }

   private void onCountChanged() {
      int var1 = this.mCount;
      if (var1 > 99) {
         this.mText = "99+";
      } else {
         this.mText = String.valueOf(var1);
      }
   }

   private void startAnimation() {
      int var1 = this.mCount;
      float var2 = 1.0F;
      float var3;
      if (var1 == 0) {
         var3 = 0.0F;
      } else {
         var2 = 0.0F;
         var3 = 1.0F;
      }

      if (this.isAnimating()) {
         this.mAnimator.cancel();
      }

      Property var4 = this.ANIMATION_PROPERTY;
      Float[] var5 = new Float[]{var2, var3};
      this.mAnimator = ObjectAnimator.ofObject(this, var4, (TypeEvaluator)null, var5);
      this.mAnimator.setInterpolator(ANIMATION_INTERPOLATOR);
      this.mAnimator.setDuration((long)this.mAnimationDuration);
      this.mAnimator.start();
   }

   public void decrease() {
      int var1 = this.mCount;
      int var2;
      if (var1 > 0) {
         var2 = var1 - 1;
      } else {
         var2 = 0;
      }

      this.setCount(var2);
   }

   public int getCount() {
      return this.mCount;
   }

   public void increase() {
      this.setCount(1 + this.mCount);
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      if (this.mCount > 0 || this.isAnimating()) {
         if (this.getContentRect(this.mContentBounds)) {
            this.mCircleBounds.offsetTo(this.mContentBounds.left + this.mContentBounds.width() - this.mCircleBounds.width(), this.mContentBounds.top);
         }

         float var2 = (float)this.mCircleBounds.centerX();
         float var3 = (float)this.mCircleBounds.centerY();
         float var4 = (float)this.mCircleBounds.width() / 2.0F * this.mAnimationFactor;
         var1.drawCircle(var2, var3, var4, this.mCirclePaint);
         var1.drawCircle(var2, var3, var4, this.mMaskPaint);
         this.mTextPaint.setTextSize(this.mTextSize * this.mAnimationFactor);
         var1.drawText(this.mText, var2, var3 + this.mTextHeight / 2.0F, this.mTextPaint);
      }

   }

   public void onRestoreInstanceState(Parcelable var1) {
      SavedState var2 = (SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      this.setCount(SavedState.access$300(var2));
      this.requestLayout();
   }

   public Parcelable onSaveInstanceState() {
      SavedState var1 = new SavedState(super.onSaveInstanceState(), (1)null);
      SavedState.access$302(var1, this.mCount);
      return var1;
   }

   public void setCount(@IntRange(from = 0L) int var1) {
      if (var1 != this.mCount) {
         if (var1 <= 0) {
            var1 = 0;
         }

         this.mCount = var1;
         this.onCountChanged();
         if (ViewCompat.isLaidOut(this)) {
            this.startAnimation();
         }

      }
   }
}
