package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.db.CoordenadaFiguraDAO;
import com.brq.inspecao_360_android.model.db.CroquiDAO;
import com.brq.inspecao_360_android.model.db.FiguraDAO;
import com.brq.inspecao_360_android.model.entity.Usuario;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

// $FF: synthetic class
public final class -$$Lambda$CroquiInteractorImpl$oQWnrwig2xk_-KMVgh9j0L85yJY implements OnSubscribe {
   // $FF: synthetic field
   private final CroquiInteractorImpl f$0;
   // $FF: synthetic field
   private final CoordenadaFiguraDAO f$1;
   // $FF: synthetic field
   private final Long f$2;
   // $FF: synthetic field
   private final FiguraDAO f$3;
   // $FF: synthetic field
   private final CroquiDAO f$4;
   // $FF: synthetic field
   private final Usuario f$5;

   // $FF: synthetic method
   public _$$Lambda$CroquiInteractorImpl$oQWnrwig2xk__KMVgh9j0L85yJY/* $FF was: -$$Lambda$CroquiInteractorImpl$oQWnrwig2xk_-KMVgh9j0L85yJY*/(CroquiInteractorImpl var1, CoordenadaFiguraDAO var2, Long var3, FiguraDAO var4, CroquiDAO var5, Usuario var6) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
      this.f$3 = var4;
      this.f$4 = var5;
      this.f$5 = var6;
   }

   public final void call(Object var1) {
      this.f$0.lambda$salvarOff$0$CroquiInteractorImpl(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (Subscriber)var1);
   }
}
