package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.github.gcacace.signaturepad.views.SignaturePad;

public class ItemInspecaoAssinaturaActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public ItemInspecaoAssinaturaActivity_ViewBinding(ItemInspecaoAssinaturaActivity var1, View var2) {
      super(var1, var2);
      var1.txtDescStatus = (TextView)Utils.findRequiredViewAsType(var2, 2131296880, "field 'txtDescStatus'", TextView.class);
      var1.mViewError = var2.findViewById(2131296945);
      var1.txtErro = (TextView)Utils.findOptionalViewAsType(var2, 2131296895, "field 'txtErro'", TextView.class);
      var1.txtNomeAssinatura = (TextView)Utils.findOptionalViewAsType(var2, 2131296750, "field 'txtNomeAssinatura'", TextView.class);
      var1.mSignaturePad = (SignaturePad)Utils.findOptionalViewAsType(var2, 2131296749, "field 'mSignaturePad'", SignaturePad.class);
   }

   public void unbind() {
      ItemInspecaoAssinaturaActivity var1 = (ItemInspecaoAssinaturaActivity)this.target;
      super.unbind();
      var1.txtDescStatus = null;
      var1.mViewError = null;
      var1.txtErro = null;
      var1.txtNomeAssinatura = null;
      var1.mSignaturePad = null;
   }
}
