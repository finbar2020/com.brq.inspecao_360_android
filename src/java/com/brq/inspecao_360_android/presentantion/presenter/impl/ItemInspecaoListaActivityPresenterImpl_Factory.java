package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.interactor.UsuarioInteractor;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ItemInspecaoListaActivityPresenterImpl_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final Provider usuarioInteractorProvider;
   private final Provider viewProvider;

   public ItemInspecaoListaActivityPresenterImpl_Factory(Provider var1, Provider var2) {
      this.viewProvider = var1;
      this.usuarioInteractorProvider = var2;
   }

   public static Factory create(Provider var0, Provider var1) {
      return new ItemInspecaoListaActivityPresenterImpl_Factory(var0, var1);
   }

   public ItemInspecaoListaActivityPresenterImpl get() {
      return new ItemInspecaoListaActivityPresenterImpl((ItemInspecaoView)this.viewProvider.get(), (UsuarioInteractor)this.usuarioInteractorProvider.get());
   }
}
