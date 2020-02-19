package com.brq.inspecao_360_android.common.service;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Item;
import com.mapbox.mapboxsdk.offline.OfflineRegion;
import com.mapbox.mapboxsdk.offline.OfflineManager.CreateOfflineRegionCallback;

class DownloadMapsService$2 implements CreateOfflineRegionCallback {
   // $FF: synthetic field
   final DownloadMapsService this$0;
   // $FF: synthetic field
   final Item val$item;

   DownloadMapsService$2(DownloadMapsService var1, Item var2) {
      this.this$0 = var1;
      this.val$item = var2;
   }

   public void onCreate(OfflineRegion var1) {
      var1.setDownloadState(1);
      this.this$0.itemIdOfflineRegion.put((int)var1.getID(), this.val$item);
      DownloadMapsService var2 = this.this$0;
      DownloadMapsService.access$000(var2, ((Item)var2.itemIdOfflineRegion.get((int)var1.getID())).getUid(), ((Item)this.this$0.itemIdOfflineRegion.get((int)var1.getID())).getId());
      var1.setObserver(new DownloadMapsService$2$1(this, var1));
   }

   public void onError(String var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("Error: ");
      var2.append(var1);
      var2.append(" Item UID:");
      var2.append(this.val$item.getUid());
      Logger.error(var2.toString());
   }
}
