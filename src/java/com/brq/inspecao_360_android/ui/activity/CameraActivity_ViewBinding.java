package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import butterknife.internal.Utils;

public class CameraActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public CameraActivity_ViewBinding(CameraActivity var1, View var2) {
      super(var1, var2);
      var1.mSurfaceView = (SurfaceView)Utils.findRequiredViewAsType(var2, 2131296782, "field 'mSurfaceView'", SurfaceView.class);
      var1.btnFoto = (ImageView)Utils.findRequiredViewAsType(var2, 2131296319, "field 'btnFoto'", ImageView.class);
      var1.btnFlash = (ImageView)Utils.findRequiredViewAsType(var2, 2131296318, "field 'btnFlash'", ImageView.class);
   }

   public void unbind() {
      CameraActivity var1 = (CameraActivity)this.target;
      super.unbind();
      var1.mSurfaceView = null;
      var1.btnFoto = null;
      var1.btnFlash = null;
   }
}
