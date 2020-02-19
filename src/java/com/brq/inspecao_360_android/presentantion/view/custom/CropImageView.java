package com.brq.inspecao_360_android.presentantion.view.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.Paint.Style;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
public class CropImageView extends ImageView {
   private static final float DEFAULT_INITIAL_FRAME_SCALE = 0.75F;
   private static final int FRAME_STROKE_WEIGHT_IN_DP = 1;
   private static final int GUIDE_STROKE_WEIGHT_IN_DP = 1;
   private static final int HANDLE_SIZE_IN_DP = 16;
   private static final int MIN_FRAME_SIZE_IN_DP = 50;
   private static final String TAG = "CropImageView";
   private final int TRANSLUCENT_BLACK;
   private final int TRANSLUCENT_WHITE;
   private final int TRANSPARENT;
   private final int WHITE;
   private float mAngle;
   private int mBackgroundColor;
   private PointF mCenter;
   private CropImageView.CropMode mCropMode;
   private PointF mCustomRatio;
   private int mFrameColor;
   private RectF mFrameRect;
   private float mFrameStrokeWeight;
   private int mGuideColor;
   private CropImageView.ShowMode mGuideShowMode;
   private float mGuideStrokeWeight;
   private int mHandleColor;
   private CropImageView.ShowMode mHandleShowMode;
   private int mHandleSize;
   private RectF mImageRect;
   private float mImgHeight;
   private float mImgWidth;
   private float mInitialFrameScale;
   private boolean mIsCropEnabled;
   private boolean mIsEnabled;
   private boolean mIsInitialized;
   private float mLastX;
   private float mLastY;
   private Matrix mMatrix;
   private float mMinFrameSize;
   private int mOverlayColor;
   private Paint mPaintBitmap;
   private Paint mPaintFrame;
   private Paint mPaintTransparent;
   private float mScale;
   private boolean mShowGuide;
   private boolean mShowHandle;
   private CropImageView.TouchArea mTouchArea;
   private int mTouchPadding;
   private int mViewHeight;
   private int mViewWidth;

   public CropImageView(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public CropImageView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public CropImageView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.TRANSLUCENT_WHITE = -1140850689;
      this.WHITE = -1;
      this.TRANSLUCENT_BLACK = -1157627904;
      this.mViewWidth = 0;
      this.mViewHeight = 0;
      this.mScale = 1.0F;
      this.mAngle = 0.0F;
      this.mImgWidth = 0.0F;
      this.mImgHeight = 0.0F;
      this.mIsInitialized = false;
      this.mMatrix = null;
      this.mCenter = new PointF();
      this.mTouchArea = CropImageView.TouchArea.OUT_OF_BOUNDS;
      this.mCropMode = CropImageView.CropMode.RATIO_1_1;
      this.mGuideShowMode = CropImageView.ShowMode.SHOW_ALWAYS;
      this.mHandleShowMode = CropImageView.ShowMode.SHOW_ALWAYS;
      this.mTouchPadding = 0;
      this.mShowGuide = true;
      this.mShowHandle = true;
      this.mIsCropEnabled = true;
      this.mIsEnabled = true;
      this.mCustomRatio = new PointF(1.0F, 1.0F);
      this.mFrameStrokeWeight = 3.0F;
      this.mGuideStrokeWeight = 3.0F;
      this.TRANSPARENT = this.getResources().getColor(17170445);
      float var4 = this.getDensity();
      this.mHandleSize = (int)(16.0F * var4);
      this.mMinFrameSize = 50.0F * var4;
      float var5 = var4 * 1.0F;
      this.mFrameStrokeWeight = var5;
      this.mGuideStrokeWeight = var5;
      this.mPaintFrame = new Paint();
      this.mPaintTransparent = new Paint();
      this.mPaintBitmap = new Paint();
      this.mPaintBitmap.setFilterBitmap(true);
      this.mMatrix = new Matrix();
      this.mScale = 1.0F;
      this.mBackgroundColor = this.TRANSPARENT;
      this.mFrameColor = -1;
      this.mOverlayColor = -1157627904;
      this.mHandleColor = -1;
      this.mGuideColor = -1140850689;
      this.handleStyleable(var1, var2, var3, var4);
   }

   private void adjustRatio() {
      RectF var1 = this.mImageRect;
      if (var1 != null) {
         float var2 = var1.right - this.mImageRect.left;
         float var3 = this.mImageRect.bottom - this.mImageRect.top;
         float var4 = this.getRatioX(var2);
         float var5 = this.getRatioY(var3);
         float var6 = var2 / var3;
         float var7 = var4 / var5;
         float var8 = this.mImageRect.left;
         float var9 = this.mImageRect.top;
         float var10 = this.mImageRect.right;
         float var11 = this.mImageRect.bottom;
         if (var7 >= var6) {
            var8 = this.mImageRect.left;
            var10 = this.mImageRect.right;
            float var24 = 0.5F * (this.mImageRect.top + this.mImageRect.bottom);
            float var25 = 0.5F * (var2 / var7);
            var9 = var24 - var25;
            var11 = var24 + var25;
         } else if (var7 < var6) {
            var9 = this.mImageRect.top;
            var11 = this.mImageRect.bottom;
            float var22 = 0.5F * (this.mImageRect.left + this.mImageRect.right);
            float var23 = 0.5F * var3 * var7;
            var8 = var22 - var23;
            var10 = var22 + var23;
         }

         float var12 = var10 - var8;
         float var13 = var11 - var9;
         float var14 = var8 + var12 / 2.0F;
         float var15 = var9 + var13 / 2.0F;
         float var16 = this.mInitialFrameScale;
         float var17 = var12 * var16;
         float var18 = var13 * var16;
         float var19 = var17 / 2.0F;
         float var20 = var14 - var19;
         float var21 = var18 / 2.0F;
         this.mFrameRect = new RectF(var20, var15 - var21, var14 + var19, var15 + var21);
         this.invalidate();
      }
   }

   private void checkMoveBounds() {
      float var1 = this.mFrameRect.left - this.mImageRect.left;
      if (var1 < 0.0F) {
         RectF var11 = this.mFrameRect;
         var11.left -= var1;
         RectF var12 = this.mFrameRect;
         var12.right -= var1;
      }

      float var2 = this.mFrameRect.right - this.mImageRect.right;
      if (var2 > 0.0F) {
         RectF var9 = this.mFrameRect;
         var9.left -= var2;
         RectF var10 = this.mFrameRect;
         var10.right -= var2;
      }

      float var3 = this.mFrameRect.top - this.mImageRect.top;
      if (var3 < 0.0F) {
         RectF var7 = this.mFrameRect;
         var7.top -= var3;
         RectF var8 = this.mFrameRect;
         var8.bottom -= var3;
      }

      float var4 = this.mFrameRect.bottom - this.mImageRect.bottom;
      if (var4 > 0.0F) {
         RectF var5 = this.mFrameRect;
         var5.top -= var4;
         RectF var6 = this.mFrameRect;
         var6.bottom -= var4;
      }

   }

   private void checkScaleBounds() {
      float var1 = this.mFrameRect.left - this.mImageRect.left;
      float var2 = this.mFrameRect.right - this.mImageRect.right;
      float var3 = this.mFrameRect.top - this.mImageRect.top;
      float var4 = this.mFrameRect.bottom - this.mImageRect.bottom;
      if (var1 < 0.0F) {
         RectF var8 = this.mFrameRect;
         var8.left -= var1;
      }

      if (var2 > 0.0F) {
         RectF var7 = this.mFrameRect;
         var7.right -= var2;
      }

      if (var3 < 0.0F) {
         RectF var6 = this.mFrameRect;
         var6.top -= var3;
      }

      if (var4 > 0.0F) {
         RectF var5 = this.mFrameRect;
         var5.bottom -= var4;
      }

   }

   private void checkTouchArea(float var1, float var2) {
      if (this.isInsideCornerLeftTop(var1, var2)) {
         this.mTouchArea = CropImageView.TouchArea.LEFT_TOP;
         if (this.mHandleShowMode == CropImageView.ShowMode.SHOW_ON_TOUCH) {
            this.mShowHandle = true;
         }

         if (this.mGuideShowMode == CropImageView.ShowMode.SHOW_ON_TOUCH) {
            this.mShowGuide = true;
         }

      } else if (this.isInsideCornerRightTop(var1, var2)) {
         this.mTouchArea = CropImageView.TouchArea.RIGHT_TOP;
         if (this.mHandleShowMode == CropImageView.ShowMode.SHOW_ON_TOUCH) {
            this.mShowHandle = true;
         }

         if (this.mGuideShowMode == CropImageView.ShowMode.SHOW_ON_TOUCH) {
            this.mShowGuide = true;
         }

      } else if (this.isInsideCornerLeftBottom(var1, var2)) {
         this.mTouchArea = CropImageView.TouchArea.LEFT_BOTTOM;
         if (this.mHandleShowMode == CropImageView.ShowMode.SHOW_ON_TOUCH) {
            this.mShowHandle = true;
         }

         if (this.mGuideShowMode == CropImageView.ShowMode.SHOW_ON_TOUCH) {
            this.mShowGuide = true;
         }

      } else if (this.isInsideCornerRightBottom(var1, var2)) {
         this.mTouchArea = CropImageView.TouchArea.RIGHT_BOTTOM;
         if (this.mHandleShowMode == CropImageView.ShowMode.SHOW_ON_TOUCH) {
            this.mShowHandle = true;
         }

         if (this.mGuideShowMode == CropImageView.ShowMode.SHOW_ON_TOUCH) {
            this.mShowGuide = true;
         }

      } else if (this.isInsideFrame(var1, var2)) {
         if (this.mGuideShowMode == CropImageView.ShowMode.SHOW_ON_TOUCH) {
            this.mShowGuide = true;
         }

         this.mTouchArea = CropImageView.TouchArea.CENTER;
      } else {
         this.mTouchArea = CropImageView.TouchArea.OUT_OF_BOUNDS;
      }
   }

   private float constrain(float var1, float var2, float var3, float var4) {
      if (var1 >= var2) {
         return var1 > var3 ? var4 : var1;
      } else {
         return var4;
      }
   }

   private void drawEditFrame(Canvas var1) {
      if (this.mIsCropEnabled) {
         if (this.mCropMode == CropImageView.CropMode.CIRCLE) {
            this.mPaintTransparent.setFilterBitmap(true);
            this.mPaintTransparent.setColor(this.mOverlayColor);
            this.mPaintTransparent.setStyle(Style.FILL);
            Path var6 = new Path();
            var6.addRect(this.mImageRect.left, this.mImageRect.top, this.mImageRect.right, this.mImageRect.bottom, Direction.CW);
            var6.addCircle((this.mFrameRect.left + this.mFrameRect.right) / 2.0F, (this.mFrameRect.top + this.mFrameRect.bottom) / 2.0F, (this.mFrameRect.right - this.mFrameRect.left) / 2.0F, Direction.CCW);
            var1.drawPath(var6, this.mPaintTransparent);
         } else {
            this.mPaintTransparent.setFilterBitmap(true);
            this.mPaintTransparent.setColor(this.mOverlayColor);
            this.mPaintTransparent.setStyle(Style.FILL);
            var1.drawRect(this.mImageRect.left, this.mImageRect.top, this.mImageRect.right, this.mFrameRect.top, this.mPaintTransparent);
            var1.drawRect(this.mImageRect.left, this.mFrameRect.bottom, this.mImageRect.right, this.mImageRect.bottom, this.mPaintTransparent);
            var1.drawRect(this.mImageRect.left, this.mFrameRect.top, this.mFrameRect.left, this.mFrameRect.bottom, this.mPaintTransparent);
            var1.drawRect(this.mFrameRect.right, this.mFrameRect.top, this.mImageRect.right, this.mFrameRect.bottom, this.mPaintTransparent);
         }

         this.mPaintFrame.setAntiAlias(true);
         this.mPaintFrame.setFilterBitmap(true);
         this.mPaintFrame.setStyle(Style.STROKE);
         this.mPaintFrame.setColor(this.mFrameColor);
         this.mPaintFrame.setStrokeWidth(this.mFrameStrokeWeight);
         var1.drawRect(this.mFrameRect.left, this.mFrameRect.top, this.mFrameRect.right, this.mFrameRect.bottom, this.mPaintFrame);
         if (this.mShowGuide) {
            this.mPaintFrame.setColor(this.mGuideColor);
            this.mPaintFrame.setStrokeWidth(this.mGuideStrokeWeight);
            float var2 = this.mFrameRect.left + (this.mFrameRect.right - this.mFrameRect.left) / 3.0F;
            float var3 = this.mFrameRect.right - (this.mFrameRect.right - this.mFrameRect.left) / 3.0F;
            float var4 = this.mFrameRect.top + (this.mFrameRect.bottom - this.mFrameRect.top) / 3.0F;
            float var5 = this.mFrameRect.bottom - (this.mFrameRect.bottom - this.mFrameRect.top) / 3.0F;
            var1.drawLine(var2, this.mFrameRect.top, var2, this.mFrameRect.bottom, this.mPaintFrame);
            var1.drawLine(var3, this.mFrameRect.top, var3, this.mFrameRect.bottom, this.mPaintFrame);
            var1.drawLine(this.mFrameRect.left, var4, this.mFrameRect.right, var4, this.mPaintFrame);
            var1.drawLine(this.mFrameRect.left, var5, this.mFrameRect.right, var5, this.mPaintFrame);
         }

         if (this.mShowHandle) {
            this.mPaintFrame.setStyle(Style.FILL);
            this.mPaintFrame.setColor(this.mHandleColor);
            var1.drawCircle(this.mFrameRect.left, this.mFrameRect.top, (float)this.mHandleSize, this.mPaintFrame);
            var1.drawCircle(this.mFrameRect.right, this.mFrameRect.top, (float)this.mHandleSize, this.mPaintFrame);
            var1.drawCircle(this.mFrameRect.left, this.mFrameRect.bottom, (float)this.mHandleSize, this.mPaintFrame);
            var1.drawCircle(this.mFrameRect.right, this.mFrameRect.bottom, (float)this.mHandleSize, this.mPaintFrame);
         }

      }
   }

   private Bitmap getBitmap() {
      Drawable var1 = this.getDrawable();
      return var1 != null && var1 instanceof BitmapDrawable ? ((BitmapDrawable)var1).getBitmap() : null;
   }

   private float getDensity() {
      DisplayMetrics var1 = new DisplayMetrics();
      ((WindowManager)this.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(var1);
      return var1.density;
   }

   private float getFrameH() {
      return this.mFrameRect.bottom - this.mFrameRect.top;
   }

   private float getFrameW() {
      return this.mFrameRect.right - this.mFrameRect.left;
   }

   private float getRatioX() {
      switch(null.$SwitchMap$com$brq$inspecao_360_android$presentantion$view$custom$CropImageView$CropMode[this.mCropMode.ordinal()]) {
      case 1:
         return this.mImgWidth;
      case 2:
      default:
         return 1.0F;
      case 3:
         return 4.0F;
      case 4:
         return 3.0F;
      case 5:
         return 16.0F;
      case 6:
         return 9.0F;
      case 7:
      case 8:
         return 1.0F;
      case 9:
         return this.mCustomRatio.x;
      }
   }

   private float getRatioX(float var1) {
      switch(null.$SwitchMap$com$brq$inspecao_360_android$presentantion$view$custom$CropImageView$CropMode[this.mCropMode.ordinal()]) {
      case 1:
         return this.mImgWidth;
      case 3:
         var1 = 4.0F;
      case 2:
         return var1;
      case 4:
         return 3.0F;
      case 5:
         return 16.0F;
      case 6:
         return 9.0F;
      case 7:
      case 8:
         return 1.0F;
      case 9:
         return this.mCustomRatio.x;
      default:
         return var1;
      }
   }

   private float getRatioY() {
      switch(null.$SwitchMap$com$brq$inspecao_360_android$presentantion$view$custom$CropImageView$CropMode[this.mCropMode.ordinal()]) {
      case 1:
         return this.mImgHeight;
      case 2:
      default:
         return 1.0F;
      case 3:
         return 3.0F;
      case 4:
         return 4.0F;
      case 5:
         return 9.0F;
      case 6:
         return 16.0F;
      case 7:
      case 8:
         return 1.0F;
      case 9:
         return this.mCustomRatio.y;
      }
   }

   private float getRatioY(float var1) {
      switch(null.$SwitchMap$com$brq$inspecao_360_android$presentantion$view$custom$CropImageView$CropMode[this.mCropMode.ordinal()]) {
      case 1:
         return this.mImgHeight;
      case 3:
         var1 = 3.0F;
      case 2:
         return var1;
      case 4:
         return 4.0F;
      case 5:
         return 9.0F;
      case 6:
         return 16.0F;
      case 7:
      case 8:
         return 1.0F;
      case 9:
         return this.mCustomRatio.y;
      default:
         return var1;
      }
   }

   private void handleStyleable(Context param1, AttributeSet param2, int param3, float param4) {
      // $FF: Couldn't be decompiled
   }

   private void initCropFrame() {
      this.setMatrix();
      float[] var1 = new float[8];
      var1[0] = 0.0F;
      var1[1] = 0.0F;
      var1[2] = 0.0F;
      float var2 = this.mImgHeight;
      var1[3] = var2;
      float var3 = this.mImgWidth;
      var1[4] = var3;
      var1[5] = 0.0F;
      var1[6] = var3;
      var1[7] = var2;
      this.mMatrix.mapPoints(var1);
      float var4 = var1[0];
      float var5 = var1[1];
      float var6 = var1[6];
      float var7 = var1[7];
      this.mFrameRect = new RectF(var4, var5, var6, var7);
      this.mImageRect = new RectF(var4, var5, var6, var7);
   }

   private void initLayout(int var1, int var2) {
      this.mImgWidth = (float)this.getDrawable().getIntrinsicWidth();
      this.mImgHeight = (float)this.getDrawable().getIntrinsicHeight();
      if (this.mImgWidth <= 0.0F) {
         this.mImgWidth = (float)var1;
      }

      if (this.mImgHeight <= 0.0F) {
         this.mImgHeight = (float)var2;
      }

      float var3 = (float)var1;
      float var4 = (float)var2;
      float var5 = var3 / var4;
      float var6 = this.mImgWidth;
      float var7 = this.mImgHeight;
      float var8 = var6 / var7;
      float var9 = 1.0F;
      if (var8 >= var5) {
         var9 = var3 / var6;
      } else if (var8 < var5) {
         var9 = var4 / var7;
      }

      this.setCenter(new PointF((float)this.getPaddingLeft() + var3 * 0.5F, (float)this.getPaddingTop() + var4 * 0.5F));
      this.setScale(var9);
      this.initCropFrame();
      this.adjustRatio();
      this.mIsInitialized = true;
   }

   private boolean isHeightTooSmall() {
      return this.getFrameH() < this.mMinFrameSize;
   }

   private boolean isInsideCornerLeftBottom(float var1, float var2) {
      float var3 = var1 - this.mFrameRect.left;
      float var4 = var2 - this.mFrameRect.bottom;
      float var5 = var3 * var3 + var4 * var4;
      return this.sq((float)(this.mHandleSize + this.mTouchPadding)) >= var5;
   }

   private boolean isInsideCornerLeftTop(float var1, float var2) {
      float var3 = var1 - this.mFrameRect.left;
      float var4 = var2 - this.mFrameRect.top;
      float var5 = var3 * var3 + var4 * var4;
      return this.sq((float)(this.mHandleSize + this.mTouchPadding)) >= var5;
   }

   private boolean isInsideCornerRightBottom(float var1, float var2) {
      float var3 = var1 - this.mFrameRect.right;
      float var4 = var2 - this.mFrameRect.bottom;
      float var5 = var3 * var3 + var4 * var4;
      return this.sq((float)(this.mHandleSize + this.mTouchPadding)) >= var5;
   }

   private boolean isInsideCornerRightTop(float var1, float var2) {
      float var3 = var1 - this.mFrameRect.right;
      float var4 = var2 - this.mFrameRect.top;
      float var5 = var3 * var3 + var4 * var4;
      return this.sq((float)(this.mHandleSize + this.mTouchPadding)) >= var5;
   }

   private boolean isInsideFrame(float var1, float var2) {
      if (this.mFrameRect.left <= var1 && this.mFrameRect.right >= var1 && this.mFrameRect.top <= var2 && this.mFrameRect.bottom >= var2) {
         this.mTouchArea = CropImageView.TouchArea.CENTER;
         return true;
      } else {
         return false;
      }
   }

   private boolean isInsideHorizontal(float var1) {
      return this.mImageRect.left <= var1 && this.mImageRect.right >= var1;
   }

   private boolean isInsideVertical(float var1) {
      return this.mImageRect.top <= var1 && this.mImageRect.bottom >= var1;
   }

   private boolean isWidthTooSmall() {
      return this.getFrameW() < this.mMinFrameSize;
   }

   private void moveFrame(float var1, float var2) {
      RectF var3 = this.mFrameRect;
      var3.left += var1;
      RectF var4 = this.mFrameRect;
      var4.right += var1;
      RectF var5 = this.mFrameRect;
      var5.top += var2;
      RectF var6 = this.mFrameRect;
      var6.bottom += var2;
      this.checkMoveBounds();
   }

   private void moveHandleLB(float var1, float var2) {
      if (this.mCropMode == CropImageView.CropMode.RATIO_FREE) {
         RectF var22 = this.mFrameRect;
         var22.left += var1;
         RectF var23 = this.mFrameRect;
         var23.bottom += var2;
         if (this.isWidthTooSmall()) {
            float var26 = this.mMinFrameSize - this.getFrameW();
            RectF var27 = this.mFrameRect;
            var27.left -= var26;
         }

         if (this.isHeightTooSmall()) {
            float var24 = this.mMinFrameSize - this.getFrameH();
            RectF var25 = this.mFrameRect;
            var25.bottom += var24;
         }

         this.checkScaleBounds();
      } else {
         float var3 = var1 * this.getRatioY() / this.getRatioX();
         RectF var4 = this.mFrameRect;
         var4.left += var1;
         RectF var5 = this.mFrameRect;
         var5.bottom -= var3;
         if (this.isWidthTooSmall()) {
            float var18 = this.mMinFrameSize - this.getFrameW();
            RectF var19 = this.mFrameRect;
            var19.left -= var18;
            float var20 = var18 * this.getRatioY() / this.getRatioX();
            RectF var21 = this.mFrameRect;
            var21.bottom += var20;
         }

         if (this.isHeightTooSmall()) {
            float var14 = this.mMinFrameSize - this.getFrameH();
            RectF var15 = this.mFrameRect;
            var15.bottom += var14;
            float var16 = var14 * this.getRatioX() / this.getRatioY();
            RectF var17 = this.mFrameRect;
            var17.left -= var16;
         }

         if (!this.isInsideHorizontal(this.mFrameRect.left)) {
            float var10 = this.mImageRect.left - this.mFrameRect.left;
            RectF var11 = this.mFrameRect;
            var11.left += var10;
            float var12 = var10 * this.getRatioY() / this.getRatioX();
            RectF var13 = this.mFrameRect;
            var13.bottom -= var12;
         }

         if (!this.isInsideVertical(this.mFrameRect.bottom)) {
            float var6 = this.mFrameRect.bottom - this.mImageRect.bottom;
            RectF var7 = this.mFrameRect;
            var7.bottom -= var6;
            float var8 = var6 * this.getRatioX() / this.getRatioY();
            RectF var9 = this.mFrameRect;
            var9.left += var8;
         }

      }
   }

   private void moveHandleLT(float var1, float var2) {
      if (this.mCropMode == CropImageView.CropMode.RATIO_FREE) {
         RectF var22 = this.mFrameRect;
         var22.left += var1;
         RectF var23 = this.mFrameRect;
         var23.top += var2;
         if (this.isWidthTooSmall()) {
            float var26 = this.mMinFrameSize - this.getFrameW();
            RectF var27 = this.mFrameRect;
            var27.left -= var26;
         }

         if (this.isHeightTooSmall()) {
            float var24 = this.mMinFrameSize - this.getFrameH();
            RectF var25 = this.mFrameRect;
            var25.top -= var24;
         }

         this.checkScaleBounds();
      } else {
         float var3 = var1 * this.getRatioY() / this.getRatioX();
         RectF var4 = this.mFrameRect;
         var4.left += var1;
         RectF var5 = this.mFrameRect;
         var5.top += var3;
         if (this.isWidthTooSmall()) {
            float var18 = this.mMinFrameSize - this.getFrameW();
            RectF var19 = this.mFrameRect;
            var19.left -= var18;
            float var20 = var18 * this.getRatioY() / this.getRatioX();
            RectF var21 = this.mFrameRect;
            var21.top -= var20;
         }

         if (this.isHeightTooSmall()) {
            float var14 = this.mMinFrameSize - this.getFrameH();
            RectF var15 = this.mFrameRect;
            var15.top -= var14;
            float var16 = var14 * this.getRatioX() / this.getRatioY();
            RectF var17 = this.mFrameRect;
            var17.left -= var16;
         }

         if (!this.isInsideHorizontal(this.mFrameRect.left)) {
            float var10 = this.mImageRect.left - this.mFrameRect.left;
            RectF var11 = this.mFrameRect;
            var11.left += var10;
            float var12 = var10 * this.getRatioY() / this.getRatioX();
            RectF var13 = this.mFrameRect;
            var13.top += var12;
         }

         if (!this.isInsideVertical(this.mFrameRect.top)) {
            float var6 = this.mImageRect.top - this.mFrameRect.top;
            RectF var7 = this.mFrameRect;
            var7.top += var6;
            float var8 = var6 * this.getRatioX() / this.getRatioY();
            RectF var9 = this.mFrameRect;
            var9.left += var8;
         }

      }
   }

   private void moveHandleRB(float var1, float var2) {
      if (this.mCropMode == CropImageView.CropMode.RATIO_FREE) {
         RectF var22 = this.mFrameRect;
         var22.right += var1;
         RectF var23 = this.mFrameRect;
         var23.bottom += var2;
         if (this.isWidthTooSmall()) {
            float var26 = this.mMinFrameSize - this.getFrameW();
            RectF var27 = this.mFrameRect;
            var27.right += var26;
         }

         if (this.isHeightTooSmall()) {
            float var24 = this.mMinFrameSize - this.getFrameH();
            RectF var25 = this.mFrameRect;
            var25.bottom += var24;
         }

         this.checkScaleBounds();
      } else {
         float var3 = var1 * this.getRatioY() / this.getRatioX();
         RectF var4 = this.mFrameRect;
         var4.right += var1;
         RectF var5 = this.mFrameRect;
         var5.bottom += var3;
         if (this.isWidthTooSmall()) {
            float var18 = this.mMinFrameSize - this.getFrameW();
            RectF var19 = this.mFrameRect;
            var19.right += var18;
            float var20 = var18 * this.getRatioY() / this.getRatioX();
            RectF var21 = this.mFrameRect;
            var21.bottom += var20;
         }

         if (this.isHeightTooSmall()) {
            float var14 = this.mMinFrameSize - this.getFrameH();
            RectF var15 = this.mFrameRect;
            var15.bottom += var14;
            float var16 = var14 * this.getRatioX() / this.getRatioY();
            RectF var17 = this.mFrameRect;
            var17.right += var16;
         }

         if (!this.isInsideHorizontal(this.mFrameRect.right)) {
            float var10 = this.mFrameRect.right - this.mImageRect.right;
            RectF var11 = this.mFrameRect;
            var11.right -= var10;
            float var12 = var10 * this.getRatioY() / this.getRatioX();
            RectF var13 = this.mFrameRect;
            var13.bottom -= var12;
         }

         if (!this.isInsideVertical(this.mFrameRect.bottom)) {
            float var6 = this.mFrameRect.bottom - this.mImageRect.bottom;
            RectF var7 = this.mFrameRect;
            var7.bottom -= var6;
            float var8 = var6 * this.getRatioX() / this.getRatioY();
            RectF var9 = this.mFrameRect;
            var9.right -= var8;
         }

      }
   }

   private void moveHandleRT(float var1, float var2) {
      if (this.mCropMode == CropImageView.CropMode.RATIO_FREE) {
         RectF var22 = this.mFrameRect;
         var22.right += var1;
         RectF var23 = this.mFrameRect;
         var23.top += var2;
         if (this.isWidthTooSmall()) {
            float var26 = this.mMinFrameSize - this.getFrameW();
            RectF var27 = this.mFrameRect;
            var27.right += var26;
         }

         if (this.isHeightTooSmall()) {
            float var24 = this.mMinFrameSize - this.getFrameH();
            RectF var25 = this.mFrameRect;
            var25.top -= var24;
         }

         this.checkScaleBounds();
      } else {
         float var3 = var1 * this.getRatioY() / this.getRatioX();
         RectF var4 = this.mFrameRect;
         var4.right += var1;
         RectF var5 = this.mFrameRect;
         var5.top -= var3;
         if (this.isWidthTooSmall()) {
            float var18 = this.mMinFrameSize - this.getFrameW();
            RectF var19 = this.mFrameRect;
            var19.right += var18;
            float var20 = var18 * this.getRatioY() / this.getRatioX();
            RectF var21 = this.mFrameRect;
            var21.top -= var20;
         }

         if (this.isHeightTooSmall()) {
            float var14 = this.mMinFrameSize - this.getFrameH();
            RectF var15 = this.mFrameRect;
            var15.top -= var14;
            float var16 = var14 * this.getRatioX() / this.getRatioY();
            RectF var17 = this.mFrameRect;
            var17.right += var16;
         }

         if (!this.isInsideHorizontal(this.mFrameRect.right)) {
            float var10 = this.mFrameRect.right - this.mImageRect.right;
            RectF var11 = this.mFrameRect;
            var11.right -= var10;
            float var12 = var10 * this.getRatioY() / this.getRatioX();
            RectF var13 = this.mFrameRect;
            var13.top += var12;
         }

         if (!this.isInsideVertical(this.mFrameRect.top)) {
            float var6 = this.mImageRect.top - this.mFrameRect.top;
            RectF var7 = this.mFrameRect;
            var7.top += var6;
            float var8 = var6 * this.getRatioX() / this.getRatioY();
            RectF var9 = this.mFrameRect;
            var9.right -= var8;
         }

      }
   }

   private void onCancel() {
      this.mTouchArea = CropImageView.TouchArea.OUT_OF_BOUNDS;
      this.invalidate();
   }

   private void onDown(MotionEvent var1) {
      this.invalidate();
      this.mLastX = var1.getX();
      this.mLastY = var1.getY();
      this.checkTouchArea(var1.getX(), var1.getY());
   }

   private void onMove(MotionEvent var1) {
      float var2 = var1.getX() - this.mLastX;
      float var3 = var1.getY() - this.mLastY;
      int var4 = null.$SwitchMap$com$brq$inspecao_360_android$presentantion$view$custom$CropImageView$TouchArea[this.mTouchArea.ordinal()];
      if (var4 != 1) {
         if (var4 != 2) {
            if (var4 != 3) {
               if (var4 != 4) {
                  if (var4 == 5) {
                     this.moveHandleRB(var2, var3);
                  }
               } else {
                  this.moveHandleLB(var2, var3);
               }
            } else {
               this.moveHandleRT(var2, var3);
            }
         } else {
            this.moveHandleLT(var2, var3);
         }
      } else {
         this.moveFrame(var2, var3);
      }

      this.invalidate();
      this.mLastX = var1.getX();
      this.mLastY = var1.getY();
   }

   private void onUp(MotionEvent var1) {
      if (this.mGuideShowMode == CropImageView.ShowMode.SHOW_ON_TOUCH) {
         this.mShowGuide = false;
      }

      if (this.mHandleShowMode == CropImageView.ShowMode.SHOW_ON_TOUCH) {
         this.mShowHandle = false;
      }

      this.mTouchArea = CropImageView.TouchArea.OUT_OF_BOUNDS;
      this.invalidate();
   }

   private void setCenter(PointF var1) {
      this.mCenter = var1;
   }

   private void setMatrix() {
      this.mMatrix.reset();
      this.mMatrix.setTranslate(this.mCenter.x - 0.5F * this.mImgWidth, this.mCenter.y - 0.5F * this.mImgHeight);
      Matrix var1 = this.mMatrix;
      float var2 = this.mScale;
      var1.postScale(var2, var2, this.mCenter.x, this.mCenter.y);
      this.mMatrix.postRotate(this.mAngle, this.mCenter.x, this.mCenter.y);
   }

   private void setScale(float var1) {
      this.mScale = var1;
   }

   private float sq(float var1) {
      return var1 * var1;
   }

   private void updateDrawableInfo() {
      if (this.getDrawable() != null) {
         this.initLayout(this.mViewWidth, this.mViewHeight);
      }

   }

   public RectF getActualCropRect() {
      float var1 = this.mImageRect.left / this.mScale;
      float var2 = this.mImageRect.top / this.mScale;
      return new RectF(this.mFrameRect.left / this.mScale - var1, this.mFrameRect.top / this.mScale - var2, this.mFrameRect.right / this.mScale - var1, this.mFrameRect.bottom / this.mScale - var2);
   }

   public Bitmap getCircularBitmap(Bitmap var1) {
      if (var1 == null) {
         return null;
      } else {
         Bitmap var2 = Bitmap.createBitmap(var1.getWidth(), var1.getHeight(), Config.ARGB_8888);
         Rect var3 = new Rect(0, 0, var1.getWidth(), var1.getHeight());
         Canvas var4 = new Canvas(var2);
         int var5 = var1.getWidth() / 2;
         int var6 = var1.getHeight() / 2;
         Paint var7 = new Paint();
         var7.setAntiAlias(true);
         var7.setFilterBitmap(true);
         var4.drawCircle((float)var5, (float)var6, (float)Math.min(var5, var6), var7);
         var7.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
         var4.drawBitmap(var1, var3, var3, var7);
         return var2;
      }
   }

   public Bitmap getCroppedBitmap() {
      Bitmap var1 = this.getBitmap();
      if (var1 == null) {
         return null;
      } else {
         float var2 = this.mFrameRect.left / this.mScale;
         float var3 = this.mFrameRect.top / this.mScale;
         float var4 = this.mFrameRect.right / this.mScale;
         float var5 = this.mFrameRect.bottom / this.mScale;
         int var6 = Math.round(var2 - this.mImageRect.left / this.mScale);
         int var7 = Math.round(var3 - this.mImageRect.top / this.mScale);
         int var8 = Math.round(var4 - var2);
         int var9 = Math.round(var5 - var3);
         if (var6 + var8 > var1.getWidth()) {
            var8 = var1.getWidth() - var6;
         }

         int var11;
         if (var7 + var9 > var1.getHeight()) {
            var11 = var1.getHeight() - var7;
         } else {
            var11 = var9;
         }

         Bitmap var12 = Bitmap.createBitmap(var1, var6, var7, var8, var11, (Matrix)null, false);
         return this.mCropMode != CropImageView.CropMode.CIRCLE ? var12 : this.getCircularBitmap(var12);
      }
   }

   public Bitmap getImageBitmap() {
      return this.getBitmap();
   }

   public Bitmap getRectBitmap() {
      Bitmap var1 = this.getBitmap();
      if (var1 == null) {
         return null;
      } else {
         float var2 = this.mFrameRect.left / this.mScale;
         float var3 = this.mFrameRect.top / this.mScale;
         float var4 = this.mFrameRect.right / this.mScale;
         float var5 = this.mFrameRect.bottom / this.mScale;
         int var6 = Math.round(var2 - this.mImageRect.left / this.mScale);
         int var7 = Math.round(var3 - this.mImageRect.top / this.mScale);
         int var8 = Math.round(var4 - var2);
         int var9 = Math.round(var5 - var3);
         if (var6 + var8 > var1.getWidth()) {
            var8 = var1.getWidth() - var6;
         }

         int var11;
         if (var7 + var9 > var1.getHeight()) {
            var11 = var1.getHeight() - var7;
         } else {
            var11 = var9;
         }

         return Bitmap.createBitmap(var1, var6, var7, var8, var11, (Matrix)null, false);
      }
   }

   public void onDraw(Canvas var1) {
      super.onDraw(var1);
      if (this.mIsInitialized) {
         this.setMatrix();
         Matrix var2 = new Matrix();
         var2.postConcat(this.mMatrix);
         Bitmap var4 = this.getBitmap();
         if (var4 != null) {
            var1.drawBitmap(var4, var2, this.mPaintBitmap);
            this.drawEditFrame(var1);
         }
      }

   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      this.mViewWidth = var4 - var2 - this.getPaddingLeft() - this.getPaddingRight();
      this.mViewHeight = var5 - var3 - this.getPaddingTop() - this.getPaddingBottom();
      if (this.getDrawable() != null) {
         this.initLayout(this.mViewWidth, this.mViewHeight);
      }

   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      this.setMeasuredDimension(MeasureSpec.getSize(var1), MeasureSpec.getSize(var2));
   }

   public void onRestoreInstanceState(Parcelable var1) {
      CropImageView.SavedState var2 = (CropImageView.SavedState)var1;
      super.onRestoreInstanceState(var2.getSuperState());
      this.mCropMode = var2.mode;
      this.mBackgroundColor = var2.backgroundColor;
      this.mOverlayColor = var2.overlayColor;
      this.mFrameColor = var2.frameColor;
      this.mGuideShowMode = var2.guideShowMode;
      this.mHandleShowMode = var2.handleShowMode;
      this.mShowGuide = var2.showGuide;
      this.mShowHandle = var2.showHandle;
      this.mHandleSize = var2.handleSize;
      this.mTouchPadding = var2.touchPadding;
      this.mMinFrameSize = var2.minFrameSize;
      this.mCustomRatio = new PointF(var2.customRatioX, var2.customRatioY);
      this.mFrameStrokeWeight = var2.frameStrokeWeight;
      this.mGuideStrokeWeight = var2.guideStrokeWeight;
      this.mIsCropEnabled = var2.isCropEnabled;
      this.mHandleColor = var2.handleColor;
      this.mGuideColor = var2.guideColor;
      this.mInitialFrameScale = var2.initialFrameScale;
      this.setImageBitmap(var2.image);
      this.requestLayout();
   }

   public Parcelable onSaveInstanceState() {
      CropImageView.SavedState var1 = new CropImageView.SavedState(super.onSaveInstanceState());
      var1.image = this.getBitmap();
      var1.mode = this.mCropMode;
      var1.backgroundColor = this.mBackgroundColor;
      var1.overlayColor = this.mOverlayColor;
      var1.frameColor = this.mFrameColor;
      var1.guideShowMode = this.mGuideShowMode;
      var1.handleShowMode = this.mHandleShowMode;
      var1.showGuide = this.mShowGuide;
      var1.showHandle = this.mShowHandle;
      var1.handleSize = this.mHandleSize;
      var1.touchPadding = this.mTouchPadding;
      var1.minFrameSize = this.mMinFrameSize;
      var1.customRatioX = this.mCustomRatio.x;
      var1.customRatioY = this.mCustomRatio.y;
      var1.frameStrokeWeight = this.mFrameStrokeWeight;
      var1.guideStrokeWeight = this.mGuideStrokeWeight;
      var1.isCropEnabled = this.mIsCropEnabled;
      var1.handleColor = this.mHandleColor;
      var1.guideColor = this.mGuideColor;
      var1.initialFrameScale = this.mInitialFrameScale;
      return var1;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      if (!this.mIsInitialized) {
         return false;
      } else if (!this.mIsCropEnabled) {
         return false;
      } else if (!this.mIsEnabled) {
         return false;
      } else {
         int var2 = var1.getAction();
         if (var2 != 0) {
            if (var2 != 1) {
               if (var2 != 2) {
                  if (var2 != 3) {
                     return false;
                  } else {
                     this.getParent().requestDisallowInterceptTouchEvent(false);
                     this.onCancel();
                     return true;
                  }
               } else {
                  this.onMove(var1);
                  if (this.mTouchArea != CropImageView.TouchArea.OUT_OF_BOUNDS) {
                     this.getParent().requestDisallowInterceptTouchEvent(true);
                  }

                  return true;
               }
            } else {
               this.getParent().requestDisallowInterceptTouchEvent(false);
               this.onUp(var1);
               return true;
            }
         } else {
            this.onDown(var1);
            return true;
         }
      }
   }

   public void rotateImage(CropImageView.RotateDegrees var1) {
      Bitmap var2 = this.getBitmap();
      if (var2 != null) {
         int var3 = var1.getValue();
         Matrix var4 = new Matrix();
         var4.postRotate((float)var3);
         this.setImageBitmap(Bitmap.createBitmap(var2, 0, 0, var2.getWidth(), var2.getHeight(), var4, true));
      }
   }

   public void setBackgroundColor(int var1) {
      this.mBackgroundColor = var1;
      super.setBackgroundColor(this.mBackgroundColor);
      this.invalidate();
   }

   public void setCropEnabled(boolean var1) {
      this.mIsCropEnabled = var1;
      this.invalidate();
   }

   public void setCropMode(CropImageView.CropMode var1) {
      if (var1 == CropImageView.CropMode.RATIO_CUSTOM) {
         this.setCustomRatio(1, 1);
      } else {
         this.mCropMode = var1;
         this.adjustRatio();
      }
   }

   public void setCustomRatio(int var1, int var2) {
      if (var1 != 0) {
         if (var2 == 0) {
            return;
         }

         this.mCropMode = CropImageView.CropMode.RATIO_CUSTOM;
         this.mCustomRatio = new PointF((float)var1, (float)var2);
         this.adjustRatio();
      }

   }

   public void setEnabled(boolean var1) {
      super.setEnabled(var1);
      this.mIsEnabled = var1;
   }

   public void setFrameColor(int var1) {
      this.mFrameColor = var1;
      this.invalidate();
   }

   public void setFrameStrokeWeightInDp(int var1) {
      this.mFrameStrokeWeight = (float)var1 * this.getDensity();
      this.invalidate();
   }

   public void setGuideColor(int var1) {
      this.mGuideColor = var1;
      this.invalidate();
   }

   public void setGuideShowMode(CropImageView.ShowMode var1) {
      this.mGuideShowMode = var1;
      int var2 = null.$SwitchMap$com$brq$inspecao_360_android$presentantion$view$custom$CropImageView$ShowMode[var1.ordinal()];
      if (var2 != 1) {
         if (var2 == 2 || var2 == 3) {
            this.mShowGuide = false;
         }
      } else {
         this.mShowGuide = true;
      }

      this.invalidate();
   }

   public void setGuideStrokeWeightInDp(int var1) {
      this.mGuideStrokeWeight = (float)var1 * this.getDensity();
      this.invalidate();
   }

   public void setHandleColor(int var1) {
      this.mHandleColor = var1;
      this.invalidate();
   }

   public void setHandleShowMode(CropImageView.ShowMode var1) {
      this.mHandleShowMode = var1;
      int var2 = null.$SwitchMap$com$brq$inspecao_360_android$presentantion$view$custom$CropImageView$ShowMode[var1.ordinal()];
      if (var2 != 1) {
         if (var2 == 2 || var2 == 3) {
            this.mShowHandle = false;
         }
      } else {
         this.mShowHandle = true;
      }

      this.invalidate();
   }

   public void setHandleSizeInDp(int var1) {
      this.mHandleSize = (int)((float)var1 * this.getDensity());
   }

   public void setImageBitmap(Bitmap var1) {
      this.mIsInitialized = false;
      super.setImageBitmap(var1);
      this.updateDrawableInfo();
   }

   public void setImageDrawable(Drawable var1) {
      this.mIsInitialized = false;
      super.setImageDrawable(var1);
      this.updateDrawableInfo();
   }

   public void setImageResource(int var1) {
      this.mIsInitialized = false;
      super.setImageResource(var1);
      this.updateDrawableInfo();
   }

   public void setImageURI(Uri var1) {
      this.mIsInitialized = false;
      super.setImageURI(var1);
      this.updateDrawableInfo();
   }

   public void setInitialFrameScale(float var1) {
      this.mInitialFrameScale = this.constrain(var1, 0.01F, 1.0F, 0.75F);
   }

   public void setMinFrameSizeInDp(int var1) {
      this.mMinFrameSize = (float)var1 * this.getDensity();
   }

   public void setMinFrameSizeInPx(int var1) {
      this.mMinFrameSize = (float)var1;
   }

   public void setOverlayColor(int var1) {
      this.mOverlayColor = var1;
      this.invalidate();
   }

   public void setTouchPaddingInDp(int var1) {
      this.mTouchPadding = (int)((float)var1 * this.getDensity());
   }

   public static enum CropMode {
      CIRCLE(8),
      RATIO_16_9(4),
      RATIO_1_1(3),
      RATIO_3_4(2),
      RATIO_4_3(1),
      RATIO_9_16(5),
      RATIO_CUSTOM(7),
      RATIO_FIT_IMAGE(0),
      RATIO_FREE(6);

      private final int ID;

      static {
         CropImageView.CropMode[] var0 = new CropImageView.CropMode[]{RATIO_FIT_IMAGE, RATIO_4_3, RATIO_3_4, RATIO_1_1, RATIO_16_9, RATIO_9_16, RATIO_FREE, RATIO_CUSTOM, CIRCLE};
      }

      private CropMode(int var3) {
         this.ID = var3;
      }

      public int getId() {
         return this.ID;
      }
   }

   public static enum RotateDegrees {
      ROTATE_180D(180),
      ROTATE_270D(270),
      ROTATE_90D(90);

      private final int VALUE;

      static {
         CropImageView.RotateDegrees[] var0 = new CropImageView.RotateDegrees[]{ROTATE_90D, ROTATE_180D, ROTATE_270D};
      }

      private RotateDegrees(int var3) {
         this.VALUE = var3;
      }

      public int getValue() {
         return this.VALUE;
      }
   }

   public static class SavedState extends BaseSavedState {
      public static final Creator CREATOR = new Creator() {
         public CropImageView.SavedState createFromParcel(Parcel var1) {
            return new CropImageView.SavedState(var1);
         }

         public CropImageView.SavedState[] newArray(int var1) {
            return new CropImageView.SavedState[var1];
         }
      };
      int backgroundColor;
      float customRatioX;
      float customRatioY;
      int frameColor;
      float frameStrokeWeight;
      int guideColor;
      CropImageView.ShowMode guideShowMode;
      float guideStrokeWeight;
      int handleColor;
      CropImageView.ShowMode handleShowMode;
      int handleSize;
      Bitmap image;
      float initialFrameScale;
      boolean isCropEnabled;
      float minFrameSize;
      CropImageView.CropMode mode;
      int overlayColor;
      boolean showGuide;
      boolean showHandle;
      int touchPadding;

      private SavedState(Parcel var1) {
         super(var1);
         this.image = (Bitmap)var1.readParcelable(Bitmap.class.getClassLoader());
         this.mode = (CropImageView.CropMode)var1.readSerializable();
         this.backgroundColor = var1.readInt();
         this.overlayColor = var1.readInt();
         this.frameColor = var1.readInt();
         this.guideShowMode = (CropImageView.ShowMode)var1.readSerializable();
         this.handleShowMode = (CropImageView.ShowMode)var1.readSerializable();
         int var2 = var1.readInt();
         boolean var3 = true;
         boolean var4;
         if (var2 != 0) {
            var4 = true;
         } else {
            var4 = false;
         }

         this.showGuide = var4;
         boolean var5;
         if (var1.readInt() != 0) {
            var5 = true;
         } else {
            var5 = false;
         }

         this.showHandle = var5;
         this.handleSize = var1.readInt();
         this.touchPadding = var1.readInt();
         this.minFrameSize = var1.readFloat();
         this.customRatioX = var1.readFloat();
         this.customRatioY = var1.readFloat();
         this.frameStrokeWeight = var1.readFloat();
         this.guideStrokeWeight = var1.readFloat();
         if (var1.readInt() == 0) {
            var3 = false;
         }

         this.isCropEnabled = var3;
         this.handleColor = var1.readInt();
         this.guideColor = var1.readInt();
         this.initialFrameScale = var1.readFloat();
      }

      // $FF: synthetic method
      SavedState(Parcel var1, Object var2) {
         this(var1);
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeParcelable(this.image, var2);
         var1.writeSerializable(this.mode);
         var1.writeInt(this.backgroundColor);
         var1.writeInt(this.overlayColor);
         var1.writeInt(this.frameColor);
         var1.writeSerializable(this.guideShowMode);
         var1.writeSerializable(this.handleShowMode);
         var1.writeInt(this.showGuide);
         var1.writeInt(this.showHandle);
         var1.writeInt(this.handleSize);
         var1.writeInt(this.touchPadding);
         var1.writeFloat(this.minFrameSize);
         var1.writeFloat(this.customRatioX);
         var1.writeFloat(this.customRatioY);
         var1.writeFloat(this.frameStrokeWeight);
         var1.writeFloat(this.guideStrokeWeight);
         var1.writeInt(this.isCropEnabled);
         var1.writeInt(this.handleColor);
         var1.writeInt(this.guideColor);
         var1.writeFloat(this.initialFrameScale);
      }
   }

   public static enum ShowMode {
      NOT_SHOW(3),
      SHOW_ALWAYS(1),
      SHOW_ON_TOUCH(2);

      private final int ID;

      static {
         CropImageView.ShowMode[] var0 = new CropImageView.ShowMode[]{SHOW_ALWAYS, SHOW_ON_TOUCH, NOT_SHOW};
      }

      private ShowMode(int var3) {
         this.ID = var3;
      }

      public int getId() {
         return this.ID;
      }
   }

   private static enum TouchArea {
      CENTER,
      LEFT_BOTTOM,
      LEFT_TOP,
      OUT_OF_BOUNDS,
      RIGHT_BOTTOM,
      RIGHT_TOP;

      static {
         CropImageView.TouchArea[] var0 = new CropImageView.TouchArea[]{OUT_OF_BOUNDS, CENTER, LEFT_TOP, RIGHT_TOP, LEFT_BOTTOM, RIGHT_BOTTOM};
      }
   }
}
