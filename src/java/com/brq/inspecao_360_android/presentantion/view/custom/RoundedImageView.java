package com.brq.inspecao_360_android.presentantion.view.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

public class RoundedImageView extends AppCompatImageView {
   private int RADIUS = 0;
   private Path mClip;
   private RectF mRect;

   public RoundedImageView(Context var1) {
      super(var1);
      this.init();
   }

   public RoundedImageView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init();
   }

   public RoundedImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init();
   }

   private void init() {
      this.mRect = new RectF();
      this.mClip = new Path();
   }

   public void onDraw(Canvas var1) {
      Drawable var2 = this.getDrawable();
      if (var2 != null && var2 instanceof BitmapDrawable && this.RADIUS > 0) {
         Paint var3 = ((BitmapDrawable)var2).getPaint();
         RectF var4 = new RectF(var2.getBounds());
         int var5 = var1.saveLayer(var4, (Paint)null, 31);
         this.getImageMatrix().mapRect(var4);
         var3.setAntiAlias(true);
         var1.drawARGB(0, 0, 0, 0);
         var3.setColor(-16777216);
         var1.drawCircle(var4.centerX(), var4.centerY(), (float)this.RADIUS, var3);
         Xfermode var7 = var3.getXfermode();
         var3.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
         super.onDraw(var1);
         var3.setXfermode(var7);
         var1.restoreToCount(var5);
      } else {
         super.onDraw(var1);
      }
   }

   public void setRadius(int var1) {
      this.RADIUS = var1;
   }
}
