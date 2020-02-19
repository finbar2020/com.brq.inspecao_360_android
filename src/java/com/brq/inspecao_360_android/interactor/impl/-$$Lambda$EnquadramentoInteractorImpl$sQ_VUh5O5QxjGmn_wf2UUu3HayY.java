package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.db.ClasseConstrucaoDAO;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

// $FF: synthetic class
public final class -$$Lambda$EnquadramentoInteractorImpl$sQ_VUh5O5QxjGmn_wf2UUu3HayY implements OnSubscribe {
   // $FF: synthetic field
   private final ClasseConstrucaoDAO f$0;
   // $FF: synthetic field
   private final Long f$1;

   // $FF: synthetic method
   public _$$Lambda$EnquadramentoInteractorImpl$sQ_VUh5O5QxjGmn_wf2UUu3HayY/* $FF was: -$$Lambda$EnquadramentoInteractorImpl$sQ_VUh5O5QxjGmn_wf2UUu3HayY*/(ClasseConstrucaoDAO var1, Long var2) {
      this.f$0 = var1;
      this.f$1 = var2;
   }

   public final void call(Object var1) {
      EnquadramentoInteractorImpl.lambda$obterClasseConstrucoes$13(this.f$0, this.f$1, (Subscriber)var1);
   }
}
