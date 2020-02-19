package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.interactor.CroquiInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.Croqui;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.ItemInspecaoCroquiActivityPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoCroquiActivityPresenterImpl.1.YeilRzGM5vm_3VLF7FXBhRTPd0o;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoCroquiActivityPresenterImpl.2.1sdd6eoU_xe-z-1Mh7G_a1FLcwg;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoCroquiActivityPresenterImpl.3.evDLzB9OvAB-2T37XES0M8ltWDQ;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$Croqui_inspecao;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ItemInspecaoCroquiActivityPresenterImpl extends BasePresenterImpl implements ItemInspecaoCroquiActivityPresenter {
   @Inject
   CroquiInteractor croquiInteractor;
   @Inject
   ItemInspecaoInteractor itemInspecaoInteractor;
   private ItemInspecaoView$Croqui_inspecao.Activity view;

   @Inject
   public ItemInspecaoCroquiActivityPresenterImpl(ItemInspecaoView var1) {
      super(var1);
      this.view = (ItemInspecaoView$Croqui_inspecao.Activity)var1;
   }

   public void atualizar(final Long var1, final Long var2, final String var3) {
      this.croquiInteractor.atualizar(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoCroquiActivityPresenterImpl$3(Long var1x, Long var2x, String var3x, View var4) {
            ItemInspecaoCroquiActivityPresenterImpl.this.atualizar(var1x, var2x, var3x);
         }

         public void onCompleted() {
            ItemInspecaoCroquiActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item enquadramento.", var1x);
            ItemInspecaoCroquiActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoCroquiActivityPresenterImpl.this.view.onError();
            ItemInspecaoCroquiActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoCroquiActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoCroquiActivityPresenterImpl.this.view.getString(2131820915), new evDLzB9OvAB-2T37XES0M8ltWDQ(this, var1, var2, var3));
         }

         public void onNext(Item var1x) {
            ItemInspecaoCroquiActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoCroquiActivityPresenterImpl.this.view.preencher(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoCroquiActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoCroquiActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoCroquiActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
   }

   public void carregar(final Long var1, final Long var2, Long var3, final String var4) {
      this.croquiInteractor.atualizar(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoCroquiActivityPresenterImpl$2(Long var1x, Long var2x, String var3, View var4x) {
            ItemInspecaoCroquiActivityPresenterImpl.this.atualizar(var1x, var2x, var3);
         }

         public void onCompleted() {
            ItemInspecaoCroquiActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item enquadramento.", var1x);
            ItemInspecaoCroquiActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoCroquiActivityPresenterImpl.this.view.onError();
            ItemInspecaoCroquiActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoCroquiActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoCroquiActivityPresenterImpl.this.view.getString(2131820915), new 1sdd6eoU_xe-z-1Mh7G_a1FLcwg(this, var1, var2, var4));
         }

         public void onNext(Item var1x) {
            ItemInspecaoCroquiActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoCroquiActivityPresenterImpl.this.view.preencherECarregarMapa(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoCroquiActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoCroquiActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoCroquiActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
   }

   public void obterTiposDemarcacoes(Long var1) {
   }

   public void salvarOff(final Long var1, final Long var2, final String var3, final Croqui var4) {
      Observable var5 = this.croquiInteractor.salvarOff(var1, var4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoCroquiActivityPresenterImpl$1(Long var1x, Long var2x, String var3x, Croqui var4x, View var5) {
            ItemInspecaoCroquiActivityPresenterImpl.this.salvarOff(var1x, var2x, var3x, var4x);
         }

         public void onCompleted() {
            ItemInspecaoCroquiActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoCroquiActivityPresenterImpl.this.atualizar(var2, var1, var3);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao salvar croqui.", var1x);
            ItemInspecaoCroquiActivityPresenterImpl.this.view.onError();
            ItemInspecaoView$Croqui_inspecao.Activity var2x = ItemInspecaoCroquiActivityPresenterImpl.this.view;
            String var3x = ItemInspecaoCroquiActivityPresenterImpl.this.view.getString(2131821121);
            String var4x = ItemInspecaoCroquiActivityPresenterImpl.this.view.getString(2131820915);
            Long var5 = var1;
            Long var6 = var2;
            String var7 = var3;
            Croqui var8 = var4;
            YeilRzGM5vm_3VLF7FXBhRTPd0o var9 = new YeilRzGM5vm_3VLF7FXBhRTPd0o(this, var5, var6, var7, var8);
            var2x.showSnackbar(var3x, var4x, var9);
         }

         public void onNext(Void var1x) {
         }

         public void onStart() {
            super.onStart();
         }
      };
      var5.subscribe(var6);
   }

   public void salvarOn(Long var1, Long var2, String var3) {
   }
}
