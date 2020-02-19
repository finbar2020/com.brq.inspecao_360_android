package com.aurelhubert.ahbottomnavigation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;
import com.aurelhubert.ahbottomnavigation.R.color;
import com.aurelhubert.ahbottomnavigation.R.dimen;
import com.aurelhubert.ahbottomnavigation.R.drawable;
import com.aurelhubert.ahbottomnavigation.R.id;
import com.aurelhubert.ahbottomnavigation.R.layout;
import com.aurelhubert.ahbottomnavigation.R.styleable;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.aurelhubert.ahbottomnavigation.notification.AHNotificationHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AHBottomNavigation extends FrameLayout {
   public static final int CURRENT_ITEM_NONE = -1;
   private static final String EXCEPTION_INDEX_OUT_OF_BOUNDS = "The position (%d) is out of bounds of the items (%d elements)";
   private static final int MAX_ITEMS = 5;
   private static final int MIN_ITEMS = 3;
   private static String TAG;
   public static final int UPDATE_ALL_NOTIFICATIONS = -1;
   private View backgroundColorView;
   private boolean behaviorTranslationEnabled;
   private AHBottomNavigationBehavior bottomNavigationBehavior;
   private int bottomNavigationHeight;
   private Animator circleRevealAnim;
   private boolean colored = false;
   @ColorInt
   private int coloredTitleColorActive;
   @ColorInt
   private int coloredTitleColorInactive;
   private Context context;
   private int currentColor;
   private int currentItem;
   private int defaultBackgroundColor;
   private int defaultBackgroundResource;
   private boolean forceTint;
   private boolean hideBottomNavigationWithAnimation;
   private boolean isBehaviorTranslationSet;
   @ColorInt
   private int itemActiveColor;
   @ColorInt
   private int itemDisableColor;
   @ColorInt
   private int itemInactiveColor;
   private ArrayList items = new ArrayList();
   private Boolean[] itemsEnabledStates;
   private LinearLayout linearLayoutContainer;
   private int navigationBarHeight;
   private AHBottomNavigation.OnNavigationPositionListener navigationPositionListener;
   private boolean needHideBottomNavigation;
   private float notSelectedItemWidth;
   private int notificationActiveMarginLeft;
   private int notificationActiveMarginTop;
   private long notificationAnimationDuration;
   @ColorInt
   private int notificationBackgroundColor;
   private Drawable notificationBackgroundDrawable;
   private int notificationInactiveMarginLeft;
   private int notificationInactiveMarginTop;
   @ColorInt
   private int notificationTextColor;
   private Typeface notificationTypeface;
   private List notifications = AHNotification.generateEmptyList(5);
   private Resources resources;
   private boolean selectedBackgroundVisible = false;
   private float selectedItemWidth;
   private boolean soundEffectsEnabled;
   private AHBottomNavigation.OnTabSelectedListener tabSelectedListener;
   private float titleActiveTextSize;
   @ColorInt
   private int titleColorActive;
   @ColorInt
   private int titleColorInactive;
   private float titleInactiveTextSize;
   private AHBottomNavigation.TitleState titleState;
   private Typeface titleTypeface;
   private boolean translucentNavigationEnabled;
   private ArrayList views = new ArrayList();

   public AHBottomNavigation(Context var1) {
      super(var1);
      Boolean[] var2 = new Boolean[5];
      Boolean var3 = true;
      var2[0] = var3;
      var2[1] = var3;
      var2[2] = var3;
      var2[3] = var3;
      var2[4] = var3;
      this.itemsEnabledStates = var2;
      this.isBehaviorTranslationSet = false;
      this.currentItem = 0;
      this.currentColor = 0;
      this.behaviorTranslationEnabled = true;
      this.needHideBottomNavigation = false;
      this.hideBottomNavigationWithAnimation = false;
      this.soundEffectsEnabled = true;
      this.defaultBackgroundColor = -1;
      this.defaultBackgroundResource = 0;
      this.navigationBarHeight = 0;
      this.forceTint = false;
      this.titleState = AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE;
      this.init(var1, (AttributeSet)null);
   }

   public AHBottomNavigation(Context var1, AttributeSet var2) {
      super(var1, var2);
      Boolean[] var3 = new Boolean[5];
      Boolean var4 = true;
      var3[0] = var4;
      var3[1] = var4;
      var3[2] = var4;
      var3[3] = var4;
      var3[4] = var4;
      this.itemsEnabledStates = var3;
      this.isBehaviorTranslationSet = false;
      this.currentItem = 0;
      this.currentColor = 0;
      this.behaviorTranslationEnabled = true;
      this.needHideBottomNavigation = false;
      this.hideBottomNavigationWithAnimation = false;
      this.soundEffectsEnabled = true;
      this.defaultBackgroundColor = -1;
      this.defaultBackgroundResource = 0;
      this.navigationBarHeight = 0;
      this.forceTint = false;
      this.titleState = AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE;
      this.init(var1, var2);
   }

   public AHBottomNavigation(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      Boolean[] var4 = new Boolean[5];
      Boolean var5 = true;
      var4[0] = var5;
      var4[1] = var5;
      var4[2] = var5;
      var4[3] = var5;
      var4[4] = var5;
      this.itemsEnabledStates = var4;
      this.isBehaviorTranslationSet = false;
      this.currentItem = 0;
      this.currentColor = 0;
      this.behaviorTranslationEnabled = true;
      this.needHideBottomNavigation = false;
      this.hideBottomNavigationWithAnimation = false;
      this.soundEffectsEnabled = true;
      this.defaultBackgroundColor = -1;
      this.defaultBackgroundResource = 0;
      this.navigationBarHeight = 0;
      this.forceTint = false;
      this.titleState = AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE;
      this.init(var1, var2);
   }

   @SuppressLint({"NewApi"})
   @TargetApi(21)
   private int calculateHeight(int var1) {
      if (!this.translucentNavigationEnabled) {
         return var1;
      } else {
         int var2 = this.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
         if (var2 > 0) {
            this.navigationBarHeight = this.resources.getDimensionPixelSize(var2);
         }

         int[] var3 = new int[]{16842973, 16843760};
         TypedArray var4 = this.getContext().getTheme().obtainStyledAttributes(var3);
         var4.getBoolean(0, false);
         boolean var6 = var4.getBoolean(1, true);
         if (this.hasImmersive() && var6) {
            var1 += this.navigationBarHeight;
         }

         var4.recycle();
         return var1;
      }
   }

   private void createClassicItems(LinearLayout var1) {
      LayoutInflater var2 = (LayoutInflater)this.context.getSystemService("layout_inflater");
      float var3 = this.resources.getDimension(dimen.bottom_navigation_height);
      float var4 = this.resources.getDimension(dimen.bottom_navigation_min_width);
      float var5 = this.resources.getDimension(dimen.bottom_navigation_max_width);
      if (this.titleState == AHBottomNavigation.TitleState.ALWAYS_SHOW && this.items.size() > 3) {
         var4 = this.resources.getDimension(dimen.bottom_navigation_small_inactive_min_width);
         var5 = this.resources.getDimension(dimen.bottom_navigation_small_inactive_max_width);
      }

      int var6 = this.getWidth();
      if (var6 != 0) {
         if (this.items.size() == 0) {
            return;
         }

         float var7 = (float)(var6 / this.items.size());
         if (var7 >= var4) {
            if (var7 > var5) {
               var4 = var5;
            } else {
               var4 = var7;
            }
         }

         float var8;
         float var9;
         int var10;
         label101: {
            var8 = this.resources.getDimension(dimen.bottom_navigation_text_size_active);
            var9 = this.resources.getDimension(dimen.bottom_navigation_text_size_inactive);
            var10 = (int)this.resources.getDimension(dimen.bottom_navigation_margin_top_active);
            float var11 = this.titleActiveTextSize;
            if (var11 != 0.0F) {
               float var36 = this.titleInactiveTextSize;
               if (var36 != 0.0F) {
                  var8 = var11;
                  var9 = var36;
                  break label101;
               }
            }

            if (this.titleState == AHBottomNavigation.TitleState.ALWAYS_SHOW && this.items.size() > 3) {
               var8 = this.resources.getDimension(dimen.bottom_navigation_text_size_forced_active);
               var9 = this.resources.getDimension(dimen.bottom_navigation_text_size_forced_inactive);
            }
         }

         float var23;
         for(final int var12 = 0; var12 < this.items.size(); var8 = var23) {
            boolean var13;
            if (this.currentItem == var12) {
               var13 = true;
            } else {
               var13 = false;
            }

            AHBottomNavigationItem var14 = (AHBottomNavigationItem)this.items.get(var12);
            View var15 = var2.inflate(layout.bottom_navigation_item, this, false);
            FrameLayout var16 = (FrameLayout)var15.findViewById(id.bottom_navigation_container);
            ImageView var17 = (ImageView)var15.findViewById(id.bottom_navigation_item_icon);
            TextView var18 = (TextView)var15.findViewById(id.bottom_navigation_item_title);
            TextView var19 = (TextView)var15.findViewById(id.bottom_navigation_notification);
            var17.setImageDrawable(var14.getDrawable(this.context));
            var18.setText(var14.getTitle(this.context));
            Typeface var20 = this.titleTypeface;
            if (var20 != null) {
               var18.setTypeface(var20);
            }

            AHBottomNavigation.TitleState var21 = this.titleState;
            if (var21 == AHBottomNavigation.TitleState.ALWAYS_SHOW && this.items.size() > 3) {
               int var34 = var16.getPaddingTop();
               int var35 = var16.getPaddingBottom();
               var23 = var8;
               var16.setPadding(0, var34, 0, var35);
            } else {
               var23 = var8;
            }

            if (var13) {
               boolean var31;
               if (this.selectedBackgroundVisible) {
                  var31 = true;
                  var15.setSelected(var31);
               } else {
                  var31 = true;
               }

               var17.setSelected(var31);
               if (var15.getLayoutParams() instanceof MarginLayoutParams) {
                  MarginLayoutParams var32 = (MarginLayoutParams)var17.getLayoutParams();
                  var32.setMargins(var32.leftMargin, var10, var32.rightMargin, var32.bottomMargin);
                  MarginLayoutParams var33 = (MarginLayoutParams)var19.getLayoutParams();
                  var33.setMargins(this.notificationActiveMarginLeft, var33.topMargin, var33.rightMargin, var33.bottomMargin);
                  var15.requestLayout();
               }
            } else {
               var17.setSelected(false);
               MarginLayoutParams var24 = (MarginLayoutParams)var19.getLayoutParams();
               var24.setMargins(this.notificationInactiveMarginLeft, var24.topMargin, var24.rightMargin, var24.bottomMargin);
            }

            if (this.colored) {
               if (var13) {
                  this.setBackgroundColor(var14.getColor(this.context));
                  this.currentColor = var14.getColor(this.context);
               }
            } else {
               int var25 = this.defaultBackgroundResource;
               if (var25 != 0) {
                  this.setBackgroundResource(var25);
               } else {
                  this.setBackgroundColor(this.defaultBackgroundColor);
               }
            }

            float var26;
            if (var13) {
               var26 = var23;
            } else {
               var26 = var9;
            }

            var18.setTextSize(0, var26);
            if (this.itemsEnabledStates[var12]) {
               var15.setOnClickListener(new OnClickListener() {
                  public void onClick(View var1) {
                     AHBottomNavigation.this.updateItems(var12, true);
                  }
               });
               Drawable var28 = ((AHBottomNavigationItem)this.items.get(var12)).getDrawable(this.context);
               int var29;
               if (var13) {
                  var29 = this.itemActiveColor;
               } else {
                  var29 = this.itemInactiveColor;
               }

               var17.setImageDrawable(AHHelper.getTintDrawable(var28, var29, this.forceTint));
               int var30;
               if (var13) {
                  var30 = this.itemActiveColor;
               } else {
                  var30 = this.itemInactiveColor;
               }

               var18.setTextColor(var30);
               var15.setSoundEffectsEnabled(this.soundEffectsEnabled);
            } else {
               var17.setImageDrawable(AHHelper.getTintDrawable(((AHBottomNavigationItem)this.items.get(var12)).getDrawable(this.context), this.itemDisableColor, this.forceTint));
               var18.setTextColor(this.itemDisableColor);
            }

            var1.addView(var15, new LayoutParams((int)var4, (int)var3));
            this.views.add(var15);
            ++var12;
            var2 = var2;
         }

         this.updateNotifications(true, -1);
      }

   }

   private void createItems() {
      if (this.items.size() < 3) {
         Log.w(TAG, "The items list should have at least 3 items");
      } else if (this.items.size() > 5) {
         Log.w(TAG, "The items list should not have more than 5 items");
      }

      int var1 = (int)this.resources.getDimension(dimen.bottom_navigation_height);
      this.removeAllViews();
      this.views.clear();
      this.backgroundColorView = new View(this.context);
      if (VERSION.SDK_INT >= 21) {
         LayoutParams var2 = new LayoutParams(-1, this.calculateHeight(var1));
         this.addView(this.backgroundColorView, var2);
         this.bottomNavigationHeight = var1;
      }

      this.linearLayoutContainer = new LinearLayout(this.context);
      this.linearLayoutContainer.setOrientation(0);
      this.linearLayoutContainer.setGravity(17);
      LayoutParams var3 = new LayoutParams(-1, var1);
      this.addView(this.linearLayoutContainer, var3);
      if (this.titleState == AHBottomNavigation.TitleState.ALWAYS_HIDE || this.items.size() != 3 && this.titleState != AHBottomNavigation.TitleState.ALWAYS_SHOW) {
         this.createSmallItems(this.linearLayoutContainer);
      } else {
         this.createClassicItems(this.linearLayoutContainer);
      }

      this.post(new Runnable() {
         public void run() {
            AHBottomNavigation.this.requestLayout();
         }
      });
   }

   private void createSmallItems(LinearLayout var1) {
      LayoutInflater var2 = (LayoutInflater)this.context.getSystemService("layout_inflater");
      float var3 = this.resources.getDimension(dimen.bottom_navigation_height);
      float var4 = this.resources.getDimension(dimen.bottom_navigation_small_inactive_min_width);
      float var5 = this.resources.getDimension(dimen.bottom_navigation_small_inactive_max_width);
      int var6 = this.getWidth();
      if (var6 != 0) {
         if (this.items.size() == 0) {
            return;
         }

         float var7 = (float)(var6 / this.items.size());
         if (var7 >= var4) {
            if (var7 > var5) {
               var4 = var5;
            } else {
               var4 = var7;
            }
         }

         int var8 = (int)this.resources.getDimension(dimen.bottom_navigation_small_margin_top_active);
         float var9 = this.resources.getDimension(dimen.bottom_navigation_small_selected_width_difference);
         this.selectedItemWidth = var4 + var9 * (float)this.items.size();
         float var10 = var4 - var9;
         this.notSelectedItemWidth = var10;

         for(final int var11 = 0; var11 < this.items.size(); ++var11) {
            AHBottomNavigationItem var12 = (AHBottomNavigationItem)this.items.get(var11);
            View var13 = var2.inflate(layout.bottom_navigation_small_item, this, false);
            ImageView var14 = (ImageView)var13.findViewById(id.bottom_navigation_small_item_icon);
            TextView var15 = (TextView)var13.findViewById(id.bottom_navigation_small_item_title);
            TextView var16 = (TextView)var13.findViewById(id.bottom_navigation_notification);
            var14.setImageDrawable(var12.getDrawable(this.context));
            if (this.titleState != AHBottomNavigation.TitleState.ALWAYS_HIDE) {
               var15.setText(var12.getTitle(this.context));
            }

            float var17 = this.titleActiveTextSize;
            if (var17 != 0.0F) {
               var15.setTextSize(0, var17);
            }

            Typeface var18 = this.titleTypeface;
            if (var18 != null) {
               var15.setTypeface(var18);
            }

            if (var11 == this.currentItem) {
               if (this.selectedBackgroundVisible) {
                  var13.setSelected(true);
               }

               var14.setSelected(true);
               if (this.titleState != AHBottomNavigation.TitleState.ALWAYS_HIDE && var13.getLayoutParams() instanceof MarginLayoutParams) {
                  MarginLayoutParams var30 = (MarginLayoutParams)var14.getLayoutParams();
                  var30.setMargins(var30.leftMargin, var8, var30.rightMargin, var30.bottomMargin);
                  MarginLayoutParams var31 = (MarginLayoutParams)var16.getLayoutParams();
                  var31.setMargins(this.notificationActiveMarginLeft, this.notificationActiveMarginTop, var31.rightMargin, var31.bottomMargin);
                  var13.requestLayout();
               }
            } else {
               var14.setSelected(false);
               MarginLayoutParams var19 = (MarginLayoutParams)var16.getLayoutParams();
               var19.setMargins(this.notificationInactiveMarginLeft, this.notificationInactiveMarginTop, var19.rightMargin, var19.bottomMargin);
            }

            if (this.colored) {
               if (var11 == this.currentItem) {
                  this.setBackgroundColor(var12.getColor(this.context));
                  this.currentColor = var12.getColor(this.context);
               }
            } else {
               int var20 = this.defaultBackgroundResource;
               if (var20 != 0) {
                  this.setBackgroundResource(var20);
               } else {
                  this.setBackgroundColor(this.defaultBackgroundColor);
               }
            }

            if (this.itemsEnabledStates[var11]) {
               Drawable var26 = ((AHBottomNavigationItem)this.items.get(var11)).getDrawable(this.context);
               int var27;
               if (this.currentItem == var11) {
                  var27 = this.itemActiveColor;
               } else {
                  var27 = this.itemInactiveColor;
               }

               var14.setImageDrawable(AHHelper.getTintDrawable(var26, var27, this.forceTint));
               int var28;
               if (this.currentItem == var11) {
                  var28 = this.itemActiveColor;
               } else {
                  var28 = this.itemInactiveColor;
               }

               var15.setTextColor(var28);
               float var29;
               if (this.currentItem == var11) {
                  var29 = 1.0F;
               } else {
                  var29 = 0.0F;
               }

               var15.setAlpha(var29);
               var13.setOnClickListener(new OnClickListener() {
                  public void onClick(View var1) {
                     AHBottomNavigation.this.updateSmallItems(var11, true);
                  }
               });
               var13.setSoundEffectsEnabled(this.soundEffectsEnabled);
            } else {
               var14.setImageDrawable(AHHelper.getTintDrawable(((AHBottomNavigationItem)this.items.get(var11)).getDrawable(this.context), this.itemDisableColor, this.forceTint));
               var15.setTextColor(this.itemDisableColor);
               var15.setAlpha(0.0F);
            }

            int var21;
            if (var11 == this.currentItem) {
               var21 = (int)this.selectedItemWidth;
            } else {
               var21 = (int)var10;
            }

            if (this.titleState == AHBottomNavigation.TitleState.ALWAYS_HIDE) {
               double var23 = (double)var10;
               Double.isNaN(var23);
               var21 = (int)(var23 * 1.16D);
            }

            var1.addView(var13, new LayoutParams(var21, (int)var3));
            this.views.add(var13);
         }

         this.updateNotifications(true, -1);
      }

   }

   private void init(Context var1, AttributeSet var2) {
      this.context = var1;
      this.resources = this.context.getResources();
      this.titleColorActive = ContextCompat.getColor(var1, color.colorBottomNavigationAccent);
      this.titleColorInactive = ContextCompat.getColor(var1, color.colorBottomNavigationInactive);
      this.itemDisableColor = ContextCompat.getColor(var1, color.colorBottomNavigationDisable);
      this.coloredTitleColorActive = ContextCompat.getColor(var1, color.colorBottomNavigationActiveColored);
      this.coloredTitleColorInactive = ContextCompat.getColor(var1, color.colorBottomNavigationInactiveColored);
      if (var2 != null) {
         TypedArray var3 = var1.obtainStyledAttributes(var2, styleable.AHBottomNavigationBehavior_Params, 0, 0);

         try {
            this.selectedBackgroundVisible = var3.getBoolean(styleable.AHBottomNavigationBehavior_Params_selectedBackgroundVisible, false);
            this.translucentNavigationEnabled = var3.getBoolean(styleable.AHBottomNavigationBehavior_Params_translucentNavigationEnabled, false);
            this.titleColorActive = var3.getColor(styleable.AHBottomNavigationBehavior_Params_accentColor, ContextCompat.getColor(var1, color.colorBottomNavigationAccent));
            this.titleColorInactive = var3.getColor(styleable.AHBottomNavigationBehavior_Params_inactiveColor, ContextCompat.getColor(var1, color.colorBottomNavigationInactive));
            this.itemDisableColor = var3.getColor(styleable.AHBottomNavigationBehavior_Params_disableColor, ContextCompat.getColor(var1, color.colorBottomNavigationDisable));
            this.coloredTitleColorActive = var3.getColor(styleable.AHBottomNavigationBehavior_Params_coloredActive, ContextCompat.getColor(var1, color.colorBottomNavigationActiveColored));
            this.coloredTitleColorInactive = var3.getColor(styleable.AHBottomNavigationBehavior_Params_coloredInactive, ContextCompat.getColor(var1, color.colorBottomNavigationInactiveColored));
            this.colored = var3.getBoolean(styleable.AHBottomNavigationBehavior_Params_colored, false);
         } finally {
            var3.recycle();
         }
      }

      this.notificationTextColor = ContextCompat.getColor(var1, 17170443);
      this.bottomNavigationHeight = (int)this.resources.getDimension(dimen.bottom_navigation_height);
      this.itemActiveColor = this.titleColorActive;
      this.itemInactiveColor = this.titleColorInactive;
      this.notificationActiveMarginLeft = (int)this.resources.getDimension(dimen.bottom_navigation_notification_margin_left_active);
      this.notificationInactiveMarginLeft = (int)this.resources.getDimension(dimen.bottom_navigation_notification_margin_left);
      this.notificationActiveMarginTop = (int)this.resources.getDimension(dimen.bottom_navigation_notification_margin_top_active);
      this.notificationInactiveMarginTop = (int)this.resources.getDimension(dimen.bottom_navigation_notification_margin_top);
      this.notificationAnimationDuration = 150L;
      ViewCompat.setElevation(this, this.resources.getDimension(dimen.bottom_navigation_elevation));
      this.setClipToPadding(false);
      this.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, this.bottomNavigationHeight));
   }

   private boolean isClassic() {
      return this.titleState == AHBottomNavigation.TitleState.ALWAYS_SHOW || this.items.size() <= 3 && this.titleState != AHBottomNavigation.TitleState.ALWAYS_SHOW;
   }

   private void updateItems(final int var1, boolean var2) {
      int var3 = this.currentItem;
      boolean var4 = true;
      if (var3 == var1) {
         AHBottomNavigation.OnTabSelectedListener var28 = this.tabSelectedListener;
         if (var28 != null && var2) {
            var28.onTabSelected(var1, var4);
         }

      } else {
         AHBottomNavigation.OnTabSelectedListener var5 = this.tabSelectedListener;
         if (var5 == null || !var2 || var5.onTabSelected(var1, false)) {
            int var6;
            int var7;
            float var8;
            float var9;
            label91: {
               var6 = (int)this.resources.getDimension(dimen.bottom_navigation_margin_top_active);
               var7 = (int)this.resources.getDimension(dimen.bottom_navigation_margin_top_inactive);
               var8 = this.resources.getDimension(dimen.bottom_navigation_text_size_active);
               var9 = this.resources.getDimension(dimen.bottom_navigation_text_size_inactive);
               float var10 = this.titleActiveTextSize;
               if (var10 != 0.0F) {
                  float var27 = this.titleInactiveTextSize;
                  if (var27 != 0.0F) {
                     var8 = var10;
                     var9 = var27;
                     break label91;
                  }
               }

               if (this.titleState == AHBottomNavigation.TitleState.ALWAYS_SHOW && this.items.size() > 3) {
                  var8 = this.resources.getDimension(dimen.bottom_navigation_text_size_forced_active);
                  var9 = this.resources.getDimension(dimen.bottom_navigation_text_size_forced_inactive);
               }
            }

            for(int var11 = 0; var11 < this.views.size(); var4 = true) {
               View var14 = (View)this.views.get(var11);
               if (this.selectedBackgroundVisible) {
                  boolean var26;
                  if (var11 == var1) {
                     var26 = true;
                  } else {
                     var26 = false;
                  }

                  var14.setSelected(var26);
               }

               if (var11 == var1) {
                  TextView var18 = (TextView)var14.findViewById(id.bottom_navigation_item_title);
                  ImageView var19 = (ImageView)var14.findViewById(id.bottom_navigation_item_icon);
                  TextView var20 = (TextView)var14.findViewById(id.bottom_navigation_notification);
                  var19.setSelected(var4);
                  AHHelper.updateTopMargin(var19, var7, var6);
                  AHHelper.updateLeftMargin(var20, this.notificationInactiveMarginLeft, this.notificationActiveMarginLeft);
                  AHHelper.updateTextColor(var18, this.itemInactiveColor, this.itemActiveColor);
                  AHHelper.updateTextSize(var18, var9, var8);
                  AHHelper.updateDrawableColor(this.context, ((AHBottomNavigationItem)this.items.get(var1)).getDrawable(this.context), var19, this.itemInactiveColor, this.itemActiveColor, this.forceTint);
                  if (VERSION.SDK_INT >= 21 && this.colored) {
                     int var22 = Math.max(this.getWidth(), this.getHeight());
                     int var23 = (int)var14.getX() + var14.getWidth() / 2;
                     int var24 = var14.getHeight() / 2;
                     Animator var25 = this.circleRevealAnim;
                     if (var25 != null && var25.isRunning()) {
                        this.circleRevealAnim.cancel();
                        this.setBackgroundColor(((AHBottomNavigationItem)this.items.get(var1)).getColor(this.context));
                        this.backgroundColorView.setBackgroundColor(0);
                     }

                     this.circleRevealAnim = ViewAnimationUtils.createCircularReveal(this.backgroundColorView, var23, var24, 0.0F, (float)var22);
                     this.circleRevealAnim.setStartDelay(5L);
                     this.circleRevealAnim.addListener(new AnimatorListener() {
                        public void onAnimationCancel(Animator var1x) {
                        }

                        public void onAnimationEnd(Animator var1x) {
                           AHBottomNavigation var2 = AHBottomNavigation.this;
                           var2.setBackgroundColor(((AHBottomNavigationItem)var2.items.get(var1)).getColor(AHBottomNavigation.this.context));
                           AHBottomNavigation.this.backgroundColorView.setBackgroundColor(0);
                        }

                        public void onAnimationRepeat(Animator var1x) {
                        }

                        public void onAnimationStart(Animator var1x) {
                           AHBottomNavigation.this.backgroundColorView.setBackgroundColor(((AHBottomNavigationItem)AHBottomNavigation.this.items.get(var1)).getColor(AHBottomNavigation.this.context));
                        }
                     });
                     this.circleRevealAnim.start();
                  } else if (this.colored) {
                     AHHelper.updateViewBackgroundColor(this, this.currentColor, ((AHBottomNavigationItem)this.items.get(var1)).getColor(this.context));
                  } else {
                     int var21 = this.defaultBackgroundResource;
                     if (var21 != 0) {
                        this.setBackgroundResource(var21);
                     } else {
                        this.setBackgroundColor(this.defaultBackgroundColor);
                     }

                     this.backgroundColorView.setBackgroundColor(0);
                  }
               } else if (var11 == this.currentItem) {
                  TextView var15 = (TextView)var14.findViewById(id.bottom_navigation_item_title);
                  ImageView var16 = (ImageView)var14.findViewById(id.bottom_navigation_item_icon);
                  TextView var17 = (TextView)var14.findViewById(id.bottom_navigation_notification);
                  var16.setSelected(false);
                  AHHelper.updateTopMargin(var16, var6, var7);
                  AHHelper.updateLeftMargin(var17, this.notificationActiveMarginLeft, this.notificationInactiveMarginLeft);
                  AHHelper.updateTextColor(var15, this.itemActiveColor, this.itemInactiveColor);
                  AHHelper.updateTextSize(var15, var8, var9);
                  AHHelper.updateDrawableColor(this.context, ((AHBottomNavigationItem)this.items.get(this.currentItem)).getDrawable(this.context), var16, this.itemActiveColor, this.itemInactiveColor, this.forceTint);
               }

               ++var11;
            }

            this.currentItem = var1;
            int var12 = this.currentItem;
            if (var12 > 0 && var12 < this.items.size()) {
               this.currentColor = ((AHBottomNavigationItem)this.items.get(this.currentItem)).getColor(this.context);
            } else {
               if (this.currentItem == -1) {
                  int var13 = this.defaultBackgroundResource;
                  if (var13 != 0) {
                     this.setBackgroundResource(var13);
                  } else {
                     this.setBackgroundColor(this.defaultBackgroundColor);
                  }

                  this.backgroundColorView.setBackgroundColor(0);
               }

            }
         }
      }
   }

   private void updateNotifications(boolean var1, int var2) {
      for(int var3 = 0; var3 < this.views.size(); ++var3) {
         if (var3 >= this.notifications.size()) {
            return;
         }

         if (var2 == -1 || var2 == var3) {
            AHNotification var4 = (AHNotification)this.notifications.get(var3);
            int var5 = AHNotificationHelper.getTextColor(var4, this.notificationTextColor);
            int var6 = AHNotificationHelper.getBackgroundColor(var4, this.notificationBackgroundColor);
            TextView var7 = (TextView)((View)this.views.get(var3)).findViewById(id.bottom_navigation_notification);
            boolean var8 = true ^ var7.getText().toString().equals(String.valueOf(var4.getText()));
            if (var1) {
               var7.setTextColor(var5);
               Typeface var9 = this.notificationTypeface;
               if (var9 != null) {
                  var7.setTypeface(var9);
               } else {
                  var7.setTypeface((Typeface)null, 1);
               }

               if (this.notificationBackgroundDrawable != null) {
                  if (VERSION.SDK_INT >= 16) {
                     var7.setBackground(this.notificationBackgroundDrawable.getConstantState().newDrawable());
                  } else {
                     var7.setBackgroundDrawable(this.notificationBackgroundDrawable);
                  }
               } else if (var6 != 0) {
                  Drawable var10 = ContextCompat.getDrawable(this.context, drawable.notification_background);
                  if (VERSION.SDK_INT >= 16) {
                     var7.setBackground(AHHelper.getTintDrawable(var10, var6, this.forceTint));
                  } else {
                     var7.setBackgroundDrawable(AHHelper.getTintDrawable(var10, var6, this.forceTint));
                  }
               }
            }

            if (var4.isEmpty() && var7.getText().length() > 0) {
               var7.setText("");
               if (var8) {
                  var7.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setInterpolator(new AccelerateInterpolator()).setDuration(this.notificationAnimationDuration).start();
               }
            } else if (!var4.isEmpty()) {
               var7.setText(String.valueOf(var4.getText()));
               if (var8) {
                  var7.setScaleX(0.0F);
                  var7.setScaleY(0.0F);
                  var7.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setInterpolator(new OvershootInterpolator()).setDuration(this.notificationAnimationDuration).start();
               }
            }
         }
      }

   }

   private void updateSmallItems(final int var1, boolean var2) {
      if (this.currentItem == var1) {
         AHBottomNavigation.OnTabSelectedListener var24 = this.tabSelectedListener;
         if (var24 != null && var2) {
            var24.onTabSelected(var1, true);
         }

      } else {
         AHBottomNavigation.OnTabSelectedListener var3 = this.tabSelectedListener;
         if (var3 == null || !var2 || var3.onTabSelected(var1, false)) {
            int var4 = (int)this.resources.getDimension(dimen.bottom_navigation_small_margin_top_active);
            int var5 = (int)this.resources.getDimension(dimen.bottom_navigation_small_margin_top);

            for(int var6 = 0; var6 < this.views.size(); ++var6) {
               View var9 = (View)this.views.get(var6);
               if (this.selectedBackgroundVisible) {
                  boolean var23;
                  if (var6 == var1) {
                     var23 = true;
                  } else {
                     var23 = false;
                  }

                  var9.setSelected(var23);
               }

               if (var6 == var1) {
                  FrameLayout var14 = (FrameLayout)var9.findViewById(id.bottom_navigation_small_container);
                  TextView var15 = (TextView)var9.findViewById(id.bottom_navigation_small_item_title);
                  ImageView var16 = (ImageView)var9.findViewById(id.bottom_navigation_small_item_icon);
                  TextView var17 = (TextView)var9.findViewById(id.bottom_navigation_notification);
                  var16.setSelected(true);
                  if (this.titleState != AHBottomNavigation.TitleState.ALWAYS_HIDE) {
                     AHHelper.updateTopMargin(var16, var5, var4);
                     AHHelper.updateLeftMargin(var17, this.notificationInactiveMarginLeft, this.notificationActiveMarginLeft);
                     AHHelper.updateTopMargin(var17, this.notificationInactiveMarginTop, this.notificationActiveMarginTop);
                     AHHelper.updateTextColor(var15, this.itemInactiveColor, this.itemActiveColor);
                     AHHelper.updateWidth(var14, this.notSelectedItemWidth, this.selectedItemWidth);
                  }

                  AHHelper.updateAlpha(var15, 0.0F, 1.0F);
                  AHHelper.updateDrawableColor(this.context, ((AHBottomNavigationItem)this.items.get(var1)).getDrawable(this.context), var16, this.itemInactiveColor, this.itemActiveColor, this.forceTint);
                  if (VERSION.SDK_INT >= 21 && this.colored) {
                     int var19 = Math.max(this.getWidth(), this.getHeight());
                     int var20 = (int)((View)this.views.get(var1)).getX() + ((View)this.views.get(var1)).getWidth() / 2;
                     int var21 = ((View)this.views.get(var1)).getHeight() / 2;
                     Animator var22 = this.circleRevealAnim;
                     if (var22 != null && var22.isRunning()) {
                        this.circleRevealAnim.cancel();
                        this.setBackgroundColor(((AHBottomNavigationItem)this.items.get(var1)).getColor(this.context));
                        this.backgroundColorView.setBackgroundColor(0);
                     }

                     this.circleRevealAnim = ViewAnimationUtils.createCircularReveal(this.backgroundColorView, var20, var21, 0.0F, (float)var19);
                     this.circleRevealAnim.setStartDelay(5L);
                     this.circleRevealAnim.addListener(new AnimatorListener() {
                        public void onAnimationCancel(Animator var1x) {
                        }

                        public void onAnimationEnd(Animator var1x) {
                           AHBottomNavigation var2 = AHBottomNavigation.this;
                           var2.setBackgroundColor(((AHBottomNavigationItem)var2.items.get(var1)).getColor(AHBottomNavigation.this.context));
                           AHBottomNavigation.this.backgroundColorView.setBackgroundColor(0);
                        }

                        public void onAnimationRepeat(Animator var1x) {
                        }

                        public void onAnimationStart(Animator var1x) {
                           AHBottomNavigation.this.backgroundColorView.setBackgroundColor(((AHBottomNavigationItem)AHBottomNavigation.this.items.get(var1)).getColor(AHBottomNavigation.this.context));
                        }
                     });
                     this.circleRevealAnim.start();
                  } else if (this.colored) {
                     AHHelper.updateViewBackgroundColor(this, this.currentColor, ((AHBottomNavigationItem)this.items.get(var1)).getColor(this.context));
                  } else {
                     int var18 = this.defaultBackgroundResource;
                     if (var18 != 0) {
                        this.setBackgroundResource(var18);
                     } else {
                        this.setBackgroundColor(this.defaultBackgroundColor);
                     }

                     this.backgroundColorView.setBackgroundColor(0);
                  }
               } else if (var6 == this.currentItem) {
                  View var10 = var9.findViewById(id.bottom_navigation_small_container);
                  TextView var11 = (TextView)var9.findViewById(id.bottom_navigation_small_item_title);
                  ImageView var12 = (ImageView)var9.findViewById(id.bottom_navigation_small_item_icon);
                  TextView var13 = (TextView)var9.findViewById(id.bottom_navigation_notification);
                  var12.setSelected(false);
                  if (this.titleState != AHBottomNavigation.TitleState.ALWAYS_HIDE) {
                     AHHelper.updateTopMargin(var12, var4, var5);
                     AHHelper.updateLeftMargin(var13, this.notificationActiveMarginLeft, this.notificationInactiveMarginLeft);
                     AHHelper.updateTopMargin(var13, this.notificationActiveMarginTop, this.notificationInactiveMarginTop);
                     AHHelper.updateTextColor(var11, this.itemActiveColor, this.itemInactiveColor);
                     AHHelper.updateWidth(var10, this.selectedItemWidth, this.notSelectedItemWidth);
                  }

                  AHHelper.updateAlpha(var11, 1.0F, 0.0F);
                  AHHelper.updateDrawableColor(this.context, ((AHBottomNavigationItem)this.items.get(this.currentItem)).getDrawable(this.context), var12, this.itemActiveColor, this.itemInactiveColor, this.forceTint);
               }
            }

            this.currentItem = var1;
            int var7 = this.currentItem;
            if (var7 > 0 && var7 < this.items.size()) {
               this.currentColor = ((AHBottomNavigationItem)this.items.get(this.currentItem)).getColor(this.context);
            } else {
               if (this.currentItem == -1) {
                  int var8 = this.defaultBackgroundResource;
                  if (var8 != 0) {
                     this.setBackgroundResource(var8);
                  } else {
                     this.setBackgroundColor(this.defaultBackgroundColor);
                  }

                  this.backgroundColorView.setBackgroundColor(0);
               }

            }
         }
      }
   }

   public void addItem(AHBottomNavigationItem var1) {
      if (this.items.size() > 5) {
         Log.w(TAG, "The items list should not have more than 5 items");
      }

      this.items.add(var1);
      this.createItems();
   }

   public void addItems(List var1) {
      if (var1.size() > 5 || this.items.size() + var1.size() > 5) {
         Log.w(TAG, "The items list should not have more than 5 items");
      }

      this.items.addAll(var1);
      this.createItems();
   }

   public void disableItemAtPosition(int var1) {
      if (var1 >= 0 && var1 <= -1 + this.items.size()) {
         this.itemsEnabledStates[var1] = false;
         this.createItems();
      } else {
         String var2 = TAG;
         StringBuilder var3 = new StringBuilder();
         var3.append("The position is out of bounds of the items (");
         var3.append(this.items.size());
         var3.append(" elements)");
         Log.w(var2, var3.toString());
      }
   }

   public void enableItemAtPosition(int var1) {
      if (var1 >= 0 && var1 <= this.items.size() - 1) {
         this.itemsEnabledStates[var1] = true;
         this.createItems();
      } else {
         String var2 = TAG;
         StringBuilder var3 = new StringBuilder();
         var3.append("The position is out of bounds of the items (");
         var3.append(this.items.size());
         var3.append(" elements)");
         Log.w(var2, var3.toString());
      }
   }

   public int getAccentColor() {
      return this.itemActiveColor;
   }

   public int getCurrentItem() {
      return this.currentItem;
   }

   public int getDefaultBackgroundColor() {
      return this.defaultBackgroundColor;
   }

   public int getInactiveColor() {
      return this.itemInactiveColor;
   }

   public AHBottomNavigationItem getItem(int var1) {
      if (var1 >= 0 && var1 <= -1 + this.items.size()) {
         return (AHBottomNavigationItem)this.items.get(var1);
      } else {
         String var2 = TAG;
         StringBuilder var3 = new StringBuilder();
         var3.append("The position is out of bounds of the items (");
         var3.append(this.items.size());
         var3.append(" elements)");
         Log.w(var2, var3.toString());
         return null;
      }
   }

   public int getItemsCount() {
      return this.items.size();
   }

   public AHBottomNavigation.TitleState getTitleState() {
      return this.titleState;
   }

   public View getViewAtPosition(int var1) {
      LinearLayout var2 = this.linearLayoutContainer;
      return var2 != null && var1 >= 0 && var1 < var2.getChildCount() ? this.linearLayoutContainer.getChildAt(var1) : null;
   }

   @SuppressLint({"NewApi"})
   @TargetApi(21)
   public boolean hasImmersive() {
      Display var1 = ((WindowManager)this.getContext().getSystemService("window")).getDefaultDisplay();
      DisplayMetrics var2 = new DisplayMetrics();
      var1.getRealMetrics(var2);
      int var3 = var2.heightPixels;
      int var4 = var2.widthPixels;
      DisplayMetrics var5 = new DisplayMetrics();
      var1.getMetrics(var5);
      int var6 = var5.heightPixels;
      return var4 > var5.widthPixels || var3 > var6;
   }

   public void hideBottomNavigation() {
      this.hideBottomNavigation(true);
   }

   public void hideBottomNavigation(boolean var1) {
      AHBottomNavigationBehavior var2 = this.bottomNavigationBehavior;
      if (var2 != null) {
         var2.hideView(this, this.bottomNavigationHeight, var1);
      } else if (this.getParent() instanceof CoordinatorLayout) {
         this.needHideBottomNavigation = true;
         this.hideBottomNavigationWithAnimation = var1;
      } else {
         ViewPropertyAnimatorCompat var3 = ViewCompat.animate(this).translationY((float)this.bottomNavigationHeight).setInterpolator(new LinearOutSlowInInterpolator());
         long var4;
         if (var1) {
            var4 = 300L;
         } else {
            var4 = 0L;
         }

         var3.setDuration(var4).start();
      }
   }

   public boolean isBehaviorTranslationEnabled() {
      return this.behaviorTranslationEnabled;
   }

   public boolean isColored() {
      return this.colored;
   }

   public boolean isForceTint() {
      return this.forceTint;
   }

   public boolean isHidden() {
      AHBottomNavigationBehavior var1 = this.bottomNavigationBehavior;
      return var1 != null ? var1.isHidden() : false;
   }

   public boolean isTranslucentNavigationEnabled() {
      return this.translucentNavigationEnabled;
   }

   public void manageFloatingActionButtonBehavior(FloatingActionButton var1) {
      if (var1.getParent() instanceof CoordinatorLayout) {
         AHBottomNavigationFABBehavior var2 = new AHBottomNavigationFABBehavior(this.navigationBarHeight);
         ((android.support.design.widget.CoordinatorLayout.LayoutParams)var1.getLayoutParams()).setBehavior(var2);
      }

   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if (!this.isBehaviorTranslationSet) {
         this.setBehaviorTranslationEnabled(this.behaviorTranslationEnabled);
         this.isBehaviorTranslationSet = true;
      }

   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (var1 instanceof Bundle) {
         Bundle var2 = (Bundle)var1;
         this.currentItem = var2.getInt("current_item");
         this.notifications = var2.getParcelableArrayList("notifications");
         var1 = var2.getParcelable("superState");
      }

      super.onRestoreInstanceState(var1);
   }

   protected Parcelable onSaveInstanceState() {
      Bundle var1 = new Bundle();
      var1.putParcelable("superState", super.onSaveInstanceState());
      var1.putInt("current_item", this.currentItem);
      var1.putParcelableArrayList("notifications", new ArrayList(this.notifications));
      return var1;
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      this.createItems();
   }

   public void refresh() {
      this.createItems();
   }

   public void removeAllItems() {
      this.items.clear();
      this.createItems();
   }

   public void removeItemAtIndex(int var1) {
      if (var1 < this.items.size()) {
         this.items.remove(var1);
         this.createItems();
      }

   }

   public void removeOnNavigationPositionListener() {
      this.navigationPositionListener = null;
      AHBottomNavigationBehavior var1 = this.bottomNavigationBehavior;
      if (var1 != null) {
         var1.removeOnNavigationPositionListener();
      }

   }

   public void removeOnTabSelectedListener() {
      this.tabSelectedListener = null;
   }

   public void restoreBottomNavigation() {
      this.restoreBottomNavigation(true);
   }

   public void restoreBottomNavigation(boolean var1) {
      AHBottomNavigationBehavior var2 = this.bottomNavigationBehavior;
      if (var2 != null) {
         var2.resetOffset(this, var1);
      } else {
         ViewPropertyAnimatorCompat var3 = ViewCompat.animate(this).translationY(0.0F).setInterpolator(new LinearOutSlowInInterpolator());
         long var4;
         if (var1) {
            var4 = 300L;
         } else {
            var4 = 0L;
         }

         var3.setDuration(var4).start();
      }
   }

   public void setAccentColor(int var1) {
      this.titleColorActive = var1;
      this.itemActiveColor = var1;
      this.createItems();
   }

   public void setBehaviorTranslationEnabled(boolean var1) {
      this.behaviorTranslationEnabled = var1;
      if (this.getParent() instanceof CoordinatorLayout) {
         android.view.ViewGroup.LayoutParams var2 = this.getLayoutParams();
         AHBottomNavigationBehavior var3 = this.bottomNavigationBehavior;
         if (var3 == null) {
            this.bottomNavigationBehavior = new AHBottomNavigationBehavior(var1, this.navigationBarHeight);
         } else {
            var3.setBehaviorTranslationEnabled(var1, this.navigationBarHeight);
         }

         AHBottomNavigation.OnNavigationPositionListener var4 = this.navigationPositionListener;
         if (var4 != null) {
            this.bottomNavigationBehavior.setOnNavigationPositionListener(var4);
         }

         ((android.support.design.widget.CoordinatorLayout.LayoutParams)var2).setBehavior(this.bottomNavigationBehavior);
         if (this.needHideBottomNavigation) {
            this.needHideBottomNavigation = false;
            this.bottomNavigationBehavior.hideView(this, this.bottomNavigationHeight, this.hideBottomNavigationWithAnimation);
         }
      }

   }

   public void setColored(boolean var1) {
      this.colored = var1;
      int var2;
      if (var1) {
         var2 = this.coloredTitleColorActive;
      } else {
         var2 = this.titleColorActive;
      }

      this.itemActiveColor = var2;
      int var3;
      if (var1) {
         var3 = this.coloredTitleColorInactive;
      } else {
         var3 = this.titleColorInactive;
      }

      this.itemInactiveColor = var3;
      this.createItems();
   }

   public void setColoredModeColors(@ColorInt int var1, @ColorInt int var2) {
      this.coloredTitleColorActive = var1;
      this.coloredTitleColorInactive = var2;
      this.createItems();
   }

   public void setCurrentItem(int var1) {
      this.setCurrentItem(var1, true);
   }

   public void setCurrentItem(int var1, boolean var2) {
      if (var1 >= this.items.size()) {
         String var3 = TAG;
         StringBuilder var4 = new StringBuilder();
         var4.append("The position is out of bounds of the items (");
         var4.append(this.items.size());
         var4.append(" elements)");
         Log.w(var3, var4.toString());
      } else if (this.titleState == AHBottomNavigation.TitleState.ALWAYS_HIDE || this.items.size() != 3 && this.titleState != AHBottomNavigation.TitleState.ALWAYS_SHOW) {
         this.updateSmallItems(var1, var2);
      } else {
         this.updateItems(var1, var2);
      }
   }

   public void setDefaultBackgroundColor(@ColorInt int var1) {
      this.defaultBackgroundColor = var1;
      this.createItems();
   }

   public void setDefaultBackgroundResource(@DrawableRes int var1) {
      this.defaultBackgroundResource = var1;
      this.createItems();
   }

   public void setForceTint(boolean var1) {
      this.forceTint = var1;
      this.createItems();
   }

   public void setInactiveColor(int var1) {
      this.titleColorInactive = var1;
      this.itemInactiveColor = var1;
      this.createItems();
   }

   public void setItemDisableColor(@ColorInt int var1) {
      this.itemDisableColor = var1;
   }

   @Deprecated
   public void setNotification(int var1, int var2) {
      if (var2 >= 0 && var2 <= this.items.size() - 1) {
         String var5;
         if (var1 == 0) {
            var5 = "";
         } else {
            var5 = String.valueOf(var1);
         }

         this.notifications.set(var2, AHNotification.justText(var5));
         this.updateNotifications(false, var2);
      } else {
         Locale var3 = Locale.US;
         Object[] var4 = new Object[]{var2, this.items.size()};
         throw new IndexOutOfBoundsException(String.format(var3, "The position (%d) is out of bounds of the items (%d elements)", var4));
      }
   }

   public void setNotification(AHNotification var1, int var2) {
      if (var2 >= 0 && var2 <= this.items.size() - 1) {
         if (var1 == null) {
            var1 = new AHNotification();
         }

         this.notifications.set(var2, var1);
         this.updateNotifications(true, var2);
      } else {
         Locale var3 = Locale.US;
         Object[] var4 = new Object[]{var2, this.items.size()};
         throw new IndexOutOfBoundsException(String.format(var3, "The position (%d) is out of bounds of the items (%d elements)", var4));
      }
   }

   public void setNotification(String var1, int var2) {
      if (var2 >= 0 && var2 <= this.items.size() - 1) {
         this.notifications.set(var2, AHNotification.justText(var1));
         this.updateNotifications(false, var2);
      } else {
         Locale var3 = Locale.US;
         Object[] var4 = new Object[]{var2, this.items.size()};
         throw new IndexOutOfBoundsException(String.format(var3, "The position (%d) is out of bounds of the items (%d elements)", var4));
      }
   }

   public void setNotificationAnimationDuration(long var1) {
      this.notificationAnimationDuration = var1;
      this.updateNotifications(true, -1);
   }

   public void setNotificationBackground(Drawable var1) {
      this.notificationBackgroundDrawable = var1;
      this.updateNotifications(true, -1);
   }

   public void setNotificationBackgroundColor(@ColorInt int var1) {
      this.notificationBackgroundColor = var1;
      this.updateNotifications(true, -1);
   }

   public void setNotificationBackgroundColorResource(@ColorRes int var1) {
      this.notificationBackgroundColor = ContextCompat.getColor(this.context, var1);
      this.updateNotifications(true, -1);
   }

   public void setNotificationMarginLeft(int var1, int var2) {
      this.notificationActiveMarginLeft = var1;
      this.notificationInactiveMarginLeft = var2;
      this.createItems();
   }

   public void setNotificationTextColor(@ColorInt int var1) {
      this.notificationTextColor = var1;
      this.updateNotifications(true, -1);
   }

   public void setNotificationTextColorResource(@ColorRes int var1) {
      this.notificationTextColor = ContextCompat.getColor(this.context, var1);
      this.updateNotifications(true, -1);
   }

   public void setNotificationTypeface(Typeface var1) {
      this.notificationTypeface = var1;
      this.updateNotifications(true, -1);
   }

   public void setOnNavigationPositionListener(AHBottomNavigation.OnNavigationPositionListener var1) {
      this.navigationPositionListener = var1;
      AHBottomNavigationBehavior var2 = this.bottomNavigationBehavior;
      if (var2 != null) {
         var2.setOnNavigationPositionListener(var1);
      }

   }

   public void setOnTabSelectedListener(AHBottomNavigation.OnTabSelectedListener var1) {
      this.tabSelectedListener = var1;
   }

   public void setSelectedBackgroundVisible(boolean var1) {
      this.selectedBackgroundVisible = var1;
      this.createItems();
   }

   public void setSoundEffectsEnabled(boolean var1) {
      super.setSoundEffectsEnabled(var1);
      this.soundEffectsEnabled = var1;
   }

   public void setTitleState(AHBottomNavigation.TitleState var1) {
      this.titleState = var1;
      this.createItems();
   }

   public void setTitleTextSize(float var1, float var2) {
      this.titleActiveTextSize = var1;
      this.titleInactiveTextSize = var2;
      this.createItems();
   }

   public void setTitleTextSizeInSp(float var1, float var2) {
      this.titleActiveTextSize = TypedValue.applyDimension(2, var1, this.resources.getDisplayMetrics());
      this.titleInactiveTextSize = TypedValue.applyDimension(2, var2, this.resources.getDisplayMetrics());
      this.createItems();
   }

   public void setTitleTypeface(Typeface var1) {
      this.titleTypeface = var1;
      this.createItems();
   }

   public void setTranslucentNavigationEnabled(boolean var1) {
      this.translucentNavigationEnabled = var1;
   }

   public void setUseElevation(boolean var1) {
      float var2;
      if (var1) {
         var2 = this.resources.getDimension(dimen.bottom_navigation_elevation);
      } else {
         var2 = 0.0F;
      }

      ViewCompat.setElevation(this, var2);
      this.setClipToPadding(false);
   }

   public void setUseElevation(boolean var1, float var2) {
      if (!var1) {
         var2 = 0.0F;
      }

      ViewCompat.setElevation(this, var2);
      this.setClipToPadding(false);
   }

   public interface OnNavigationPositionListener {
      void onPositionChange(int var1);
   }

   public interface OnTabSelectedListener {
      boolean onTabSelected(int var1, boolean var2);
   }

   public static enum TitleState {
      ALWAYS_HIDE,
      ALWAYS_SHOW,
      SHOW_WHEN_ACTIVE;

      static {
         AHBottomNavigation.TitleState[] var0 = new AHBottomNavigation.TitleState[]{SHOW_WHEN_ACTIVE, ALWAYS_SHOW, ALWAYS_HIDE};
      }
   }
}
