package com.brq.inspecao_360_android.ui.activity;

import android.content.Intent;
import com.brq.inspecao_360_android.common.util.BusEvent.AuthenticationError;
import com.brq.inspecao_360_android.geolocalizacao.LocationUpdatesService;
import com.brq.inspecao_360_android.interactor.impl.BaseInteractorImpl;
import rx.Subscriber;

class BaseActivity$1 extends Subscriber {
   // $FF: synthetic field
   final BaseActivity this$0;

   BaseActivity$1(BaseActivity var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
   }

   public void onError(Throwable var1) {
   }

   public void onNext(Object var1) {
      if (var1 instanceof AuthenticationError && !this.this$0.isActivityRunning(LoginActivity.class)) {
         BaseActivity.access$000().setDataHoraUltimaAtualizacao((String)null);
         (new BaseInteractorImpl()).pararTodosOsRastreamentos();
         BaseActivity.access$000().setModoInspecao(false);
         if (LocationUpdatesService.serviceIsRunning(this.this$0)) {
            BaseActivity var4 = this.this$0;
            var4.stopService(new Intent(var4, LocationUpdatesService.class));
         }

         BaseActivity var2 = this.this$0;
         var2.showToastLongTime(var2.getString(2131821145));
         BaseActivity var3 = this.this$0;
         var3.startActivity(LoginActivity.newInstance(var3));
      }

   }
}
