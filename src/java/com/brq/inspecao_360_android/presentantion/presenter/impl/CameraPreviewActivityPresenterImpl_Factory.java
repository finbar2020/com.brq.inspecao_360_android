package com.brq.inspecao_360_android.presentantion.presenter.impl;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class CameraPreviewActivityPresenterImpl_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final MembersInjector membersInjector;

   public CameraPreviewActivityPresenterImpl_Factory(MembersInjector var1) {
      this.membersInjector = var1;
   }

   public static Factory create(MembersInjector var0) {
      return new CameraPreviewActivityPresenterImpl_Factory(var0);
   }

   public CameraPreviewActivityPresenterImpl get() {
      CameraPreviewActivityPresenterImpl var1 = new CameraPreviewActivityPresenterImpl();
      this.membersInjector.injectMembers(var1);
      return var1;
   }
}
