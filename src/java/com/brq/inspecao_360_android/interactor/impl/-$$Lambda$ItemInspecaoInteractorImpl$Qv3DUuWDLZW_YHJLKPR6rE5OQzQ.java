package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.model.entity.Usuario;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

// $FF: synthetic class
public final class -$$Lambda$ItemInspecaoInteractorImpl$Qv3DUuWDLZW_YHJLKPR6rE5OQzQ implements OnSubscribe {
   // $FF: synthetic field
   private final ItemInspecaoInteractorImpl f$0;
   // $FF: synthetic field
   private final Long f$1;
   // $FF: synthetic field
   private final Usuario f$2;

   // $FF: synthetic method
   public _$$Lambda$ItemInspecaoInteractorImpl$Qv3DUuWDLZW_YHJLKPR6rE5OQzQ/* $FF was: -$$Lambda$ItemInspecaoInteractorImpl$Qv3DUuWDLZW_YHJLKPR6rE5OQzQ*/(ItemInspecaoInteractorImpl var1, Long var2, Usuario var3) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
   }

   public final void call(Object var1) {
      this.f$0.lambda$obterItemComInspecaoOff$10$ItemInspecaoInteractorImpl(this.f$1, this.f$2, (Subscriber)var1);
   }
}
