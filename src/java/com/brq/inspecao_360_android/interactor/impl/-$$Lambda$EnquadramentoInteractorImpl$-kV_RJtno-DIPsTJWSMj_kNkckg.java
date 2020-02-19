package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.db.ItemDAO;
import com.brq.inspecao_360_android.model.db.ItemEnquadramentoDAO;
import com.brq.inspecao_360_android.model.entity.Usuario;
import java.util.List;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

// $FF: synthetic class
public final class -$$Lambda$EnquadramentoInteractorImpl$-kV_RJtno-DIPsTJWSMj_kNkckg implements OnSubscribe {
   // $FF: synthetic field
   private final List f$0;
   // $FF: synthetic field
   private final ItemEnquadramentoDAO f$1;
   // $FF: synthetic field
   private final ItemDAO f$2;
   // $FF: synthetic field
   private final Usuario f$3;

   // $FF: synthetic method
   public _$$Lambda$EnquadramentoInteractorImpl$_kV_RJtno_DIPsTJWSMj_kNkckg/* $FF was: -$$Lambda$EnquadramentoInteractorImpl$-kV_RJtno-DIPsTJWSMj_kNkckg*/(List var1, ItemEnquadramentoDAO var2, ItemDAO var3, Usuario var4) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
      this.f$3 = var4;
   }

   public final void call(Object var1) {
      EnquadramentoInteractorImpl.lambda$enquadrarOff$3(this.f$0, this.f$1, this.f$2, this.f$3, (Subscriber)var1);
   }
}
