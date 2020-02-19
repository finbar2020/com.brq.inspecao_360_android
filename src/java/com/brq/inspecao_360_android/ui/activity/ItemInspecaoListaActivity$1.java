package com.brq.inspecao_360_android.ui.activity;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

class ItemInspecaoListaActivity$1 extends ActionBarDrawerToggle {
   // $FF: synthetic field
   final ItemInspecaoListaActivity this$0;

   ItemInspecaoListaActivity$1(ItemInspecaoListaActivity var1, Activity var2, DrawerLayout var3, Toolbar var4, int var5, int var6) {
      super(var2, var3, var4, var5, var6);
      this.this$0 = var1;
   }

   public void onDrawerOpened(View var1) {
      super.onDrawerOpened(var1);
      if (this.this$0.drawerLayout.isDrawerOpen(8388611)) {
         this.this$0.presenter.carregarDadosPerfilUsuario();
      }

   }
}
