package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;

public class ItemInspecaoDetalheActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public ItemInspecaoDetalheActivity_ViewBinding(ItemInspecaoDetalheActivity var1, View var2) {
      super(var1, var2);
      var1.txtDescStatus = (TextView)Utils.findRequiredViewAsType(var2, 2131296880, "field 'txtDescStatus'", TextView.class);
      var1.tabLayout = (TabLayout)Utils.findRequiredViewAsType(var2, 2131296791, "field 'tabLayout'", TabLayout.class);
      var1.viewPager = (ViewPager)Utils.findRequiredViewAsType(var2, 2131296792, "field 'viewPager'", ViewPager.class);
      var1.navigationView = (AHBottomNavigation)Utils.findRequiredViewAsType(var2, 2131296300, "field 'navigationView'", AHBottomNavigation.class);
   }

   public void unbind() {
      ItemInspecaoDetalheActivity var1 = (ItemInspecaoDetalheActivity)this.target;
      super.unbind();
      var1.txtDescStatus = null;
      var1.tabLayout = null;
      var1.viewPager = null;
      var1.navigationView = null;
   }
}
