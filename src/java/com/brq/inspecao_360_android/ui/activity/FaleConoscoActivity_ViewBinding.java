package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import butterknife.internal.Utils;
import com.brq.inspecao_360_android.ui.activity.FaleConoscoActivity_ViewBinding.1;
import com.brq.inspecao_360_android.ui.activity.FaleConoscoActivity_ViewBinding.2;

public class FaleConoscoActivity_ViewBinding extends BaseActivity_ViewBinding {
   private View view2131296332;
   private View view2131296337;

   @UiThread
   public FaleConoscoActivity_ViewBinding(FaleConoscoActivity var1, View var2) {
      super(var1, var2);
      var1.toolbar = (Toolbar)Utils.findRequiredViewAsType(var2, 2131296833, "field 'toolbar'", Toolbar.class);
      View var3 = Utils.findRequiredView(var2, 2131296332, "method 'CardEmailOnClick'");
      this.view2131296332 = var3;
      var3.setOnClickListener(new 1(this, var1));
      View var4 = Utils.findRequiredView(var2, 2131296337, "method 'CardTelefoneOnClick'");
      this.view2131296337 = var4;
      var4.setOnClickListener(new 2(this, var1));
   }

   public void unbind() {
      FaleConoscoActivity var1 = (FaleConoscoActivity)this.target;
      super.unbind();
      var1.toolbar = null;
      this.view2131296332.setOnClickListener((OnClickListener)null);
      this.view2131296332 = null;
      this.view2131296337.setOnClickListener((OnClickListener)null);
      this.view2131296337 = null;
   }
}
