package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.graphics.Bitmap;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import rx.Subscriber;

class ItemInspecaoListaActivityPresenterImpl$1 extends Subscriber {
   // $FF: synthetic field
   final ItemInspecaoListaActivityPresenterImpl this$0;

   ItemInspecaoListaActivityPresenterImpl$1(ItemInspecaoListaActivityPresenterImpl var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
      ItemInspecaoListaActivityPresenterImpl.access$000(this.this$0).showProgressFotoPerfil(false);
   }

   public void onError(Throwable var1) {
      Logger.error(var1.getMessage(), var1);
      ItemInspecaoListaActivityPresenterImpl.access$000(this.this$0).showProgressFotoPerfil(false);
      ItemInspecaoListaActivityPresenterImpl.access$000(this.this$0).showSnackbar(ItemInspecaoListaActivityPresenterImpl.access$000(this.this$0).getString(2131821120));
   }

   public void onNext(Bitmap var1) {
      if (!Validator.isNullOrEmpty(var1)) {
         ItemInspecaoListaActivityPresenterImpl.access$000(this.this$0).setUsuarioFoto(var1);
      }

   }

   public void onStart() {
      super.onStart();
      ItemInspecaoListaActivityPresenterImpl.access$000(this.this$0).showProgressFotoPerfil(true);
   }
}
