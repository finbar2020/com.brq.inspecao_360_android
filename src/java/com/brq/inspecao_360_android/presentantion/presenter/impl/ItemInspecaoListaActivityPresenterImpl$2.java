package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.content.Intent;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.SharedPreferenceUtil;
import com.brq.inspecao_360_android.configuration.di.App;
import com.brq.inspecao_360_android.geolocalizacao.LocationUpdatesService;
import rx.Subscriber;

class ItemInspecaoListaActivityPresenterImpl$2 extends Subscriber {
   // $FF: synthetic field
   final ItemInspecaoListaActivityPresenterImpl this$0;

   ItemInspecaoListaActivityPresenterImpl$2(ItemInspecaoListaActivityPresenterImpl var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
      ItemInspecaoListaActivityPresenterImpl.access$000(this.this$0).hideProgressDialog();
   }

   public void onError(Throwable var1) {
      Logger.error(var1.getMessage(), var1);
      ItemInspecaoListaActivityPresenterImpl.access$000(this.this$0).hideProgressDialog();
      ItemInspecaoListaActivityPresenterImpl.access$000(this.this$0).iniLoginActivity();
      ItemInspecaoListaActivityPresenterImpl.access$100(this.this$0).pararTodosOsRastreamentos();
      (new SharedPreferenceUtil(App.getContext())).setModoInspecao(false);
      if (LocationUpdatesService.serviceIsRunning(App.getContext())) {
         App.getContext().stopService(new Intent(App.getContext(), LocationUpdatesService.class));
      }

   }

   public void onNext(Void var1) {
      ItemInspecaoListaActivityPresenterImpl.access$000(this.this$0).iniLoginActivity();
      ItemInspecaoListaActivityPresenterImpl.access$100(this.this$0).pararTodosOsRastreamentos();
      (new SharedPreferenceUtil(App.getContext())).setModoInspecao(false);
      if (LocationUpdatesService.serviceIsRunning(App.getContext())) {
         App.getContext().stopService(new Intent(App.getContext(), LocationUpdatesService.class));
      }

   }

   public void onStart() {
      super.onStart();
      ItemInspecaoListaActivityPresenterImpl.access$000(this.this$0).showProgessDialog(ItemInspecaoListaActivityPresenterImpl.access$000(this.this$0).getString(2131820595), ItemInspecaoListaActivityPresenterImpl.access$000(this.this$0).getString(2131821137));
   }
}
