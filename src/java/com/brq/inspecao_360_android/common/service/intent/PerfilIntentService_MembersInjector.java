package com.brq.inspecao_360_android.common.service.intent;

import com.brq.inspecao_360_android.interactor.impl.UsuarioInteractorImpl;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PerfilIntentService_MembersInjector implements MembersInjector {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final Provider interactorProvider;
   private final MembersInjector supertypeInjector;

   public PerfilIntentService_MembersInjector(MembersInjector var1, Provider var2) {
      this.supertypeInjector = var1;
      this.interactorProvider = var2;
   }

   public static MembersInjector create(MembersInjector var0, Provider var1) {
      return new PerfilIntentService_MembersInjector(var0, var1);
   }

   public void injectMembers(PerfilIntentService var1) {
      if (var1 != null) {
         this.supertypeInjector.injectMembers(var1);
         var1.interactor = (UsuarioInteractorImpl)this.interactorProvider.get();
      } else {
         throw new NullPointerException("Cannot inject members into a null reference");
      }
   }
}
