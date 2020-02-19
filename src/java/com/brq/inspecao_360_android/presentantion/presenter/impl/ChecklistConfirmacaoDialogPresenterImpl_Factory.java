package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.presentantion.view.ChecklistConfirmacaoDialogView;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ChecklistConfirmacaoDialogPresenterImpl_Factory implements Factory {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private final MembersInjector membersInjector;
   private final Provider viewProvider;

   public ChecklistConfirmacaoDialogPresenterImpl_Factory(MembersInjector var1, Provider var2) {
      this.membersInjector = var1;
      this.viewProvider = var2;
   }

   public static Factory create(MembersInjector var0, Provider var1) {
      return new ChecklistConfirmacaoDialogPresenterImpl_Factory(var0, var1);
   }

   public ChecklistConfirmacaoDialogPresenterImpl get() {
      ChecklistConfirmacaoDialogPresenterImpl var1 = new ChecklistConfirmacaoDialogPresenterImpl((ChecklistConfirmacaoDialogView)this.viewProvider.get());
      this.membersInjector.injectMembers(var1);
      return var1;
   }
}
