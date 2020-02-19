package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.internal.Utils;

public class ItemInspecaoRecusaActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public ItemInspecaoRecusaActivity_ViewBinding(ItemInspecaoRecusaActivity var1, View var2) {
      super(var1, var2);
      var1.txtDescStatus = (TextView)Utils.findRequiredViewAsType(var2, 2131296880, "field 'txtDescStatus'", TextView.class);
      var1.spinner = (Spinner)Utils.findRequiredViewAsType(var2, 2131296738, "field 'spinner'", Spinner.class);
      var1.editDescMotivo = (TextView)Utils.findRequiredViewAsType(var2, 2131296406, "field 'editDescMotivo'", TextView.class);
   }

   public void unbind() {
      ItemInspecaoRecusaActivity var1 = (ItemInspecaoRecusaActivity)this.target;
      super.unbind();
      var1.txtDescStatus = null;
      var1.spinner = null;
      var1.editDescMotivo = null;
   }
}
