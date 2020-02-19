package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.db.AssinaturaDAO;
import com.brq.inspecao_360_android.model.db.ItemDAO;
import com.brq.inspecao_360_android.model.entity.Assinatura;
import com.brq.inspecao_360_android.model.entity.Usuario;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

// $FF: synthetic class
public final class -$$Lambda$AssinaturaInteractorImpl$4BPdBbu7--eqSWb97XZOti0EgzY implements OnSubscribe {
   // $FF: synthetic field
   private final ItemDAO f$0;
   // $FF: synthetic field
   private final Usuario f$1;
   // $FF: synthetic field
   private final Long f$2;
   // $FF: synthetic field
   private final Assinatura f$3;
   // $FF: synthetic field
   private final AssinaturaDAO f$4;
   // $FF: synthetic field
   private final Long f$5;

   // $FF: synthetic method
   public _$$Lambda$AssinaturaInteractorImpl$4BPdBbu7__eqSWb97XZOti0EgzY/* $FF was: -$$Lambda$AssinaturaInteractorImpl$4BPdBbu7--eqSWb97XZOti0EgzY*/(ItemDAO var1, Usuario var2, Long var3, Assinatura var4, AssinaturaDAO var5, Long var6) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
      this.f$3 = var4;
      this.f$4 = var5;
      this.f$5 = var6;
   }

   public final void call(Object var1) {
      AssinaturaInteractorImpl.lambda$salvarOff$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (Subscriber)var1);
   }
}
