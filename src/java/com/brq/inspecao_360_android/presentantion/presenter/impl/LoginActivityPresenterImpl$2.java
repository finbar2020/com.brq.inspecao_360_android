package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.model.entity.Token;
import rx.Observable;
import rx.functions.Func1;

class LoginActivityPresenterImpl$2 implements Func1 {
   // $FF: synthetic field
   final LoginActivityPresenterImpl this$0;

   LoginActivityPresenterImpl$2(LoginActivityPresenterImpl var1) {
      this.this$0 = var1;
   }

   public Observable call(Token var1) {
      return LoginActivityPresenterImpl.access$100(this.this$0).obterInfo();
   }
}
