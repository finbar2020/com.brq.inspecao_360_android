package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Resposta;
import java.sql.SQLException;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class ChecklistListaPerguntaPresenterImpl$11 implements OnSubscribe {
   // $FF: synthetic field
   final ChecklistListaPerguntaPresenterImpl this$0;
   // $FF: synthetic field
   final Resposta val$resposta;

   ChecklistListaPerguntaPresenterImpl$11(ChecklistListaPerguntaPresenterImpl var1, Resposta var2) {
      this.this$0 = var1;
      this.val$resposta = var2;
   }

   public void call(Subscriber var1) {
      try {
         Logger.info(this.val$resposta.toString());
         this.this$0.respostaInteractor.salvar(this.val$resposta);
      } catch (SQLException var3) {
         Logger.error("Erro ao salvar resposta.", var3);
         var1.onError(var3);
      }

      var1.onNext((Object)null);
      var1.onCompleted();
   }
}
