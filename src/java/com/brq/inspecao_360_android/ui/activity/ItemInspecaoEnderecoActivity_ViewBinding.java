package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.internal.Utils;

public class ItemInspecaoEnderecoActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public ItemInspecaoEnderecoActivity_ViewBinding(ItemInspecaoEnderecoActivity var1, View var2) {
      super(var1, var2);
      var1.txtDescStatus = (TextView)Utils.findRequiredViewAsType(var2, 2131296880, "field 'txtDescStatus'", TextView.class);
      var1.estadoSpinner = (Spinner)Utils.findRequiredViewAsType(var2, 2131296735, "field 'estadoSpinner'", Spinner.class);
      var1.municipioSpinner = (Spinner)Utils.findRequiredViewAsType(var2, 2131296739, "field 'municipioSpinner'", Spinner.class);
      var1.tieCep = (TextInputEditText)Utils.findRequiredViewAsType(var2, 2131296820, "field 'tieCep'", TextInputEditText.class);
      var1.tieNumero = (TextInputEditText)Utils.findRequiredViewAsType(var2, 2131296823, "field 'tieNumero'", TextInputEditText.class);
      var1.tieLogradouro = (TextInputEditText)Utils.findRequiredViewAsType(var2, 2131296822, "field 'tieLogradouro'", TextInputEditText.class);
      var1.tieBairro = (TextInputEditText)Utils.findRequiredViewAsType(var2, 2131296819, "field 'tieBairro'", TextInputEditText.class);
      var1.tieComplemento = (TextInputEditText)Utils.findRequiredViewAsType(var2, 2131296821, "field 'tieComplemento'", TextInputEditText.class);
      var1.mViewError = var2.findViewById(2131296945);
      var1.txtErro = (TextView)Utils.findOptionalViewAsType(var2, 2131296895, "field 'txtErro'", TextView.class);
   }

   public void unbind() {
      ItemInspecaoEnderecoActivity var1 = (ItemInspecaoEnderecoActivity)this.target;
      super.unbind();
      var1.txtDescStatus = null;
      var1.estadoSpinner = null;
      var1.municipioSpinner = null;
      var1.tieCep = null;
      var1.tieNumero = null;
      var1.tieLogradouro = null;
      var1.tieBairro = null;
      var1.tieComplemento = null;
      var1.mViewError = null;
      var1.txtErro = null;
   }
}
