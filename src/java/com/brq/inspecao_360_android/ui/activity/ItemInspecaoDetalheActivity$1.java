package com.brq.inspecao_360_android.ui.activity;

import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;

class ItemInspecaoDetalheActivity$1 implements OnTabSelectedListener {
   // $FF: synthetic field
   final ItemInspecaoDetalheActivity this$0;

   ItemInspecaoDetalheActivity$1(ItemInspecaoDetalheActivity var1) {
      this.this$0 = var1;
   }

   public void onTabReselected(Tab var1) {
   }

   public void onTabSelected(Tab var1) {
      int var2 = var1.getPosition();
      this.this$0.viewPager.setCurrentItem(var2);
      ItemInspecaoDetalheActivity.access$002(this.this$0, var2);
      this.this$0.shouldShowFloatingButton();
   }

   public void onTabUnselected(Tab var1) {
   }
}
