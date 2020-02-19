package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.db.ItemEnquadramentoDAO;
import com.brq.inspecao_360_android.model.entity.ItemEnquadramento;
import com.brq.inspecao_360_android.model.entity.Usuario;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

// $FF: synthetic class
public final class -$$Lambda$EnquadramentoInteractorImpl$CZDJJlKwPqqikl2ZakAWOteVweA implements OnSubscribe {
   // $FF: synthetic field
   private final EnquadramentoInteractorImpl f$0;
   // $FF: synthetic field
   private final ItemEnquadramento f$1;
   // $FF: synthetic field
   private final ItemEnquadramentoDAO f$2;
   // $FF: synthetic field
   private final Usuario f$3;

   // $FF: synthetic method
   public _$$Lambda$EnquadramentoInteractorImpl$CZDJJlKwPqqikl2ZakAWOteVweA/* $FF was: -$$Lambda$EnquadramentoInteractorImpl$CZDJJlKwPqqikl2ZakAWOteVweA*/(EnquadramentoInteractorImpl var1, ItemEnquadramento var2, ItemEnquadramentoDAO var3, Usuario var4) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
      this.f$3 = var4;
   }

   public final void call(Object var1) {
      this.f$0.lambda$removerEnquadramento$15$EnquadramentoInteractorImpl(this.f$1, this.f$2, this.f$3, (Subscriber)var1);
   }
}
