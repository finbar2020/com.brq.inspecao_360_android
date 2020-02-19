package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.internal.Utils;

public class ItemInspecaoEnquadrarActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public ItemInspecaoEnquadrarActivity_ViewBinding(ItemInspecaoEnquadrarActivity var1, View var2) {
      super(var1, var2);
      var1.txtDescStatus = (TextView)Utils.findRequiredViewAsType(var2, 2131296880, "field 'txtDescStatus'", TextView.class);
      var1.mViewError = var2.findViewById(2131296945);
      var1.txtErro = (TextView)Utils.findOptionalViewAsType(var2, 2131296895, "field 'txtErro'", TextView.class);
      var1.lstEnquandramento = (ListView)Utils.findRequiredViewAsType(var2, 2131296599, "field 'lstEnquandramento'", ListView.class);
   }

   public void unbind() {
      ItemInspecaoEnquadrarActivity var1 = (ItemInspecaoEnquadrarActivity)this.target;
      super.unbind();
      var1.txtDescStatus = null;
      var1.mViewError = null;
      var1.txtErro = null;
      var1.lstEnquandramento = null;
   }
}
