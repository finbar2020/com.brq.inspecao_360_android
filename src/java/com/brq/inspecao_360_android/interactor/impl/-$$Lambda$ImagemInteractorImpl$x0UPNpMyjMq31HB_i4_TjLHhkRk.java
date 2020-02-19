package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.db.ImagemDAO;
import com.brq.inspecao_360_android.model.db.ItemDAO;
import com.brq.inspecao_360_android.model.entity.Imagem;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

// $FF: synthetic class
public final class -$$Lambda$ImagemInteractorImpl$x0UPNpMyjMq31HB_i4_TjLHhkRk implements OnSubscribe {
   // $FF: synthetic field
   private final ImagemDAO f$0;
   // $FF: synthetic field
   private final Imagem f$1;
   // $FF: synthetic field
   private final ItemDAO f$2;

   // $FF: synthetic method
   public _$$Lambda$ImagemInteractorImpl$x0UPNpMyjMq31HB_i4_TjLHhkRk/* $FF was: -$$Lambda$ImagemInteractorImpl$x0UPNpMyjMq31HB_i4_TjLHhkRk*/(ImagemDAO var1, Imagem var2, ItemDAO var3) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
   }

   public final void call(Object var1) {
      ImagemInteractorImpl.lambda$salvarOff$0(this.f$0, this.f$1, this.f$2, (Subscriber)var1);
   }
}
