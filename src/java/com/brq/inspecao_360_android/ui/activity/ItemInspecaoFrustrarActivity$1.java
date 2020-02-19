package com.brq.inspecao_360_android.ui.activity;

import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;

class ItemInspecaoFrustrarActivity$1 implements OnTabSelectedListener {
   // $FF: synthetic field
   final ItemInspecaoFrustrarActivity this$0;

   ItemInspecaoFrustrarActivity$1(ItemInspecaoFrustrarActivity var1) {
      this.this$0 = var1;
   }

   public void onTabReselected(Tab var1) {
   }

   public void onTabSelected(Tab var1) {
      int var2 = var1.getPosition();
      this.this$0.viewPager.setCurrentItem(var2);
      ItemInspecaoFrustrarActivity.access$002(this.this$0, var2);
      this.this$0.configureFab();
   }

   public void onTabUnselected(Tab var1) {
   }
}
