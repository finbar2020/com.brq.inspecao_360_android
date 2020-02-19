package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ItemInspecaoTabInformacaoFragmentPresenterImpl_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final Provider interactorProvider;
   private final Provider viewProvider;

   public ItemInspecaoTabInformacaoFragmentPresenterImpl_Factory(Provider var1, Provider var2) {
      this.viewProvider = var1;
      this.interactorProvider = var2;
   }

   public static Factory create(Provider var0, Provider var1) {
      return new ItemInspecaoTabInformacaoFragmentPresenterImpl_Factory(var0, var1);
   }

   public ItemInspecaoTabInformacaoFragmentPresenterImpl get() {
      return new ItemInspecaoTabInformacaoFragmentPresenterImpl((ItemInspecaoView)this.viewProvider.get(), (ItemInspecaoInteractor)this.interactorProvider.get());
   }
}
