package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.common.enumerator.StatusInspecaoEnum;
import com.brq.inspecao_360_android.common.util.DateUtil;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.model.entity.StatusInspecao;
import java.sql.SQLException;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class FrustroInteractorImpl$1 implements OnSubscribe {
   // $FF: synthetic field
   final FrustroInteractorImpl this$0;
   // $FF: synthetic field
   final Long val$idItem;
   // $FF: synthetic field
   final Long val$idMotivo;
   // $FF: synthetic field
   final String val$justificativa;

   FrustroInteractorImpl$1(FrustroInteractorImpl var1, Long var2, Long var3, String var4) {
      this.this$0 = var1;
      this.val$idItem = var2;
      this.val$idMotivo = var3;
      this.val$justificativa = var4;
   }

   public void call(Subscriber var1) {
      try {
         String var10 = DateUtil.getCurrentDate("dd/MM/yyyy HH:mm:ss");
         this.this$0.itemDAO.frustrar(this.val$idItem, this.val$idMotivo, this.val$justificativa, var10);
      } catch (SQLException var11) {
         Logger.error("Erro ao salvarOff frustro.", var11);
         var1.onError(var11);
      }

      Item var6;
      label30: {
         Item var4;
         SQLException var5;
         label29: {
            try {
               var4 = (Item)this.this$0.itemDAO.getById(this.val$idItem);
            } catch (SQLException var13) {
               var4 = null;
               var5 = var13;
               break label29;
            }

            try {
               StatusInspecao var7 = var4.getStatusVigente();
               if (var7.getId() != StatusInspecaoEnum.ASSINADO_AGUARDANDO_ENVIAR_DADOS.getId()) {
                  StatusInspecao var8 = StatusInspecaoEnum.get(StatusInspecaoEnum.AGUARDANDO_ENVIAR_DADOS.getId());
                  this.this$0.itemDAO.atualizarStatus(this.val$idItem, var8, var7);
               }

               var6 = (Item)this.this$0.itemDAO.getById(this.val$idItem);
               break label30;
            } catch (SQLException var12) {
               var5 = var12;
            }
         }

         Logger.error("Erro atualizar status off.", var5);
         var1.onError(var5);
         var6 = var4;
      }

      var1.onNext(var6);
      var1.onCompleted();
   }
}
