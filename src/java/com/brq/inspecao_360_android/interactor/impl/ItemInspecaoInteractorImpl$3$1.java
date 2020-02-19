package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.interactor.impl.ItemInspecaoInteractorImpl.3;
import java.util.List;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class ItemInspecaoInteractorImpl$3$1 implements OnSubscribe {
   // $FF: synthetic field
   final 3 this$1;
   // $FF: synthetic field
   final List val$itens;

   ItemInspecaoInteractorImpl$3$1(3 var1, List var2) {
      this.this$1 = var1;
      this.val$itens = var2;
   }

   public void call(Subscriber var1) {
      var1.onNext(this.val$itens);
      var1.onCompleted();
   }
}
