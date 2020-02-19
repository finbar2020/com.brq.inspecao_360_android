package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.interactor.AssinaturaInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.Assinatura;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.ItemInspecaoAssinaturaActivityPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoAssinaturaActivityPresenterImpl.1.BrECXE0e47jqX1E5nwZJ3rmTz5E;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoAssinaturaActivityPresenterImpl.2.I3KV56fYNRkKdoy8mlWwGGpVaPY;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoAssinaturaActivityPresenterImpl.3.Vx9IkD1eTdvTBwPFlfTLmEelLGg;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoAssinaturaActivityPresenterImpl.4.V_QNH79bHGk-oCi1wyJuff0dCNo;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$Assinatura_inspecao;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ItemInspecaoAssinaturaActivityPresenterImpl extends BasePresenterImpl implements ItemInspecaoAssinaturaActivityPresenter {
   @Inject
   AssinaturaInteractor assinaturaInteractor;
   @Inject
   ItemInspecaoInteractor itemInspecaoInteractor;
   private ItemInspecaoView$Assinatura_inspecao.Activity view;

   @Inject
   public ItemInspecaoAssinaturaActivityPresenterImpl(ItemInspecaoView var1) {
      super(var1);
      this.view = (ItemInspecaoView$Assinatura_inspecao.Activity)var1;
   }

   public void atualizar(final Long var1, final Long var2, final String var3) {
      this.assinaturaInteractor.atualizar(var1, var2, 3).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoAssinaturaActivityPresenterImpl$4(Long var1x, Long var2x, String var3x, View var4) {
            ItemInspecaoAssinaturaActivityPresenterImpl.this.atualizar(var1x, var2x, var3x);
         }

         public void onCompleted() {
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item enquadramento.", var1x);
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.onError();
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131820915), new V_QNH79bHGk-oCi1wyJuff0dCNo(this, var1, var2, var3));
         }

         public void onNext(Item var1x) {
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.preencher(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
   }

   public void carregar(final Long var1, final Long var2, final Long var3, final String var4, final int var5) {
      Observable var6 = this.assinaturaInteractor.atualizar(var1, var2, var5).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var7 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoAssinaturaActivityPresenterImpl$3(Long var1x, Long var2x, Long var3x, String var4x, int var5x, View var6) {
            ItemInspecaoAssinaturaActivityPresenterImpl.this.carregar(var1x, var2x, var3x, var4x, var5x);
         }

         public void onCompleted() {
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item enquadramento.", var1x);
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.onError();
            ItemInspecaoView$Assinatura_inspecao.Activity var2x = ItemInspecaoAssinaturaActivityPresenterImpl.this.view;
            String var3x = ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131821121);
            String var4x = ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131820915);
            Long var5x = var1;
            Long var6 = var2;
            Long var7 = var3;
            String var8 = var4;
            int var9 = var5;
            Vx9IkD1eTdvTBwPFlfTLmEelLGg var10 = new Vx9IkD1eTdvTBwPFlfTLmEelLGg(this, var5x, var6, var7, var8, var9);
            var2x.showSnackbar(var3x, var4x, var10);
         }

         public void onNext(Item var1x) {
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.preencher(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131821137));
         }
      };
      var6.subscribe(var7);
   }

   public void salvarOff(final Long var1, final Long var2, final String var3, final Assinatura var4) {
      Observable var5 = this.assinaturaInteractor.salvarOff(var1, var2, var3, var4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoAssinaturaActivityPresenterImpl$2(Long var1x, Long var2x, String var3x, Assinatura var4x, View var5) {
            ItemInspecaoAssinaturaActivityPresenterImpl.this.salvarOff(var1x, var2x, var3x, var4x);
         }

         public void onCompleted() {
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoAssinaturaActivityPresenterImpl.this.atualizar(var2, var1, var3);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao salvar enquadramento.", var1x);
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.onError();
            ItemInspecaoView$Assinatura_inspecao.Activity var2x = ItemInspecaoAssinaturaActivityPresenterImpl.this.view;
            String var3x = ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131821121);
            String var4x = ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131820915);
            Long var5 = var1;
            Long var6 = var2;
            String var7 = var3;
            Assinatura var8 = var4;
            I3KV56fYNRkKdoy8mlWwGGpVaPY var9 = new I3KV56fYNRkKdoy8mlWwGGpVaPY(this, var5, var6, var7, var8);
            var2x.showSnackbar(var3x, var4x, var9);
         }

         public void onNext(Assinatura var1x) {
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.showToastLongTime("Assinatura salva com sucesso.");
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131821137));
         }
      };
      var5.subscribe(var6);
   }

   public void salvarOn(Long var1, Long var2, String var3) {
   }

   public void savarRecusa(final Long var1, final Long var2, final String var3, final Assinatura var4) {
      Observable var5 = this.assinaturaInteractor.salvarOff(var1, var2, var3, var4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoAssinaturaActivityPresenterImpl$1(Long var1x, Long var2x, String var3x, Assinatura var4x, View var5) {
            ItemInspecaoAssinaturaActivityPresenterImpl.this.savarRecusa(var1x, var2x, var3x, var4x);
         }

         public void onCompleted() {
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.onSuccessSalvarRecusa();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao recusa de assinatura.", var1x);
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.onError();
            ItemInspecaoView$Assinatura_inspecao.Activity var2x = ItemInspecaoAssinaturaActivityPresenterImpl.this.view;
            String var3x = ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131821121);
            String var4x = ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131820915);
            Long var5 = var1;
            Long var6 = var2;
            String var7 = var3;
            Assinatura var8 = var4;
            BrECXE0e47jqX1E5nwZJ3rmTz5E var9 = new BrECXE0e47jqX1E5nwZJ3rmTz5E(this, var5, var6, var7, var8);
            var2x.showSnackbar(var3x, var4x, var9);
         }

         public void onNext(Assinatura var1x) {
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.showToastLongTime("Procedimento realizado com sucesso.");
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoAssinaturaActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoAssinaturaActivityPresenterImpl.this.view.getString(2131821137));
         }
      };
      var5.subscribe(var6);
   }
}
