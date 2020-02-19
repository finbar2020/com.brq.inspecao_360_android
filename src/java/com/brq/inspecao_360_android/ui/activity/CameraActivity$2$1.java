package com.brq.inspecao_360_android.ui.activity;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Imagem;
import com.brq.inspecao_360_android.ui.activity.CameraActivity.2;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

class CameraActivity$2$1 extends Subscriber {
   // $FF: synthetic field
   final 2 this$1;

   CameraActivity$2$1(2 var1) {
      this.this$1 = var1;
   }

   public void onCompleted() {
      if (this.this$1.this$0.baseInteractor.getConfiguracaoUsuario().getEnableFastCapture()) {
         if (CameraActivity.access$200(this.this$1.this$0) != null) {
            this.this$1.this$0.interactor.salvarOff(CameraActivity.access$200(this.this$1.this$0)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CameraActivity$2$1$1(this));
            return;
         }
      } else {
         CameraActivity.access$102(this.this$1.this$0, true);
         this.this$1.this$0.showProgress(false);
         this.this$1.this$0.btnFoto.setEnabled(true);
         this.this$1.this$0.startActivity(CameraPreviewActivity.newInstance(this.this$1.this$0, CameraActivity.access$400(this.this$1.this$0), CameraActivity.access$500(this.this$1.this$0), CameraActivity.access$200(this.this$1.this$0), true, true));
      }

   }

   public void onError(Throwable var1) {
      Logger.error(this.this$1.this$0.getString(2131821072), var1);
      this.this$1.this$0.showProgress(false);
      this.this$1.this$0.showSnackbar(this.this$1.this$0.getString(2131821067));
      this.this$1.this$0.refresh();
   }

   public void onNext(Imagem var1) {
   }

   public void onStart() {
      super.onStart();
   }
}
