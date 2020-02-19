package com.brq.inspecao_360_android.ui.activity;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Imagem;
import com.brq.inspecao_360_android.ui.activity.CameraV2Activity.1;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

class CameraV2Activity$1$1 extends Subscriber {
   // $FF: synthetic field
   final 1 this$1;

   CameraV2Activity$1$1(1 var1) {
      this.this$1 = var1;
   }

   public void onCompleted() {
      if (CameraV2Activity.access$100(this.this$1.this$0)) {
         if (CameraV2Activity.access$200(this.this$1.this$0) != null) {
            this.this$1.this$0.interactor.salvarOff(CameraV2Activity.access$200(this.this$1.this$0)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CameraV2Activity$1$1$1(this));
            return;
         }
      } else {
         Logger.info("CAMERA - Vai chamar a activity.");
         CameraV2Activity.access$302(this.this$1.this$0, true);
         this.this$1.this$0.showProgress(false);
         this.this$1.this$0.btnFoto.setEnabled(true);
         CameraV2Activity.access$500(this.this$1.this$0, true, true);
      }

   }

   public void onError(Throwable var1) {
      Logger.error(this.this$1.this$0.getString(2131821072), var1);
      this.this$1.this$0.showProgress(false);
      this.this$1.this$0.showSnackbar(this.this$1.this$0.getString(2131821067));
   }

   public void onNext(Imagem var1) {
   }

   public void onStart() {
      super.onStart();
   }
}
