package com.brq.inspecao_360_android.common.service.intent;

import com.brq.inspecao_360_android.common.util.SharedPreferenceUtil;
import com.brq.inspecao_360_android.interactor.AnexoInteractor;
import com.brq.inspecao_360_android.interactor.ChecklistInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AtualizarListaInspecaoIntentService_MembersInjector implements MembersInjector {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final Provider anexoInteractorProvider;
   private final Provider checklistInteractorProvider;
   private final Provider itemInspecaoInteractorProvider;
   private final Provider preferenceProvider;
   private final MembersInjector supertypeInjector;

   public AtualizarListaInspecaoIntentService_MembersInjector(MembersInjector var1, Provider var2, Provider var3, Provider var4, Provider var5) {
      this.supertypeInjector = var1;
      this.itemInspecaoInteractorProvider = var2;
      this.checklistInteractorProvider = var3;
      this.anexoInteractorProvider = var4;
      this.preferenceProvider = var5;
   }

   public static MembersInjector create(MembersInjector var0, Provider var1, Provider var2, Provider var3, Provider var4) {
      AtualizarListaInspecaoIntentService_MembersInjector var5 = new AtualizarListaInspecaoIntentService_MembersInjector(var0, var1, var2, var3, var4);
      return var5;
   }

   public void injectMembers(AtualizarListaInspecaoIntentService var1) {
      if (var1 != null) {
         this.supertypeInjector.injectMembers(var1);
         var1.itemInspecaoInteractor = (ItemInspecaoInteractor)this.itemInspecaoInteractorProvider.get();
         var1.checklistInteractor = (ChecklistInteractor)this.checklistInteractorProvider.get();
         var1.anexoInteractor = (AnexoInteractor)this.anexoInteractorProvider.get();
         var1.preference = (SharedPreferenceUtil)this.preferenceProvider.get();
      } else {
         throw new NullPointerException("Cannot inject members into a null reference");
      }
   }
}
