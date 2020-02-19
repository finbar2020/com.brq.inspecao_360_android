package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.impl.ChecklistListaCoberturaFragmentPresenterImpl.2.1;
import rx.Subscriber;

class ChecklistListaCoberturaFragmentPresenterImpl$2 extends Subscriber {
   // $FF: synthetic field
   final ChecklistListaCoberturaFragmentPresenterImpl this$0;
   // $FF: synthetic field
   final Item val$item;

   ChecklistListaCoberturaFragmentPresenterImpl$2(ChecklistListaCoberturaFragmentPresenterImpl var1, Item var2) {
      this.this$0 = var1;
      this.val$item = var2;
   }

   public void onCompleted() {
      ChecklistListaCoberturaFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao salvar email para envio de laudo", var1);
      ChecklistListaCoberturaFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
      ChecklistListaCoberturaFragmentPresenterImpl.access$000(this.this$0).showSnackbar(ChecklistListaCoberturaFragmentPresenterImpl.access$000(this.this$0).getString(2131821121), ChecklistListaCoberturaFragmentPresenterImpl.access$000(this.this$0).getString(2131820915), new 1(this));
   }

   public void onNext(Void var1) {
   }

   public void onStart() {
      super.onStart();
      ChecklistListaCoberturaFragmentPresenterImpl.access$000(this.this$0).showProgress(true);
   }
}
