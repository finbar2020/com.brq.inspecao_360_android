package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.db.EnquadramentoDAO;
import com.brq.inspecao_360_android.model.entity.ProdutoComercial;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

// $FF: synthetic class
public final class -$$Lambda$EnquadramentoInteractorImpl$7bWL60Z8OUcqfbXvlLPKPfsiGnI implements OnSubscribe {
   // $FF: synthetic field
   private final EnquadramentoInteractorImpl f$0;
   // $FF: synthetic field
   private final EnquadramentoDAO f$1;
   // $FF: synthetic field
   private final ProdutoComercial f$2;

   // $FF: synthetic method
   public _$$Lambda$EnquadramentoInteractorImpl$7bWL60Z8OUcqfbXvlLPKPfsiGnI/* $FF was: -$$Lambda$EnquadramentoInteractorImpl$7bWL60Z8OUcqfbXvlLPKPfsiGnI*/(EnquadramentoInteractorImpl var1, EnquadramentoDAO var2, ProdutoComercial var3) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
   }

   public final void call(Object var1) {
      this.f$0.lambda$obterEnquadramentosPorProdutoComercial$9$EnquadramentoInteractorImpl(this.f$1, this.f$2, (Subscriber)var1);
   }
}
