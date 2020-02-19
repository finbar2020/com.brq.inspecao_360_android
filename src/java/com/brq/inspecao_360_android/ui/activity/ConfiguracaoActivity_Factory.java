package com.brq.inspecao_360_android.ui.activity;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class ConfiguracaoActivity_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final MembersInjector membersInjector;

   public ConfiguracaoActivity_Factory(MembersInjector var1) {
      this.membersInjector = var1;
   }

   public static Factory create(MembersInjector var0) {
      return new ConfiguracaoActivity_Factory(var0);
   }

   public ConfiguracaoActivity get() {
      ConfiguracaoActivity var1 = new ConfiguracaoActivity();
      this.membersInjector.injectMembers(var1);
      return var1;
   }
}
