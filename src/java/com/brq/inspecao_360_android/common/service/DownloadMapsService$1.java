package com.brq.inspecao_360_android.common.service;

import com.brq.inspecao_360_android.common.util.Logger;
import com.mapbox.mapboxsdk.offline.OfflineRegion;
import com.mapbox.mapboxsdk.offline.OfflineManager.ListOfflineRegionsCallback;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

class DownloadMapsService$1 implements ListOfflineRegionsCallback {
   // $FF: synthetic field
   final DownloadMapsService this$0;
   // $FF: synthetic field
   final Long val$idItem;

   DownloadMapsService$1(DownloadMapsService var1, Long var2) {
      this.this$0 = var1;
      this.val$idItem = var2;
   }

   public void onError(String var1) {
   }

   public void onList(OfflineRegion[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         OfflineRegion var4 = var1[var3];
         byte[] var5 = var4.getMetadata();

         Object var6;
         try {
            if ((new JSONObject(new String(var5, "UTF-8"))).getString("FIELD_REGION_NAME").equals(this.val$idItem.toString())) {
               var4.delete(new DownloadMapsService$1$1(this));
            }
            continue;
         } catch (UnsupportedEncodingException var7) {
            var6 = var7;
         } catch (JSONException var8) {
            var6 = var8;
         }

         Logger.error("Erro ao obter nome da região", (Throwable)var6);
      }

   }
}
