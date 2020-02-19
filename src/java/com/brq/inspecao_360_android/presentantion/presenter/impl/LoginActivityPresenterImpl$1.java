package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.exception.BusinessException;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.model.entity.Usuario;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.LoginActivityPresenterImpl.1.qaELl7nO823rjDirmV6mr79prho;
import com.brq.inspecao_360_android.presentantion.view.LoginView$Activity;
import com.crashlytics.android.Crashlytics;
import rx.Subscriber;

class LoginActivityPresenterImpl$1 extends Subscriber {
   // $FF: synthetic field
   final LoginActivityPresenterImpl this$0;
   // $FF: synthetic field
   final String val$usuario;

   LoginActivityPresenterImpl$1(LoginActivityPresenterImpl var1, String var2) {
      this.this$0 = var1;
      this.val$usuario = var2;
   }

   // $FF: synthetic method
   public void lambda$onError$0$LoginActivityPresenterImpl$1(View var1) {
      LoginActivityPresenterImpl.access$000(this.this$0).showAlertaRedefinirSenha();
   }

   public void onCompleted() {
      LoginActivityPresenterImpl.access$000(this.this$0).isShowBtnEntrar(true);
      LoginActivityPresenterImpl.access$000(this.this$0).isShowProgressLogin(false);
      LoginActivityPresenterImpl.access$000(this.this$0).onSuccess();
   }

   public void onError(Throwable var1) {
      Logger.error("Não foi possível autenticar!", var1);
      LoginActivityPresenterImpl.access$000(this.this$0).isShowBtnEntrar(true);
      LoginActivityPresenterImpl.access$000(this.this$0).isShowProgressLogin(false);
      if (var1 instanceof BusinessException) {
         BusinessException var2 = (BusinessException)var1;
         if (!Validator.isNullOrEmpty(var2.getCodMessage())) {
            if (var2.getCodMessage() == 10002) {
               LoginActivityPresenterImpl.access$000(this.this$0).showSnackbar(var1.getMessage(), "Redefinir senha", new qaELl7nO823rjDirmV6mr79prho(this));
               return;
            }

            if (var2.getCodMessage() == 10001) {
               LoginActivityPresenterImpl.access$000(this.this$0).showSnackbar(var1.getMessage());
               return;
            }
         }
      } else {
         LoginActivityPresenterImpl.access$000(this.this$0).showSnackbar("Não foi possível autenticar.");
      }

   }

   public void onNext(Usuario var1) {
      LoginView$Activity var2 = LoginActivityPresenterImpl.access$000(this.this$0);
      String var3 = LoginActivityPresenterImpl.access$000(this.this$0).getString(2131821005);
      Object[] var4 = new Object[]{var1.getNome()};
      var2.showToastShortTime(String.format(var3, var4));
   }

   public void onStart() {
      super.onStart();
      Crashlytics.setUserEmail(this.val$usuario);
      LoginActivityPresenterImpl.access$000(this.this$0).isShowBtnEntrar(false);
      LoginActivityPresenterImpl.access$000(this.this$0).isShowProgressLogin(true);
   }
}
