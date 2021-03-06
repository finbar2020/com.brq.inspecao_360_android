package com.brq.inspecao_360_android.common.service;

import com.brq.inspecao_360_android.common.util.SharedPreferenceUtil;
import com.brq.inspecao_360_android.interactor.BaseInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.interactor.UsuarioInteractor;
import com.brq.inspecao_360_android.service.UsuarioService;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class RastreamentoService_MembersInjector implements MembersInjector {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final Provider interactorProvider;
   private final Provider itemInteractorProvider;
   private final Provider preferenceProvider;
   private final Provider serviceProvider;
   private final MembersInjector supertypeInjector;
   private final Provider usuarioInteractorProvider;

   public RastreamentoService_MembersInjector(MembersInjector var1, Provider var2, Provider var3, Provider var4, Provider var5, Provider var6) {
      this.supertypeInjector = var1;
      this.preferenceProvider = var2;
      this.serviceProvider = var3;
      this.usuarioInteractorProvider = var4;
      this.interactorProvider = var5;
      this.itemInteractorProvider = var6;
   }

   public static MembersInjector create(MembersInjector var0, Provider var1, Provider var2, Provider var3, Provider var4, Provider var5) {
      RastreamentoService_MembersInjector var6 = new RastreamentoService_MembersInjector(var0, var1, var2, var3, var4, var5);
      return var6;
   }

   public void injectMembers(RastreamentoService var1) {
      if (var1 != null) {
         this.supertypeInjector.injectMembers(var1);
         var1.preference = (SharedPreferenceUtil)this.preferenceProvider.get();
         var1.service = (UsuarioService)this.serviceProvider.get();
         var1.usuarioInteractor = (UsuarioInteractor)this.usuarioInteractorProvider.get();
         var1.interactor = (BaseInteractor)this.interactorProvider.get();
         var1.itemInteractor = (ItemInspecaoInteractor)this.itemInteractorProvider.get();
      } else {
         throw new NullPointerException("Cannot inject members into a null reference");
      }
   }
}
