package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.model.entity.Item;
import rx.Subscriber;

class ChecklistListaPerguntaPresenterImpl$1 extends Subscriber {
   // $FF: synthetic field
   final ChecklistListaPerguntaPresenterImpl this$0;

   ChecklistListaPerguntaPresenterImpl$1(ChecklistListaPerguntaPresenterImpl var1) {
      this.this$0 = var1;
   }

   public void onCompleted() {
   }

   public void onError(Throwable var1) {
   }

   public void onNext(Item var1) {
      ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).atualizar(var1);
   }

   public void onStart() {
      super.onStart();
   }
}
