package com.brq.inspecao_360_android.interactor.impl;

import android.graphics.Bitmap;
import com.brq.inspecao_360_android.interactor.impl.UsuarioInteractorImpl.1;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class UsuarioInteractorImpl$1$1 implements OnSubscribe {
   // $FF: synthetic field
   final 1 this$1;
   // $FF: synthetic field
   final Bitmap val$bitmap;

   UsuarioInteractorImpl$1$1(1 var1, Bitmap var2) {
      this.this$1 = var1;
      this.val$bitmap = var2;
   }

   public void call(Subscriber var1) {
      var1.onNext(this.val$bitmap);
      var1.onCompleted();
   }
}
