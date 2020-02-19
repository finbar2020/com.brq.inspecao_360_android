package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import java.sql.SQLException;
import java.util.List;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

class ChecklistListaPerguntaPresenterImpl$3 implements Func1 {
   // $FF: synthetic field
   final ChecklistListaPerguntaPresenterImpl this$0;
   // $FF: synthetic field
   final Long val$idItem;

   ChecklistListaPerguntaPresenterImpl$3(ChecklistListaPerguntaPresenterImpl var1, Long var2) {
      this.this$0 = var1;
      this.val$idItem = var2;
   }

   public Observable call(List var1) {
      try {
         var1 = this.this$0.respostaInteractor.obterPorGrupoEPergunta(var1, this.val$idItem);
      } catch (SQLException var3) {
         Logger.error("Erro ao obter respostas por pergunta.", var3);
         Exceptions.propagate(var3);
      }

      return Observable.just(var1);
   }
}
