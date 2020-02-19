package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.model.db.MunicipioDAO;
import com.brq.inspecao_360_android.model.entity.Estado;
import java.sql.SQLException;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class EnderecoInteractorImpl$5 implements OnSubscribe {
   // $FF: synthetic field
   final EnderecoInteractorImpl this$0;
   // $FF: synthetic field
   final Estado val$estado;

   EnderecoInteractorImpl$5(EnderecoInteractorImpl var1, Estado var2) {
      this.this$0 = var1;
      this.val$estado = var2;
   }

   public void call(Subscriber var1) {
      MunicipioDAO var2 = MunicipioDAO.newInstance();
      if (!Validator.isNullOrEmpty(this.val$estado)) {
         try {
            var1.onNext(var2.getAllByEstado(this.val$estado.getId().longValue()));
            var1.onCompleted();
            return;
         } catch (SQLException var4) {
            Logger.error("Erro ao obter municipios", var4);
            var1.onError(var4);
         }
      }

   }
}
