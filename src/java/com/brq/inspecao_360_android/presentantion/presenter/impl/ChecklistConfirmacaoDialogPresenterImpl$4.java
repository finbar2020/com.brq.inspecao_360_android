package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.content.DialogInterface;
import android.view.View;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ChecklistConfirmacaoDialogPresenterImpl.4.WOWmms1i-SJ1xQ0UwRZDMon32RI;
import rx.Subscriber;

class ChecklistConfirmacaoDialogPresenterImpl$4 extends Subscriber {
   // $FF: synthetic field
   final ChecklistConfirmacaoDialogPresenterImpl this$0;
   // $FF: synthetic field
   final DialogInterface val$dialog;
   // $FF: synthetic field
   final Item val$item;

   ChecklistConfirmacaoDialogPresenterImpl$4(ChecklistConfirmacaoDialogPresenterImpl var1, DialogInterface var2, Item var3) {
      this.this$0 = var1;
      this.val$dialog = var2;
      this.val$item = var3;
   }

   // $FF: synthetic method
   public void lambda$onError$0$ChecklistConfirmacaoDialogPresenterImpl$4(DialogInterface var1, Item var2, View var3) {
      this.this$0.alterarSolicitacaoInspecao(var1, var2);
   }

   public void onCompleted() {
      ChecklistConfirmacaoDialogPresenterImpl.access$000(this.this$0).showProgress(false);
      ChecklistConfirmacaoDialogPresenterImpl.access$000(this.this$0).successIniciarTransmissao(this.val$dialog);
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao alterar flag de solicitacao de inspecao", var1);
      ChecklistConfirmacaoDialogPresenterImpl.access$000(this.this$0).showProgress(false);
      ChecklistConfirmacaoDialogPresenterImpl.access$000(this.this$0).showSnackbar("Não foi possível carregar esta funcionalidade.", "Tentar Novamente", new WOWmms1i-SJ1xQ0UwRZDMon32RI(this, this.val$dialog, this.val$item));
   }

   public void onNext(Void var1) {
   }

   public void onStart() {
      super.onStart();
      ChecklistConfirmacaoDialogPresenterImpl.access$000(this.this$0).showProgress(true);
   }
}
