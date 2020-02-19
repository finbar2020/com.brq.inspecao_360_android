package com.brq.inspecao_360_android.ui.activity;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class CameraActivity_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final MembersInjector membersInjector;

   public CameraActivity_Factory(MembersInjector var1) {
      this.membersInjector = var1;
   }

   public static Factory create(MembersInjector var0) {
      return new CameraActivity_Factory(var0);
   }

   public CameraActivity get() {
      CameraActivity var1 = new CameraActivity();
      this.membersInjector.injectMembers(var1);
      return var1;
   }
}
