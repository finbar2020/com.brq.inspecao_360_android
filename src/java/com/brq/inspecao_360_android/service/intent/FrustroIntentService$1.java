package com.brq.inspecao_360_android.service.intent;

import com.brq.inspecao_360_android.model.entity.Item;
import rx.Subscriber;

class FrustroIntentService$1 extends Subscriber {
   // $FF: synthetic field
   final FrustroIntentService this$0;

   FrustroIntentService$1(FrustroIntentService var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
      FrustroIntentService.access$000(this.this$0).putExtra(this.this$0.getString(2131821261), "br.com.brq.action.ACTION_COMPLETED");
      FrustroIntentService var2 = this.this$0;
      var2.sendBroadcast(FrustroIntentService.access$000(var2));
      this.this$0.stopSelf();
   }

   public void onError(Throwable var1) {
      this.this$0.throwError(var1);
   }

   public void onNext(Item var1) {
   }

   public void onStart() {
      super.onStart();
   }
}
