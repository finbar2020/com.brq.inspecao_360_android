package com.brq.inspecao_360_android.service.intent;

import android.widget.Toast;
import com.brq.inspecao_360_android.model.entity.Item;
import rx.Subscriber;

class ChecklistIntentService$4 extends Subscriber {
   // $FF: synthetic field
   final ChecklistIntentService this$0;

   ChecklistIntentService$4(ChecklistIntentService var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
      ChecklistIntentService.access$1100(this.this$0).putExtra(this.this$0.getString(2131821261), "br.com.brq.action.ACTION_COMPLETED");
      ChecklistIntentService var2 = this.this$0;
      var2.sendBroadcast(ChecklistIntentService.access$1100(var2));
      this.this$0.stopForeground(false);
      this.this$0.stopSelf();
   }

   public void onError(Throwable var1) {
      this.this$0.throwError(var1.getMessage(), var1);
   }

   public void onNext(Item var1) {
   }

   public void onStart() {
      super.onStart();
      if (ChecklistIntentService.access$400(this.this$0).equalsIgnoreCase("br.com.brq.action.ACAO_ENVIAR")) {
         Toast.makeText(this.this$0.getApplicationContext(), "Iniciando Transmissão...", 1).show();
      } else {
         if (ChecklistIntentService.access$400(this.this$0).equalsIgnoreCase("br.com.brq.action.ACAO_REENVIAR")) {
            Toast.makeText(this.this$0.getApplicationContext(), "Reiniciando Transmissão...", 1).show();
         }

      }
   }
}
