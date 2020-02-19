package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Imagem;
import com.brq.inspecao_360_android.model.entity.Item;
import rx.Subscriber;

class CameraPreviewActivityPresenterImpl$1 extends Subscriber {
   // $FF: synthetic field
   final CameraPreviewActivityPresenterImpl this$0;
   // $FF: synthetic field
   final Imagem val$imagem;

   CameraPreviewActivityPresenterImpl$1(CameraPreviewActivityPresenterImpl var1, Imagem var2) {
      this.this$0 = var1;
      this.val$imagem = var2;
   }

   public void onCompleted() {
      this.this$0.view.hideProgressDialog();
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao salvarOff imagem preview.", var1);
      this.this$0.view.hideProgressDialog();
      this.this$0.view.showSnackbar(this.this$0.view.getString(2131821076));

      try {
         Item var3 = this.this$0.itemInteractor.obterOff(this.val$imagem.getItem().getId());
         StringBuilder var4 = new StringBuilder();
         var4.append("Fotografia: '");
         var4.append(this.val$imagem.getFilePath());
         var4.append("' da inspeção: ");
         var4.append(var3.getUid());
         var4.append(", não obteve êxito ao salvar.");
         Logger.info(var4.toString());
         Logger.info(var1.getMessage());
      } catch (Exception var5) {
         Logger.error("Erro ao obter item off", var5);
      }
   }

   public void onNext(Imagem var1) {
      Logger.debug("Fotografia salva com sucesso.");
      this.this$0.view.sendSaveBroadCast(var1);

      try {
         Item var3 = this.this$0.itemInteractor.obterOff(var1.getItem().getId());
         StringBuilder var4 = new StringBuilder();
         var4.append("Fotografia: '");
         var4.append(var1.getFilePath());
         var4.append("' da inspeção: ");
         var4.append(var3.getUid());
         var4.append(", salva com sucesso.");
         Logger.info(var4.toString());
      } catch (Exception var5) {
         Logger.error("Erro ao obter item off", var5);
      }

      this.this$0.view.onSuccess();
   }

   public void onStart() {
      super.onStart();
      this.this$0.view.showProgessDialog(this.this$0.view.getString(2131820595), this.this$0.view.getString(2131821137));
   }
}
