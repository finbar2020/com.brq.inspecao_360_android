package com.brq.inspecao_360_android.service.intent;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class ControleRemotoIntentService_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final MembersInjector membersInjector;

   public ControleRemotoIntentService_Factory(MembersInjector var1) {
      this.membersInjector = var1;
   }

   public static Factory create(MembersInjector var0) {
      return new ControleRemotoIntentService_Factory(var0);
   }

   public ControleRemotoIntentService get() {
      ControleRemotoIntentService var1 = new ControleRemotoIntentService();
      this.membersInjector.injectMembers(var1);
      return var1;
   }
}
