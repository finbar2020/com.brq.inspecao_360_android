package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.util.SparseArray;
import android.view.View;
import com.brq.inspecao_360_android.common.exception.IntegrationException;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.interactor.ChecklistInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.CardItemInspecao;
import com.brq.inspecao_360_android.model.entity.Checklist;
import com.brq.inspecao_360_android.model.entity.Filtro;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.model.entity.SchemaItem;
import com.brq.inspecao_360_android.presentantion.presenter.ListaGrupoItemInspecaoFragmentPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ListaGrupoItemInspecaoFragmentPresenterImpl.3.WaiDDlOOO7gb5V0_DfzNFmhfeCs;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ListaGrupoItemInspecaoFragmentPresenterImpl.5.z2xLogBarz2koe4DgG1rljSXACE;
import com.brq.inspecao_360_android.presentantion.presenter.impl.ListaGrupoItemInspecaoFragmentPresenterImpl.1.1;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$ListaGrupo$Activity;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$ListaGrupo$Fragment;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ListaGrupoItemInspecaoFragmentPresenterImpl extends BasePresenterImpl implements ListaGrupoItemInspecaoFragmentPresenter {
   @Inject
   ChecklistInteractor checklistInteractor;
   @Inject
   ItemInspecaoInteractor interactor;
   private ItemInspecaoView$ListaGrupo$Activity mActivityView;
   private ItemInspecaoView$ListaGrupo$Fragment mView;

   @Inject
   public ListaGrupoItemInspecaoFragmentPresenterImpl(ItemInspecaoView var1) {
      super(var1);
      if (var1 instanceof ItemInspecaoView$ListaGrupo$Fragment) {
         this.mView = (ItemInspecaoView$ListaGrupo$Fragment)var1;
      } else {
         this.mActivityView = (ItemInspecaoView$ListaGrupo$Activity)var1;
      }
   }

   private void downloadChecklists(final SparseArray var1) {
      if (!Validator.isNullOrEmpty(var1)) {
         int var2 = var1.keyAt(0);
         if (!Validator.isNullOrEmpty(var1.get(var2))) {
            this.checklistInteractor.obterOn((Long)var1.get(var2)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
               public void onCompleted() {
                  ListaGrupoItemInspecaoFragmentPresenterImpl.this.downloadChecklists(var1);
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
         ItemInspecaoView$ListaGrupo$Fragment var12 = this.mView;
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

   public void carregar(final int var1, final long var2) {
      this.interactor.obterPaginadoOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.showSwipe(false);
         }

         public void onError(Throwable var1x) {
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.showSwipe(false);
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.showSnackbar(ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.getString(2131821049), ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.getString(2131820915), new 1(this));
         }

         public void onNext(SchemaItem var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.preencher(var1x);
            }
         }

         public void onStart() {
            super.onStart();
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.showSwipe(true);
         }
      });
   }

   public void carregarTodosOsItens(final long var1) {
      this.interactor.obterPorInspecaoOff(var1).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
         }

         public void onError(Throwable var1x) {
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.mActivityView.showSnackbar(ListaGrupoItemInspecaoFragmentPresenterImpl.this.mActivityView.getString(2131821049), ListaGrupoItemInspecaoFragmentPresenterImpl.this.mActivityView.getString(2131820915), new com.brq.inspecao_360_android.presentantion.presenter.impl.ListaGrupoItemInspecaoFragmentPresenterImpl.2.1(this));
         }

         public void onNext(List var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ListaGrupoItemInspecaoFragmentPresenterImpl.this.mActivityView.preencher(var1x);
            }
         }

         public void onStart() {
            super.onStart();
         }
      });
   }

   public void filtrar(final Filtro var1, final int var2, final long var3, final long var5) {
      Observable var7 = this.interactor.obterPorFiltroPaginadoOff(var1, var2, var3, var5).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var8 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ListaGrupoItemInspecaoFragmentPresenterImpl$3(Filtro var1x, int var2x, long var3x, long var5x, View var7) {
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.filtrar(var1x, var2x, var3x, var5x);
         }

         public void onCompleted() {
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.showSwipe(false);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar itens inspecao", var1x);
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.showSwipe(false);
            ItemInspecaoView$ListaGrupo$Fragment var2x = ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView;
            String var3x = ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.getString(2131821058);
            String var4 = ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.getString(2131820915);
            Filtro var5x = var1;
            int var6 = var2;
            long var7 = var3;
            long var9 = var5;
            WaiDDlOOO7gb5V0_DfzNFmhfeCs var11 = new WaiDDlOOO7gb5V0_DfzNFmhfeCs(this, var5x, var6, var7, var9);
            var2x.showSnackbar(var3x, var4, var11);
         }

         public void onNext(SchemaItem var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.preencher(var1x);
            }
         }

         public void onStart() {
            super.onStart();
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.showSwipe(true);
         }
      };
      var7.subscribe(var8);
   }

   public CardItemInspecao parseItemToCardItem(Item var1) {
      return this.interactor.parseItemToCardItem(var1, false);
   }

   protected Subscriber subscriberAceiteOn(final Long var1, final List var2, final boolean var3, final SparseArray var4) {
      Subscriber var5 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ListaGrupoItemInspecaoFragmentPresenterImpl$5(Long var1x, List var2x, View var3x) {
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.aceitar(var1x, var2x);
         }

         public void onCompleted() {
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.downloadChecklists(var4);
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.showLoad(var3, false);
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar detalhe item.", var1x);
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.showLoad(var3, false);
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.showSnackbar(ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.getString(2131821121), ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.getString(2131821238), new z2xLogBarz2koe4DgG1rljSXACE(this, var1, var2));
         }

         public void onNext(List var1x) {
            if (!Validator.isNullOrEmpty(var1x)) {
               ListaGrupoItemInspecaoFragmentPresenterImpl.this.mView.onSuccessAceitar(true);
            }

         }

         public void onStart() {
            super.onStart();
            ListaGrupoItemInspecaoFragmentPresenterImpl.this.showLoad(var3, true);
         }
      };
      return var5;
   }
}
