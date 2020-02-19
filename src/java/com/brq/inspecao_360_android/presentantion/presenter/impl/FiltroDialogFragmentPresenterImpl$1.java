package com.brq.inspecao_360_android.presentantion.presenter.impl;

import java.util.List;
import rx.Subscriber;

class FiltroDialogFragmentPresenterImpl$1 extends Subscriber {
   // $FF: synthetic field
   final FiltroDialogFragmentPresenterImpl this$0;

   FiltroDialogFragmentPresenterImpl$1(FiltroDialogFragmentPresenterImpl var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
      FiltroDialogFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
   }

   public void onError(Throwable var1) {
      FiltroDialogFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
   }

   public void onNext(List var1) {
      FiltroDialogFragmentPresenterImpl.access$000(this.this$0).preencher(var1);
   }

   public void onStart() {
      super.onStart();
      FiltroDialogFragmentPresenterImpl.access$000(this.this$0).showProgress(true);
   }
}
