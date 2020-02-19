package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import java.util.List;
import rx.Subscriber;

class GaleriaFragmentPresenterImpl$1 extends Subscriber {
   // $FF: synthetic field
   final GaleriaFragmentPresenterImpl this$0;

   GaleriaFragmentPresenterImpl$1(GaleriaFragmentPresenterImpl var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
      GaleriaFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao carregar fotos na galeria.", var1);
      GaleriaFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
   }

   public void onNext(List var1) {
      GaleriaFragmentPresenterImpl.access$000(this.this$0).addAll(var1);
   }

   public void onStart() {
      super.onStart();
      GaleriaFragmentPresenterImpl.access$000(this.this$0).showProgress(true);
   }
}
