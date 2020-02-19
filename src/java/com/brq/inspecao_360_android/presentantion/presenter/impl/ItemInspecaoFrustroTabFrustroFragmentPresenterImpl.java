package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.interactor.CustodiaisInteractor;
import com.brq.inspecao_360_android.interactor.FrustroInteractor;
import com.brq.inspecao_360_android.interactor.ImagemInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.ItemInspecaoFrustroTabFrustroFragmentPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.5.SVcjkb63OmfluGV02m12NzoiS8Q;
import com.brq.inspecao_360_android.presentantion.presenter.impl.ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.4.1;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$Frustro$TabFrustro;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ItemInspecaoFrustroTabFrustroFragmentPresenterImpl extends BasePresenterImpl implements ItemInspecaoFrustroTabFrustroFragmentPresenter {
   @Inject
   CustodiaisInteractor custodiaisInteractor;
   @Inject
   FrustroInteractor frustroInteractor;
   @Inject
   ImagemInteractor imagemInteractor;
   @Inject
   ItemInspecaoInteractor itemInspecaoInteractor;
   private ItemInspecaoView$Frustro$TabFrustro.Fragment view;

   @Inject
   public ItemInspecaoFrustroTabFrustroFragmentPresenterImpl(ItemInspecaoView var1) {
      super(var1);
      this.view = (ItemInspecaoView$Frustro$TabFrustro.Fragment)var1;
   }

   private void atualizarCounterBottomNav(Long var1, Long var2, String var3) {
      this.imagemInteractor.obterPorItem(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao carregar contador de imagens.", var1);
         }

         public void onNext(List var1) {
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.preencherCounterFab(var1);
         }

         public void onStart() {
            super.onStart();
         }
      });
   }

   public void atualizar(final Long var1, final Long var2, final String var3) {
      this.itemInspecaoInteractor.obterOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoFrustroTabFrustroFragmentPresenterImpl$5(Long var1x, Long var2x, String var3x, View var4) {
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.atualizar(var1x, var2x, var3x);
         }

         public void onCompleted() {
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.onSuccess();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item frustro.", var1x);
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.onError();
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.showSnackbar(ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.getString(2131821121), ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.getString(2131820915), new SVcjkb63OmfluGV02m12NzoiS8Q(this, var1, var2, var3));
         }

         public void onNext(Item var1x) {
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.preencher(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.showProgessDialog(ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.getString(2131820595), ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.getString(2131821137));
         }
      });
   }

   public void carregar(Long var1, Long var2, String var3) {
      this.custodiaisInteractor.obterMotivoFrustroOff().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.showProgress(false);
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao carregar motivo frustro.", var1);
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.showProgress(false);
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.onError();
         }

         public void onNext(List var1) {
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.addMotivos(var1);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.showProgress(true);
         }
      });
      this.atualizar(var1, var2, var3);
      this.atualizarCounterBottomNav(var1, var2, var3);
   }

   public void frustrar(final Long var1, final Long var2, final Long var3, final String var4) {
      Observable var5 = this.frustroInteractor.frustrarOff(var1, var2, var3, var4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var6 = new Subscriber() {
         public void onCompleted() {
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.frustrar();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao salvarOff o frustro.", var1x);
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.showSnackbar(ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.getString(2131821066), ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.getString(2131820915), new 1(this));
         }

         public void onNext(Item var1x) {
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.preencher(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.showProgessDialog(ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.getString(2131820595), ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.getString(2131821137));
         }
      };
      var5.subscribe(var6);
   }

   public void salvar(final Long var1, final Long var2, final Long var3, final String var4) {
      Observable var5 = this.frustroInteractor.frustrarOff(var1, var2, var3, var4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var6 = new Subscriber() {
         public void onCompleted() {
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.showToastShortTime(ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.getString(2131821090));
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao salvarOff o frustro.", var1x);
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.showSnackbar(ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.getString(2131821066), ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.getString(2131820915), new com.brq.inspecao_360_android.presentantion.presenter.impl.ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.2.1(this));
         }

         public void onNext(Item var1x) {
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.preencher(var1x);
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.salvarSucesso();
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.showProgessDialog(ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.getString(2131820595), ItemInspecaoFrustroTabFrustroFragmentPresenterImpl.this.view.getString(2131821248));
         }
      };
      var5.subscribe(var6);
   }
}
