package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import java.util.List;
import rx.Subscriber;

class ChecklistListaSecaoFragmentPresenterImpl$1 extends Subscriber {
   // $FF: synthetic field
   final ChecklistListaSecaoFragmentPresenterImpl this$0;

   ChecklistListaSecaoFragmentPresenterImpl$1(ChecklistListaSecaoFragmentPresenterImpl var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
      ChecklistListaSecaoFragmentPresenterImpl.access$000(this.this$0).hideProgressDialog();
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao carregar seções", var1);
      ChecklistListaSecaoFragmentPresenterImpl.access$000(this.this$0).hideProgressDialog();
   }

   public void onNext(List var1) {
      if (!Validator.isNullOrEmpty(var1)) {
         ChecklistListaSecaoFragmentPresenterImpl.access$000(this.this$0).addAll(var1);
      }

   }

   public void onStart() {
      super.onStart();
      ChecklistListaSecaoFragmentPresenterImpl.access$000(this.this$0).showProgessDialog(ChecklistListaSecaoFragmentPresenterImpl.access$000(this.this$0).getString(2131820595), ChecklistListaSecaoFragmentPresenterImpl.access$000(this.this$0).getString(2131821137));
   }
}
