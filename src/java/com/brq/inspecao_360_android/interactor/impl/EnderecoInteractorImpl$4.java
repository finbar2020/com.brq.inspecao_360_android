package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.db.MunicipioDAO;
import java.sql.SQLException;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class EnderecoInteractorImpl$4 implements OnSubscribe {
   // $FF: synthetic field
   final EnderecoInteractorImpl this$0;
   // $FF: synthetic field
   final Long val$idItem;

   EnderecoInteractorImpl$4(EnderecoInteractorImpl var1, Long var2) {
      this.this$0 = var1;
      this.val$idItem = var2;
   }

   public void call(Subscriber var1) {
      MunicipioDAO var2 = MunicipioDAO.newInstance();

      try {
         var1.onNext(var2.getAllByItem(this.val$idItem));
         var1.onCompleted();
      } catch (SQLException var4) {
         Logger.error("Erro ao obter municipios", var4);
         var1.onError(var4);
      }
   }
}
