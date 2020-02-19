package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.presentantion.presenter.impl.ChecklistListaGrupoFragmentPresenterImpl.1.1;
import java.util.List;
import rx.Subscriber;

class ChecklistListaGrupoFragmentPresenterImpl$1 extends Subscriber {
   // $FF: synthetic field
   final ChecklistListaGrupoFragmentPresenterImpl this$0;
   // $FF: synthetic field
   final Long val$idChecklist;
   // $FF: synthetic field
   final Long val$idCoberturaChecklist;
   // $FF: synthetic field
   final Long val$idInspecao;
   // $FF: synthetic field
   final Long val$idItem;

   ChecklistListaGrupoFragmentPresenterImpl$1(ChecklistListaGrupoFragmentPresenterImpl var1, Long var2, Long var3, Long var4, Long var5) {
      this.this$0 = var1;
      this.val$idInspecao = var2;
      this.val$idItem = var3;
      this.val$idChecklist = var4;
      this.val$idCoberturaChecklist = var5;
   }

   public void onCompleted() {
      ChecklistListaGrupoFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao carregar os itens", var1);
      ChecklistListaGrupoFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
      ChecklistListaGrupoFragmentPresenterImpl.access$000(this.this$0).showSnackbar(ChecklistListaGrupoFragmentPresenterImpl.access$000(this.this$0).getString(2131821121), ChecklistListaGrupoFragmentPresenterImpl.access$000(this.this$0).getString(2131820915), new 1(this));
   }

   public void onNext(List var1) {
      if (!Validator.isNullOrEmpty(var1)) {
         ChecklistListaGrupoFragmentPresenterImpl.access$000(this.this$0).addAll(var1);
      }

   }

   public void onStart() {
      super.onStart();
      ChecklistListaGrupoFragmentPresenterImpl.access$000(this.this$0).showProgress(true);
   }
}
