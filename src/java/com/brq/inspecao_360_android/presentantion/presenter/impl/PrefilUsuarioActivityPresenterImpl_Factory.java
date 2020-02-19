package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.interactor.UsuarioInteractor;
import com.brq.inspecao_360_android.presentantion.view.UsuarioView;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PrefilUsuarioActivityPresenterImpl_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final Provider interactorProvider;
   private final Provider viewProvider;

   public PrefilUsuarioActivityPresenterImpl_Factory(Provider var1, Provider var2) {
      this.viewProvider = var1;
      this.interactorProvider = var2;
   }

   public static Factory create(Provider var0, Provider var1) {
      return new PrefilUsuarioActivityPresenterImpl_Factory(var0, var1);
   }

   public PrefilUsuarioActivityPresenterImpl get() {
      return new PrefilUsuarioActivityPresenterImpl((UsuarioView)this.viewProvider.get(), (UsuarioInteractor)this.interactorProvider.get());
   }
}
