package com.brq.inspecao_360_android.presentantion.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.view.View;

public class AutoFocusDrawView extends View {
   private boolean mHasTouch = false;
   private Paint mPaint = new Paint();
   private Rect mTouchArea;

   public AutoFocusDrawView(Context var1) {
      super(var1);
      this.mPaint.setColor(-16776961);
      this.mPaint.setStyle(Style.STROKE);
      this.mPaint.setStrokeWidth(2.0F);
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      var1.drawColor(0);
      this.mPaint.setColor(-16776961);
      boolean var10000 = this.mHasTouch;
   }

   public void setTouchArea(Rect var1) {
      this.mHasTouch = true;
      this.mTouchArea = var1;
   }
}
