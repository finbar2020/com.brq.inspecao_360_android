package com.brq.inspecao_360_android.ui.activity;

import com.brq.inspecao_360_android.common.util.FotografiaUtil;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Imagem;
import rx.Subscriber;

class CameraV2Activity$1$1$1 extends Subscriber {
   // $FF: synthetic field
   final CameraV2Activity$1$1 this$2;

   CameraV2Activity$1$1$1(CameraV2Activity$1$1 var1) {
      this.this$2 = var1;
   }

   public void onCompleted() {
      CameraV2Activity.access$302(this.this$2.this$1.this$0, true);
      this.this$2.this$1.this$0.btnFoto.setEnabled(true);
      this.this$2.this$1.this$0.setUltimaFoto(CameraV2Activity.access$200(this.this$2.this$1.this$0), true);
      this.this$2.this$1.this$0.showProgress(false);
      FotografiaUtil.sendInsertBroadCast(this.this$2.this$1.this$0, CameraV2Activity.access$200(this.this$2.this$1.this$0));
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao salvarOff imagem preview.", var1);

      try {
         StringBuilder var2 = new StringBuilder();
         var2.append("Fotografia: '");
         var2.append(CameraV2Activity.access$200(this.this$2.this$1.this$0).getFilePath());
         var2.append("' da inspeção: ");
         var2.append(CameraV2Activity.access$400(this.this$2.this$1.this$0));
         var2.append(", não pode ser salva.");
         Logger.info(var2.toString());
         Logger.info(var1.getMessage());
      } catch (Exception var4) {
         Logger.error("Erro ao salvar log off", var4);
      }
   }

   public void onNext(Imagem var1) {
      Logger.debug("Fotografia salva com sucesso.");
      StringBuilder var2 = new StringBuilder();
      var2.append("Fotografia: '");
      var2.append(var1.getFilePath());
      var2.append("' da inspeção: ");
      var2.append(CameraV2Activity.access$400(this.this$2.this$1.this$0));
      var2.append(", salva com sucesso.");
      Logger.info(var2.toString());
   }

   public void onStart() {
      super.onStart();
   }
}
