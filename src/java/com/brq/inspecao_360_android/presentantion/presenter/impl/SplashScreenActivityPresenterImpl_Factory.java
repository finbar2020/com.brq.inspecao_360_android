package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.presentantion.view.SplashScreeView;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SplashScreenActivityPresenterImpl_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final Provider mViewProvider;
   private final MembersInjector membersInjector;

   public SplashScreenActivityPresenterImpl_Factory(MembersInjector var1, Provider var2) {
      this.membersInjector = var1;
      this.mViewProvider = var2;
   }

   public static Factory create(MembersInjector var0, Provider var1) {
      return new SplashScreenActivityPresenterImpl_Factory(var0, var1);
   }

   public SplashScreenActivityPresenterImpl get() {
      SplashScreenActivityPresenterImpl var1 = new SplashScreenActivityPresenterImpl((SplashScreeView)this.mViewProvider.get());
      this.membersInjector.injectMembers(var1);
      return var1;
   }
}
