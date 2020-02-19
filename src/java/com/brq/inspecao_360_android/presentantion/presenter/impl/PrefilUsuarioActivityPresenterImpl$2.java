package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.exception.BusinessException;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Usuario;
import rx.Subscriber;

class PrefilUsuarioActivityPresenterImpl$2 extends Subscriber {
   // $FF: synthetic field
   final PrefilUsuarioActivityPresenterImpl this$0;
   // $FF: synthetic field
   final Usuario val$usuario;

   PrefilUsuarioActivityPresenterImpl$2(PrefilUsuarioActivityPresenterImpl var1, Usuario var2) {
      this.this$0 = var1;
      this.val$usuario = var2;
   }

   public void onCompleted() {
      PrefilUsuarioActivityPresenterImpl.access$000(this.this$0).hideProgressDialog();
      PrefilUsuarioActivityPresenterImpl.access$000(this.this$0).onSucessoSalvar();
   }

   public void onError(Throwable var1) {
      Logger.error(var1.getMessage(), var1);
      PrefilUsuarioActivityPresenterImpl.access$000(this.this$0).hideProgressDialog();
      if (var1 instanceof BusinessException) {
         PrefilUsuarioActivityPresenterImpl.access$000(this.this$0).showSnackbar(var1.getMessage());
      } else {
         PrefilUsuarioActivityPresenterImpl.access$000(this.this$0).showSnackbar(PrefilUsuarioActivityPresenterImpl.access$000(this.this$0).getString(2131821119));
      }
   }

   public void onNext(Void var1) {
      PrefilUsuarioActivityPresenterImpl.access$100(this.this$0).setUsuarioInfo(this.val$usuario);
   }

   public void onStart() {
      super.onStart();
      PrefilUsuarioActivityPresenterImpl.access$000(this.this$0).showProgessDialog(PrefilUsuarioActivityPresenterImpl.access$000(this.this$0).getString(2131820595), PrefilUsuarioActivityPresenterImpl.access$000(this.this$0).getString(2131821137));
   }
}
