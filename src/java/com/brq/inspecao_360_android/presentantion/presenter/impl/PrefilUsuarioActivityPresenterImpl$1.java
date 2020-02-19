package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.graphics.Bitmap;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import rx.Subscriber;

class PrefilUsuarioActivityPresenterImpl$1 extends Subscriber {
   // $FF: synthetic field
   final PrefilUsuarioActivityPresenterImpl this$0;

   PrefilUsuarioActivityPresenterImpl$1(PrefilUsuarioActivityPresenterImpl var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
   }

   public void onError(Throwable var1) {
      Logger.error(var1.getMessage(), var1);
      PrefilUsuarioActivityPresenterImpl.access$000(this.this$0).showSnackbar(PrefilUsuarioActivityPresenterImpl.access$000(this.this$0).getString(2131821045));
   }

   public void onNext(Bitmap var1) {
      if (!Validator.isNullOrEmpty(var1)) {
         PrefilUsuarioActivityPresenterImpl.access$000(this.this$0).setFotoUsuario(var1);
      }

   }
}
