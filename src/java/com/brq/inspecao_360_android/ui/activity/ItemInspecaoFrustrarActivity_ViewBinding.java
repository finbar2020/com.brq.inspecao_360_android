package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.brq.inspecao_360_android.common.view.BadgedTabLayout;
import com.brq.inspecao_360_android.common.view.CounterFab;

public class ItemInspecaoFrustrarActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public ItemInspecaoFrustrarActivity_ViewBinding(ItemInspecaoFrustrarActivity var1, View var2) {
      super(var1, var2);
      var1.tabLayout = (BadgedTabLayout)Utils.findRequiredViewAsType(var2, 2131296791, "field 'tabLayout'", BadgedTabLayout.class);
      var1.viewPager = (ViewPager)Utils.findRequiredViewAsType(var2, 2131296792, "field 'viewPager'", ViewPager.class);
      var1.txtDescStatus = (TextView)Utils.findRequiredViewAsType(var2, 2131296880, "field 'txtDescStatus'", TextView.class);
      var1.fabCamera = (CounterFab)Utils.findRequiredViewAsType(var2, 2131296449, "field 'fabCamera'", CounterFab.class);
   }

   public void unbind() {
      ItemInspecaoFrustrarActivity var1 = (ItemInspecaoFrustrarActivity)this.target;
      super.unbind();
      var1.tabLayout = null;
      var1.viewPager = null;
      var1.txtDescStatus = null;
      var1.fabCamera = null;
   }
}
