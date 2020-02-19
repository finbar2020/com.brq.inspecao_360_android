package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;

public class ItemInspecaoFotosActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public ItemInspecaoFotosActivity_ViewBinding(ItemInspecaoFotosActivity var1, View var2) {
      super(var1, var2);
      var1.txtDescStatus = (TextView)Utils.findRequiredViewAsType(var2, 2131296880, "field 'txtDescStatus'", TextView.class);
      var1.navigationView = (AHBottomNavigation)Utils.findRequiredViewAsType(var2, 2131296300, "field 'navigationView'", AHBottomNavigation.class);
   }

   public void unbind() {
      ItemInspecaoFotosActivity var1 = (ItemInspecaoFotosActivity)this.target;
      super.unbind();
      var1.txtDescStatus = null;
      var1.navigationView = null;
   }
}
