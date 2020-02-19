package com.brq.inspecao_360_android.common.service;

import com.brq.inspecao_360_android.common.util.Logger;
import com.mapbox.mapboxsdk.offline.OfflineRegion.OfflineRegionDeleteCallback;

class DownloadMapsService$1$1 implements OfflineRegionDeleteCallback {
   // $FF: synthetic field
   final DownloadMapsService$1 this$1;

   DownloadMapsService$1$1(DownloadMapsService$1 var1) {
      this.this$1 = var1;
   }

   public void onDelete() {
      StringBuilder var1 = new StringBuilder();
      var1.append("Mapa do Item ");
      var1.append(this.this$1.val$idItem);
      var1.append(" deletado com sucesso.");
      Logger.info(var1.toString());
   }

   public void onError(String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Erro ao deletar mapa do item ");
      var2.append(this.this$1.val$idItem);
      var2.append(" , erro: ");
      var2.append(var1);
      Logger.error(var2.toString());
   }
}
