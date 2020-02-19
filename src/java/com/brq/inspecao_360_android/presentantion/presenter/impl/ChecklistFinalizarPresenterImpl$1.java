package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.model.entity.Grupo;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ChecklistFinalizarPresenterImpl.1.BSI9W6w6VgIVtkPHepoX5r-aI-w;
import com.brq.inspecao_360_android.presentantion.view.ChecklistView$Finalizar_inspecao;
import java.util.Iterator;
import java.util.List;
import rx.Subscriber;

class ChecklistFinalizarPresenterImpl$1 extends Subscriber {
   // $FF: synthetic field
   final ChecklistFinalizarPresenterImpl this$0;
   // $FF: synthetic field
   final Long val$idChecklist;
   // $FF: synthetic field
   final Long val$idInspecao;
   // $FF: synthetic field
   final Long val$idItem;
   // $FF: synthetic field
   final String val$uid;

   ChecklistFinalizarPresenterImpl$1(ChecklistFinalizarPresenterImpl var1, Long var2, Long var3, String var4, Long var5) {
      this.this$0 = var1;
      this.val$idInspecao = var2;
      this.val$idItem = var3;
      this.val$uid = var4;
      this.val$idChecklist = var5;
   }

   // $FF: synthetic method
   public void lambda$onError$0$ChecklistFinalizarPresenterImpl$1(Long var1, Long var2, String var3, Long var4, View var5) {
      this.this$0.carregar(var1, var2, var3, var4);
   }

   public void onCompleted() {
      ChecklistFinalizarPresenterImpl.access$000(this.this$0).hideProgressDialog();
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao carregar dialog de confirmacao de envio do checklist", var1);
      ChecklistFinalizarPresenterImpl.access$000(this.this$0).hideProgressDialog();
      ChecklistView$Finalizar_inspecao var2 = ChecklistFinalizarPresenterImpl.access$000(this.this$0);
      Long var3 = this.val$idInspecao;
      Long var4 = this.val$idItem;
      String var5 = this.val$uid;
      Long var6 = this.val$idChecklist;
      BSI9W6w6VgIVtkPHepoX5r-aI-w var7 = new BSI9W6w6VgIVtkPHepoX5r-aI-w(this, var3, var4, var5, var6);
      var2.showSnackbar("Não foi possível carregar esta funcionalidade.", "Tentar Novamente", var7);
   }

   public void onNext(List var1) {
      if (!Validator.isNullOrEmpty(var1)) {
         Iterator var2 = var1.iterator();
         int var3 = 0;

         int var4;
         Grupo var7;
         for(var4 = 0; var2.hasNext(); var3 = (int)((long)var3 + var7.getQtdResposta())) {
            var7 = (Grupo)var2.next();
            var4 = (int)((long)var4 + var7.getQtdPergunta());
         }

         int var10000 = var3 * 100 / var4;
         ChecklistFinalizarPresenterImpl.access$100(this.this$0).size();
      }

   }

   public void onStart() {
      super.onStart();
      ChecklistFinalizarPresenterImpl.access$000(this.this$0).showProgessDialog(ChecklistFinalizarPresenterImpl.access$000(this.this$0).getString(2131820595), ChecklistFinalizarPresenterImpl.access$000(this.this$0).getString(2131821137));
   }
}
