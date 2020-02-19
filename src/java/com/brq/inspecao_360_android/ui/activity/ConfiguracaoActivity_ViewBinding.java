package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Switch;
import butterknife.internal.Utils;

public class ConfiguracaoActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public ConfiguracaoActivity_ViewBinding(ConfiguracaoActivity var1, View var2) {
      super(var1, var2);
      var1.toolbar = (Toolbar)Utils.findRequiredViewAsType(var2, 2131296832, "field 'toolbar'", Toolbar.class);
      var1.swFastCapture = (Switch)Utils.findRequiredViewAsType(var2, 2131296788, "field 'swFastCapture'", Switch.class);
      var1.swRastreamento = (Switch)Utils.findRequiredViewAsType(var2, 2131296789, "field 'swRastreamento'", Switch.class);
      var1.swSyncOnlyOnWifi = (Switch)Utils.findRequiredViewAsType(var2, 2131296787, "field 'swSyncOnlyOnWifi'", Switch.class);
   }

   public void unbind() {
      ConfiguracaoActivity var1 = (ConfiguracaoActivity)this.target;
      super.unbind();
      var1.toolbar = null;
      var1.swFastCapture = null;
      var1.swRastreamento = null;
      var1.swSyncOnlyOnWifi = null;
   }
}
