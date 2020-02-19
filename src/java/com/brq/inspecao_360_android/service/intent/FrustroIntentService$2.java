package com.brq.inspecao_360_android.service.intent;

import com.brq.inspecao_360_android.model.entity.Item;
import rx.Subscriber;

class FrustroIntentService$2 extends Subscriber {
   // $FF: synthetic field
   final FrustroIntentService this$0;

   FrustroIntentService$2(FrustroIntentService var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
   }

   public void onError(Throwable var1) {
      this.this$0.throwError(var1);
   }

   public void onNext(Item var1) {
      this.this$0.throwItem(var1);
   }

   public void onStart() {
      super.onStart();
   }
}
