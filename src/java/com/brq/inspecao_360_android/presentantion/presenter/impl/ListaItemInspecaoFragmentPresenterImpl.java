package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.exception.BusinessException;
import com.brq.inspecao_360_android.common.exception.IntegrationException;
import com.brq.inspecao_360_android.common.service.DownloadMapsService;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.configuration.di.App;
import com.brq.inspecao_360_android.interactor.ChecklistInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.CardItemInspecao;
import com.brq.inspecao_360_android.model.entity.Checklist;
import com.brq.inspecao_360_android.model.entity.Filtro;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.model.entity.SchemaItem;
import com.brq.inspecao_360_android.presentantion.presenter.ListaItemInspecaoFragmentPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ListaItemInspecaoFragmentPresenterImpl.2.EVZdSsNjAQ8jaq7P2M2_gB3oPwY;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ListaItemInspecaoFragmentPresenterImpl.4.aNm-BLw4bQxiqhomUhArillb5aM;
import com.brq.inspecao_360_android.presentantion.presenter.impl.ListaItemInspecaoFragmentPresenterImpl.1.1;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$Lista$Fragment;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ListaItemInspecaoFragmentPresenterImpl extends BasePresenterImpl implements ListaItemInspecaoFragmentPresenter {
   @Inject
   ChecklistInteractor checklistInteractor;
   @Inject
   ItemInspecaoInteractor interactor;
   private ItemInspecaoView$Lista$Fragment mView;

   @Inject
   public ListaItemInspecaoFragmentPresenterImpl(ItemInspecaoView var1) {
      super(var1);
      this.mView = (ItemInspecaoView$Lista$Fragment)var1;
   }

   public void aceitar(Long var1, Long var2, String var3, Long var4) {
      if (!this.mView.isConnected()) {
         ItemInspecaoView$Lista$Fragment var8 = this.mView;
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

   public void atualizar(Long var1, Long var2, String var3) {
   }

   public void carregar(final int var1, final long var2) {
      this.interactor.obterPaginadoOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ListaItemInspecaoFragmentPresenterImpl.this.mView.showSwipe(false);
         }

         public void onError(Throwable var1x) {
            ListaItemInspecaoFragmentPresenterImpl.this.mView.showSwipe(false);
            ListaItemInspecaoFragmentPresenterImpl.this.mView.showSnackbar(ListaItemInspecaoFragmentPresenterImpl.this.mView.getString(2131821049), ListaItemInspecaoFragmentPresenterImpl.this.mView.getString(2131820915), new 1(this));
         }

         public void onNext(SchemaItem var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ListaItemInspecaoFragmentPresenterImpl.this.mView.preencher(var1x);
            }
         }

         public void onStart() {
            super.onStart();
            ListaItemInspecaoFragmentPresenterImpl.this.mView.showSwipe(true);
         }
      });
   }

   public void filtrar(final Filtro var1, final int var2, final long var3) {
      Observable var5 = this.interactor.obterPorFiltroPaginadoOff(var1, var2, var3).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ListaItemInspecaoFragmentPresenterImpl$2(Filtro var1x, int var2x, long var3x, View var5) {
            ListaItemInspecaoFragmentPresenterImpl.this.filtrar(var1x, var2x, var3x);
         }

         public void onCompleted() {
            ListaItemInspecaoFragmentPresenterImpl.this.mView.showSwipe(false);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar itens inspecao", var1x);
            ListaItemInspecaoFragmentPresenterImpl.this.mView.showSwipe(false);
            ItemInspecaoView$Lista$Fragment var2x = ListaItemInspecaoFragmentPresenterImpl.this.mView;
            String var3x = ListaItemInspecaoFragmentPresenterImpl.this.mView.getString(2131821058);
            String var4 = ListaItemInspecaoFragmentPresenterImpl.this.mView.getString(2131820915);
            Filtro var5 = var1;
            int var6 = var2;
            long var7 = var3;
            EVZdSsNjAQ8jaq7P2M2_gB3oPwY var9 = new EVZdSsNjAQ8jaq7P2M2_gB3oPwY(this, var5, var6, var7);
            var2x.showSnackbar(var3x, var4, var9);
         }

         public void onNext(SchemaItem var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ListaItemInspecaoFragmentPresenterImpl.this.mView.preencher(var1x);
            }
         }

         public void onStart() {
            super.onStart();
            ListaItemInspecaoFragmentPresenterImpl.this.mView.showSwipe(true);
         }
      };
      var5.subscribe(var6);
   }

   public CardItemInspecao parseItemToCardItem(Item var1) {
      return this.interactor.parseItemToCardItem(var1, true);
   }

   protected Subscriber subscriberAceiteOn(final Long var1, final Long var2, final String var3, final boolean var4, final Long var5) {
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ListaItemInspecaoFragmentPresenterImpl$4(Long var1x, Long var2x, String var3x, Long var4x, View var5x) {
            ListaItemInspecaoFragmentPresenterImpl.this.aceitar(var1x, var2x, var3x, var4x);
         }

         public void onCompleted() {
            ListaItemInspecaoFragmentPresenterImpl.this.showLoad(var4, false);
            App.getContext().startService(DownloadMapsService.newInstance(App.getContext()));
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar detalhe item.", var1x);
            ListaItemInspecaoFragmentPresenterImpl.this.showLoad(var4, false);
            if (var1x instanceof BusinessException) {
               BusinessException var10 = (BusinessException)var1x;
               ListaItemInspecaoFragmentPresenterImpl.this.checkBusinessExpection(var1, var2, var3, var10);
            } else {
               ItemInspecaoView$Lista$Fragment var2x = ListaItemInspecaoFragmentPresenterImpl.this.mView;
               String var3x = ListaItemInspecaoFragmentPresenterImpl.this.mView.getString(2131821121);
               String var4x = ListaItemInspecaoFragmentPresenterImpl.this.mView.getString(2131821238);
               Long var5x = var1;
               Long var6 = var2;
               String var7 = var3;
               Long var8 = var5;
               aNm-BLw4bQxiqhomUhArillb5aM var9 = new aNm-BLw4bQxiqhomUhArillb5aM(this, var5x, var6, var7, var8);
               var2x.showSnackbar(var3x, var4x, var9);
            }
         }

         public void onNext(Item var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ListaItemInspecaoFragmentPresenterImpl.this.mView.onSuccessAceitar(var1x);
            }

         }

         public void onStart() {
            super.onStart();
            ListaItemInspecaoFragmentPresenterImpl.this.showLoad(var4, true);
         }
      };
      return var6;
   }
}
