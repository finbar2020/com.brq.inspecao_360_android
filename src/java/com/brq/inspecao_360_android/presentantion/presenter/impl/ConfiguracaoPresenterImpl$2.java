package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.model.entity.Configuracao;
import java.sql.SQLException;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class ConfiguracaoPresenterImpl$2 implements OnSubscribe {
   // $FF: synthetic field
   final ConfiguracaoPresenterImpl this$0;
   // $FF: synthetic field
   final Configuracao val$configuracao;

   ConfiguracaoPresenterImpl$2(ConfiguracaoPresenterImpl var1, Configuracao var2) {
      this.this$0 = var1;
      this.val$configuracao = var2;
   }

   public void call(Subscriber var1) {
      try {
         this.this$0.interactor.setConfiguracaoUsuario(this.val$configuracao);
      } catch (SQLException var3) {
         var1.onError(var3);
      }

      var1.onNext((Object)null);
      var1.onCompleted();
   }
}
