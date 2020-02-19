package com.brq.inspecao_360_android.ui.activity;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class CameraV2Activity_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final MembersInjector membersInjector;

   public CameraV2Activity_Factory(MembersInjector var1) {
      this.membersInjector = var1;
   }

   public static Factory create(MembersInjector var0) {
      return new CameraV2Activity_Factory(var0);
   }

   public CameraV2Activity get() {
      CameraV2Activity var1 = new CameraV2Activity();
      this.membersInjector.injectMembers(var1);
      return var1;
   }
}
