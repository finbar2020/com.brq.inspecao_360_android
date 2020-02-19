package com.brq.inspecao_360_android.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat.Builder;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.MainBus;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.configuration.di.App;
import com.brq.inspecao_360_android.configuration.di.module.IntentServiceModule;
import com.brq.inspecao_360_android.interactor.AnexoInteractor;
import com.brq.inspecao_360_android.model.entity.ProgressEvent;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.Okio;
import retrofit2.Response;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class DownloadIntentService extends Service {
   public static final String ACTION_DOWNLOAD_MULTIPLE = "ACTION_DOWNLOAD_MULTIPLE";
   public static final String ACTION_DOWNLOAD_SINGLE = "ACTION_DOWNLOAD_SINGLE";
   private static final String NOTIFICATION_CHANNEL = "APP_360_CHANNEL";
   private String action;
   @Inject
   AnexoInteractor interactor;
   private DownloadIntentService.ServiceHandler mServiceHandler;
   private Looper mServiceLooper;
   private Map nomeAnexoMap;
   private NotificationManager notificationManager;
   private Map startIdMap;
   private Subscription subscription = MainBus.getInstance().filteredObservable(ProgressEvent.class).subscribe(new DownloadIntentService$1(this));
   private CompositeSubscription subscriptions = new CompositeSubscription();

   // $FF: synthetic method
   static void access$000(DownloadIntentService var0) {
      var0.refreshNotificationManager();
   }

   // $FF: synthetic method
   static NotificationManager access$100(DownloadIntentService var0) {
      return var0.notificationManager;
   }

   // $FF: synthetic method
   static Map access$200(DownloadIntentService var0) {
      return var0.nomeAnexoMap;
   }

   // $FF: synthetic method
   static void access$300(DownloadIntentService var0, int var1, String var2, String var3, int var4, boolean var5) {
      var0.sendNotification(var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   static String access$400(DownloadIntentService var0) {
      return var0.action;
   }

   private Subscription getFile(Long var1, String var2) {
      return this.interactor.obterAnexo(var1, var2).flatMap(new -$$Lambda$DownloadIntentService$Qyco5LuNNj8vba6QgIi6D6P6Lhc(var2)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DownloadIntentService$2(this, var2, var1));
   }

   // $FF: synthetic method
   static Observable lambda$getFile$0(String var0, Response var1) {
      try {
         File var2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsoluteFile(), var0);
         BufferedSink var4 = Okio.buffer(Okio.sink(var2));
         BufferedInputStream var5 = new BufferedInputStream(new ByteArrayInputStream(((ResponseBody)var1.body()).bytes()), 8192);
         var4.writeAll(Okio.source(var5));
         var4.close();
         var5.close();
         Observable var8 = Observable.just(var2);
         return var8;
      } catch (IOException var9) {
         Logger.error("Erro ao salvar arquivo de anexo!", var9);
         return Observable.error(var9);
      }
   }

   private void refreshNotificationManager() {
      this.notificationManager = (NotificationManager)this.getSystemService("notification");
      if (VERSION.SDK_INT >= 26) {
         NotificationChannel var1 = new NotificationChannel("APP_360_CHANNEL", this.getString(2131820597), 4);
         var1.enableLights(true);
         var1.enableVibration(true);
         var1.setLightColor(-256);
         var1.setLockscreenVisibility(1);
         this.notificationManager.createNotificationChannel(var1);
      }

   }

   private void sendNotification(int var1, String var2, String var3, int var4, boolean var5) {
      Builder var6 = new Builder(this, "APP_360_CHANNEL");
      if (var2.length() > 25) {
         StringBuilder var7 = new StringBuilder();
         var7.append(var2.substring(0, 25));
         var7.append("...");
         var2 = var7.toString();
      }

      if (var5) {
         var6.setSmallIcon(17301634).setProgress(0, 0, false);
      } else {
         var6.setSmallIcon(17301633).setProgress(100, var4, false);
      }

      var6.setContentTitle(var2).setContentText(var3).setOnlyAlertOnce(true).setAutoCancel(true);
      this.notificationManager.notify(var1, var6.build());
   }

   @Nullable
   public IBinder onBind(Intent var1) {
      return null;
   }

   public void onCreate() {
      super.onCreate();
      App.get(this).getAppComponent().plus(new IntentServiceModule()).inject(this);
      this.refreshNotificationManager();
      HandlerThread var1 = new HandlerThread("ServiceStartArguments", -2);
      var1.start();
      this.mServiceLooper = var1.getLooper();
      this.mServiceHandler = new DownloadIntentService.ServiceHandler(this.mServiceLooper);
   }

   public void onDestroy() {
      super.onDestroy();
   }

   public int onStartCommand(Intent var1, int var2, int var3) {
      Bundle var4 = var1.getExtras();
      if (Validator.isNullOrEmpty(var4)) {
         return super.onStartCommand(var1, var2, var3);
      } else {
         this.action = var4.getString(this.getString(2131820590));
         Long var5 = var4.getLong(this.getString(2131820727));
         String var6 = var4.getString(this.getString(2131821162));
         if (this.startIdMap == null) {
            this.startIdMap = new HashMap();
         }

         this.startIdMap.put(var5.intValue(), var3);
         if (this.nomeAnexoMap == null) {
            this.nomeAnexoMap = new HashMap();
         }

         this.nomeAnexoMap.put(var5.intValue(), var6);
         Message var9 = this.mServiceHandler.obtainMessage();
         var9.setData(var4);
         var9.arg1 = var3;
         this.mServiceHandler.sendMessage(var9);
         return 3;
      }
   }

   public boolean onUnbind(Intent var1) {
      return super.onUnbind(var1);
   }

   public boolean stopService(Intent var1) {
      return super.stopService(var1);
   }

   private final class ServiceHandler extends Handler {
      public ServiceHandler(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message var1) {
         try {
            Bundle var2 = var1.getData();
            Subscription var3 = DownloadIntentService.this.getFile(var2.getLong(DownloadIntentService.this.getString(2131820727)), var2.getString(DownloadIntentService.this.getString(2131821162)));
            DownloadIntentService.this.subscriptions.add(var3);
         } catch (Exception var4) {
            Thread.currentThread().interrupt();
         }
      }
   }
}
