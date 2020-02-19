package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.db.RespostaDAO;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

// $FF: synthetic class
public final class -$$Lambda$ControleRemotoInteractorImpl$klSRYSKwaYkKc6LB_T-8xzkr7Ec implements OnSubscribe {
   // $FF: synthetic field
   private final RespostaDAO f$0;
   // $FF: synthetic field
   private final Long f$1;
   // $FF: synthetic field
   private final Long f$2;

   // $FF: synthetic method
   public _$$Lambda$ControleRemotoInteractorImpl$klSRYSKwaYkKc6LB_T_8xzkr7Ec/* $FF was: -$$Lambda$ControleRemotoInteractorImpl$klSRYSKwaYkKc6LB_T-8xzkr7Ec*/(RespostaDAO var1, Long var2, Long var3) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
   }

   public final void call(Object var1) {
      ControleRemotoInteractorImpl.lambda$removerPerguntas$3(this.f$0, this.f$1, this.f$2, (Subscriber)var1);
   }
}
