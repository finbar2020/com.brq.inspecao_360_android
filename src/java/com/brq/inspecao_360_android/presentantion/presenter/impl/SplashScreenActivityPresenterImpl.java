package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.exception.BusinessException;
import com.brq.inspecao_360_android.common.exception.TokenException;
import com.brq.inspecao_360_android.common.util.DateUtil;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.SharedPreferenceUtil;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.interactor.CustodiaisInteractor;
import com.brq.inspecao_360_android.interactor.UsuarioInteractor;
import com.brq.inspecao_360_android.presentantion.presenter.SplashScreenActivityPresenter;
import com.brq.inspecao_360_android.presentantion.view.SplashScreeView;
import com.brq.inspecao_360_android.presentantion.view.SplashScreeView$Actvity;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Date;
import javax.inject.Inject;
import org.joda.time.Duration;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class SplashScreenActivityPresenterImpl extends BasePresenterImpl implements SplashScreenActivityPresenter {
   private Long mCodigo;
   @Inject
   CustodiaisInteractor mInteractor;
   private SplashScreeView$Actvity mView;
   @Inject
   SharedPreferenceUtil preference;
   @Inject
   UsuarioInteractor usuarioInteractor;

   @Inject
   public SplashScreenActivityPresenterImpl(SplashScreeView var1) {
      super(var1);
      this.mView = (SplashScreeView$Actvity)var1;
   }

   public void atualizar(Long var1, Long var2, String var3) {
      throw new UnsupportedOperationException("Unsupported Operation!");
   }

   public void configurar(String var1, int var2) {
      Observable var3 = this.mInteractor.obterStatusServidor();
      final Observable var4 = this.mInteractor.checkAppUpdate(var2);
      final Observable var5 = this.mInteractor.carregar();
      var3.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
         public void onCompleted() {
         }

         public void onError(Throwable var1) {
            SplashScreenActivityPresenterImpl.this.mView.onSuccess(true);
         }

         public void onNext(JsonObject var1) {
            JsonElement var2 = var1.get("now");
            boolean var3 = Validator.isNullOrEmpty(var2);
            boolean var4x = true;
            if (!var3) {
               Date var6 = DateUtil.toBR(new Date(var2.getAsLong()));
               Date var7 = DateUtil.toBR(new Date());
               Duration var8 = new Duration(var6.getTime(), var7.getTime());
               if (var8.getStandardMinutes() > 30L || var8.getStandardMinutes() < -30L) {
                  var4x = false;
               }
            }

            if (var4x) {
               var4.switchMap(new Func1() {
                  public Observable call(Long var1) {
                     SplashScreenActivityPresenterImpl.this.mCodigo = var1;
                     return var5;
                  }
               }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
                  public void onCompleted() {
                     if (SplashScreenActivityPresenterImpl.this.preference.getFirstUserAccess()) {
                        SplashScreenActivityPresenterImpl.this.preference.setUserFirstAccess(false);
                     }

                     if (SplashScreenActivityPresenterImpl.this.mCodigo == 1L) {
                        SplashScreenActivityPresenterImpl.this.mView.showAvisoUpdateDialog();
                     } else {
                        SplashScreenActivityPresenterImpl.this.mView.onSuccess(false);
                     }
                  }

                  public void onError(Throwable var1) {
                     Logger.error("Erro ao configurar o applicativo.", var1);
                     if (var1 instanceof BusinessException) {
                        if (99 == ((BusinessException)var1).getCodMessage()) {
                           SplashScreenActivityPresenterImpl.this.mView.showAppUpdateDialog();
                           return;
                        }
                     } else {
                        if (var1 instanceof TokenException) {
                           SplashScreenActivityPresenterImpl.this.mView.showToastShortTime(SplashScreenActivityPresenterImpl.this.mView.getString(2131821080));
                           SplashScreenActivityPresenterImpl.this.mView.onError();
                           return;
                        }

                        SplashScreenActivityPresenterImpl.this.mView.showToastShortTime(SplashScreenActivityPresenterImpl.this.mView.getString(2131821066));
                        SplashScreenActivityPresenterImpl.this.mView.onSuccess(true);
                     }

                  }

                  public void onNext(Void var1) {
                  }
               });
            } else {
               SplashScreenActivityPresenterImpl.this.mView.mostrarDialogHoraIncorreta();
            }
         }
      });
   }

   public boolean isFirstAsccess() {
      return this.usuarioInteractor.isFirstAccess();
   }

   public void shouldLogIn(String var1, int var2) {
      this.mInteractor.setIdDispositivo(var1);
      if (Validator.isNullOrEmpty(this.usuarioInteractor.getUsuarioInfo())) {
         this.mView.onError();
      } else {
         if (Validator.isNullOrEmpty(this.usuarioInteractor.getConfiguracaoUsuario())) {
            this.usuarioInteractor.setConfiguracaoInicialUsuario();
         }

         if (!this.mView.isConnected()) {
            this.mView.onSuccess(true);
         } else {
            this.configurar(var1, var2);
         }
      }
   }
}
