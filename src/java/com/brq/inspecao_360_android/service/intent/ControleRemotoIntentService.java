package com.brq.inspecao_360_android.service.intent;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.brq.inspecao_360_android.common.util.SharedPreferenceUtil;
import com.brq.inspecao_360_android.configuration.di.App;
import com.brq.inspecao_360_android.configuration.di.module.IntentServiceModule;
import com.brq.inspecao_360_android.interactor.ControleRemotoInteractor;
import javax.inject.Inject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ControleRemotoIntentService extends IntentService {
   public static final int DECRIPTOGRAFAR_IMAGENS = 4;
   public static final int DECRIPTOGRAFAR_IMAGENS_FROM_ITEM = 10;
   public static final int DECRIPTOGRAFAR_TODAS_IMAGENS = 6;
   public static final int EXPORTAR_DATABASE = 1;
   public static final int EXPORTAR_HYPERLOG = 9;
   public static final int EXPORTAR_LOG = 2;
   public static final int FORCAR_ATUALIZACAO_SPLASHSCREEN = 5;
   public static final int LIMPAR_IMAGENS = 8;
   public static final int REMOCAO_PERGUNTAS = 7;
   public static final int RESETAR_DATA_ITEM = 3;
   private int funcaoRemota;
   @Inject
   ControleRemotoInteractor interactor;

   @Inject
   public ControleRemotoIntentService() {
      super("ControleRemotoIntentService");
   }

   private void forcarAtualizacaoSplashScreen() {
      (new SharedPreferenceUtil(App.getContext())).setUserFirstAccess(true);
   }

   public static Intent newInstance(Context var0, int var1) {
      Intent var2 = new Intent("android.intent.action.SYNC", (Uri)null, var0, ControleRemotoIntentService.class);
      var2.putExtra(var0.getString(2131820696), var1);
      return var2;
   }

   public static Intent newInstance(Context var0, int var1, long var2) {
      Intent var4 = new Intent("android.intent.action.SYNC", (Uri)null, var0, ControleRemotoIntentService.class);
      var4.putExtra(var0.getString(2131820696), var1);
      var4.putExtra(var0.getString(2131820731), var2);
      return var4;
   }

   public static Intent newInstance(Context var0, int var1, long var2, long var4) {
      Intent var6 = new Intent("android.intent.action.SYNC", (Uri)null, var0, ControleRemotoIntentService.class);
      var6.putExtra(var0.getString(2131820696), var1);
      var6.putExtra(var0.getString(2131820731), var2);
      var6.putExtra(var0.getString(2131820735), var4);
      return var6;
   }

   private void removerPerguntas(long var1, long var3) {
      Observable var5 = this.interactor.removerPerguntas(var1, var3).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      ControleRemotoIntentService$1 var6 = new ControleRemotoIntentService$1(this, var1, var3);
      var5.subscribe(var6);
   }

   private void resetarDataItem() {
      this.interactor.resetarDataItem().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ControleRemotoIntentService$2(this));
   }

   public void decriptografarImagemFromItem(Context var1, Long var2) {
      this.interactor.decriptografarImagemFromItem(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ControleRemotoIntentService$8(this));
   }

   public void decriptografarImagens(Long var1) {
      this.interactor.decriptografarImagens(var1).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ControleRemotoIntentService$6(this));
   }

   public void decriptografarTodasImagens() {
      this.interactor.decriptografarTodasImagens().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ControleRemotoIntentService$7(this));
   }

   public void exportarDatabase() {
      this.interactor.exportarDatabase().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ControleRemotoIntentService$3(this));
   }

   public void exportarHyperLog() {
      this.interactor.exportarHyperLog().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ControleRemotoIntentService$5(this));
   }

   public void exportarLog() {
      this.interactor.exportarLog().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ControleRemotoIntentService$4(this));
   }

   public void limparImagens() {
      this.interactor.limparImagens().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ControleRemotoIntentService$9(this));
   }

   @Nullable
   public IBinder onBind(Intent var1) {
      return null;
   }

   public void onCreate() {
      super.onCreate();
      App.get(this).getAppComponent().plus(new IntentServiceModule()).inject(this);
   }

   protected void onHandleIntent(Intent var1) {
      Bundle var2 = var1.getExtras();
      this.funcaoRemota = var2.getInt(this.getString(2131820696));
      switch(this.funcaoRemota) {
      case 1:
         this.exportarDatabase();
         return;
      case 2:
         this.exportarLog();
         return;
      case 3:
         this.resetarDataItem();
         return;
      case 4:
         this.decriptografarImagens(var2.getLong(this.getString(2131820731)));
         return;
      case 5:
         this.forcarAtualizacaoSplashScreen();
         return;
      case 6:
         this.decriptografarTodasImagens();
         return;
      case 7:
         this.removerPerguntas(var2.getLong(this.getString(2131820731)), var2.getLong(this.getString(2131820735)));
         return;
      case 8:
         this.limparImagens();
         return;
      case 9:
         this.exportarHyperLog();
         return;
      case 10:
         this.decriptografarImagemFromItem(this, var2.getLong(this.getString(2131820731)));
         return;
      default:
      }
   }

   public void onStart(Intent var1, int var2) {
      super.onStart(var1, var2);
   }

   public int onStartCommand(Intent var1, int var2, int var3) {
      return super.onStartCommand(var1, var2, var3);
   }
}
