package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.interactor.CustodiaisInteractor;
import com.brq.inspecao_360_android.interactor.FrustroInteractor;
import com.brq.inspecao_360_android.interactor.ImagemInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.Imagem;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.ItemInspecaoFrustroActivityPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoFrustroActivityPresenterImpl.1.qZHYK3RKh0zxjAWMlMCb1c2o2O4;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoFrustroActivityPresenterImpl.4.yDrAhTR2e5WP90DcUHT-lRJqkg0;
import com.brq.inspecao_360_android.presentantion.presenter.impl.ItemInspecaoFrustroActivityPresenterImpl.3.1;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$Frustro$Activity;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ItemInspecaoFrustroActivityPresenterImpl extends BasePresenterImpl implements ItemInspecaoFrustroActivityPresenter {
   @Inject
   CustodiaisInteractor custodiaisInteractor;
   @Inject
   FrustroInteractor frustroInteractor;
   @Inject
   ImagemInteractor imagemInteractor;
   @Inject
   ItemInspecaoInteractor itemInspecaoInteractor;
   private ItemInspecaoView$Frustro$Activity view;

   @Inject
   public ItemInspecaoFrustroActivityPresenterImpl(ItemInspecaoView var1) {
      super(var1);
      this.view = (ItemInspecaoView$Frustro$Activity)var1;
   }

   private void atualizarCounterBottomNav(Long var1, Long var2, String var3) {
      this.imagemInteractor.obterPorItem(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao carregar contador de imagens.", var1);
         }

         public void onNext(List var1) {
            ItemInspecaoFrustroActivityPresenterImpl.this.view.preencherCounterFab(var1);
         }

         public void onStart() {
            super.onStart();
         }
      });
   }

   public void atualizar(final Long var1, final Long var2, final String var3) {
      this.itemInspecaoInteractor.obterOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoFrustroActivityPresenterImpl$4(Long var1x, Long var2x, String var3x, View var4) {
            ItemInspecaoFrustroActivityPresenterImpl.this.atualizar(var1x, var2x, var3x);
         }

         public void onCompleted() {
            ItemInspecaoFrustroActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.onSuccess();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item frustro.", var1x);
            ItemInspecaoFrustroActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.onError();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131820915), new yDrAhTR2e5WP90DcUHT-lRJqkg0(this, var1, var2, var3));
         }

         public void onNext(Item var1x) {
            ItemInspecaoFrustroActivityPresenterImpl.this.view.preencher(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
      this.atualizarCounterBottomNav(var1, var2, var3);
   }

   public void carregar(final Long var1, final Long var2, final String var3) {
      this.itemInspecaoInteractor.obterOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoFrustroActivityPresenterImpl$1(Long var1x, Long var2x, String var3x, View var4) {
            ItemInspecaoFrustroActivityPresenterImpl.this.atualizar(var1x, var2x, var3x);
         }

         public void onCompleted() {
            ItemInspecaoFrustroActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.onSuccess();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item frustro.", var1x);
            ItemInspecaoFrustroActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.onError();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131820915), new qZHYK3RKh0zxjAWMlMCb1c2o2O4(this, var1, var2, var3));
         }

         public void onNext(Item var1x) {
            ItemInspecaoFrustroActivityPresenterImpl.this.view.preencher(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
      this.atualizarCounterBottomNav(var1, var2, var3);
   }

   public void excluirFotoGaleria(List var1) {
      this.imagemInteractor.excluirPorIdsOff(var1).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriberImagem());
   }

   public void frustrar(final Long var1, final Long var2, final Long var3, final String var4) {
      Observable var5 = this.frustroInteractor.frustrarOff(var1, var2, var3, var4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var6 = new Subscriber() {
         public void onCompleted() {
            ItemInspecaoFrustroActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao salvarOff o frustro.", var1x);
            ItemInspecaoFrustroActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131821066), ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131820915), new 1(this));
         }

         public void onNext(Item var1x) {
            ItemInspecaoFrustroActivityPresenterImpl.this.view.preencher(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131821137));
         }
      };
      var5.subscribe(var6);
   }

   public void iniciar(Long var1, Long var2, String var3) {
      this.interactor.iniciarOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao parar modo inspecao.", var1);
         }

         public void onNext(Item var1) {
            if (!Validator.isNullOrEmpty(var1)) {
               ItemInspecaoFrustroActivityPresenterImpl.this.view.preencher(var1);
            }
         }

         public void onStart() {
            super.onStart();
         }
      });
   }

   public void parar(Long var1, Long var2, Long var3) {
      this.interactor.pararOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao parar modo inspecao.", var1);
         }

         public void onNext(Item var1) {
            if (!Validator.isNullOrEmpty(var1)) {
               ItemInspecaoFrustroActivityPresenterImpl.this.view.preencher(var1);
            }
         }

         public void onStart() {
            super.onStart();
         }
      });
   }

   public void salvar(final Long var1, final Long var2, final Long var3, final String var4) {
      Observable var5 = this.frustroInteractor.frustrarOff(var1, var2, var3, var4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var6 = new Subscriber() {
         public void onCompleted() {
            ItemInspecaoFrustroActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.showToastShortTime(ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131821090));
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao salvarOff o frustro.", var1x);
            ItemInspecaoFrustroActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131821066), ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131820915), new com.brq.inspecao_360_android.presentantion.presenter.impl.ItemInspecaoFrustroActivityPresenterImpl.2.1(this));
         }

         public void onNext(Item var1x) {
            ItemInspecaoFrustroActivityPresenterImpl.this.view.preencher(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131821248));
         }
      };
      var5.subscribe(var6);
   }

   public Subscriber subscriberImagem() {
      return new Subscriber() {
         public void onCompleted() {
            ItemInspecaoFrustroActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao excluir fotografias (galeria).", var1);
            ItemInspecaoFrustroActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131821066));
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
               ItemInspecaoFrustroActivityPresenterImpl.this.view.sendRemoveBroadCast(var1);
            }
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoFrustroActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoFrustroActivityPresenterImpl.this.view.getString(2131821137));
         }
      };
   }
}
