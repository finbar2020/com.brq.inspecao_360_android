package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.model.entity.Item;
import rx.Observable;
import rx.functions.Func1;

class ChecklistConfirmacaoDialogPresenterImpl$3 implements Func1 {
   // $FF: synthetic field
   final ChecklistConfirmacaoDialogPresenterImpl this$0;
   // $FF: synthetic field
   final String val$action;
   // $FF: synthetic field
   final Long val$idChecklist;
   // $FF: synthetic field
   final Long val$idItem;

   ChecklistConfirmacaoDialogPresenterImpl$3(ChecklistConfirmacaoDialogPresenterImpl var1, Long var2, Long var3, String var4) {
      this.this$0 = var1;
      this.val$idItem = var2;
      this.val$idChecklist = var3;
      this.val$action = var4;
   }

   public Observable call(Item var1) {
      ChecklistConfirmacaoDialogPresenterImpl.access$402(this.this$0, var1);
      return this.this$0.checklistInteractor.obterGrupoOffPorTodasCoberturas(var1.getInspecao().getId(), this.val$idItem, this.val$idChecklist, this.val$action);
   }
}
