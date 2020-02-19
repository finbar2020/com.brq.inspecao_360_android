package com.brq.inspecao_360_android.common.service;

import com.brq.inspecao_360_android.common.util.SharedPreferenceUtil;
import com.brq.inspecao_360_android.interactor.BaseInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.service.UsuarioService;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class LogBackupService_MembersInjector implements MembersInjector {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final Provider interactorProvider;
   private final Provider itemInteractorProvider;
   private final Provider preferenceProvider;
   private final Provider serviceProvider;
   private final MembersInjector supertypeInjector;

   public LogBackupService_MembersInjector(MembersInjector var1, Provider var2, Provider var3, Provider var4, Provider var5) {
      this.supertypeInjector = var1;
      this.preferenceProvider = var2;
      this.serviceProvider = var3;
      this.interactorProvider = var4;
      this.itemInteractorProvider = var5;
   }

   public static MembersInjector create(MembersInjector var0, Provider var1, Provider var2, Provider var3, Provider var4) {
      LogBackupService_MembersInjector var5 = new LogBackupService_MembersInjector(var0, var1, var2, var3, var4);
      return var5;
   }

   public void injectMembers(LogBackupService var1) {
      if (var1 != null) {
         this.supertypeInjector.injectMembers(var1);
         var1.preference = (SharedPreferenceUtil)this.preferenceProvider.get();
         var1.service = (UsuarioService)this.serviceProvider.get();
         var1.interactor = (BaseInteractor)this.interactorProvider.get();
         var1.itemInteractor = (ItemInspecaoInteractor)this.itemInteractorProvider.get();
      } else {
         throw new NullPointerException("Cannot inject members into a null reference");
      }
   }
}
