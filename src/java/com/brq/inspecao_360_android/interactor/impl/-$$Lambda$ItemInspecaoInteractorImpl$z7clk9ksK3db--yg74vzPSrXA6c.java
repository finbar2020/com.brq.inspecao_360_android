package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.entity.Filtro;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

// $FF: synthetic class
public final class -$$Lambda$ItemInspecaoInteractorImpl$z7clk9ksK3db--yg74vzPSrXA6c implements OnSubscribe {
   // $FF: synthetic field
   private final ItemInspecaoInteractorImpl f$0;
   // $FF: synthetic field
   private final Filtro f$1;
   // $FF: synthetic field
   private final int f$2;
   // $FF: synthetic field
   private final long f$3;

   // $FF: synthetic method
   public _$$Lambda$ItemInspecaoInteractorImpl$z7clk9ksK3db__yg74vzPSrXA6c/* $FF was: -$$Lambda$ItemInspecaoInteractorImpl$z7clk9ksK3db--yg74vzPSrXA6c*/(ItemInspecaoInteractorImpl var1, Filtro var2, int var3, long var4) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
      this.f$3 = var4;
   }

   public final void call(Object var1) {
      this.f$0.lambda$obterPorFiltroPaginadoOff$13$ItemInspecaoInteractorImpl(this.f$1, this.f$2, this.f$3, (Subscriber)var1);
   }
}
