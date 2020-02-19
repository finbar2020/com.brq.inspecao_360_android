package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import java.util.List;
import rx.Subscriber;

class ItemInspecaoTabAnexoFragmentPresenterImpl$2 extends Subscriber {
   // $FF: synthetic field
   final ItemInspecaoTabAnexoFragmentPresenterImpl this$0;

   ItemInspecaoTabAnexoFragmentPresenterImpl$2(ItemInspecaoTabAnexoFragmentPresenterImpl var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
      ItemInspecaoTabAnexoFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
   }

   public void onError(Throwable var1) {
      Logger.error(var1.getMessage());
      ItemInspecaoTabAnexoFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
      ItemInspecaoTabAnexoFragmentPresenterImpl.access$000(this.this$0).onError();
   }

   public void onNext(List var1) {
      ItemInspecaoTabAnexoFragmentPresenterImpl.access$000(this.this$0).addAll(var1);
   }

   public void onStart() {
      super.onStart();
      ItemInspecaoTabAnexoFragmentPresenterImpl.access$000(this.this$0).showProgress(true);
   }
}
