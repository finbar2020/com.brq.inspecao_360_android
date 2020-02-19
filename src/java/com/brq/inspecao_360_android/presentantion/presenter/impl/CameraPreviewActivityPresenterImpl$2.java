package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Imagem;
import rx.Subscriber;

class CameraPreviewActivityPresenterImpl$2 extends Subscriber {
   // $FF: synthetic field
   final CameraPreviewActivityPresenterImpl this$0;
   // $FF: synthetic field
   final Imagem val$imagem;

   CameraPreviewActivityPresenterImpl$2(CameraPreviewActivityPresenterImpl var1, Imagem var2) {
      this.this$0 = var1;
      this.val$imagem = var2;
   }

   public void onCompleted() {
      this.this$0.view.hideProgressDialog();
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao excluirFotoGaleria imagem preview.", var1);
      this.this$0.view.hideProgressDialog();
      this.this$0.view.showSnackbar(this.this$0.view.getString(2131821056));
   }

   public void onNext(Void var1) {
      Logger.debug("Fotografia excluída com sucesso.");
      this.this$0.view.sendRemoveBroadCast(this.val$imagem);
      this.this$0.view.onSuccess();
   }

   public void onStart() {
      super.onStart();
      this.this$0.view.showProgessDialog(this.this$0.view.getString(2131820595), this.this$0.view.getString(2131821137));
   }
}
