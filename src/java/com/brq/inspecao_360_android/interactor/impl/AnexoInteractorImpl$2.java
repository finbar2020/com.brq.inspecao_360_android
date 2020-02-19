package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.db.AnexoDAO;
import java.sql.SQLException;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class AnexoInteractorImpl$2 implements OnSubscribe {
   // $FF: synthetic field
   final AnexoInteractorImpl this$0;
   // $FF: synthetic field
   final Long val$idInspecao;

   AnexoInteractorImpl$2(AnexoInteractorImpl var1, Long var2) {
      this.this$0 = var1;
      this.val$idInspecao = var2;
   }

   public void call(Subscriber var1) {
      AnexoDAO var2 = AnexoDAO.newInstance();

      try {
         var1.onNext(var2.getAllByInspecao(this.val$idInspecao));
      } catch (SQLException var4) {
         Logger.error("Erro ao obter anexos offline.", var4);
         var1.onError(var4);
      }

      var1.onCompleted();
   }
}
