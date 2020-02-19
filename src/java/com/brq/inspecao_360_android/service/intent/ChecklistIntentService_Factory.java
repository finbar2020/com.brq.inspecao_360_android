package com.brq.inspecao_360_android.service.intent;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class ChecklistIntentService_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final MembersInjector membersInjector;

   public ChecklistIntentService_Factory(MembersInjector var1) {
      this.membersInjector = var1;
   }

   public static Factory create(MembersInjector var0) {
      return new ChecklistIntentService_Factory(var0);
   }

   public ChecklistIntentService get() {
      ChecklistIntentService var1 = new ChecklistIntentService();
      this.membersInjector.injectMembers(var1);
      return var1;
   }
}
