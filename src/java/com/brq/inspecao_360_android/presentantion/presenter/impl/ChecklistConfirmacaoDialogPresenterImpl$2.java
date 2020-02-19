package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.model.db.ImagemDAO;
import com.brq.inspecao_360_android.model.entity.Grupo;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.ChecklistConfirmacaoDialogPresenterImpl.2.UxXNozcPxW0OTvIW99NYjY7f_gc;
import com.brq.inspecao_360_android.presentantion.view.ChecklistConfirmacaoDialogView.DialogFragment;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import rx.Subscriber;

class ChecklistConfirmacaoDialogPresenterImpl$2 extends Subscriber {
   // $FF: synthetic field
   final ChecklistConfirmacaoDialogPresenterImpl this$0;
   // $FF: synthetic field
   final String val$action;
   // $FF: synthetic field
   final Long val$idChecklist;
   // $FF: synthetic field
   final Long val$idItem;
   // $FF: synthetic field
   final String val$uid;

   ChecklistConfirmacaoDialogPresenterImpl$2(ChecklistConfirmacaoDialogPresenterImpl var1, Long var2, String var3, Long var4, String var5) {
      this.this$0 = var1;
      this.val$idItem = var2;
      this.val$uid = var3;
      this.val$idChecklist = var4;
      this.val$action = var5;
   }

   // $FF: synthetic method
   public void lambda$onError$0$ChecklistConfirmacaoDialogPresenterImpl$2(Long var1, String var2, Long var3, String var4, View var5) {
      this.this$0.carregar(var1, var2, var3, var4);
   }

   public void onCompleted() {
      ChecklistConfirmacaoDialogPresenterImpl.access$000(this.this$0).showProgress(false);
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao carregar dialog de confirmacao de envio do checklist", var1);
      ChecklistConfirmacaoDialogPresenterImpl.access$000(this.this$0).showProgress(false);
      DialogFragment var2 = ChecklistConfirmacaoDialogPresenterImpl.access$000(this.this$0);
      Long var3 = this.val$idItem;
      String var4 = this.val$uid;
      Long var5 = this.val$idChecklist;
      String var6 = this.val$action;
      UxXNozcPxW0OTvIW99NYjY7f_gc var7 = new UxXNozcPxW0OTvIW99NYjY7f_gc(this, var3, var4, var5, var6);
      var2.showSnackbar("Não foi possível carregar esta funcionalidade.", "Tentar Novamente", var7);
   }

   public void onNext(List var1) {
      if (!Validator.isNullOrEmpty(var1)) {
         int var2 = 0;

         try {
            ChecklistConfirmacaoDialogPresenterImpl var11 = this.this$0;
            ImagemDAO var12 = ChecklistConfirmacaoDialogPresenterImpl.access$200(this.this$0);
            Long var13 = this.val$idItem;
            Object[] var14 = new Object[]{1, -1};
            ChecklistConfirmacaoDialogPresenterImpl.access$102(var11, var12.getAllByIdItemAndIdStatus(var13, var14));
            ChecklistConfirmacaoDialogPresenterImpl var16 = this.this$0;
            ImagemDAO var17 = ChecklistConfirmacaoDialogPresenterImpl.access$200(this.this$0);
            Long var18 = this.val$idItem;
            Object[] var19 = new Object[]{4};
            ChecklistConfirmacaoDialogPresenterImpl.access$302(var16, var17.getAllByIdItemAndIdStatus(var18, var19));
         } catch (SQLException var20) {
            Logger.error("Erro ao carregar referencias de imagens do checklist", var20);
         }

         Iterator var4 = var1.iterator();
         int var5 = 0;
         int var6 = 0;

         int var7;
         Grupo var10;
         for(var7 = 0; var4.hasNext(); var7 = (int)((long)var7 + var10.getQtdRespostaObrigatoria())) {
            var10 = (Grupo)var4.next();
            var5 = (int)((long)var5 + var10.getQtdPergunta());
            var2 = (int)((long)var2 + var10.getQtdResposta());
            var6 = (int)((long)var6 + var10.getQtdPerguntaObrigatoria());
         }

         int var8 = var2 * 100 / var5;
         int var9 = ChecklistConfirmacaoDialogPresenterImpl.access$100(this.this$0).size();
         ChecklistConfirmacaoDialogPresenterImpl.access$000(this.this$0).preencher(ChecklistConfirmacaoDialogPresenterImpl.access$400(this.this$0), var9, var8, ChecklistConfirmacaoDialogPresenterImpl.access$100(this.this$0), ChecklistConfirmacaoDialogPresenterImpl.access$300(this.this$0), var6, var7);
      }

   }

   public void onStart() {
      super.onStart();
      ChecklistConfirmacaoDialogPresenterImpl.access$000(this.this$0).showProgress(true);
   }
}
