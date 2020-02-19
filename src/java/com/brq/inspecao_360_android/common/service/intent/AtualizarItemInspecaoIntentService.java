package com.brq.inspecao_360_android.common.service.intent;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.SparseArray;
import com.brq.inspecao_360_android.common.enumerator.TopicoPushEnum;
import com.brq.inspecao_360_android.common.exception.IntegrationException;
import com.brq.inspecao_360_android.common.service.intent.AtualizarItemInspecaoIntentService.1;
import com.brq.inspecao_360_android.common.service.intent.AtualizarItemInspecaoIntentService.2;
import com.brq.inspecao_360_android.common.service.intent.AtualizarItemInspecaoIntentService.3;
import com.brq.inspecao_360_android.common.service.intent.AtualizarItemInspecaoIntentService.4;
import com.brq.inspecao_360_android.common.service.intent.AtualizarItemInspecaoIntentService.5;
import com.brq.inspecao_360_android.common.service.intent.AtualizarItemInspecaoIntentService.6;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.configuration.di.App;
import com.brq.inspecao_360_android.configuration.di.module.ItemInspecaoModule;
import com.brq.inspecao_360_android.interactor.ChecklistInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.ui.activity.ItemInspecaoListaActivity;
import javax.inject.Inject;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AtualizarItemInspecaoIntentService extends AbstractIntentService {
   private static final String NOTIFICATION_CHANNEL = "APP_360_CHANNEL";
   private SparseArray areaSeguradaid = new SparseArray();
   @Inject
   ChecklistInteractor checklistInteractor;
   private SparseArray checklistid = new SparseArray();
   @Inject
   ItemInspecaoInteractor interactor;
   private TopicoPushEnum mAcao;
   private Long mIdInspecao;
   private Long mIdItem;
   private String mMensagem;
   private int mQtdItemInspecao;

   @Inject
   public AtualizarItemInspecaoIntentService() {
      super(AtualizarItemInspecaoIntentService.class.toString());
   }

   // $FF: synthetic method
   static Long access$000(AtualizarItemInspecaoIntentService var0) {
      return var0.mIdItem;
   }

   // $FF: synthetic method
   static SparseArray access$100(AtualizarItemInspecaoIntentService var0) {
      return var0.checklistid;
   }

   // $FF: synthetic method
   static void access$200(AtualizarItemInspecaoIntentService var0, SparseArray var1) {
      var0.downloadChecklistIfNecessary(var1);
   }

   // $FF: synthetic method
   static SparseArray access$300(AtualizarItemInspecaoIntentService var0) {
      return var0.areaSeguradaid;
   }

   // $FF: synthetic method
   static void access$400(AtualizarItemInspecaoIntentService var0, SparseArray var1) {
      var0.downloadAreaSeguradaIfNecessary(var1);
   }

   // $FF: synthetic method
   static Long access$500(AtualizarItemInspecaoIntentService var0) {
      return var0.mIdInspecao;
   }

   private void downloadAreaSeguradaIfNecessary(SparseArray var1) {
      if (!Validator.isNullOrEmpty(var1)) {
         int var2 = var1.keyAt(0);
         if (!Validator.isNullOrEmpty(var1.get(var2))) {
            Item var3 = (Item)var1.get(var2);
            var1.remove(var2);
            this.interactor.obterAreasSeguradasOn(var3.getInspecao().getId().intValue(), var3.getId().intValue()).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new 4(this, var1));
         }
      }

   }

   private void downloadChecklistIfNecessary(SparseArray var1) {
      if (!Validator.isNullOrEmpty(var1)) {
         int var2 = var1.keyAt(0);
         if (!Validator.isNullOrEmpty(var1.get(var2))) {
            Item var3 = (Item)var1.get(var2);
            var1.remove(var2);

            try {
               if (!this.checklistInteractor.hasChecklist(var3.getChecklistId())) {
                  this.checklistInteractor.obterOn(var3.getChecklistId()).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new 5(this, var1));
                  return;
               }
            } catch (IntegrationException var5) {
               Logger.error("Não foi possível carregar o processar. - AtualizarItemInspecaoIntentService", var5);
            }
         }
      }

   }

   public static Intent newInstance(Context var0, Long var1, int var2) {
      Intent var3 = new Intent("android.intent.action.SYNC", (Uri)null, var0, AtualizarItemInspecaoIntentService.class);
      var3.putExtra(var0.getString(2131820730), var1);
      var3.putExtra("qtdItemInspecao", var2);
      return var3;
   }

   public static Intent newInstance(Context var0, Long var1, int var2, TopicoPushEnum var3, String var4) {
      Intent var5 = new Intent("android.intent.action.SYNC", (Uri)null, var0, AtualizarItemInspecaoIntentService.class);
      var5.putExtra(var0.getString(2131820730), var1);
      var5.putExtra(var0.getString(2131820586), var3);
      var5.putExtra(var0.getString(2131820853), var4);
      var5.putExtra("qtdItemInspecao", var2);
      return var5;
   }

   public static Intent newInstance(Context var0, Long var1, TopicoPushEnum var2, String var3) {
      Intent var4 = new Intent("android.intent.action.SYNC", (Uri)null, var0, AtualizarItemInspecaoIntentService.class);
      var4.putExtra(var0.getString(2131820731), var1);
      var4.putExtra(var0.getString(2131820586), var2);
      var4.putExtra(var0.getString(2131820853), var3);
      return var4;
   }

   public static Intent newInstance(Context var0, Long var1, String var2) {
      Intent var3 = new Intent("android.intent.action.SYNC", (Uri)null, var0, AtualizarItemInspecaoIntentService.class);
      var3.putExtra(var0.getString(2131820730), var1);
      var3.putExtra(var0.getString(2131820853), var2);
      return var3;
   }

   public void notificar() {
      Intent var1 = ItemInspecaoListaActivity.newInstance(this.getApplicationContext());
      Uri var2 = RingtoneManager.getDefaultUri(2);
      PendingIntent var3 = PendingIntent.getActivity(this, 0, var1, 1073741824);
      NotificationManager var4 = (NotificationManager)this.getSystemService("notification");
      if (VERSION.SDK_INT >= 26) {
         NotificationChannel var5 = new NotificationChannel("APP_360_CHANNEL", this.getString(2131820597), 4);
         var5.enableLights(true);
         var5.enableVibration(true);
         var5.setLightColor(-256);
         var5.setLockscreenVisibility(1);
         if (var4 != null) {
            var4.createNotificationChannel(var5);
         }
      }

      int var6 = 6.$SwitchMap$com$brq$inspecao_360_android$common$enumerator$TopicoPushEnum[this.mAcao.ordinal()];
      if (var6 != 1) {
         if (var6 != 2) {
            if (var6 != 3) {
               return;
            }

            if (!Validator.isNullOrEmpty(this.mMensagem)) {
               Builder var14 = (new Builder(this, "APP_360_CHANNEL")).setSmallIcon(2131624024).setContentTitle(this.getString(2131820597)).setStyle((new BigTextStyle()).bigText(this.mMensagem)).setSound(var2).setAutoCancel(true).setVisibility(1).setContentIntent(var3).setPriority(2);
               if (var4 != null) {
                  var4.notify(this.mIdInspecao.intValue(), var14.build());
                  return;
               }
            }
         } else if (!Validator.isNullOrEmpty(this.mMensagem)) {
            Builder var13 = (new Builder(this, "APP_360_CHANNEL")).setSmallIcon(2131624024).setContentTitle(this.getString(2131820597)).setStyle((new BigTextStyle()).bigText(this.mMensagem)).setSound(var2).setAutoCancel(true).setContentIntent(var3).setPriority(2);
            if (var4 != null) {
               var4.notify(this.mIdInspecao.intValue(), var13.build());
               return;
            }
         }
      } else {
         Builder var7 = new Builder(this, "APP_360_CHANNEL");
         Builder var8 = var7.setSmallIcon(2131624024).setContentTitle(this.getString(2131820597));
         Resources var9 = this.getResources();
         int var10 = this.mQtdItemInspecao;
         Object[] var11 = new Object[]{var10};
         var8.setContentText(var9.getQuantityString(2131689473, var10, var11)).setSound(var2).setAutoCancel(true).setVisibility(1).setContentIntent(var3);
         if (var4 != null) {
            var4.notify(this.mIdInspecao.intValue(), var7.build());
         }
      }

   }

   public void onCreate() {
      super.onCreate();
      App.get(this).getAppComponent().plus(new ItemInspecaoModule()).inject(this);
   }

   protected void onHandleIntent(Intent var1) {
      Bundle var2 = var1.getExtras();
      this.mAcao = (TopicoPushEnum)var2.getSerializable(this.getString(2131820586));
      this.mIdInspecao = var2.getLong(this.getString(2131820730), 0L);
      this.mIdItem = var2.getLong(this.getString(2131820731), 0L);
      this.mQtdItemInspecao = var2.getInt("qtdItemInspecao", 0);
      this.mMensagem = var2.getString(this.getString(2131820853), "");
      if (this.mAcao == TopicoPushEnum.REMOCAO_INSPECAO) {
         this.interactor.obterItemComInspecaoOff(this.mIdItem).switchMap(new 2(this)).subscribeOn(Schedulers.immediate()).subscribe(new 1(this));
      } else {
         this.interactor.obterOn(this.mIdInspecao, false).subscribeOn(Schedulers.immediate()).subscribe(new 3(this));
      }
   }

   public void onStart(Intent var1, int var2) {
      super.onStart(var1, var2);
      this.mIntentReceiver = new Intent("br.com.brq.action.ACTION_UPDATE_ITEM");
   }

   public int onStartCommand(Intent var1, int var2, int var3) {
      return super.onStartCommand(var1, var2, var3);
   }
}
