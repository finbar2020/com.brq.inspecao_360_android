package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.enumerator.StatusInspecaoEnum;
import com.brq.inspecao_360_android.common.exception.BusinessException;
import com.brq.inspecao_360_android.common.exception.IntegrationException;
import com.brq.inspecao_360_android.common.service.DownloadMapsService;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.configuration.di.App;
import com.brq.inspecao_360_android.interactor.ChecklistInteractor;
import com.brq.inspecao_360_android.interactor.ImagemInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.Checklist;
import com.brq.inspecao_360_android.model.entity.CombinedResult;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.ChecklistActivityPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ChecklistActivityPresenterImpl.px4gAfCrEuBwAstnGxFRZQdXem4;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ChecklistActivityPresenterImpl.11.l6-jnITlksM3BOhMm-iodgGfymk;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ChecklistActivityPresenterImpl.6.RUXHAndjl6HRpnovuZ13sJTw3Ho;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ChecklistActivityPresenterImpl.7.Gfsmr09VHrsBFT2IzTSeW8i2yMM;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ChecklistActivityPresenterImpl.7.tBvkJk5iMJqx1l9yaQexl4C-iCg;
import com.brq.inspecao_360_android.presentantion.view.ChecklistView;
import com.brq.inspecao_360_android.presentantion.view.ChecklistView$Activity;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ChecklistActivityPresenterImpl extends BasePresenterImpl implements ChecklistActivityPresenter {
   @Inject
   ChecklistInteractor checklistInteractor;
   @Inject
   ImagemInteractor imagemInteractor;
   @Inject
   ItemInspecaoInteractor itemInspecaoInteractor;
   private ChecklistView$Activity view;

   @Inject
   public ChecklistActivityPresenterImpl(ChecklistView var1) {
      super(var1);
      this.view = (ChecklistView$Activity)var1;
   }

   public void aceitar(Long var1, Long var2, String var3, Long var4) {
      if (!this.view.isConnected()) {
         ChecklistView$Activity var8 = this.view;
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
      this.itemInspecaoInteractor.obterOn(var1, var2, true).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ChecklistActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1) {
            Logger.error("Checklist - Erro ao atualizar item.", var1);
            ChecklistActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onNext(Item var1) {
            ChecklistActivityPresenterImpl.this.view.preencherStatus(var1);
         }

         public void onStart() {
            super.onStart();
            ChecklistActivityPresenterImpl.this.view.showProgessDialog(ChecklistActivityPresenterImpl.this.view.getString(2131820595), ChecklistActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
   }

   public void atualizarCounterBottomNav(Long var1, Long var2) {
      this.imagemInteractor.obterPorItem(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao carregar contador de imagens.", var1);
         }

         public void onNext(List var1) {
            ChecklistActivityPresenterImpl.this.view.preencherCounterBottomNav(var1);
         }

         public void onStart() {
            super.onStart();
         }
      });
   }

   public void atualizarOff(Long var1, Long var2, String var3) {
      this.itemInspecaoInteractor.obterOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ChecklistActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1) {
            Logger.error("Checklist - Erro ao atualizar item.", var1);
            ChecklistActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onNext(Item var1) {
            ChecklistActivityPresenterImpl.this.view.preencherStatus(var1);
         }

         public void onStart() {
            super.onStart();
            ChecklistActivityPresenterImpl.this.view.showProgessDialog(ChecklistActivityPresenterImpl.this.view.getString(2131820595), ChecklistActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
   }

   public void carregar(Long var1, Long var2, String var3, Long var4) {
      final Observable var5 = this.itemInspecaoInteractor.obterOff(var1, var2).switchMap(new Func1() {
         public Observable call(final Item var1) {
            return ChecklistActivityPresenterImpl.this.checklistInteractor.obterCoberturaOffForIndex(var1.getId()).switchMap(new Func1() {
               public Observable call(List var1x) {
                  return Observable.just(new CombinedResult(var1, var1x));
               }
            });
         }
      });

      try {
         if (this.checklistInteractor.hasChecklist(var4)) {
            var5.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriberLoadIndex(var1, var2, var3, var4, true));
         } else if (this.view.isConnected()) {
            this.checklistInteractor.obterOn(var4).switchMap(new Func1() {
               public Observable call(Checklist var1) {
                  return var5;
               }
            }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriberLoadIndex(var1, var2, var3, var4, true));
         } else {
            this.view.onErrorChecklistNotFound();
         }
      } catch (IntegrationException var11) {
         Logger.error("Não foi possível carregar o processar.", var11);
         ChecklistView$Activity var7 = this.view;
         String var8 = var7.getString(2131821121);
         String var9 = this.view.getString(2131821238);
         px4gAfCrEuBwAstnGxFRZQdXem4 var10 = new px4gAfCrEuBwAstnGxFRZQdXem4(this, var1, var2, var3, var4);
         var7.showSnackbar(var8, var9, var10);
      }
   }

   public void editar(Long var1, Long var2, String var3, Long var4) {
      this.itemInspecaoInteractor.atualizarStatusOff(var1, var2, StatusInspecaoEnum.AGUARDANDO_ENVIAR_CHECKLIST.getId()).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriber(var1, var2, var3, var4, true));
   }

   public void iniciar(Long var1, Long var2, String var3, Long var4) {
      this.checklistInteractor.iniciarOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ChecklistActivityPresenterImpl.this.view.onSuccessIniciar();
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao iniciar modo inspecao.", var1);
            ChecklistActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onNext(Item var1) {
         }

         public void onStart() {
            super.onStart();
            ChecklistActivityPresenterImpl.this.showLoad(true, true);
         }
      });
   }

   // $FF: synthetic method
   public void lambda$carregar$0$ChecklistActivityPresenterImpl(Long var1, Long var2, String var3, Long var4, View var5) {
      this.carregar(var1, var2, var3, var4);
   }

   public void parar(Long var1, Long var2, String var3, Long var4) {
      this.interactor.pararOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ChecklistActivityPresenterImpl.this.view.onSuccessParar();
            ChecklistActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao parar modo inspecao.", var1);
            ChecklistActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onNext(Item var1) {
            if (!Validator.isNullOrEmpty(var1)) {
               ChecklistActivityPresenterImpl.this.view.preencherStatus(var1);
            }
         }

         public void onStart() {
            super.onStart();
            ChecklistActivityPresenterImpl.this.showLoad(true, true);
         }
      });
   }

   protected Subscriber subscriber(final Long var1, final Long var2, final String var3, final Long var4, final boolean var5) {
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ChecklistActivityPresenterImpl$6(Long var1x, Long var2x, String var3x, Long var4x, View var5x) {
            ChecklistActivityPresenterImpl.this.carregar(var1x, var2x, var3x, var4x);
         }

         public void onCompleted() {
            ChecklistActivityPresenterImpl.this.showLoad(var5, false);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar detalhe item.", var1x);
            ChecklistActivityPresenterImpl.this.showLoad(var5, false);
            if (var1x.getCause() instanceof BusinessException) {
               BusinessException var10 = (BusinessException)var1x.getCause();
               ChecklistActivityPresenterImpl.this.checkBusinessExpection(var1, var2, var3, var10);
            } else {
               ChecklistView$Activity var2x = ChecklistActivityPresenterImpl.this.view;
               String var3x = ChecklistActivityPresenterImpl.this.view.getString(2131821121);
               String var4x = ChecklistActivityPresenterImpl.this.view.getString(2131821238);
               Long var5x = var1;
               Long var6 = var2;
               String var7 = var3;
               Long var8 = var4;
               RUXHAndjl6HRpnovuZ13sJTw3Ho var9 = new RUXHAndjl6HRpnovuZ13sJTw3Ho(this, var5x, var6, var7, var8);
               var2x.showSnackbar(var3x, var4x, var9);
            }
         }

         public void onNext(Item var1x) {
            ChecklistActivityPresenterImpl.this.view.preencherStatus(var1x);
         }

         public void onStart() {
            super.onStart();
            ChecklistActivityPresenterImpl.this.showLoad(var5, true);
         }
      };
      return var6;
   }

   protected Subscriber subscriberAceiteOn(final Long var1, final Long var2, final String var3, final boolean var4, final Long var5) {
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ChecklistActivityPresenterImpl$11(Long var1x, Long var2x, String var3x, Long var4x, View var5x) {
            ChecklistActivityPresenterImpl.this.aceitar(var1x, var2x, var3x, var4x);
         }

         public void onCompleted() {
            ChecklistActivityPresenterImpl.this.showLoad(var4, false);
            App.getContext().startService(DownloadMapsService.newInstance(App.getContext()));
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar detalhe item.", var1x);
            ChecklistActivityPresenterImpl.this.showLoad(var4, false);
            ChecklistActivityPresenterImpl.this.view.showViewError(App.getContext().getString(2131821069));
            if (var1x instanceof BusinessException) {
               BusinessException var10 = (BusinessException)var1x;
               ChecklistActivityPresenterImpl.this.checkBusinessExpection(var1, var2, var3, var10);
            } else {
               ChecklistView$Activity var2x = ChecklistActivityPresenterImpl.this.view;
               String var3x = ChecklistActivityPresenterImpl.this.view.getString(2131821121);
               String var4x = ChecklistActivityPresenterImpl.this.view.getString(2131821238);
               Long var5x = var1;
               Long var6 = var2;
               String var7 = var3;
               Long var8 = var5;
               l6-jnITlksM3BOhMm-iodgGfymk var9 = new l6-jnITlksM3BOhMm-iodgGfymk(this, var5x, var6, var7, var8);
               var2x.showSnackbar(var3x, var4x, var9);
            }
         }

         public void onNext(Item var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ChecklistActivityPresenterImpl.this.carregar(var1, var2, var3, var5);
            }

         }

         public void onStart() {
            super.onStart();
            ChecklistActivityPresenterImpl.this.showLoad(var4, true);
         }
      };
      return var6;
   }

   protected Subscriber subscriberLoadIndex(final Long var1, final Long var2, final String var3, final Long var4, final boolean var5) {
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ChecklistActivityPresenterImpl$7(Long var1x, Long var2x, String var3x, Long var4x, View var5x) {
            ChecklistActivityPresenterImpl.this.carregar(var1x, var2x, var3x, var4x);
         }

         // $FF: synthetic method
         public void lambda$onNext$1$ChecklistActivityPresenterImpl$7(View var1x) {
            ChecklistActivityPresenterImpl.this.view.finish();
         }

         public void onCompleted() {
            ChecklistActivityPresenterImpl.this.showLoad(var5, false);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar detalhe item.", var1x);
            ChecklistActivityPresenterImpl.this.showLoad(var5, false);
            if (var1x.getCause() instanceof BusinessException) {
               BusinessException var10 = (BusinessException)var1x.getCause();
               ChecklistActivityPresenterImpl.this.checkBusinessExpection(var1, var2, var3, var10);
            } else {
               ChecklistView$Activity var2x = ChecklistActivityPresenterImpl.this.view;
               String var3x = ChecklistActivityPresenterImpl.this.view.getString(2131821121);
               String var4x = ChecklistActivityPresenterImpl.this.view.getString(2131821238);
               Long var5x = var1;
               Long var6 = var2;
               String var7 = var3;
               Long var8 = var4;
               Gfsmr09VHrsBFT2IzTSeW8i2yMM var9 = new Gfsmr09VHrsBFT2IzTSeW8i2yMM(this, var5x, var6, var7, var8);
               var2x.showSnackbar(var3x, var4x, var9);
            }
         }

         public void onNext(CombinedResult var1x) {
            ChecklistActivityPresenterImpl.this.view.preencherStatus(var1x.getItem());
            if (ChecklistActivityPresenterImpl.this.isUserCanEdit(var1x.getItem())) {
               if (var1x.getCoberturaChecklists().size() == 0) {
                  ChecklistActivityPresenterImpl.this.view.showSnackbar(ChecklistActivityPresenterImpl.this.view.getString(2131820990), ChecklistActivityPresenterImpl.this.view.getString(2131820866), new tBvkJk5iMJqx1l9yaQexl4C-iCg(this));
               } else {
                  ChecklistActivityPresenterImpl.this.view.preencherDependencias(var1x);
                  ChecklistActivityPresenterImpl.this.view.showViewSuccess();
               }
            } else if (ChecklistActivityPresenterImpl.this.isAguardandoRevisaoOuPendencia(var1x.getItem())) {
               ChecklistActivityPresenterImpl.this.view.showViewError(App.getContext().getString(2131820986));
            } else {
               ChecklistActivityPresenterImpl.this.view.showViewError(App.getContext().getString(2131820985));
            }

            ChecklistActivityPresenterImpl.this.atualizarCounterBottomNav(var1x.getItem().getInspecao().getId(), var1x.getItem().getId());
         }

         public void onStart() {
            super.onStart();
            ChecklistActivityPresenterImpl.this.showLoad(var5, true);
         }
      };
      return var6;
   }
}
