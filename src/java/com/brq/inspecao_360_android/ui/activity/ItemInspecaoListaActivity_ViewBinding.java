package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.internal.Utils;

public class ItemInspecaoListaActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public ItemInspecaoListaActivity_ViewBinding(ItemInspecaoListaActivity var1, View var2) {
      super(var1, var2);
      var1.toolbar = (Toolbar)Utils.findRequiredViewAsType(var2, 2131296832, "field 'toolbar'", Toolbar.class);
      var1.drawerLayout = (DrawerLayout)Utils.findRequiredViewAsType(var2, 2131296398, "field 'drawerLayout'", DrawerLayout.class);
      var1.navigationView = (NavigationView)Utils.findRequiredViewAsType(var2, 2131296649, "field 'navigationView'", NavigationView.class);
      var1.floatingActionButton = (FloatingActionButton)Utils.findRequiredViewAsType(var2, 2131296448, "field 'floatingActionButton'", FloatingActionButton.class);
   }

   public void unbind() {
      ItemInspecaoListaActivity var1 = (ItemInspecaoListaActivity)this.target;
      super.unbind();
      var1.toolbar = null;
      var1.drawerLayout = null;
      var1.navigationView = null;
      var1.floatingActionButton = null;
   }
}
