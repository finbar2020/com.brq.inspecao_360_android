package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import java.util.List;
import rx.Subscriber;

class ItemInspecaoTabCoberturaFragmentPresenterImpl$1 extends Subscriber {
   // $FF: synthetic field
   final ItemInspecaoTabCoberturaFragmentPresenterImpl this$0;

   ItemInspecaoTabCoberturaFragmentPresenterImpl$1(ItemInspecaoTabCoberturaFragmentPresenterImpl var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
      ItemInspecaoTabCoberturaFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
   }

   public void onError(Throwable var1) {
      Logger.error(var1.getMessage());
      ItemInspecaoTabCoberturaFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
      ItemInspecaoTabCoberturaFragmentPresenterImpl.access$000(this.this$0).onError(ItemInspecaoTabCoberturaFragmentPresenterImpl.access$000(this.this$0).getString(2131821121));
   }

   public void onNext(List var1) {
      ItemInspecaoTabCoberturaFragmentPresenterImpl.access$000(this.this$0).addAll(var1);
   }

   public void onStart() {
      super.onStart();
      ItemInspecaoTabCoberturaFragmentPresenterImpl.access$000(this.this$0).showProgress(true);
   }
}
