package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.internal.Utils;

public class CameraPreviewActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public CameraPreviewActivity_ViewBinding(CameraPreviewActivity var1, View var2) {
      super(var1, var2);
      var1.imageView = (ImageView)Utils.findRequiredViewAsType(var2, 2131296678, "field 'imageView'", ImageView.class);
      var1.viewComentario = Utils.findRequiredView(var2, 2131296557, "field 'viewComentario'");
      var1.txtComentario = (TextView)Utils.findRequiredViewAsType(var2, 2131296873, "field 'txtComentario'", TextView.class);
   }

   public void unbind() {
      CameraPreviewActivity var1 = (CameraPreviewActivity)this.target;
      super.unbind();
      var1.imageView = null;
      var1.viewComentario = null;
      var1.txtComentario = null;
   }
}
