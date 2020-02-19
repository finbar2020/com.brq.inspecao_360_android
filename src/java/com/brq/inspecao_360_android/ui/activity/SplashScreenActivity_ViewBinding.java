package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.Utils;

public class SplashScreenActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public SplashScreenActivity_ViewBinding(SplashScreenActivity var1, View var2) {
      super(var1, var2);
      var1.tvDescricao = (TextView)Utils.findRequiredViewAsType(var2, 2131296384, "field 'tvDescricao'", TextView.class);
   }

   public void unbind() {
      SplashScreenActivity var1 = (SplashScreenActivity)this.target;
      super.unbind();
      var1.tvDescricao = null;
   }
}
