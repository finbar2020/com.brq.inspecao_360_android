package com.brq.inspecao_360_android.interactor.impl;

import android.content.Context;
import android.content.Intent;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.model.entity.Usuario;
import com.brq.inspecao_360_android.service.intent.ChecklistIntentService;
import java.io.File;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class ControleRemotoInteractorImpl$3 implements OnSubscribe {
   // $FF: synthetic field
   final ControleRemotoInteractorImpl this$0;
   // $FF: synthetic field
   final Context val$context;
   // $FF: synthetic field
   final Long val$idItem;

   ControleRemotoInteractorImpl$3(ControleRemotoInteractorImpl var1, Long var2, Context var3) {
      this.this$0 = var1;
      this.val$idItem = var2;
      this.val$context = var3;
   }

   public void call(Subscriber var1) {
      List var2 = this.this$0.getAllImagesFromItem(this.val$idItem);
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         File var9 = (File)var3.next();
         this.this$0.imagemInteractor.criarRegistroParaImagemExterna(var9, this.val$idItem);
      }

      if (var2.size() > 0) {
         Usuario var4 = this.this$0.preference.getUsuarioInfo();

         Item var6;
         try {
            var6 = this.this$0.itemDAO.getById(this.val$idItem, var4);
         } catch (SQLException var10) {
            Logger.error("Erro ao obter item", var10);
            var6 = null;
         }

         Intent var7 = ChecklistIntentService.newInstance(this.val$context, 0L, var6.getId(), var6.getUid(), var6.getChecklistId(), "br.com.brq.action.ACAO_ENVIAR", false, false, 0, false);
         this.val$context.startService(var7);
      }

      var1.onCompleted();
   }
}
