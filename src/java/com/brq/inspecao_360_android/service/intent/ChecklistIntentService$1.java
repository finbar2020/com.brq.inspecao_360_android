package com.brq.inspecao_360_android.service.intent;

import com.brq.inspecao_360_android.model.entity.Item;
import rx.Observable;
import rx.functions.Func1;

class ChecklistIntentService$1 implements Func1 {
   // $FF: synthetic field
   final ChecklistIntentService this$0;

   ChecklistIntentService$1(ChecklistIntentService var1) {
      this.this$0 = var1;
   }

   public Observable call(Item var1) {
      return this.this$0.atualizar(var1.getStatusVigente());
   }
}
