package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.util.SparseArray;
import android.view.View;
import com.brq.inspecao_360_android.common.exception.IntegrationException;
import com.brq.inspecao_360_android.common.service.DownloadMapsService;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.configuration.di.App;
import com.brq.inspecao_360_android.interactor.ChecklistInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.Checklist;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.ItemInspecaoListaGrupoActivityPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoListaGrupoActivityPresenterImpl.3.efwJ5XsHau3oWyqv-DJLqI8NhP4;
import com.brq.inspecao_360_android.presentantion.presenter.impl.ItemInspecaoListaGrupoActivityPresenterImpl.1.1;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$ListaGrupo$Activity;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ItemInspecaoListaGrupoActivityPresenterImpl extends BasePresenterImpl implements ItemInspecaoListaGrupoActivityPresenter {
   @Inject
   protected ChecklistInteractor checklistInteractor;
   @Inject
   ItemInspecaoInteractor interactor;
   private ItemInspecaoView$ListaGrupo$Activity mView;

   @Inject
   public ItemInspecaoListaGrupoActivityPresenterImpl(ItemInspecaoView var1) {
      super(var1);
      this.mView = (ItemInspecaoView$ListaGrupo$Activity)var1;
   }

   private void downloadChecklists(final SparseArray var1) {
      if (!Validator.isNullOrEmpty(var1)) {
         int var2 = var1.keyAt(0);
         if (!Validator.isNullOrEmpty(var1.get(var2))) {
            this.checklistInteractor.obterOn((Long)var1.get(var2)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
               public void onCompleted() {
                  ItemInspecaoListaGrupoActivityPresenterImpl.this.downloadChecklists(var1);
               }

               public void onError(Throwable var1x) {
                  Logger.error("Erro ao carregar checklist - AtualizarListaInspecaoIntentService", var1x);
               }

               public void onNext(Checklist var1x) {
                  var1.remove(var1x.getId().intValue());
               }
            });
         }
      }

   }

   public void aceitar(Long var1, List var2) {
      if (!this.mView.isConnected()) {
         ItemInspecaoView$ListaGrupo$Activity var12 = this.mView;
         var12.showSnackbar(var12.getString(2131821092));
      } else {
         IntegrationException var10000;
         label56: {
            SparseArray var3;
            Iterator var5;
            boolean var10001;
            try {
               var3 = new SparseArray();
               var5 = var2.iterator();
            } catch (IntegrationException var15) {
               var10000 = var15;
               var10001 = false;
               break label56;
            }

            label55:
            while(true) {
               try {
                  if (var5.hasNext()) {
                     Item var11 = (Item)var5.next();
                     var3.put(var11.getChecklistId().intValue(), var11.getChecklistId());
                     continue;
                  }
               } catch (IntegrationException var16) {
                  var10000 = var16;
                  var10001 = false;
                  break;
               }

               int var6 = 0;

               while(true) {
                  try {
                     if (var6 >= var3.size()) {
                        break;
                     }

                     int var8 = var3.keyAt(var6);
                     if (!Validator.isNullOrEmpty(var3.get(var8))) {
                        long var9 = (Long)var3.get(var8);
                        if (this.checklistInteractor.hasChecklist(var9)) {
                           var3.remove(var8);
                        }
                     }
                  } catch (IntegrationException var14) {
                     var10000 = var14;
                     var10001 = false;
                     break label55;
                  }

                  ++var6;
               }

               try {
                  this.interactor.aceitar(var1, var2, (String)null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.subscriberAceiteOn(var1, var2, true, var3));
                  return;
               } catch (IntegrationException var13) {
                  var10000 = var13;
                  var10001 = false;
                  break;
               }
            }
         }

         IntegrationException var4 = var10000;
         Logger.error("Não foi possível carregar o processar. - ItemInspecaoDetalheActivityPresenterImpl", var4);
      }
   }

   public void atualizar(Long var1, Long var2, String var3) {
   }

   public void carregar(final long var1) {
      this.interactor.obterPorInspecaoOff(var1).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
         }

         public void onError(Throwable var1x) {
            ItemInspecaoListaGrupoActivityPresenterImpl.this.mView.showSnackbar(ItemInspecaoListaGrupoActivityPresenterImpl.this.mView.getString(2131821049), ItemInspecaoListaGrupoActivityPresenterImpl.this.mView.getString(2131820915), new 1(this));
         }

         public void onNext(List var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ItemInspecaoListaGrupoActivityPresenterImpl.this.mView.preencher(var1x);
            }
         }

         public void onStart() {
            super.onStart();
         }
      });
   }

   protected Subscriber subscriberAceiteOn(final Long var1, final List var2, final boolean var3, final SparseArray var4) {
      Subscriber var5 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoListaGrupoActivityPresenterImpl$3(Long var1x, List var2x, View var3x) {
            ItemInspecaoListaGrupoActivityPresenterImpl.this.aceitar(var1x, var2x);
         }

         public void onCompleted() {
            ItemInspecaoListaGrupoActivityPresenterImpl.this.downloadChecklists(var4);
            ItemInspecaoListaGrupoActivityPresenterImpl.this.showLoad(var3, false);
            App.getContext().startService(DownloadMapsService.newInstance(App.getContext()));
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar detalhe item.", var1x);
            ItemInspecaoListaGrupoActivityPresenterImpl.this.showLoad(var3, false);
            ItemInspecaoListaGrupoActivityPresenterImpl.this.mView.showSnackbar(ItemInspecaoListaGrupoActivityPresenterImpl.this.mView.getString(2131821121), ItemInspecaoListaGrupoActivityPresenterImpl.this.mView.getString(2131821238), new efwJ5XsHau3oWyqv-DJLqI8NhP4(this, var1, var2));
         }

         public void onNext(List var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ItemInspecaoListaGrupoActivityPresenterImpl.this.mView.carregar(true);
            }

         }

         public void onStart() {
            super.onStart();
            ItemInspecaoListaGrupoActivityPresenterImpl.this.showLoad(var3, true);
         }
      };
      return var5;
   }
}
