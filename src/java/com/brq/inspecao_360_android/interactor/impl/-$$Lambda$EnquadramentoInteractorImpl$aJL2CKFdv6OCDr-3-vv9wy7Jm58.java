package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.db.SubRamoDAO;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

// $FF: synthetic class
public final class -$$Lambda$EnquadramentoInteractorImpl$aJL2CKFdv6OCDr-3-vv9wy7Jm58 implements OnSubscribe {
   // $FF: synthetic field
   private final SubRamoDAO f$0;
   // $FF: synthetic field
   private final Long f$1;

   // $FF: synthetic method
   public _$$Lambda$EnquadramentoInteractorImpl$aJL2CKFdv6OCDr_3_vv9wy7Jm58/* $FF was: -$$Lambda$EnquadramentoInteractorImpl$aJL2CKFdv6OCDr-3-vv9wy7Jm58*/(SubRamoDAO var1, Long var2) {
      this.f$0 = var1;
      this.f$1 = var2;
   }

   public final void call(Object var1) {
      EnquadramentoInteractorImpl.lambda$obterSubRamos$7(this.f$0, this.f$1, (Subscriber)var1);
   }
}
