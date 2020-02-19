package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.internal.Utils;
import com.brq.inspecao_360_android.presentantion.view.custom.RoundedImageView;
import com.otaliastudios.cameraview.CameraView;

public class CameraV2Activity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public CameraV2Activity_ViewBinding(CameraV2Activity var1, View var2) {
      super(var1, var2);
      var1.cameraView = (CameraView)Utils.findRequiredViewAsType(var2, 2131296328, "field 'cameraView'", CameraView.class);
      var1.btnFoto = (ImageView)Utils.findRequiredViewAsType(var2, 2131296319, "field 'btnFoto'", ImageView.class);
      var1.btnFlash = (ImageView)Utils.findRequiredViewAsType(var2, 2131296318, "field 'btnFlash'", ImageView.class);
      var1.imgUltimaFoto = (RoundedImageView)Utils.findRequiredViewAsType(var2, 2131296530, "field 'imgUltimaFoto'", RoundedImageView.class);
   }

   public void unbind() {
      CameraV2Activity var1 = (CameraV2Activity)this.target;
      super.unbind();
      var1.cameraView = null;
      var1.btnFoto = null;
      var1.btnFlash = null;
      var1.imgUltimaFoto = null;
   }
}
