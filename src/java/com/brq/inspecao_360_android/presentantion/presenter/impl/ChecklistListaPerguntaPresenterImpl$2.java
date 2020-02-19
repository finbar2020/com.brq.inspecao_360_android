package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import java.util.List;
import rx.Subscriber;

class ChecklistListaPerguntaPresenterImpl$2 extends Subscriber {
   // $FF: synthetic field
   final ChecklistListaPerguntaPresenterImpl this$0;
   // $FF: synthetic field
   final Long val$idChecklist;
   // $FF: synthetic field
   final Long val$idGrupo;
   // $FF: synthetic field
   final Long val$idInspecao;
   // $FF: synthetic field
   final Long val$idItem;
   // $FF: synthetic field
   final Long val$idSecao;
   // $FF: synthetic field
   final boolean val$isEnable;

   ChecklistListaPerguntaPresenterImpl$2(ChecklistListaPerguntaPresenterImpl var1, Long var2, Long var3, Long var4, Long var5, Long var6, boolean var7) {
      this.this$0 = var1;
      this.val$idInspecao = var2;
      this.val$idItem = var3;
      this.val$idChecklist = var4;
      this.val$idGrupo = var5;
      this.val$idSecao = var6;
      this.val$isEnable = var7;
   }

   public void onCompleted() {
      this.this$0.obterDependenciasOff(this.val$idInspecao, this.val$idItem, this.val$idChecklist, this.val$idGrupo, this.val$idSecao, this.val$isEnable);
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao carregar interdependencias", var1);
      ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).hideProgressDialog();
   }

   public void onNext(List var1) {
      ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).carregarInterdependencias(var1);
   }

   public void onStart() {
      super.onStart();
      ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).showProgessDialog(ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).getString(2131820595), ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).getString(2131821137));
   }
}
