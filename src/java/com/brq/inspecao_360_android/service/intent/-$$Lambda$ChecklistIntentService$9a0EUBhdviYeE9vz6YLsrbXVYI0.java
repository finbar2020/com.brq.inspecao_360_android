package com.brq.inspecao_360_android.service.intent;

import com.brq.inspecao_360_android.model.entity.Item;
import java.util.List;
import rx.functions.Func1;

// $FF: synthetic class
public final class -$$Lambda$ChecklistIntentService$9a0EUBhdviYeE9vz6YLsrbXVYI0 implements Func1 {
   // $FF: synthetic field
   private final ChecklistIntentService f$0;
   // $FF: synthetic field
   private final List f$1;
   // $FF: synthetic field
   private final Long f$2;
   // $FF: synthetic field
   private final Long f$3;

   // $FF: synthetic method
   public _$$Lambda$ChecklistIntentService$9a0EUBhdviYeE9vz6YLsrbXVYI0/* $FF was: -$$Lambda$ChecklistIntentService$9a0EUBhdviYeE9vz6YLsrbXVYI0*/(ChecklistIntentService var1, List var2, Long var3, Long var4) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
      this.f$3 = var4;
   }

   public final Object call(Object var1) {
      return this.f$0.lambda$processar$19$ChecklistIntentService(this.f$1, this.f$2, this.f$3, (Item)var1);
   }
}
