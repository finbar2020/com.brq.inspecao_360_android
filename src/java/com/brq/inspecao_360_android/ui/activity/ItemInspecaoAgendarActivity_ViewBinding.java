package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;

public class ItemInspecaoAgendarActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public ItemInspecaoAgendarActivity_ViewBinding(ItemInspecaoAgendarActivity var1, View var2) {
      super(var1, var2);
      var1.navigationView = (AHBottomNavigation)Utils.findRequiredViewAsType(var2, 2131296300, "field 'navigationView'", AHBottomNavigation.class);
      var1.txtDescStatus = (TextView)Utils.findRequiredViewAsType(var2, 2131296880, "field 'txtDescStatus'", TextView.class);
      var1.listView = (ListView)Utils.findRequiredViewAsType(var2, 2131296591, "field 'listView'", ListView.class);
   }

   public void unbind() {
      ItemInspecaoAgendarActivity var1 = (ItemInspecaoAgendarActivity)this.target;
      super.unbind();
      var1.navigationView = null;
      var1.txtDescStatus = null;
      var1.listView = null;
   }
}
