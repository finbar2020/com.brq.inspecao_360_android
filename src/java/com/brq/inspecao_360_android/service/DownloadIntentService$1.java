package com.brq.inspecao_360_android.service;

import android.os.Build.VERSION;
import android.service.notification.StatusBarNotification;
import com.brq.inspecao_360_android.model.entity.ProgressEvent;
import rx.Subscriber;

class DownloadIntentService$1 extends Subscriber {
   // $FF: synthetic field
   final DownloadIntentService this$0;

   DownloadIntentService$1(DownloadIntentService var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
   }

   public void onError(Throwable var1) {
   }

   public void onNext(ProgressEvent var1) {
      int var2 = Integer.valueOf(var1.getDownloadIdentifier());
      DownloadIntentService.access$000(this.this$0);
      if (var1.getProgress() < 100) {
         if (VERSION.SDK_INT < 23) {
            DownloadIntentService var8 = this.this$0;
            String var9 = (String)DownloadIntentService.access$200(var8).get(var2);
            StringBuilder var10 = new StringBuilder();
            var10.append("Realizando download ");
            var10.append(var1.getProgress());
            var10.append("%");
            DownloadIntentService.access$300(var8, var2, var9, var10.toString(), var1.getProgress(), false);
            return;
         }

         StatusBarNotification[] var14 = DownloadIntentService.access$100(this.this$0).getActiveNotifications();
         int var15 = var14.length;

         for(int var16 = 0; var16 < var15; ++var16) {
            if (var14[var16].getId() == var2) {
               DownloadIntentService var17 = this.this$0;
               String var18 = (String)DownloadIntentService.access$200(var17).get(var2);
               StringBuilder var19 = new StringBuilder();
               var19.append("Realizando download ");
               var19.append(var1.getProgress());
               var19.append("%");
               DownloadIntentService.access$300(var17, var2, var18, var19.toString(), var1.getProgress(), false);
            }
         }
      } else if (DownloadIntentService.access$400(this.this$0).equalsIgnoreCase("ACTION_DOWNLOAD_SINGLE")) {
         if (VERSION.SDK_INT < 23) {
            DownloadIntentService var3 = this.this$0;
            DownloadIntentService.access$300(var3, var2, (String)DownloadIntentService.access$200(var3).get(var2), "Download Finalizado", var1.getProgress(), true);
            return;
         }

         StatusBarNotification[] var4 = DownloadIntentService.access$100(this.this$0).getActiveNotifications();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            if (var4[var6].getId() == var2) {
               DownloadIntentService var7 = this.this$0;
               DownloadIntentService.access$300(var7, var2, (String)DownloadIntentService.access$200(var7).get(var2), "Download Finalizado", var1.getProgress(), true);
            }
         }
      } else {
         DownloadIntentService.access$100(this.this$0).cancel(var2);
      }

   }
}
