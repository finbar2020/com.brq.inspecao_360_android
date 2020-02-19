package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.exception.BusinessException;
import rx.Subscriber;

class LoginActivityPresenterImpl$3 extends Subscriber {
   // $FF: synthetic field
   final LoginActivityPresenterImpl this$0;

   LoginActivityPresenterImpl$3(LoginActivityPresenterImpl var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
      LoginActivityPresenterImpl.access$000(this.this$0).isShowBtnEntrar(true);
      LoginActivityPresenterImpl.access$000(this.this$0).isShowProgressLogin(false);
   }

   public void onError(Throwable var1) {
      LoginActivityPresenterImpl.access$000(this.this$0).isShowBtnEntrar(true);
      LoginActivityPresenterImpl.access$000(this.this$0).isShowProgressLogin(false);
      if (var1 instanceof BusinessException) {
         LoginActivityPresenterImpl.access$000(this.this$0).showSnackbar(var1.getMessage());
      } else {
         LoginActivityPresenterImpl.access$000(this.this$0).showSnackbar(LoginActivityPresenterImpl.access$000(this.this$0).getString(2131821121));
      }
   }

   public void onNext(Void var1) {
      LoginActivityPresenterImpl.access$000(this.this$0).showSnackbar(LoginActivityPresenterImpl.access$000(this.this$0).getString(2131821148));
   }

   public void onStart() {
      super.onStart();
      LoginActivityPresenterImpl.access$000(this.this$0).isShowBtnEntrar(false);
      LoginActivityPresenterImpl.access$000(this.this$0).isShowProgressLogin(true);
   }
}
