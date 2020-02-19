package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.exception.BusinessException;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.interactor.CustodiaisInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.ItemInspecaoRecusaActivityPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoRecusaActivityPresenterImpl.1.HDbt1Qsm7J48EqoCltfcuFkEKKo;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoRecusaActivityPresenterImpl.2.QgDIiFdMA4Jx9wc7qzAyFOso19I;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoRecusaActivityPresenterImpl.4.DG2bxkQMHtP0ZUrh0p7WPBapG4U;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoRecusaActivityPresenterImpl.5.loyzxhP7nAs1cH20mn_bcsAEcCY;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoRecusaActivityPresenterImpl.6.M_Fm_fyJml2bsuhF8LkAEpspD-o;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$Recusa$Activity;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ItemInspecaoRecusaActivityPresenterImpl extends BasePresenterImpl implements ItemInspecaoRecusaActivityPresenter {
   private ItemInspecaoInteractor itemInspecaoInteractor;
   private CustodiaisInteractor mCustodiaisInteractor;
   private ItemInspecaoView$Recusa$Activity mView;

   @Inject
   public ItemInspecaoRecusaActivityPresenterImpl(ItemInspecaoView var1, ItemInspecaoInteractor var2, CustodiaisInteractor var3) {
      super(var1);
      this.mView = (ItemInspecaoView$Recusa$Activity)var1;
      this.itemInspecaoInteractor = var2;
      this.mCustodiaisInteractor = var3;
   }

   private Subscriber subscriber(final Long var1) {
      return new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoRecusaActivityPresenterImpl$6(Long var1x, View var2) {
            ItemInspecaoRecusaActivityPresenterImpl.this.carregar(var1x);
         }

         public void onCompleted() {
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item.", var1x);
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, false);
            ItemInspecaoRecusaActivityPresenterImpl.this.mView.onError((String)null);
            ItemInspecaoRecusaActivityPresenterImpl.this.mView.showSnackbar(ItemInspecaoRecusaActivityPresenterImpl.this.mView.getString(2131821121), ItemInspecaoRecusaActivityPresenterImpl.this.mView.getString(2131821238), new M_Fm_fyJml2bsuhF8LkAEpspD-o(this, var1));
         }

         public void onNext(List var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ItemInspecaoRecusaActivityPresenterImpl.this.mView.showViewSuccess();
               ItemInspecaoRecusaActivityPresenterImpl.this.mView.preencher(var1x);
            }

         }

         public void onStart() {
            super.onStart();
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, true);
         }
      };
   }

   private Subscriber subscriber(final Long var1, final Long var2, final String var3) {
      return new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoRecusaActivityPresenterImpl$5(Long var1x, Long var2x, String var3x, View var4) {
            ItemInspecaoRecusaActivityPresenterImpl.this.carregar(var1x, var2x, var3x);
         }

         public void onCompleted() {
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item.", var1x);
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, false);
            ItemInspecaoRecusaActivityPresenterImpl.this.mView.onError((String)null);
            if (var1x instanceof BusinessException) {
               BusinessException var2x = (BusinessException)var1x;
               ItemInspecaoRecusaActivityPresenterImpl.this.checkBusinessExpection(var1, var2, var3, var2x);
            } else {
               ItemInspecaoRecusaActivityPresenterImpl.this.mView.showSnackbar(ItemInspecaoRecusaActivityPresenterImpl.this.mView.getString(2131821121), ItemInspecaoRecusaActivityPresenterImpl.this.mView.getString(2131821238), new loyzxhP7nAs1cH20mn_bcsAEcCY(this, var1, var2, var3));
            }
         }

         public void onNext(Item var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ItemInspecaoRecusaActivityPresenterImpl.this.mView.showViewSuccess();
               ItemInspecaoRecusaActivityPresenterImpl.this.mView.preencher(var1x);
            }

         }

         public void onStart() {
            super.onStart();
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, true);
         }
      };
   }

   public void atualizar(Long var1, Long var2, String var3) {
      this.itemInspecaoInteractor.obterOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriber(var1, var2, var3));
   }

   public void carregar(Long var1) {
      if (!this.mView.isConnected()) {
         ItemInspecaoView$Recusa$Activity var3 = this.mView;
         var3.showSnackbar(var3.getString(2131821092));
         ItemInspecaoView$Recusa$Activity var4 = this.mView;
         var4.onError(var4.getString(2131821092));
      } else {
         this.itemInspecaoInteractor.obterPorInspecaoOff(var1).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriber(var1));
      }
   }

   public void carregar(Long var1, Long var2, String var3) {
      if (!this.mView.isConnected()) {
         ItemInspecaoView$Recusa$Activity var5 = this.mView;
         var5.showSnackbar(var5.getString(2131821092));
         ItemInspecaoView$Recusa$Activity var6 = this.mView;
         var6.onError(var6.getString(2131821092));
      } else {
         this.itemInspecaoInteractor.obterOffAndOn(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriber(var1, var2, var3));
      }
   }

   public void carregarMotivo() {
      this.mCustodiaisInteractor.obterMotivoRecusaOff().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoRecusaActivityPresenterImpl$1(View var1) {
            ItemInspecaoRecusaActivityPresenterImpl.this.carregarMotivo();
         }

         public void onCompleted() {
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1) {
            Logger.error("Erro ao carregar motivos de recusa.", var1);
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, false);
            ItemInspecaoRecusaActivityPresenterImpl.this.mView.showSnackbar(ItemInspecaoRecusaActivityPresenterImpl.this.mView.getString(2131821121), ItemInspecaoRecusaActivityPresenterImpl.this.mView.getString(2131821238), new HDbt1Qsm7J48EqoCltfcuFkEKKo(this));
         }

         public void onNext(List var1) {
            if (!Validator.isNullOrEmpty(var1)) {
               ItemInspecaoRecusaActivityPresenterImpl.this.mView.addAll(var1);
            }

         }

         public void onStart() {
            super.onStart();
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, true);
         }
      });
   }

   public void recusar(final Long var1, final Long var2, final String var3, final Long var4, final String var5) {
      Observable var6 = this.itemInspecaoInteractor.obterOffAndOn(var1, var2);
      Func1 var7 = new Func1() {
         public Observable call(Item var1x) {
            return ItemInspecaoRecusaActivityPresenterImpl.this.itemInspecaoInteractor.recusar(var1, var2, var4, var5);
         }
      };
      Observable var8 = var6.flatMap(var7).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var9 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoRecusaActivityPresenterImpl$2(Long var1x, Long var2x, String var3x, Long var4x, String var5x, View var6) {
            ItemInspecaoRecusaActivityPresenterImpl.this.recusar(var1x, var2x, var3x, var4x, var5x);
         }

         public void onCompleted() {
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1x) {
            Logger.error(var1x.getMessage(), var1x);
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, false);
            if (var1x instanceof BusinessException) {
               BusinessException var11 = (BusinessException)var1x;
               ItemInspecaoRecusaActivityPresenterImpl.this.checkBusinessExpection(var1, var2, var3, var11);
            } else {
               ItemInspecaoView$Recusa$Activity var2x = ItemInspecaoRecusaActivityPresenterImpl.this.mView;
               String var3x = ItemInspecaoRecusaActivityPresenterImpl.this.mView.getString(2131821121);
               String var4x = ItemInspecaoRecusaActivityPresenterImpl.this.mView.getString(2131821238);
               Long var5x = var1;
               Long var6 = var2;
               String var7 = var3;
               Long var8 = var4;
               String var9 = var5;
               QgDIiFdMA4Jx9wc7qzAyFOso19I var10 = new QgDIiFdMA4Jx9wc7qzAyFOso19I(this, var5x, var6, var7, var8, var9);
               var2x.showSnackbar(var3x, var4x, var10);
            }
         }

         public void onNext(Void var1x) {
            ItemInspecaoRecusaActivityPresenterImpl.this.mView.onSuccessRecusa();
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, true);
         }
      };
      var8.subscribe(var9);
   }

   public void recusar(final Long var1, final List var2, final Long var3, final String var4) {
      Observable var5 = this.itemInspecaoInteractor.recusar(var1, var2, var3, var4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoRecusaActivityPresenterImpl$4(Long var1x, List var2x, Long var3x, String var4x, View var5) {
            ItemInspecaoRecusaActivityPresenterImpl.this.recusar(var1x, var2x, var3x, var4x);
         }

         public void onCompleted() {
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1x) {
            Logger.error(var1x.getMessage(), var1x);
            ItemInspecaoRecusaActivityPresenterImpl.this.mView.hideKeyboard();
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, false);
            ItemInspecaoView$Recusa$Activity var2x = ItemInspecaoRecusaActivityPresenterImpl.this.mView;
            String var3x = ItemInspecaoRecusaActivityPresenterImpl.this.mView.getString(2131821121);
            String var4x = ItemInspecaoRecusaActivityPresenterImpl.this.mView.getString(2131821238);
            Long var5 = var1;
            List var6 = var2;
            Long var7 = var3;
            String var8 = var4;
            DG2bxkQMHtP0ZUrh0p7WPBapG4U var9 = new DG2bxkQMHtP0ZUrh0p7WPBapG4U(this, var5, var6, var7, var8);
            var2x.showSnackbar(var3x, var4x, var9);
         }

         public void onNext(Void var1x) {
            ItemInspecaoRecusaActivityPresenterImpl.this.mView.onSuccessRecusa();
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoRecusaActivityPresenterImpl.this.showLoad(true, true);
         }
      };
      var5.subscribe(var6);
   }
}
