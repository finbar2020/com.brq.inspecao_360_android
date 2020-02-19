package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.interactor.impl.EnderecoInteractorImpl.1.1;
import com.brq.inspecao_360_android.model.db.EnderecoDAO;
import com.brq.inspecao_360_android.model.db.ItemDAO;
import com.brq.inspecao_360_android.model.entity.Endereco;
import java.sql.SQLException;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class EnderecoInteractorImpl$1$1$1 implements OnSubscribe {
   // $FF: synthetic field
   final 1 this$2;
   // $FF: synthetic field
   final Endereco val$endereco;

   EnderecoInteractorImpl$1$1$1(1 var1, Endereco var2) {
      this.this$2 = var1;
      this.val$endereco = var2;
   }

   public void call(Subscriber var1) {
      ItemDAO var2 = ItemDAO.newInstance();
      EnderecoDAO var3 = EnderecoDAO.newInstance();

      try {
         var3.alterarEndereco(this.val$endereco);
      } catch (SQLException var7) {
         Logger.error("Erro ao alterar coordenadas de endereco", var7);
         var1.onError(var7);
      }

      try {
         var2.alterarPendenciaEndereco(this.this$2.this$1.val$idItem.intValue(), false);
      } catch (SQLException var6) {
         Logger.error("Erro ao alterar flag de pendencia de endereco", var6);
         var1.onError(var6);
      }

      this.this$2.val$item.setEndereco(this.val$endereco);
      var1.onNext(this.this$2.val$item);
      var1.onCompleted();
   }
}
