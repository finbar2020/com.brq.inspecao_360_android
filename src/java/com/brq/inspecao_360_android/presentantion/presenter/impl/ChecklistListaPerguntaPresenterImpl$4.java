package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import java.util.List;
import rx.Subscriber;

class ChecklistListaPerguntaPresenterImpl$4 extends Subscriber {
   // $FF: synthetic field
   final ChecklistListaPerguntaPresenterImpl this$0;
   // $FF: synthetic field
   final boolean val$isEnable;

   ChecklistListaPerguntaPresenterImpl$4(ChecklistListaPerguntaPresenterImpl var1, boolean var2) {
      this.this$0 = var1;
      this.val$isEnable = var2;
   }

   public void onCompleted() {
      ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).hideProgressDialog();
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao carregar perguntas", var1);
      ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).hideProgressDialog();
   }

   public void onNext(List var1) {
      ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).montarQuestionario(var1, this.val$isEnable);
   }

   public void onStart() {
      super.onStart();
   }
}
