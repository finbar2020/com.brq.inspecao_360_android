package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.db.AssinaturaDAO;
import com.brq.inspecao_360_android.model.entity.Assinatura;
import rx.functions.Action1;

// $FF: synthetic class
public final class -$$Lambda$ChecklistInteractorImpl$SOK28BtT9RbRvpmlP8iu5wwceYA implements Action1 {
   // $FF: synthetic field
   private final Long f$0;
   // $FF: synthetic field
   private final Assinatura f$1;
   // $FF: synthetic field
   private final AssinaturaDAO f$2;

   // $FF: synthetic method
   public _$$Lambda$ChecklistInteractorImpl$SOK28BtT9RbRvpmlP8iu5wwceYA/* $FF was: -$$Lambda$ChecklistInteractorImpl$SOK28BtT9RbRvpmlP8iu5wwceYA*/(Long var1, Assinatura var2, AssinaturaDAO var3) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
   }

   public final void call(Object var1) {
      ChecklistInteractorImpl.lambda$anexarAssinaturaOn$4(this.f$0, this.f$1, this.f$2, (Throwable)var1);
   }
}
