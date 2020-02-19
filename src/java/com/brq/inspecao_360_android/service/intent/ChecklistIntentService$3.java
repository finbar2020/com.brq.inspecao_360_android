package com.brq.inspecao_360_android.service.intent;

import com.brq.inspecao_360_android.model.entity.Item;
import rx.Subscriber;

class ChecklistIntentService$3 extends Subscriber {
   // $FF: synthetic field
   final ChecklistIntentService this$0;

   ChecklistIntentService$3(ChecklistIntentService var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
   }

   public void onError(Throwable var1) {
      this.this$0.throwError(var1.getMessage(), var1);
   }

   public void onNext(Item var1) {
      ChecklistIntentService.access$300(this.this$0).cancel(var1.getId().intValue());
      this.this$0.throwItem(var1);
   }

   public void onStart() {
      super.onStart();
   }
}
