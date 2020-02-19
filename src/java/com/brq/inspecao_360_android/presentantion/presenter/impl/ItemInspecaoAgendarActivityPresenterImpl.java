package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.interactor.AgendamentoInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.ItemInspecaoAgendarActivityPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoAgendarActivityPresenterImpl.5.s13bu_UTW2O9jfE79KM5tIUGgAI;
import com.brq.inspecao_360_android.presentantion.presenter.impl.ItemInspecaoAgendarActivityPresenterImpl.3.1;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$Agendamento_inspecao;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ItemInspecaoAgendarActivityPresenterImpl extends BasePresenterImpl implements ItemInspecaoAgendarActivityPresenter {
   @Inject
   AgendamentoInteractor agendamentoInteractor;
   @Inject
   ItemInspecaoInteractor itemInspecaoInteractor;
   private ItemInspecaoView$Agendamento_inspecao.Activity view;

   @Inject
   public ItemInspecaoAgendarActivityPresenterImpl(ItemInspecaoView var1) {
      super(var1);
      this.view = (ItemInspecaoView$Agendamento_inspecao.Activity)var1;
   }

   private void atualizarCounterBottomNav(Long var1, Long var2) {
      this.imagemInteractor.obterPorItem(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao carregar contador de imagens.", var1);
         }

         public void onNext(List var1) {
            ItemInspecaoAgendarActivityPresenterImpl.this.view.preencherCounterBottomNav(var1);
         }

         public void onStart() {
            super.onStart();
         }
      });
   }

   public void agendar(final Long var1, final Long var2, final String var3, final Long var4, final String var5) {
      if (!this.view.isConnected()) {
         ItemInspecaoView$Agendamento_inspecao.Activity var9 = this.view;
         var9.showSnackbar(var9.getString(2131821092));
      } else {
         Observable var6 = this.agendamentoInteractor.agendarOn(var1, var2, var3, var4, var5).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
         Subscriber var7 = new Subscriber() {
            public void onCompleted() {
               ItemInspecaoAgendarActivityPresenterImpl.this.view.hideProgressDialog();
            }

            public void onError(Throwable var1x) {
               Logger.error("Erro ao realizar agendamento.", var1x);
               ItemInspecaoAgendarActivityPresenterImpl.this.view.hideProgressDialog();
               ItemInspecaoAgendarActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131821066), ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131820915), new 1(this));
            }

            public void onNext(Item var1x) {
               ItemInspecaoAgendarActivityPresenterImpl.this.view.showToastLongTime(ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131820987));
               ItemInspecaoAgendarActivityPresenterImpl.this.view.sair();
            }

            public void onStart() {
               super.onStart();
               ItemInspecaoAgendarActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131821137));
            }
         };
         var6.subscribe(var7);
      }
   }

   public void agendar(final Long var1, final String var2, final Long var3, final String var4) {
      if (!this.view.isConnected()) {
         ItemInspecaoView$Agendamento_inspecao.Activity var8 = this.view;
         var8.showSnackbar(var8.getString(2131821092));
      } else {
         Observable var5 = this.agendamentoInteractor.agendarOn(var1, var2, var3, var4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
         Subscriber var6 = new Subscriber() {
            public void onCompleted() {
               ItemInspecaoAgendarActivityPresenterImpl.this.view.hideProgressDialog();
            }

            public void onError(Throwable var1x) {
               Logger.error("Erro ao realizar agendamento.", var1x);
               ItemInspecaoAgendarActivityPresenterImpl.this.view.hideProgressDialog();
               ItemInspecaoAgendarActivityPresenterImpl.this.view.hideKeyboard();
               ItemInspecaoAgendarActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131821066), ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131820915), new com.brq.inspecao_360_android.presentantion.presenter.impl.ItemInspecaoAgendarActivityPresenterImpl.4.1(this));
            }

            public void onNext(Void var1x) {
               ItemInspecaoAgendarActivityPresenterImpl.this.view.showToastLongTime(ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131820987));
               ItemInspecaoAgendarActivityPresenterImpl.this.view.sair();
            }

            public void onStart() {
               super.onStart();
               ItemInspecaoAgendarActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131821137));
            }
         };
         var5.subscribe(var6);
      }
   }

   public void atualizar(final Long var1, final Long var2, final String var3) {
      this.itemInspecaoInteractor.obterOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoAgendarActivityPresenterImpl$5(Long var1x, Long var2x, String var3x, View var4) {
            ItemInspecaoAgendarActivityPresenterImpl.this.atualizar(var1x, var2x, var3x);
         }

         public void onCompleted() {
            ItemInspecaoAgendarActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item agendar.", var1x);
            ItemInspecaoAgendarActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoAgendarActivityPresenterImpl.this.view.onError();
            ItemInspecaoAgendarActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131820915), new s13bu_UTW2O9jfE79KM5tIUGgAI(this, var1, var2, var3));
         }

         public void onNext(Item var1x) {
            ItemInspecaoAgendarActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoAgendarActivityPresenterImpl.this.view.preencher(var1x, false);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoAgendarActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
      this.atualizarCounterBottomNav(var1, var2);
   }

   public void carregar(final Long var1, final Long var2) {
      this.agendamentoInteractor.obterHorariosOn(var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ItemInspecaoAgendarActivityPresenterImpl.this.view.showProgress(false);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar horarios de agendamento.", var1x);
            ItemInspecaoAgendarActivityPresenterImpl.this.view.showProgress(false);
            ItemInspecaoAgendarActivityPresenterImpl.this.view.onError();
            ItemInspecaoAgendarActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131821066), ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131820915), new com.brq.inspecao_360_android.presentantion.presenter.impl.ItemInspecaoAgendarActivityPresenterImpl.2.1(this));
         }

         public void onNext(List var1x) {
            ItemInspecaoAgendarActivityPresenterImpl.this.view.onSuccess();
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoAgendarActivityPresenterImpl.this.view.showProgress(true);
         }
      });
   }

   public void carregar(final Long var1, final Long var2, final String var3, final Long var4) {
      Observable var5 = this.agendamentoInteractor.obterHorariosOn(var4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var6 = new Subscriber() {
         public void onCompleted() {
            ItemInspecaoAgendarActivityPresenterImpl.this.view.showProgress(false);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar horarios de agendamento.", var1x);
            ItemInspecaoAgendarActivityPresenterImpl.this.view.showProgress(false);
            ItemInspecaoAgendarActivityPresenterImpl.this.view.onError();
            ItemInspecaoAgendarActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131821066), ItemInspecaoAgendarActivityPresenterImpl.this.view.getString(2131820915), new com.brq.inspecao_360_android.presentantion.presenter.impl.ItemInspecaoAgendarActivityPresenterImpl.1.1(this));
         }

         public void onNext(List var1x) {
            ItemInspecaoAgendarActivityPresenterImpl.this.view.onSuccess();
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoAgendarActivityPresenterImpl.this.view.showProgress(true);
         }
      };
      var5.subscribe(var6);
      this.atualizar(var1, var2, var3);
   }

   public void iniciar(Long var1, Long var2, Long var3) {
      this.interactor.iniciarOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ItemInspecaoAgendarActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao parar modo inspecao.", var1);
            ItemInspecaoAgendarActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onNext(Item var1) {
            if (!Validator.isNullOrEmpty(var1)) {
               ItemInspecaoAgendarActivityPresenterImpl.this.view.preencher(var1, false);
            }
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoAgendarActivityPresenterImpl.this.showLoad(true, true);
         }
      });
   }
}
