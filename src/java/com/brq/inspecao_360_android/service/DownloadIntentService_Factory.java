package com.brq.inspecao_360_android.service;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class DownloadIntentService_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final MembersInjector membersInjector;

   public DownloadIntentService_Factory(MembersInjector var1) {
      this.membersInjector = var1;
   }

   public static Factory create(MembersInjector var0) {
      return new DownloadIntentService_Factory(var0);
   }

   public DownloadIntentService get() {
      DownloadIntentService var1 = new DownloadIntentService();
      this.membersInjector.injectMembers(var1);
      return var1;
   }
}
