package com.brq.inspecao_360_android.service;

import com.brq.inspecao_360_android.common.util.Logger;
import rx.Subscriber;

class DownloadIntentService$2$1 extends Subscriber {
   // $FF: synthetic field
   final DownloadIntentService$2 this$1;

   DownloadIntentService$2$1(DownloadIntentService$2 var1) {
      this.this$1 = var1;
   }

   public void onCompleted() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Status do anexo alterado com sucesso! nome: [");
      var1.append(this.this$1.val$nomeAnexo);
      var1.append("], id: [");
      var1.append(this.this$1.val$idAnexo);
      var1.append("]");
      Logger.debug(var1.toString());
   }

   public void onError(Throwable var1) {
   }

   public void onNext(Void var1) {
   }
}
