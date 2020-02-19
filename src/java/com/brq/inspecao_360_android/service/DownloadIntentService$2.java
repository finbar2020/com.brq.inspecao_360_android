package com.brq.inspecao_360_android.service;

import android.app.DownloadManager;
import android.content.Context;
import android.webkit.MimeTypeMap;
import android.widget.Toast;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Anexo;
import java.io.File;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

class DownloadIntentService$2 extends Subscriber {
   // $FF: synthetic field
   final DownloadIntentService this$0;
   // $FF: synthetic field
   final Long val$idAnexo;
   // $FF: synthetic field
   final String val$nomeAnexo;

   DownloadIntentService$2(DownloadIntentService var1, String var2, Long var3) {
      this.this$0 = var1;
      this.val$nomeAnexo = var2;
      this.val$idAnexo = var3;
   }

   public void onCompleted() {
   }

   public void onError(Throwable var1) {
      Logger.error("Erro download anexo!", var1);
      if (DownloadIntentService.access$400(this.this$0).equalsIgnoreCase("ACTION_DOWNLOAD_SINGLE")) {
         Context var2 = this.this$0.getApplicationContext();
         StringBuilder var3 = new StringBuilder();
         var3.append("Erro ao iniciar o download do arquivo ");
         var3.append(this.val$nomeAnexo);
         Toast.makeText(var2, var3.toString(), 1).show();
         DownloadIntentService.access$300(this.this$0, this.val$idAnexo.intValue(), this.val$nomeAnexo, "Erro ao recuperar o arquivo", 0, true);
      }

   }

   public void onNext(File var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Fim download anexo! nome: [");
      var2.append(this.val$nomeAnexo);
      var2.append("], id: [");
      var2.append(this.val$idAnexo);
      var2.append("]");
      Logger.debug(var2.toString());
      int var8 = this.val$nomeAnexo.lastIndexOf(".");
      String var9;
      if (var8 > 0 && var8 < this.val$nomeAnexo.length() - 1) {
         var9 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(this.val$nomeAnexo.substring(var8 + 1));
      } else {
         var9 = "";
      }

      DownloadIntentService.access$000(this.this$0);
      DownloadIntentService.access$100(this.this$0).cancel(this.val$idAnexo.intValue());
      if (DownloadIntentService.access$400(this.this$0).equalsIgnoreCase("ACTION_DOWNLOAD_SINGLE")) {
         Context var12 = this.this$0.getBaseContext();
         this.this$0.getBaseContext();
         ((DownloadManager)var12.getSystemService("download")).addCompletedDownload(var1.getName(), var1.getName(), true, var9, var1.getAbsolutePath(), var1.length(), true);
      }

      this.this$0.interactor.alterarStatusAnexo(new Anexo(this.val$idAnexo.intValue(), true)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DownloadIntentService$2$1(this));
   }

   public void onStart() {
      super.onStart();
      StringBuilder var1 = new StringBuilder();
      var1.append("Notificacao do anexo iniciada! nome: [");
      var1.append(this.val$nomeAnexo);
      var1.append("], id: [");
      var1.append(this.val$idAnexo);
      var1.append("]");
      Logger.debug(var1.toString());
      DownloadIntentService.access$300(this.this$0, this.val$idAnexo.intValue(), this.val$nomeAnexo, "Iniciando download...", 0, false);
   }
}
