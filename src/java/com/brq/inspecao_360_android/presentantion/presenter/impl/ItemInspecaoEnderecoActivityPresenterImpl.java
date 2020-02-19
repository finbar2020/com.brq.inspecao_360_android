package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.NetworkEvaluator;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.interactor.EnderecoInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.model.entity.Endereco;
import com.brq.inspecao_360_android.model.entity.Estado;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.ItemInspecaoEnderecoActivityPresenter;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoEnderecoActivityPresenterImpl.1.-NhVIzn4vqWpLL98JCa0aYkQOy8;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoEnderecoActivityPresenterImpl.10.pnDYAuGOzC6QjDM_WJbaye07gGI;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoEnderecoActivityPresenterImpl.4.9Ov8LYZZe2t8ZtWQlFSnHWbFk-4;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoEnderecoActivityPresenterImpl.6.QLcAWJgAbrGvgKp4SRhag7mSyt8;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoEnderecoActivityPresenterImpl.8.VHf5SBqx8GYZnB5dJzTIoCEKyNc;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ItemInspecaoEnderecoActivityPresenterImpl.9.MCXKDDpLBG6Vz3Kc4kWdhxri9xM;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView$Endereco_inspecao;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class ItemInspecaoEnderecoActivityPresenterImpl extends BasePresenterImpl implements ItemInspecaoEnderecoActivityPresenter {
   @Inject
   EnderecoInteractor enderecoInteractor;
   @Inject
   ItemInspecaoInteractor itemInspecaoInteractor;
   private ItemInspecaoView$Endereco_inspecao.Activity view;

   @Inject
   public ItemInspecaoEnderecoActivityPresenterImpl(ItemInspecaoView var1) {
      super(var1);
      this.view = (ItemInspecaoView$Endereco_inspecao.Activity)var1;
   }

   public void alterarEnderecoOff(final Long var1, final Endereco var2) {
      this.enderecoInteractor.alterarEnderecoOff(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoEnderecoActivityPresenterImpl$9(Long var1x, Endereco var2x, View var3) {
            ItemInspecaoEnderecoActivityPresenterImpl.this.alterarEnderecoOff(var1x, var2x);
         }

         public void onCompleted() {
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.showToastLongTime(ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820673));
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao salvar endereco off.", var1x);
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.onError();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820915), new MCXKDDpLBG6Vz3Kc4kWdhxri9xM(this, var1, var2));
         }

         public void onNext(Void var1x) {
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
   }

   public void alterarEnderecoOff(final Long var1, final Long var2, final String var3, final Endereco var4) {
      Observable var5 = this.enderecoInteractor.alterarEnderecoOff(var2, var1, var4).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
      Subscriber var6 = new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoEnderecoActivityPresenterImpl$8(Long var1x, Long var2x, String var3x, Endereco var4x, View var5) {
            ItemInspecaoEnderecoActivityPresenterImpl.this.alterarEnderecoOff(var1x, var2x, var3x, var4x);
         }

         public void onCompleted() {
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao salvar endereco off.", var1x);
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.onError();
            ItemInspecaoView$Endereco_inspecao.Activity var2x = ItemInspecaoEnderecoActivityPresenterImpl.this.view;
            String var3x = ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131821121);
            String var4x = ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820915);
            Long var5 = var1;
            Long var6 = var2;
            String var7 = var3;
            Endereco var8 = var4;
            VHf5SBqx8GYZnB5dJzTIoCEKyNc var9 = new VHf5SBqx8GYZnB5dJzTIoCEKyNc(this, var5, var6, var7, var8);
            var2x.showSnackbar(var3x, var4x, var9);
         }

         public void onNext(Item var1x) {
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.preencher(var1x);
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.showToastLongTime(ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820673));
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131821137));
         }
      };
      var5.subscribe(var6);
   }

   public void atualizar(final Long var1, final Long var2, final String var3) {
      this.enderecoInteractor.atualizar(var1, var2).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoEnderecoActivityPresenterImpl$10(Long var1x, Long var2x, String var3x, View var4) {
            ItemInspecaoEnderecoActivityPresenterImpl.this.atualizar(var1x, var2x, var3x);
         }

         public void onCompleted() {
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item enquadramento.", var1x);
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.onError();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820915), new pnDYAuGOzC6QjDM_WJbaye07gGI(this, var1, var2, var3));
         }

         public void onNext(Item var1x) {
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.preencher(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
   }

   public void carregar(final Long var1) {
      this.itemInspecaoInteractor.obterPorInspecaoOff(var1).switchMap(new Func1() {
         public Observable call(List var1) {
            long var2;
            if (!Validator.isNullOrEmpty(var1)) {
               Iterator var4 = var1.iterator();

               while(var4.hasNext()) {
                  Item var5 = (Item)var4.next();
                  if (!Validator.isNullOrEmpty(var5)) {
                     var2 = var5.getId();
                     ItemInspecaoEnderecoActivityPresenterImpl.this.view.preencher(var5);
                     return Observable.combineLatest(ItemInspecaoEnderecoActivityPresenterImpl.this.enderecoInteractor.obterEstados(), ItemInspecaoEnderecoActivityPresenterImpl.this.enderecoInteractor.obterMunicipios(var2), new Func2() {
                        public Void call(List var1, List var2) {
                           ItemInspecaoEnderecoActivityPresenterImpl.this.view.storeEstados(var1);
                           ItemInspecaoEnderecoActivityPresenterImpl.this.view.storeMunicipios(var2);
                           return null;
                        }
                     });
                  }
               }
            }

            var2 = 0L;
            return Observable.combineLatest(ItemInspecaoEnderecoActivityPresenterImpl.this.enderecoInteractor.obterEstados(), ItemInspecaoEnderecoActivityPresenterImpl.this.enderecoInteractor.obterMunicipios(var2), new Func2() {
               public Void call(List var1, List var2) {
                  ItemInspecaoEnderecoActivityPresenterImpl.this.view.storeEstados(var1);
                  ItemInspecaoEnderecoActivityPresenterImpl.this.view.storeMunicipios(var2);
                  return null;
               }
            });
         }
      }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoEnderecoActivityPresenterImpl$4(Long var1x, View var2) {
            ItemInspecaoEnderecoActivityPresenterImpl.this.carregar(var1x);
         }

         public void onCompleted() {
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.onSuccess();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar Endereco.", var1x);
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.onError();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820915), new 9Ov8LYZZe2t8ZtWQlFSnHWbFk-4(this, var1));
         }

         public void onNext(Void var1x) {
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
   }

   public void carregar(final Long var1, final Long var2, final String var3) {
      Observable var4 = this.enderecoInteractor.obterEstados();
      Observable var5 = this.enderecoInteractor.obterMunicipios(var2);
      final Observable var6 = this.enderecoInteractor.atualizar(var1, var2);
      Observable.combineLatest(var4, var5, new Func2() {
         public Void call(List var1, List var2) {
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.storeEstados(var1);
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.storeMunicipios(var2);
            return null;
         }
      }).switchMap(new Func1() {
         public Observable call(Void var1) {
            return var6;
         }
      }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoEnderecoActivityPresenterImpl$1(Long var1x, Long var2x, String var3x, View var4) {
            ItemInspecaoEnderecoActivityPresenterImpl.this.carregar(var1x, var2x, var3x);
         }

         public void onCompleted() {
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar item enquadramento.", var1x);
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.onError();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820915), new -NhVIzn4vqWpLL98JCa0aYkQOy8(this, var1, var2, var3));
         }

         public void onNext(Item var1x) {
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.preencher(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
   }

   public void carregarMunicipios(final Estado var1) {
      this.enderecoInteractor.obterMunicipios(var1).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         // $FF: synthetic method
         public void lambda$onError$0$ItemInspecaoEnderecoActivityPresenterImpl$6(Estado var1x, View var2) {
            ItemInspecaoEnderecoActivityPresenterImpl.this.carregarMunicipios(var1x);
         }

         public void onCompleted() {
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.hideProgressDialog();
         }

         public void onError(Throwable var1x) {
            Logger.error("Erro ao carregar municipios.", var1x);
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.hideProgressDialog();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.onError();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.showSnackbar(ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131821121), ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820915), new QLcAWJgAbrGvgKp4SRhag7mSyt8(this, var1));
         }

         public void onNext(List var1x) {
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.onSuccess();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.addMunicipiosSpinner(var1x);
         }

         public void onStart() {
            super.onStart();
            ItemInspecaoEnderecoActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131821137));
         }
      });
   }

   public void obterEnderecoPorCep(String var1) {
      if (NetworkEvaluator.isConnected()) {
         this.enderecoInteractor.obterEnderecoPorCep(var1).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
            public void onCompleted() {
               ItemInspecaoEnderecoActivityPresenterImpl.this.view.hideProgressDialog();
            }

            public void onError(Throwable var1) {
               Logger.error("Erro ao carregar endereco pelo cep.", var1);
               ItemInspecaoEnderecoActivityPresenterImpl.this.view.hideProgressDialog();
               ItemInspecaoEnderecoActivityPresenterImpl.this.view.showToastLongTime("Não foi possível encontrar o endereço.");
            }

            public void onNext(Endereco var1) {
               ItemInspecaoEnderecoActivityPresenterImpl.this.view.preencherEndereco(var1);
            }

            public void onStart() {
               super.onStart();
               ItemInspecaoEnderecoActivityPresenterImpl.this.view.showProgessDialog(ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131820595), ItemInspecaoEnderecoActivityPresenterImpl.this.view.getString(2131821135));
            }
         });
      }
   }
}
