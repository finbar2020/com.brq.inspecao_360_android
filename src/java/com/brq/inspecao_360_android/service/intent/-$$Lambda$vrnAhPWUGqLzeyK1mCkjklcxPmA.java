package com.brq.inspecao_360_android.service.intent;

import com.brq.inspecao_360_android.model.entity.Item;
import rx.functions.Action1;

// $FF: synthetic class
public final class -$$Lambda$vrnAhPWUGqLzeyK1mCkjklcxPmA implements Action1 {
   // $FF: synthetic field
   private final ChecklistIntentService f$0;

   // $FF: synthetic method
   public _$$Lambda$vrnAhPWUGqLzeyK1mCkjklcxPmA/* $FF was: -$$Lambda$vrnAhPWUGqLzeyK1mCkjklcxPmA*/(ChecklistIntentService var1) {
      this.f$0 = var1;
   }

   public final void call(Object var1) {
      this.f$0.throwItem((Item)var1);
   }
}
