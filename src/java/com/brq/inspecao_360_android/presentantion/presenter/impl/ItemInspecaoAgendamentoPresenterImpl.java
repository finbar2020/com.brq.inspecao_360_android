package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.exception.BusinessException;
import com.brq.inspecao_360_android.common.exception.IntegrationException;
import com.brq.inspecao_360_android.common.service.DownloadMapsService;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.configuration.di.App;
import com.brq.inspecao_360_android.interactor.AgendamentoInteractor;
import com.brq.inspecao_360_android.interactor.ChecklistInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.Checklist;
import com.brq.inspecao_360_android.model.entity.Inspecao;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.ItemInspecaoAgendamentoPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoAgendamentoPresenterImpl.hq6FqGxJSiDgueAFWAqDuu-4H5E;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoAgendamentoPresenterImpl.5.-HHnCLGLtzv8M2-3laLarz_osWY;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$Agendamento_inspecao;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ItemInspecaoAgendamentoPresenterImpl extends BasePresenterImpl implements ItemInspecaoAgendamentoPresenter {
   @Inject
   AgendamentoInteractor agendamentoInteractor;
   @Inject
   ChecklistInteractor checklistInteractor;
   @Inject
   ItemInspecaoInteractor itemInspecaoInteractor;
   private Item mItem;
   boolean permiteAgendamentoPorItem = false;
   private ItemInspecaoView$Agendamento_inspecao.Activity view;

   @Inject
   public ItemInspecaoAgendamentoPresenterImpl(ItemInspecaoView var1) {
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
            ItemInspecaoAgendamentoPresenterImpl.this.view.preencherCounterBottomNav(var1);
         }

         public void onStart() {
            super.onStart();
         }
      });
   }

   public void aceitar(Long var1, Long var2, String var3, Long var4) {
      if (!this.view.isConnected()) {
         ItemInspecaoView$Agendamento_inspecao.Activity var8 = this.view;
         var8.showSnackbar(var8.getString(2131821092));
      } else {
         try {
            if (this.checklistInteractor.hasChecklist(var4)) {
               this.itemInspecaoInteractor.aceitar(var1, var2, (String)null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriberAceiteOn(var1, var2, var3, true, var4));
            } else {
               this.checklistInteractor.obterOn(var4).switchMap(new Func1(this.itemInspecaoInteractor.aceitar(var1, var2, (String)null)) {
                  // $FF: synthetic field
                  final Observable val$observableAceitar;

                  {
                     this.val$observableAceitar = var2;
                  }

                  public Observable call(Checklist var1) {
                     return this.val$observableAceitar;
                  }
               }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriberAceiteOn(var1, var2, var3, true, var4));
            }
         } catch (IntegrationException var9) {
            Logger.error("Não foi possível carregar o processar. - ItemInspecaoDetalheActivityPresenterImpl", var9);
         }
      }
   }

   public void atualizar(Long var1, Long var2, String var3) {
      this.itemInspecaoInteractor.obterOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao carregar contador de imagens.", var1);
         }

         public void onNext(Item var1) {
            ItemInspecaoAgendamentoPresenterImpl.this.view.preencher(var1, false);
         }

         public void onStart() {
            super.onStart();
         }
      });
   }

   public void carregar(Long var1, Long var2, String var3) {
      if (!this.view.isConnected()) {
         this.view.showViewError("Esta funcionalidade está disponível apenas online.");
         this.atualizar(var1, var2, var3);
         this.atualizarCounterBottomNav(var1, var2);
      } else {
         this.itemInspecaoInteractor.obterOff(var1, var2).switchMap(new hq6FqGxJSiDgueAFWAqDuu-4H5E(this, var2, var1)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
            public void onCompleted() {
               ItemInspecaoAgendamentoPresenterImpl.this.view.hideProgressDialog();
            }

            public void onError(Throwable var1) {
               Logger.error(var1.getMessage());
               ItemInspecaoAgendamentoPresenterImpl.this.view.hideProgressDialog();
               ItemInspecaoAgendamentoPresenterImpl.this.view.onError(App.getContext().getString(2131821121));
            }

            public void onNext(List var1) {
               if (!Validator.isNullOrEmpty(ItemInspecaoAgendamentoPresenterImpl.this.mItem)) {
                  ItemInspecaoAgendamentoPresenterImpl.this.view.preencher(ItemInspecaoAgendamentoPresenterImpl.this.mItem, true);
               }

               if (!Validator.isNullOrEmpty(var1)) {
                  ItemInspecaoAgendamentoPresenterImpl.this.view.addAll(var1);
                  ItemInspecaoAgendamentoPresenterImpl.this.view.onSuccess();
               } else {
                  ItemInspecaoAgendamentoPresenterImpl.this.view.showViewError("Nenhum agendamento disponível.");
               }
            }

            public void onStart() {
               super.onStart();
               ItemInspecaoAgendamentoPresenterImpl.this.view.showProgessDialog(ItemInspecaoAgendamentoPresenterImpl.this.view.getString(2131820595), ItemInspecaoAgendamentoPresenterImpl.this.view.getString(2131821137));
            }
         });
         this.atualizarCounterBottomNav(var1, var2);
      }
   }

   public void iniciar(Long var1, Long var2, Long var3) {
      this.interactor.iniciarOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ItemInspecaoAgendamentoPresenterImpl.this.view.onSuccessIniciar();
            ItemInspecaoAgendamentoPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao iniciar modo inspecao.", var1);
            ItemInspecaoAgendamentoPresenterImpl.this.showLoad(true, false);
         }

         public void onNext(Item var1) {
            if (!Validator.isNullOrEmpty(var1)) {
               ItemInspecaoAgendamentoPresenterImpl.this.view.preencher(var1, true);
            }
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoAgendamentoPresenterImpl.this.showLoad(true, true);
         }
      });
   }

   // $FF: synthetic method
   public Observable lambda$carregar$0$ItemInspecaoAgendamentoPresenterImpl(Long var1, Long var2, Item var3) {
      this.mItem = var3;
      Inspecao var4 = var3.getInspecao();
      if (!Validator.isNullOrEmpty(var4) && !Validator.isNullOrEmpty(var4.getPermiteAgendamentoPorItem())) {
         this.permiteAgendamentoPorItem = var4.getPermiteAgendamentoPorItem();
      }

      return this.permiteAgendamentoPorItem ? this.itemInspecaoInteractor.agendamentos(var1) : this.itemInspecaoInteractor.agendamentosPorInspecao(var2);
   }

   public void parar(Long var1, Long var2, Long var3) {
      this.interactor.pararOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ItemInspecaoAgendamentoPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao parar modo inspecao.", var1);
            ItemInspecaoAgendamentoPresenterImpl.this.showLoad(true, false);
         }

         public void onNext(Item var1) {
            if (!Validator.isNullOrEmpty(var1)) {
               ItemInspecaoAgendamentoPresenterImpl.this.view.preencher(var1, true);
            }
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoAgendamentoPresenterImpl.this.showLoad(true, true);
         }
      });
   }

   protected Subscriber subscriberAceiteOn(final Long var1, final Long var2, final String var3, final boolean var4, final Long var5) {
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoAgendamentoPresenterImpl$5(Long var1x, Long var2x, String var3x, Long var4x, View var5x) {
            ItemInspecaoAgendamentoPresenterImpl.this.aceitar(var1x, var2x, var3x, var4x);
         }

         public void onCompleted() {
            ItemInspecaoAgendamentoPresenterImpl.this.showLoad(var4, false);
            ItemInspecaoAgendamentoPresenterImpl.this.carregar(var1, var2, var3);
            App.getContext().startService(DownloadMapsService.newInstance(App.getContext()));
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar detalhe item.", var1x);
            ItemInspecaoAgendamentoPresenterImpl.this.showLoad(var4, false);
            ItemInspecaoAgendamentoPresenterImpl.this.view.onError((String)null);
            if (var1x instanceof BusinessException) {
               BusinessException var10 = (BusinessException)var1x;
               ItemInspecaoAgendamentoPresenterImpl.this.checkBusinessExpection(var1, var2, var3, var10);
            } else {
               ItemInspecaoView$Agendamento_inspecao.Activity var2x = ItemInspecaoAgendamentoPresenterImpl.this.view;
               String var3x = ItemInspecaoAgendamentoPresenterImpl.this.view.getString(2131821121);
               String var4x = ItemInspecaoAgendamentoPresenterImpl.this.view.getString(2131821238);
               Long var5x = var1;
               Long var6 = var2;
               String var7 = var3;
               Long var8 = var5;
               -HHnCLGLtzv8M2-3laLarz_osWY var9 = new -HHnCLGLtzv8M2-3laLarz_osWY(this, var5x, var6, var7, var8);
               var2x.showSnackbar(var3x, var4x, var9);
            }
         }

         public void onNext(Item var1x) {
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoAgendamentoPresenterImpl.this.showLoad(var4, true);
         }
      };
      return var6;
   }
}
