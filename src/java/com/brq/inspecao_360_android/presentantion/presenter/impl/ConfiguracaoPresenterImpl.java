package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.model.entity.Configuracao;
import com.brq.inspecao_360_android.presentantion.presenter.ConfiguracaoPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.ConfiguracaoPresenterImpl.3.1;
import com.brq.inspecao_360_android.presentantion.view.ConfiguracaoView;
import com.brq.inspecao_360_android.presentantion.view.ConfiguracaoView$Activity;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ConfiguracaoPresenterImpl extends BasePresenterImpl implements ConfiguracaoPresenter {
   private ConfiguracaoView$Activity view;

   @Inject
   public ConfiguracaoPresenterImpl(ConfiguracaoView var1) {
      super(var1);
      this.view = (ConfiguracaoView$Activity)var1;
   }

   public void atualizar(Long var1, Long var2, String var3) {
   }

   public void carregar() {
      Observable.create(new -$$Lambda$ConfiguracaoPresenterImpl$3rUF7e0m8ZJxDiS8qJzbGNYbkgQ(this)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ConfiguracaoPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1) {
            ConfiguracaoPresenterImpl.this.showLoad(true, false);
            Logger.error("Não foi possível carregar as configurações do usuario.", var1);
         }

         public void onNext(Configuracao var1) {
            if (!Validator.isNullOrEmpty(var1)) {
               ConfiguracaoPresenterImpl.this.view.preencher(var1);
            }

         }

         public void onStart() {
            super.onStart();
            ConfiguracaoPresenterImpl.this.showLoad(true, true);
         }
      });
   }

   // $FF: synthetic method
   public void lambda$carregar$0$ConfiguracaoPresenterImpl(Subscriber var1) {
      var1.onNext(this.interactor.getConfiguracaoUsuario());
      var1.onCompleted();
   }

   public void salvar(final Configuracao var1) {
      Observable.create(new ConfiguracaoPresenterImpl$2(this, var1)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ConfiguracaoPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1x) {
            ConfiguracaoPresenterImpl.this.showLoad(true, false);
            Logger.error("Não foi possível salvar as configurações do usuario.", var1x);
            ConfiguracaoPresenterImpl.this.view.showSnackbar("Não foi possível salvar as configurações do usuario.", ConfiguracaoPresenterImpl.this.view.getString(2131820915), new 1(this));
         }

         public void onNext(Void var1x) {
         }

         public void onStart() {
            super.onStart();
            ConfiguracaoPresenterImpl.this.showLoad(true, true);
         }
      });
   }
}
