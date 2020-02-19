package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.presentantion.presenter.impl.ChecklistListaPerguntaPresenterImpl.8.1;
import java.util.List;
import rx.Subscriber;

class ChecklistListaPerguntaPresenterImpl$8 extends Subscriber {
   // $FF: synthetic field
   final ChecklistListaPerguntaPresenterImpl this$0;
   // $FF: synthetic field
   final boolean val$backPressed;
   // $FF: synthetic field
   final Long val$idChecklist;
   // $FF: synthetic field
   final Long val$idGrupo;
   // $FF: synthetic field
   final Long val$idItem;
   // $FF: synthetic field
   final Long val$idSecao;
   // $FF: synthetic field
   final boolean val$isEnable;
   // $FF: synthetic field
   final View val$view;

   ChecklistListaPerguntaPresenterImpl$8(ChecklistListaPerguntaPresenterImpl var1, boolean var2, View var3, Long var4, Long var5, Long var6, boolean var7, Long var8) {
      this.this$0 = var1;
      this.val$backPressed = var2;
      this.val$view = var3;
      this.val$idItem = var4;
      this.val$idGrupo = var5;
      this.val$idSecao = var6;
      this.val$isEnable = var7;
      this.val$idChecklist = var8;
   }

   public void onCompleted() {
      ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).hideProgressDialog();
      if (this.val$backPressed) {
         ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).onSuccessSave();
      }

   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao lerESalvarResposta respostas.", var1);
      ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).hideProgressDialog();
      ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).showSnackbar(ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).getString(2131821078), ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).getString(2131820915), new 1(this));
   }

   public void onNext(List var1) {
      ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).onSalvarSucesso(var1);
   }

   public void onStart() {
      super.onStart();
      ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).showProgessDialog(ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).getString(2131820595), ChecklistListaPerguntaPresenterImpl.access$000(this.this$0).getString(2131821248));
   }
}
