package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.brq.inspecao_360_android.presentantion.view.custom.RoundedImageView;

public class PerfilUsuarioActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public PerfilUsuarioActivity_ViewBinding(PerfilUsuarioActivity var1, View var2) {
      super(var1, var2);
      var1.imgFotoPerfilUsuario = (RoundedImageView)Utils.findRequiredViewAsType(var2, 2131296468, "field 'imgFotoPerfilUsuario'", RoundedImageView.class);
      var1.editNomeUsuario = (EditText)Utils.findRequiredViewAsType(var2, 2131296412, "field 'editNomeUsuario'", EditText.class);
      var1.editSenhaAtual = (EditText)Utils.findRequiredViewAsType(var2, 2131296422, "field 'editSenhaAtual'", EditText.class);
      var1.editSenhaNova = (EditText)Utils.findRequiredViewAsType(var2, 2131296424, "field 'editSenhaNova'", EditText.class);
      var1.editConfirmacaoSenha = (EditText)Utils.findRequiredViewAsType(var2, 2131296423, "field 'editConfirmacaoSenha'", EditText.class);
      var1.txtEmailUsuario = (TextView)Utils.findRequiredViewAsType(var2, 2131296889, "field 'txtEmailUsuario'", TextView.class);
   }

   public void unbind() {
      PerfilUsuarioActivity var1 = (PerfilUsuarioActivity)this.target;
      super.unbind();
      var1.imgFotoPerfilUsuario = null;
      var1.editNomeUsuario = null;
      var1.editSenhaAtual = null;
      var1.editSenhaNova = null;
      var1.editConfirmacaoSenha = null;
      var1.txtEmailUsuario = null;
   }
}
