package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.interactor.EnquadramentoInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.model.entity.ItemEnquadramento;
import com.brq.inspecao_360_android.presentantion.presenter.ItemInspecaoEnquadrarActivityPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoEnquadrarActivityPresenterImpl.1.nFqNV8CPXID2_I-xgRiXnZw0-Xw;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoEnquadrarActivityPresenterImpl.2.Cqp0yY_JW0kNrrttsSGSslmMqVQ;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoEnquadrarActivityPresenterImpl.4.KJsjYOonIt2NWUfeI_L5JSUmmJQ;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoEnquadrarActivityPresenterImpl.5.MFsfyumyUp9PlxzcFI6GHeusUZ4;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$Enquadramento_inspecao;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ItemInspecaoEnquadrarActivityPresenterImpl extends BasePresenterImpl implements ItemInspecaoEnquadrarActivityPresenter {
   @Inject
   EnquadramentoInteractor enquadramentoInteractor;
   @Inject
   ItemInspecaoInteractor itemInspecaoInteractor;
   private ItemInspecaoView$Enquadramento_inspecao.Activity view;

   @Inject
   public ItemInspecaoEnquadrarActivityPresenterImpl(ItemInspecaoView var1) {
      super(var1);
      this.view = (ItemInspecaoView$Enquadramento_inspecao.Activity)var1;
   }

   public void atualizar(Long var1, Long var2, String var3) {
   }

   public void carregar(final Long var1, final Long var2, Long var3, final String var4) {
      this.enquadramentoInteractor.atualizar(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoEnquadrarActivityPresenterImpl$5(Long var1x, Long var2x, String var3, View var4x) {
            ItemInspecaoEnquadrarActivityPresenterImpl.this.atualizar(var1x, var2x, var3);
         }

         public void onCompleted() {
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item enquadramento.", var1x);
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.onError();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131820915), new MFsfyumyUp9PlxzcFI6GHeusUZ4(this, var1, var2, var4));
         }

         public void onNext(Item var1x) {
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.preencher(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
   }

   public void enquadrarOff(final Long var1, final Long var2, final String var3, final List var4) {
      Observable var5 = this.enquadramentoInteractor.enquadrarOff(var4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoEnquadrarActivityPresenterImpl$2(Long var1x, Long var2x, String var3x, List var4x, View var5) {
            ItemInspecaoEnquadrarActivityPresenterImpl.this.enquadrarOff(var1x, var2x, var3x, var4x);
         }

         public void onCompleted() {
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.atualizar(var2, var1, var3);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao salvar enquadramento.", var1x);
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.onError();
            ItemInspecaoView$Enquadramento_inspecao.Activity var2x = ItemInspecaoEnquadrarActivityPresenterImpl.this.view;
            String var3x = ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131821121);
            String var4x = ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131820915);
            Long var5 = var1;
            Long var6 = var2;
            String var7 = var3;
            List var8 = var4;
            Cqp0yY_JW0kNrrttsSGSslmMqVQ var9 = new Cqp0yY_JW0kNrrttsSGSslmMqVQ(this, var5, var6, var7, var8);
            var2x.showSnackbar(var3x, var4x, var9);
         }

         public void onNext(Void var1x) {
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.showToastLongTime("Enquadramento salvo com sucesso.");
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131821137));
         }
      };
      var5.subscribe(var6);
   }

   public void enquadrarOn(final Long var1, final Long var2, final String var3) {
      this.enquadramentoInteractor.enquadrarOn(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoEnquadrarActivityPresenterImpl$1(Long var1x, Long var2x, String var3x, View var4) {
            ItemInspecaoEnquadrarActivityPresenterImpl.this.enquadrarOn(var1x, var2x, var3x);
         }

         public void onCompleted() {
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao enviar enquadramento para a Web.", var1x);
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.onError();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131820915), new nFqNV8CPXID2_I-xgRiXnZw0-Xw(this, var1, var2, var3));
         }

         public void onNext(Item var1x) {
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.preencher(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
   }

   public void removerEnquadramento(final Long var1, final Long var2, final String var3, final ItemEnquadramento var4) {
      Observable var5 = this.enquadramentoInteractor.removerEnquadramento(var4).switchMap(new Func1() {
         public Observable call(Void var1x) {
            return ItemInspecaoEnquadrarActivityPresenterImpl.this.enquadramentoInteractor.atualizar(var2, var1);
         }
      }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoEnquadrarActivityPresenterImpl$4(Long var1x, Long var2x, String var3x, ItemEnquadramento var4x, View var5) {
            ItemInspecaoEnquadrarActivityPresenterImpl.this.removerEnquadramento(var1x, var2x, var3x, var4x);
         }

         public void onCompleted() {
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.atualizar(var2, var1, var3);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao remover enquadramento.", var1x);
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.onError();
            ItemInspecaoView$Enquadramento_inspecao.Activity var2x = ItemInspecaoEnquadrarActivityPresenterImpl.this.view;
            String var3x = ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131821121);
            String var4x = ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131820915);
            Long var5 = var1;
            Long var6 = var2;
            String var7 = var3;
            ItemEnquadramento var8 = var4;
            KJsjYOonIt2NWUfeI_L5JSUmmJQ var9 = new KJsjYOonIt2NWUfeI_L5JSUmmJQ(this, var5, var6, var7, var8);
            var2x.showSnackbar(var3x, var4x, var9);
         }

         public void onNext(Item var1x) {
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.showToastLongTime("Enquadramento removido com sucesso.");
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.preencher(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoEnquadrarActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoEnquadrarActivityPresenterImpl.this.view.getString(2131821137));
         }
      };
      var5.subscribe(var6);
   }
}
