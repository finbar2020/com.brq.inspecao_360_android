package com.brq.inspecao_360_android.service.intent;

import com.brq.inspecao_360_android.common.util.Logger;
import rx.Subscriber;

class ControleRemotoIntentService$6 extends Subscriber {
   // $FF: synthetic field
   final ControleRemotoIntentService this$0;

   ControleRemotoIntentService$6(ControleRemotoIntentService var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
      Logger.debug("Imagens decriptografadas com sucesso.");
   }

   public void onError(Throwable var1) {
      Logger.error(var1.getMessage(), var1);
   }

   public void onNext(Void var1) {
   }

   public void onStart() {
      super.onStart();
   }
}
