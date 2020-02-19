package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.interactor.CustodiaisInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.presentantion.view.ItemInspecaoView;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ItemInspecaoDevolverActivityPresenterImpl_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final Provider itemInspecaoInteractorProvider;
   private final Provider mCustodiaisInteractorProvider;
   private final MembersInjector membersInjector;
   private final Provider viewProvider;

   public ItemInspecaoDevolverActivityPresenterImpl_Factory(MembersInjector var1, Provider var2, Provider var3, Provider var4) {
      this.membersInjector = var1;
      this.viewProvider = var2;
      this.itemInspecaoInteractorProvider = var3;
      this.mCustodiaisInteractorProvider = var4;
   }

   public static Factory create(MembersInjector var0, Provider var1, Provider var2, Provider var3) {
      return new ItemInspecaoDevolverActivityPresenterImpl_Factory(var0, var1, var2, var3);
   }

   public ItemInspecaoDevolverActivityPresenterImpl get() {
      ItemInspecaoDevolverActivityPresenterImpl var1 = new ItemInspecaoDevolverActivityPresenterImpl((ItemInspecaoView)this.viewProvider.get(), (ItemInspecaoInteractor)this.itemInspecaoInteractorProvider.get(), (CustodiaisInteractor)this.mCustodiaisInteractorProvider.get());
      this.membersInjector.injectMembers(var1);
      return var1;
   }
}
