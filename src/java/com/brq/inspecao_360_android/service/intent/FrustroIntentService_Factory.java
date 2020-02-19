package com.brq.inspecao_360_android.service.intent;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class FrustroIntentService_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final MembersInjector membersInjector;

   public FrustroIntentService_Factory(MembersInjector var1) {
      this.membersInjector = var1;
   }

   public static Factory create(MembersInjector var0) {
      return new FrustroIntentService_Factory(var0);
   }

   public FrustroIntentService get() {
      FrustroIntentService var1 = new FrustroIntentService();
      this.membersInjector.injectMembers(var1);
      return var1;
   }
}
