package com.brq.inspecao_360_android.common.service.intent;

import com.brq.inspecao_360_android.interactor.ChecklistInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AtualizarItemInspecaoIntentService_MembersInjector implements MembersInjector {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final Provider checklistInteractorProvider;
   private final Provider interactorProvider;
   private final MembersInjector supertypeInjector;

   public AtualizarItemInspecaoIntentService_MembersInjector(MembersInjector var1, Provider var2, Provider var3) {
      this.supertypeInjector = var1;
      this.interactorProvider = var2;
      this.checklistInteractorProvider = var3;
   }

   public static MembersInjector create(MembersInjector var0, Provider var1, Provider var2) {
      return new AtualizarItemInspecaoIntentService_MembersInjector(var0, var1, var2);
   }

   public void injectMembers(AtualizarItemInspecaoIntentService var1) {
      if (var1 != null) {
         this.supertypeInjector.injectMembers(var1);
         var1.interactor = (ItemInspecaoInteractor)this.interactorProvider.get();
         var1.checklistInteractor = (ChecklistInteractor)this.checklistInteractorProvider.get();
      } else {
         throw new NullPointerException("Cannot inject members into a null reference");
      }
   }
}
