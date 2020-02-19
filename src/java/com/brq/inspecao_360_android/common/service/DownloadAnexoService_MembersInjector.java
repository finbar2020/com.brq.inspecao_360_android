package com.brq.inspecao_360_android.common.service;

import com.brq.inspecao_360_android.interactor.AnexoInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.service.UsuarioService;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DownloadAnexoService_MembersInjector implements MembersInjector {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final Provider anexoInteractorProvider;
   private final Provider itemInteractorProvider;
   private final Provider serviceProvider;
   private final MembersInjector supertypeInjector;

   public DownloadAnexoService_MembersInjector(MembersInjector var1, Provider var2, Provider var3, Provider var4) {
      this.supertypeInjector = var1;
      this.serviceProvider = var2;
      this.itemInteractorProvider = var3;
      this.anexoInteractorProvider = var4;
   }

   public static MembersInjector create(MembersInjector var0, Provider var1, Provider var2, Provider var3) {
      return new DownloadAnexoService_MembersInjector(var0, var1, var2, var3);
   }

   public void injectMembers(DownloadAnexoService var1) {
      if (var1 != null) {
         this.supertypeInjector.injectMembers(var1);
         var1.service = (UsuarioService)this.serviceProvider.get();
         var1.itemInteractor = (ItemInspecaoInteractor)this.itemInteractorProvider.get();
         var1.anexoInteractor = (AnexoInteractor)this.anexoInteractorProvider.get();
      } else {
         throw new NullPointerException("Cannot inject members into a null reference");
      }
   }
}
