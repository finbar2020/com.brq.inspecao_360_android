package com.brq.inspecao_360_android.ui.activity;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.model.entity.Imagem;
import rx.Subscriber;

class CameraV2Activity$4 extends Subscriber {
   // $FF: synthetic field
   final CameraV2Activity this$0;

   CameraV2Activity$4(CameraV2Activity var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao carregar ultima foto", var1);
   }

   public void onNext(Imagem var1) {
      if (!Validator.isNullOrEmpty(var1)) {
         this.this$0.setUltimaFoto(var1, false);
      }

   }
}
