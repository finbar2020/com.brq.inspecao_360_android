package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.db.AnexoDAO;
import com.brq.inspecao_360_android.model.entity.Anexo;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class AnexoInteractorImpl$1 implements OnSubscribe {
   // $FF: synthetic field
   final AnexoInteractorImpl this$0;
   // $FF: synthetic field
   final Long val$idItem;

   AnexoInteractorImpl$1(AnexoInteractorImpl var1, Long var2) {
      this.this$0 = var1;
      this.val$idItem = var2;
   }

   public void call(Subscriber var1) {
      AnexoDAO var2 = AnexoDAO.newInstance();

      label39: {
         SQLException var10000;
         label38: {
            boolean var10001;
            List var4;
            Iterator var5;
            try {
               var4 = var2.getAllByItem(this.val$idItem);
               var5 = var4.iterator();
            } catch (SQLException var8) {
               var10000 = var8;
               var10001 = false;
               break label38;
            }

            while(true) {
               try {
                  while(var5.hasNext()) {
                     Anexo var6 = (Anexo)var5.next();
                     if (!var6.getDownloaded()) {
                        var4.remove(var6);
                     }
                  }
               } catch (SQLException var9) {
                  var10000 = var9;
                  var10001 = false;
                  break;
               }

               try {
                  var1.onNext(var4);
                  break label39;
               } catch (SQLException var7) {
                  var10000 = var7;
                  var10001 = false;
                  break;
               }
            }
         }

         SQLException var3 = var10000;
         Logger.error("Erro ao obter anexos offline.", var3);
         var1.onError(var3);
      }

      var1.onCompleted();
   }
}
