package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.interactor.UsuarioInteractor;
import com.brq.inspecao_360_android.presentantion.view.LoginView;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LoginActivityPresenterImpl_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final Provider interactorProvider;
   private final Provider mViewProvider;

   public LoginActivityPresenterImpl_Factory(Provider var1, Provider var2) {
      this.mViewProvider = var1;
      this.interactorProvider = var2;
   }

   public static Factory create(Provider var0, Provider var1) {
      return new LoginActivityPresenterImpl_Factory(var0, var1);
   }

   public LoginActivityPresenterImpl get() {
      return new LoginActivityPresenterImpl((LoginView)this.mViewProvider.get(), (UsuarioInteractor)this.interactorProvider.get());
   }
}
