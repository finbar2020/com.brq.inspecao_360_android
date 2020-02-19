package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.internal.Utils;

public class ItemInspecaoListaGrupoActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public ItemInspecaoListaGrupoActivity_ViewBinding(ItemInspecaoListaGrupoActivity var1, View var2) {
      super(var1, var2);
      var1.toolbar = (Toolbar)Utils.findRequiredViewAsType(var2, 2131296832, "field 'toolbar'", Toolbar.class);
      var1.floatingActionButton = (FloatingActionButton)Utils.findRequiredViewAsType(var2, 2131296448, "field 'floatingActionButton'", FloatingActionButton.class);
   }

   public void unbind() {
      ItemInspecaoListaGrupoActivity var1 = (ItemInspecaoListaGrupoActivity)this.target;
      super.unbind();
      var1.toolbar = null;
      var1.floatingActionButton = null;
   }
}
