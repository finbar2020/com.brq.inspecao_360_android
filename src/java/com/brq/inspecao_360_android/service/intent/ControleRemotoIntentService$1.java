package com.brq.inspecao_360_android.service.intent;

import com.brq.inspecao_360_android.common.util.Logger;
import rx.Subscriber;

class ControleRemotoIntentService$1 extends Subscriber {
   // $FF: synthetic field
   final ControleRemotoIntentService this$0;
   // $FF: synthetic field
   final long val$idItem;
   // $FF: synthetic field
   final long val$idSecao;

   ControleRemotoIntentService$1(ControleRemotoIntentService var1, long var2, long var4) {
      this.this$0 = var1;
      this.val$idItem = var2;
      this.val$idSecao = var4;
   }

   public void onCompleted() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Perguntas do itemID=");
      var1.append(this.val$idItem);
      var1.append(" secaoID=");
      var1.append(this.val$idSecao);
      var1.append(" foram removidas com sucesso");
      Logger.debug(var1.toString());
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
