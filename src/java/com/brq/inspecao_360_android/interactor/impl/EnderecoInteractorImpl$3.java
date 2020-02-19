package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.db.EstadoDAO;
import java.sql.SQLException;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class EnderecoInteractorImpl$3 implements OnSubscribe {
   // $FF: synthetic field
   final EnderecoInteractorImpl this$0;

   EnderecoInteractorImpl$3(EnderecoInteractorImpl var1) {
      this.this$0 = var1;
   }

   public void call(Subscriber var1) {
      EstadoDAO var2 = EstadoDAO.newInstance();

      try {
         var1.onNext(var2.getAll());
         var1.onCompleted();
      } catch (SQLException var4) {
         Logger.error("Erro ao obter estados", var4);
      }
   }
}
