package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
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
import com.brq.inspecao_360_android.model.entity.Imagem;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.ItemInspecaoFotosActivityPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoFotosActivityPresenterImpl.1.pKbiocETFm41l0uCABcLLHvajes;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoFotosActivityPresenterImpl.4.j0oAmIfIgmLUs7G7BR1iAjh6URY;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$Fotos;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ItemInspecaoFotosActivityPresenterImpl extends BasePresenterImpl implements ItemInspecaoFotosActivityPresenter {
   @Inject
   ChecklistInteractor checklistInteractor;
   @Inject
   ImagemInteractor imagemInteractor;
   @Inject
   ItemInspecaoInteractor itemInspecaoInteractor;
   private ItemInspecaoView$Fotos.Activity view;

   @Inject
   public ItemInspecaoFotosActivityPresenterImpl(ItemInspecaoView var1) {
      super(var1);
      this.view = (ItemInspecaoView$Fotos.Activity)var1;
   }

   public void aceitar(Long var1, Long var2, String var3, Long var4) {
      if (!this.view.isConnected()) {
         ItemInspecaoView$Fotos.Activity var8 = this.view;
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
   }

   public void carregar(final Long var1, final Long var2, final String var3) {
      this.itemInspecaoInteractor.obterOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoFotosActivityPresenterImpl$1(Long var1x, Long var2x, String var3x, View var4) {
            ItemInspecaoFotosActivityPresenterImpl.this.carregar(var1x, var2x, var3x);
         }

         public void onCompleted() {
            ItemInspecaoFotosActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item fotos(galeria).", var1x);
            ItemInspecaoFotosActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFotosActivityPresenterImpl.this.view.onError();
            ItemInspecaoFotosActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoFotosActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoFotosActivityPresenterImpl.this.view.getString(2131820915), new pKbiocETFm41l0uCABcLLHvajes(this, var1, var2, var3));
         }

         public void onNext(Item var1x) {
            ItemInspecaoFotosActivityPresenterImpl.this.view.preencher(var1x);
            if (ItemInspecaoFotosActivityPresenterImpl.this.isUserCanEdit(var1x)) {
               ItemInspecaoFotosActivityPresenterImpl.this.view.onSuccess();
            } else if (ItemInspecaoFotosActivityPresenterImpl.this.isAguardandoRevisaoOuPendencia(var1x)) {
               ItemInspecaoFotosActivityPresenterImpl.this.view.showViewError(App.getContext().getString(2131820986));
            } else {
               ItemInspecaoFotosActivityPresenterImpl.this.view.showViewError(App.getContext().getString(2131820985));
            }
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoFotosActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoFotosActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoFotosActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
   }

   public void excluirFotoGaleria(List var1) {
      this.imagemInteractor.excluirPorIdsOff(var1).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriberImagem());
   }

   public void iniciar(final Long var1, final Long var2, final String var3) {
      this.interactor.iniciarOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ItemInspecaoFotosActivityPresenterImpl.this.carregar(var1, var2, var3);
            ItemInspecaoFotosActivityPresenterImpl.this.view.onSuccessIniciar();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao iniciar modo inspecao.", var1x);
            ItemInspecaoFotosActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onNext(Item var1x) {
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoFotosActivityPresenterImpl.this.showLoad(true, true);
         }
      });
   }

   public void parar(final Long var1, final Long var2, final String var3) {
      this.interactor.pararOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ItemInspecaoFotosActivityPresenterImpl.this.carregar(var1, var2, var3);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao parar modo inspecao.", var1x);
            ItemInspecaoFotosActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onNext(Item var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ItemInspecaoFotosActivityPresenterImpl.this.view.preencher(var1x);
            }
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoFotosActivityPresenterImpl.this.showLoad(true, true);
         }
      });
   }

   protected Subscriber subscriberAceiteOn(final Long var1, final Long var2, final String var3, final boolean var4, final Long var5) {
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoFotosActivityPresenterImpl$4(Long var1x, Long var2x, String var3x, Long var4x, View var5x) {
            ItemInspecaoFotosActivityPresenterImpl.this.aceitar(var1x, var2x, var3x, var4x);
         }

         public void onCompleted() {
            ItemInspecaoFotosActivityPresenterImpl.this.showLoad(var4, false);
            ItemInspecaoFotosActivityPresenterImpl.this.carregar(var1, var2, var3);
            App.getContext().startService(DownloadMapsService.newInstance(App.getContext()));
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar detalhe item.", var1x);
            ItemInspecaoFotosActivityPresenterImpl.this.showLoad(var4, false);
            ItemInspecaoFotosActivityPresenterImpl.this.view.showViewError(App.getContext().getString(2131821069));
            if (var1x instanceof BusinessException) {
               BusinessException var10 = (BusinessException)var1x;
               ItemInspecaoFotosActivityPresenterImpl.this.checkBusinessExpection(var1, var2, var3, var10);
            } else {
               ItemInspecaoView$Fotos.Activity var2x = ItemInspecaoFotosActivityPresenterImpl.this.view;
               String var3x = ItemInspecaoFotosActivityPresenterImpl.this.view.getString(2131821121);
               String var4x = ItemInspecaoFotosActivityPresenterImpl.this.view.getString(2131821238);
               Long var5x = var1;
               Long var6 = var2;
               String var7 = var3;
               Long var8 = var5;
               j0oAmIfIgmLUs7G7BR1iAjh6URY var9 = new j0oAmIfIgmLUs7G7BR1iAjh6URY(this, var5x, var6, var7, var8);
               var2x.showSnackbar(var3x, var4x, var9);
            }
         }

         public void onNext(Item var1x) {
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoFotosActivityPresenterImpl.this.showLoad(var4, true);
         }
      };
      return var6;
   }

   public Subscriber subscriberImagem() {
      return new Subscriber() {
         public void onCompleted() {
            ItemInspecaoFotosActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao excluir fotografias (galeria).", var1);
            ItemInspecaoFotosActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFotosActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoFotosActivityPresenterImpl.this.view.getString(2131821066));
         }

         public void onNext(Imagem var1) {
            if (var1 != null) {
               StringBuilder var2 = new StringBuilder();
               var2.append("Fotografia: '");
               var2.append(var1.getFilePath());
               var2.append("' da inspeção: ");
               var2.append(var1.getItem().getUid());
               var2.append(", Excluída com sucesso.");
               Logger.info(var2.toString());
               ItemInspecaoFotosActivityPresenterImpl.this.view.sendRemoveBroadCast(var1);
            }
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoFotosActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoFotosActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoFotosActivityPresenterImpl.this.view.getString(2131821137));
         }
      };
   }
}
