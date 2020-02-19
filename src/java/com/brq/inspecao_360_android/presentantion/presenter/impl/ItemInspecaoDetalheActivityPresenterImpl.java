package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.exception.BusinessException;
import com.brq.inspecao_360_android.common.exception.IntegrationException;
import com.brq.inspecao_360_android.common.service.DownloadMapsService;
import com.brq.inspecao_360_android.common.util.DateUtil;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.configuration.di.App;
import com.brq.inspecao_360_android.interactor.ChecklistInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.Checklist;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.ItemInspecaoDetalheActivityPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoDetalheActivityPresenterImpl.4.xpPXD3_o62s56P8spInsHAfr6NY;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoDetalheActivityPresenterImpl.6.6SoJKlwTKcd7_Ll7DNcwaMqMm-E;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$Detalhe$Activity;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import org.joda.time.Duration;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ItemInspecaoDetalheActivityPresenterImpl extends BasePresenterImpl implements ItemInspecaoDetalheActivityPresenter {
   @Inject
   protected ChecklistInteractor checklistInteractor;
   @Inject
   protected ItemInspecaoInteractor interactor;
   private ItemInspecaoView$Detalhe$Activity view;

   @Inject
   public ItemInspecaoDetalheActivityPresenterImpl(ItemInspecaoView var1) {
      super(var1);
      this.view = (ItemInspecaoView$Detalhe$Activity)var1;
   }

   public void aceitar(Long var1, Long var2, String var3, Long var4) {
      if (!this.view.isConnected()) {
         ItemInspecaoView$Detalhe$Activity var8 = this.view;
         var8.showSnackbar(var8.getString(2131821092));
      } else {
         try {
            if (this.checklistInteractor.hasChecklist(var4)) {
               this.interactor.aceitar(var1, var2, (String)null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriberAceiteOn(var1, var2, var3, true, var4));
            } else {
               this.checklistInteractor.obterOn(var4).switchMap(new Func1(this.interactor.aceitar(var1, var2, (String)null)) {
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

   public void atualizar(final Long var1, final Long var2, String var3) {
      this.imagemInteractor.obterPorItem(var1, var2).switchMap(new Func1() {
         public Observable call(List var1x) {
            ItemInspecaoDetalheActivityPresenterImpl.this.view.storeCountImagens(var1x);
            return ItemInspecaoDetalheActivityPresenterImpl.this.interactor.obterOff(var1, var2);
         }
      }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriberOff(var1, var2, var3, false));
   }

   public void carregar(final Long var1, final Long var2, final String var3) {
      if (this.view.isConnected()) {
         this.interactor.obterStatusServidor().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
            public void onCompleted() {
            }

            public void onError(Throwable var1x) {
               ItemInspecaoDetalheActivityPresenterImpl.this.atualizar(var1, var2, var3);
            }

            public void onNext(JsonObject var1x) {
               boolean var3x;
               label21: {
                  JsonElement var2x = var1x.get("now");
                  if (!Validator.isNullOrEmpty(var2x)) {
                     Date var5 = DateUtil.toBR(new Date(var2x.getAsLong()));
                     Date var6 = DateUtil.toBR(new Date());
                     Duration var7 = new Duration(var5.getTime(), var6.getTime());
                     if (var7.getStandardMinutes() > 30L || var7.getStandardMinutes() < -30L) {
                        var3x = false;
                        break label21;
                     }
                  }

                  var3x = true;
               }

               if (var3x) {
                  ItemInspecaoDetalheActivityPresenterImpl.this.imagemInteractor.obterPorItem(var1, var2).switchMap(new Func1() {
                     public Observable call(List var1x) {
                        ItemInspecaoDetalheActivityPresenterImpl.this.view.storeCountImagens(var1x);
                        return ItemInspecaoDetalheActivityPresenterImpl.this.interactor.obterOffAndOn(var1, var2);
                     }
                  }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ItemInspecaoDetalheActivityPresenterImpl.this.subscriberOn(var1, var2, var3, true));
               } else {
                  ItemInspecaoDetalheActivityPresenterImpl.this.view.mostrarDialogHoraIncorreta();
               }
            }
         });
      } else {
         this.atualizar(var1, var2, var3);
      }
   }

   public void iniciar(Long var1, Long var2, Long var3) {
      this.interactor.iniciarOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ItemInspecaoDetalheActivityPresenterImpl.this.view.onSuccessIniciar();
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao iniciar modo inspecao.", var1);
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onNext(Item var1) {
            if (!Validator.isNullOrEmpty(var1)) {
               ItemInspecaoDetalheActivityPresenterImpl.this.view.preencher(var1);
            }
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(true, true);
         }
      });
   }

   public void parar(Long var1, Long var2, Long var3) {
      this.interactor.pararOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao parar modo inspecao.", var1);
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onNext(Item var1) {
            if (!Validator.isNullOrEmpty(var1)) {
               ItemInspecaoDetalheActivityPresenterImpl.this.view.preencher(var1);
            }
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(true, true);
         }
      });
   }

   public void remover(Long var1, Long var2, String var3) {
   }

   protected Subscriber subscriberAceiteOn(final Long var1, final Long var2, final String var3, final boolean var4, final Long var5) {
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoDetalheActivityPresenterImpl$4(Long var1x, Long var2x, String var3x, Long var4x, View var5x) {
            ItemInspecaoDetalheActivityPresenterImpl.this.aceitar(var1x, var2x, var3x, var4x);
         }

         public void onCompleted() {
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(var4, false);
            App.getContext().startService(DownloadMapsService.newInstance(App.getContext()));
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar detalhe item.", var1x);
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(var4, false);
            ItemInspecaoDetalheActivityPresenterImpl.this.view.onError((String)null);
            if (var1x instanceof BusinessException) {
               BusinessException var10 = (BusinessException)var1x;
               ItemInspecaoDetalheActivityPresenterImpl.this.checkBusinessExpection(var1, var2, var3, var10);
            } else {
               ItemInspecaoView$Detalhe$Activity var2x = ItemInspecaoDetalheActivityPresenterImpl.this.view;
               String var3x = ItemInspecaoDetalheActivityPresenterImpl.this.view.getString(2131821121);
               String var4x = ItemInspecaoDetalheActivityPresenterImpl.this.view.getString(2131821238);
               Long var5x = var1;
               Long var6 = var2;
               String var7 = var3;
               Long var8 = var5;
               xpPXD3_o62s56P8spInsHAfr6NY var9 = new xpPXD3_o62s56P8spInsHAfr6NY(this, var5x, var6, var7, var8);
               var2x.showSnackbar(var3x, var4x, var9);
            }
         }

         public void onNext(Item var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ItemInspecaoDetalheActivityPresenterImpl.this.view.onSuccess();
               ItemInspecaoDetalheActivityPresenterImpl.this.view.preencher(var1x);
            }

         }

         public void onStart() {
            super.onStart();
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(var4, true);
         }
      };
      return var6;
   }

   protected Subscriber subscriberOff(final Long var1, final Long var2, final String var3, final boolean var4) {
      Subscriber var5 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoDetalheActivityPresenterImpl$6(Long var1x, Long var2x, String var3x, View var4x) {
            ItemInspecaoDetalheActivityPresenterImpl.this.atualizar(var1x, var2x, var3x);
         }

         public void onCompleted() {
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(var4, false);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar detalhe item.", var1x);
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(var4, false);
            ItemInspecaoDetalheActivityPresenterImpl.this.view.onError((String)null);
            if (var1x instanceof BusinessException) {
               BusinessException var2x = (BusinessException)var1x;
               ItemInspecaoDetalheActivityPresenterImpl.this.checkBusinessExpection(var1, var2, var3, var2x);
            } else {
               ItemInspecaoDetalheActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoDetalheActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoDetalheActivityPresenterImpl.this.view.getString(2131821238), new 6SoJKlwTKcd7_Ll7DNcwaMqMm-E(this, var1, var2, var3));
            }
         }

         public void onNext(Item var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ItemInspecaoDetalheActivityPresenterImpl.this.view.onSuccess();
               ItemInspecaoDetalheActivityPresenterImpl.this.view.preencher(var1x);
            }

         }

         public void onStart() {
            super.onStart();
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(var4, true);
         }
      };
      return var5;
   }

   protected Subscriber subscriberOn(final Long var1, final Long var2, final String var3, final boolean var4) {
      Subscriber var5 = new Subscriber() {
         public void onCompleted() {
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(var4, false);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar detalhe item.", var1x);
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(var4, false);
            if (var1x instanceof BusinessException) {
               BusinessException var2x = (BusinessException)var1x;
               ItemInspecaoDetalheActivityPresenterImpl.this.checkBusinessExpection(var1, var2, var3, var2x);
            } else {
               ItemInspecaoDetalheActivityPresenterImpl.this.atualizar(var1, var2, var3);
            }
         }

         public void onNext(Item var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ItemInspecaoDetalheActivityPresenterImpl.this.view.preencher(var1x);
               ItemInspecaoDetalheActivityPresenterImpl.this.view.onSuccess();
            }

         }

         public void onStart() {
            super.onStart();
            ItemInspecaoDetalheActivityPresenterImpl.this.showLoad(var4, true);
         }
      };
      return var5;
   }
}
