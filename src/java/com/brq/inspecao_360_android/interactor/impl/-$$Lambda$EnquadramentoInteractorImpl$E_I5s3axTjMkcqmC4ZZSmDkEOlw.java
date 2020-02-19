package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.db.ProdutoComercialDAO;
import com.brq.inspecao_360_android.model.entity.SubRamo;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

// $FF: synthetic class
public final class -$$Lambda$EnquadramentoInteractorImpl$E_I5s3axTjMkcqmC4ZZSmDkEOlw implements OnSubscribe {
   // $FF: synthetic field
   private final ProdutoComercialDAO f$0;
   // $FF: synthetic field
   private final SubRamo f$1;

   // $FF: synthetic method
   public _$$Lambda$EnquadramentoInteractorImpl$E_I5s3axTjMkcqmC4ZZSmDkEOlw/* $FF was: -$$Lambda$EnquadramentoInteractorImpl$E_I5s3axTjMkcqmC4ZZSmDkEOlw*/(ProdutoComercialDAO var1, SubRamo var2) {
      this.f$0 = var1;
      this.f$1 = var2;
   }

   public final void call(Object var1) {
      EnquadramentoInteractorImpl.lambda$obterProdutosComerciaisPorSubRamo$11(this.f$0, this.f$1, (Subscriber)var1);
   }
}
