package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.internal.Utils;
import com.brq.inspecao_360_android.presentantion.view.custom.CropImageView;

public class PerfilFotoUsuarioPreviewActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public PerfilFotoUsuarioPreviewActivity_ViewBinding(PerfilFotoUsuarioPreviewActivity var1, View var2) {
      super(var1, var2);
      var1.ivFoto = (CropImageView)Utils.findRequiredViewAsType(var2, 2131296543, "field 'ivFoto'", CropImageView.class);
      var1.btnConfirmar = (Button)Utils.findRequiredViewAsType(var2, 2131296323, "field 'btnConfirmar'", Button.class);
      var1.btnCancelar = (Button)Utils.findRequiredViewAsType(var2, 2131296313, "field 'btnCancelar'", Button.class);
   }

   public void unbind() {
      PerfilFotoUsuarioPreviewActivity var1 = (PerfilFotoUsuarioPreviewActivity)this.target;
      super.unbind();
      var1.ivFoto = null;
      var1.btnConfirmar = null;
      var1.btnCancelar = null;
   }
}
