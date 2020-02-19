package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.db.EnderecoDAO;
import com.brq.inspecao_360_android.model.db.ItemDAO;
import com.brq.inspecao_360_android.model.entity.Endereco;
import com.brq.inspecao_360_android.model.entity.Usuario;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

// $FF: synthetic class
public final class -$$Lambda$EnderecoInteractorImpl$iZ2zUBMmFi_qeiFn4pT0cpLD76o implements OnSubscribe {
   // $FF: synthetic field
   private final Endereco f$0;
   // $FF: synthetic field
   private final ItemDAO f$1;
   // $FF: synthetic field
   private final Usuario f$2;
   // $FF: synthetic field
   private final Long f$3;
   // $FF: synthetic field
   private final EnderecoDAO f$4;

   // $FF: synthetic method
   public _$$Lambda$EnderecoInteractorImpl$iZ2zUBMmFi_qeiFn4pT0cpLD76o/* $FF was: -$$Lambda$EnderecoInteractorImpl$iZ2zUBMmFi_qeiFn4pT0cpLD76o*/(Endereco var1, ItemDAO var2, Usuario var3, Long var4, EnderecoDAO var5) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
      this.f$3 = var4;
      this.f$4 = var5;
   }

   public final void call(Object var1) {
      EnderecoInteractorImpl.lambda$alterarEnderecoOff$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Subscriber)var1);
   }
}
