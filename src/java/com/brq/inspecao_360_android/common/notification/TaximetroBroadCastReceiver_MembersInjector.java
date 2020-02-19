package com.brq.inspecao_360_android.common.notification;

import com.brq.inspecao_360_android.common.util.SharedPreferenceUtil;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class TaximetroBroadCastReceiver_MembersInjector implements MembersInjector {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final Provider preferenceProvider;
   private final MembersInjector supertypeInjector;

   public TaximetroBroadCastReceiver_MembersInjector(MembersInjector var1, Provider var2) {
      this.supertypeInjector = var1;
      this.preferenceProvider = var2;
   }

   public static MembersInjector create(MembersInjector var0, Provider var1) {
      return new TaximetroBroadCastReceiver_MembersInjector(var0, var1);
   }

   public void injectMembers(TaximetroBroadCastReceiver var1) {
      if (var1 != null) {
         this.supertypeInjector.injectMembers(var1);
         var1.preference = (SharedPreferenceUtil)this.preferenceProvider.get();
      } else {
         throw new NullPointerException("Cannot inject members into a null reference");
      }
   }
}
