package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.exception.BusinessException;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.interactor.CustodiaisInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.ItemInspecaoDevolverActivityPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoDevolverActivityPresenterImpl.2.5PhlmQFJOJ1wuQTxAIcnv93vRjg;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoDevolverActivityPresenterImpl.4.J869qelUlE7AuvZ96GuYlpmlKe8;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoDevolverActivityPresenterImpl.5.kJxkix9uGNwQEf0IynIUABgl2fE;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoDevolverActivityPresenterImpl.6.QZ80GvBDbsPOPXVK9VnRqlLoVHs;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$Devolver$Activity;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ItemInspecaoDevolverActivityPresenterImpl extends BasePresenterImpl implements ItemInspecaoDevolverActivityPresenter {
   private ItemInspecaoInteractor itemInspecaoInteractor;
   private CustodiaisInteractor mCustodiaisInteractor;
   private ItemInspecaoView$Devolver$Activity mView;

   @Inject
   public ItemInspecaoDevolverActivityPresenterImpl(ItemInspecaoView var1, ItemInspecaoInteractor var2, CustodiaisInteractor var3) {
      super(var1);
      this.mView = (ItemInspecaoView$Devolver$Activity)var1;
      this.itemInspecaoInteractor = var2;
      this.mCustodiaisInteractor = var3;
   }

   private Subscriber subscriber(final Long var1) {
      return new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoDevolverActivityPresenterImpl$6(Long var1x, View var2) {
            ItemInspecaoDevolverActivityPresenterImpl.this.carregar(var1x);
         }

         public void onCompleted() {
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item.", var1x);
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, false);
            ItemInspecaoDevolverActivityPresenterImpl.this.mView.onError((String)null);
            ItemInspecaoDevolverActivityPresenterImpl.this.mView.showSnackbar(ItemInspecaoDevolverActivityPresenterImpl.this.mView.getString(2131821121), ItemInspecaoDevolverActivityPresenterImpl.this.mView.getString(2131821238), new QZ80GvBDbsPOPXVK9VnRqlLoVHs(this, var1));
         }

         public void onNext(List var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ItemInspecaoDevolverActivityPresenterImpl.this.mView.showViewSuccess();
               ItemInspecaoDevolverActivityPresenterImpl.this.mView.preencher(var1x);
            }

         }

         public void onStart() {
            super.onStart();
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, true);
         }
      };
   }

   private Subscriber subscriber(final Long var1, final Long var2, final String var3) {
      return new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoDevolverActivityPresenterImpl$5(Long var1x, Long var2x, String var3x, View var4) {
            ItemInspecaoDevolverActivityPresenterImpl.this.carregar(var1x, var2x, var3x);
         }

         public void onCompleted() {
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item.", var1x);
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, false);
            ItemInspecaoDevolverActivityPresenterImpl.this.mView.onError((String)null);
            if (var1x instanceof BusinessException) {
               BusinessException var2x = (BusinessException)var1x;
               ItemInspecaoDevolverActivityPresenterImpl.this.checkBusinessExpection(var1, var2, var3, var2x);
            } else {
               ItemInspecaoDevolverActivityPresenterImpl.this.mView.showSnackbar(ItemInspecaoDevolverActivityPresenterImpl.this.mView.getString(2131821121), ItemInspecaoDevolverActivityPresenterImpl.this.mView.getString(2131821238), new kJxkix9uGNwQEf0IynIUABgl2fE(this, var1, var2, var3));
            }
         }

         public void onNext(Item var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ItemInspecaoDevolverActivityPresenterImpl.this.mView.showViewSuccess();
               ItemInspecaoDevolverActivityPresenterImpl.this.mView.preencher(var1x);
            }

         }

         public void onStart() {
            super.onStart();
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, true);
         }
      };
   }

   public void atualizar(Long var1, Long var2, String var3) {
      this.itemInspecaoInteractor.obterOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriber(var1, var2, var3));
   }

   public void carregar(Long var1) {
      if (!this.mView.isConnected()) {
         ItemInspecaoView$Devolver$Activity var3 = this.mView;
         var3.showSnackbar(var3.getString(2131821092));
         ItemInspecaoView$Devolver$Activity var4 = this.mView;
         var4.onError(var4.getString(2131821092));
      } else {
         this.itemInspecaoInteractor.obterPorInspecaoOff(var1).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriber(var1));
      }
   }

   public void carregar(Long var1, Long var2, String var3) {
      if (!this.mView.isConnected()) {
         ItemInspecaoView$Devolver$Activity var5 = this.mView;
         var5.showSnackbar(var5.getString(2131821092));
         ItemInspecaoView$Devolver$Activity var6 = this.mView;
         var6.onError(var6.getString(2131821092));
      } else {
         this.itemInspecaoInteractor.obterOffAndOn(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriber(var1, var2, var3));
      }
   }

   public void carregarMotivo() {
      this.mCustodiaisInteractor.obterMotivoDevolucaoOn().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1) {
            ItemInspecaoDevolverActivityPresenterImpl.this.mView.hideKeyboard();
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onNext(List var1) {
            if (!Validator.isNullOrEmpty(var1)) {
               ItemInspecaoDevolverActivityPresenterImpl.this.mView.addAll(var1);
            }

         }

         public void onStart() {
            super.onStart();
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, true);
         }
      });
   }

   public void devolver(final Long var1, final Long var2, final String var3, final Long var4, final String var5) {
      Observable var6 = this.itemInspecaoInteractor.obterOffAndOn(var1, var2);
      Func1 var7 = new Func1() {
         public Observable call(Item var1x) {
            return ItemInspecaoDevolverActivityPresenterImpl.this.itemInspecaoInteractor.devolver(var1, var2, var4, var5);
         }
      };
      Observable var8 = var6.flatMap(var7).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var9 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoDevolverActivityPresenterImpl$2(Long var1x, Long var2x, String var3x, Long var4x, String var5x, View var6) {
            ItemInspecaoDevolverActivityPresenterImpl.this.devolver(var1x, var2x, var3x, var4x, var5x);
         }

         public void onCompleted() {
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1x) {
            Logger.error(var1x.getMessage(), var1x);
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, false);
            if (var1x instanceof BusinessException) {
               BusinessException var11 = (BusinessException)var1x;
               ItemInspecaoDevolverActivityPresenterImpl.this.checkBusinessExpection(var1, var2, var3, var11);
            } else {
               ItemInspecaoView$Devolver$Activity var2x = ItemInspecaoDevolverActivityPresenterImpl.this.mView;
               String var3x = ItemInspecaoDevolverActivityPresenterImpl.this.mView.getString(2131821121);
               String var4x = ItemInspecaoDevolverActivityPresenterImpl.this.mView.getString(2131821238);
               Long var5x = var1;
               Long var6 = var2;
               String var7 = var3;
               Long var8 = var4;
               String var9 = var5;
               5PhlmQFJOJ1wuQTxAIcnv93vRjg var10 = new 5PhlmQFJOJ1wuQTxAIcnv93vRjg(this, var5x, var6, var7, var8, var9);
               var2x.showSnackbar(var3x, var4x, var10);
            }
         }

         public void onNext(Void var1x) {
            ItemInspecaoDevolverActivityPresenterImpl.this.mView.onSuccessDevolver();
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, true);
         }
      };
      var8.subscribe(var9);
   }

   public void devolver(final Long var1, final List var2, final Long var3, final String var4) {
      Observable var5 = this.itemInspecaoInteractor.devolver(var1, var2, var3, var4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoDevolverActivityPresenterImpl$4(Long var1x, List var2x, Long var3x, String var4x, View var5) {
            ItemInspecaoDevolverActivityPresenterImpl.this.devolver(var1x, var2x, var3x, var4x);
         }

         public void onCompleted() {
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, false);
         }

         public void onError(Throwable var1x) {
            Logger.error(var1x.getMessage(), var1x);
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, false);
            ItemInspecaoView$Devolver$Activity var2x = ItemInspecaoDevolverActivityPresenterImpl.this.mView;
            String var3x = ItemInspecaoDevolverActivityPresenterImpl.this.mView.getString(2131821121);
            String var4x = ItemInspecaoDevolverActivityPresenterImpl.this.mView.getString(2131821238);
            Long var5 = var1;
            List var6 = var2;
            Long var7 = var3;
            String var8 = var4;
            J869qelUlE7AuvZ96GuYlpmlKe8 var9 = new J869qelUlE7AuvZ96GuYlpmlKe8(this, var5, var6, var7, var8);
            var2x.showSnackbar(var3x, var4x, var9);
         }

         public void onNext(Void var1x) {
            ItemInspecaoDevolverActivityPresenterImpl.this.mView.onSuccessDevolver();
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoDevolverActivityPresenterImpl.this.showLoad(true, true);
         }
      };
      var5.subscribe(var6);
   }
}
