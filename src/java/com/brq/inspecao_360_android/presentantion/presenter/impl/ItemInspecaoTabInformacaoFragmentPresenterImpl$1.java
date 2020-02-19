package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import java.util.List;
import rx.Subscriber;

class ItemInspecaoTabInformacaoFragmentPresenterImpl$1 extends Subscriber {
   // $FF: synthetic field
   final ItemInspecaoTabInformacaoFragmentPresenterImpl this$0;

   ItemInspecaoTabInformacaoFragmentPresenterImpl$1(ItemInspecaoTabInformacaoFragmentPresenterImpl var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
      ItemInspecaoTabInformacaoFragmentPresenterImpl.access$000(this.this$0).showProgressCampoDinamico(false);
   }

   public void onError(Throwable var1) {
      Logger.error(var1.getMessage(), var1);
      ItemInspecaoTabInformacaoFragmentPresenterImpl.access$000(this.this$0).showProgressCampoDinamico(false);
   }

   public void onNext(List var1) {
      ItemInspecaoTabInformacaoFragmentPresenterImpl.access$000(this.this$0).preencherCampoFormulario(var1);
   }

   public void onStart() {
      super.onStart();
      ItemInspecaoTabInformacaoFragmentPresenterImpl.access$000(this.this$0).showProgressCampoDinamico(true);
   }
}
