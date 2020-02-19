package com.brq.inspecao_360_android.common.service;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Item;
import com.mapbox.mapboxsdk.offline.OfflineRegion;
import com.mapbox.mapboxsdk.offline.OfflineRegionError;
import com.mapbox.mapboxsdk.offline.OfflineRegionStatus;
import com.mapbox.mapboxsdk.offline.OfflineRegion.OfflineRegionObserver;

class DownloadMapsService$2$1 implements OfflineRegionObserver {
   // $FF: synthetic field
   final DownloadMapsService$2 this$1;
   // $FF: synthetic field
   final OfflineRegion val$offlineRegion;

   DownloadMapsService$2$1(DownloadMapsService$2 var1, OfflineRegion var2) {
      this.this$1 = var1;
      this.val$offlineRegion = var2;
   }

   public void mapboxTileCountLimitExceeded(long var1) {
      StringBuilder var3 = new StringBuilder();
      var3.append("Mapbox tile count limit exceeded: ");
      var3.append(var1);
      var3.append(" Item UID:");
      var3.append(((Item)this.this$1.this$0.itemIdOfflineRegion.get((int)this.val$offlineRegion.getID())).getUid());
      Logger.error(var3.toString());
   }

   public void onError(OfflineRegionError var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("onError reason: ");
      var2.append(var1.getReason());
      var2.append(" Item UID:");
      var2.append(((Item)this.this$1.this$0.itemIdOfflineRegion.get((int)this.val$offlineRegion.getID())).getUid());
      Logger.error(var2.toString());
      StringBuilder var7 = new StringBuilder();
      var7.append("onError message: ");
      var7.append(var1.getMessage());
      var7.append(" Item UID:");
      var7.append(((Item)this.this$1.this$0.itemIdOfflineRegion.get((int)this.val$offlineRegion.getID())).getUid());
      Logger.error(var7.toString());
   }

   public void onStatusChanged(OfflineRegionStatus var1) {
      double var2;
      if (var1.getRequiredResourceCount() >= 0L) {
         double var8 = (double)var1.getCompletedResourceCount();
         Double.isNaN(var8);
         double var11 = var8 * 100.0D;
         double var13 = (double)var1.getRequiredResourceCount();
         Double.isNaN(var13);
         var2 = var11 / var13;
      } else {
         var2 = 0.0D;
      }

      if (var1.isComplete()) {
         DownloadMapsService.access$100(this.this$1.this$0, ((Item)this.this$1.this$0.itemIdOfflineRegion.get((int)this.val$offlineRegion.getID())).getUid(), 100, ((Item)this.this$1.this$0.itemIdOfflineRegion.get((int)this.val$offlineRegion.getID())).getId());
         DownloadMapsService.access$200(this.this$1.this$0).cancel(((Item)this.this$1.this$0.itemIdOfflineRegion.get((int)this.val$offlineRegion.getID())).getId().intValue());
         ((Item)this.this$1.this$0.itemIdOfflineRegion.get((int)this.val$offlineRegion.getID())).setIsCroquiDownloaded(true);
         this.this$1.this$0.itemInteractor.setItemMapDownloaded((Item)this.this$1.this$0.itemIdOfflineRegion.get((int)this.val$offlineRegion.getID()));
         StringBuilder var4 = new StringBuilder();
         var4.append("Download do mapa da inspeção ");
         var4.append(((Item)this.this$1.this$0.itemIdOfflineRegion.get((int)this.val$offlineRegion.getID())).getUid());
         var4.append(" finalizado com sucesso.");
         Logger.info(var4.toString());
      } else {
         if (var1.isRequiredResourceCountPrecise()) {
            DownloadMapsService.access$100(this.this$1.this$0, ((Item)this.this$1.this$0.itemIdOfflineRegion.get((int)this.val$offlineRegion.getID())).getUid(), (int)Math.round(var2), ((Item)this.this$1.this$0.itemIdOfflineRegion.get((int)this.val$offlineRegion.getID())).getId());
         }

      }
   }
}
