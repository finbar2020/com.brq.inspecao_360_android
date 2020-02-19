package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.db.ImagemDAO;
import com.brq.inspecao_360_android.model.entity.Imagem;
import rx.functions.Action1;

// $FF: synthetic class
public final class -$$Lambda$FrustroInteractorImpl$U9gTLnMGjZ4HmeV85WzgmRC3BZM implements Action1 {
   // $FF: synthetic field
   private final Long f$0;
   // $FF: synthetic field
   private final Imagem f$1;
   // $FF: synthetic field
   private final ImagemDAO f$2;

   // $FF: synthetic method
   public _$$Lambda$FrustroInteractorImpl$U9gTLnMGjZ4HmeV85WzgmRC3BZM/* $FF was: -$$Lambda$FrustroInteractorImpl$U9gTLnMGjZ4HmeV85WzgmRC3BZM*/(Long var1, Imagem var2, ImagemDAO var3) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
   }

   public final void call(Object var1) {
      FrustroInteractorImpl.lambda$anexarOn$0(this.f$0, this.f$1, this.f$2, (Throwable)var1);
   }
}
