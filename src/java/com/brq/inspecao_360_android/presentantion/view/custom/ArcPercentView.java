package com.brq.inspecao_360_android.presentantion.view.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import com.brq.inspecao_360_android.configuration.di.App;

public class ArcPercentView extends View {
   private long angle;
   private int arcColor;
   private int fontsize;
   private Paint paint;
   private Path path;
   private int radius;
   private RectF rect;
   private String text;

   public ArcPercentView(Context var1) {
      super(var1);
      this.init();
   }

   public ArcPercentView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init();
   }

   public ArcPercentView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init();
   }

   @TargetApi(21)
   public ArcPercentView(Context var1, AttributeSet var2, int var3, int var4) {
      super(var1, var2, var3, var4);
      this.init();
   }

   private void init() {
      this.text = "";
      this.radius = 100;
      this.angle = 0L;
      this.path = new Path();
      this.paint = new Paint();
      this.rect = new RectF();
      this.paint.setAntiAlias(true);
      this.paint.setColor(-7829368);
      this.paint.setStyle(Style.FILL);
      this.paint.setAlpha(50);
   }

   public long convertPercentToAngle(long var1) {
      return var1 * 360L / 100L;
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      this.radius = 90 * (this.getWidth() / 2) / 100;
      this.paint.setAntiAlias(true);
      this.paint.setColor(-7829368);
      this.paint.setStyle(Style.STROKE);
      this.paint.setAlpha(60);
      this.paint.setStrokeWidth((float)(5 * (this.getWidth() / 2) / 100));
      var1.drawCircle((float)(this.getWidth() / 2), (float)(this.getHeight() / 2), (float)this.radius, this.paint);
      int var2 = this.getWidth() / 2 - this.radius;
      int var3 = this.getHeight() / 2 - this.radius;
      this.rect.set((float)var2, (float)var3, (float)(this.getWidth() / 2 + this.radius), (float)(this.getWidth() / 2 + this.radius));
      this.paint.setStyle(Style.STROKE);
      this.paint.setColor(this.arcColor);
      this.paint.setStrokeWidth((float)(10 * (this.getWidth() / 2) / 100));
      var1.drawArc(this.rect, 270.0F, (float)this.angle, false, this.paint);
      Rect var4 = new Rect();
      this.paint = new Paint();
      this.fontsize = 50 * (this.getWidth() / 2) / 100;
      this.paint.setFlags(1);
      this.paint.setColor(-16777216);
      this.paint.setTextSize((float)this.fontsize);
      this.paint.setTextAlign(Align.CENTER);
      this.paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      Paint var6 = this.paint;
      String var7 = this.text;
      var6.getTextBounds(var7, 0, var7.length(), var4);
      float var8 = var4.exactCenterX() - (float)(var4.width() / 2);
      float var9 = var4.exactCenterY() - (float)(var4.height() / 2);
      var1.drawText(this.text, (float)(this.getWidth() / 2) - var8, ((float)this.getHeight() - var9) / 2.0F, this.paint);
   }

   public void setPercent(long var1) {
      StringBuilder var3 = new StringBuilder();
      var3.append(var1);
      var3.append("%");
      this.text = var3.toString();
      this.angle = this.convertPercentToAngle(var1);
      if (var1 == 100L) {
         this.arcColor = ContextCompat.getColor(App.getContext(), 2131099814);
      } else {
         this.arcColor = ContextCompat.getColor(App.getContext(), 2131099672);
      }

      this.invalidate();
   }
}
