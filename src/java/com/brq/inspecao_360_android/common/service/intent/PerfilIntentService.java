package com.brq.inspecao_360_android.common.service.intent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.brq.inspecao_360_android.common.service.intent.PerfilIntentService.1;
import com.brq.inspecao_360_android.configuration.di.App;
import com.brq.inspecao_360_android.configuration.di.module.UsuarioModule;
import com.brq.inspecao_360_android.interactor.impl.UsuarioInteractorImpl;
import javax.inject.Inject;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PerfilIntentService extends AbstractIntentService {
   @Inject
   UsuarioInteractorImpl interactor;

   public PerfilIntentService() {
      super(PerfilIntentService.class.toString());
   }

   public static Intent newInstance(Context var0) {
      return new Intent("android.intent.action.SYNC", (Uri)null, var0, PerfilIntentService.class);
   }

   public void onCreate() {
      super.onCreate();
      App.get(this).getAppComponent().plus(new UsuarioModule()).inject(this);
   }

   public void onDestroy() {
      super.onDestroy();
   }

   protected void onHandleIntent(Intent var1) {
      this.interactor.obterFotoOn().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new 1(this));
   }

   public void onStart(Intent var1, int var2) {
      super.onStart(var1, var2);
      this.mIntentReceiver = new Intent("br.com.brq.action.ACTION_UPDATE_USER");
   }

   public int onStartCommand(Intent var1, int var2, int var3) {
      return super.onStartCommand(var1, var2, var3);
   }

   public boolean stopService(Intent var1) {
      return super.stopService(var1);
   }
}
