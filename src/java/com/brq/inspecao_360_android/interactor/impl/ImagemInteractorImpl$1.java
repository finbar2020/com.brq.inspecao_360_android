package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.db.AssinaturaDAO;
import com.brq.inspecao_360_android.model.db.ImagemDAO;
import com.brq.inspecao_360_android.model.db.ItemDAO;
import com.brq.inspecao_360_android.model.entity.Imagem;
import java.sql.SQLException;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class ImagemInteractorImpl$1 implements OnSubscribe {
   // $FF: synthetic field
   final ImagemInteractorImpl this$0;
   // $FF: synthetic field
   final ImagemDAO val$dao;
   // $FF: synthetic field
   final Long val$id;

   ImagemInteractorImpl$1(ImagemInteractorImpl var1, ImagemDAO var2, Long var3) {
      this.this$0 = var1;
      this.val$dao = var2;
      this.val$id = var3;
   }

   public void call(Subscriber var1) {
      label32: {
         SQLException var10000;
         label34: {
            Imagem var3;
            boolean var10001;
            try {
               var3 = (Imagem)this.val$dao.getById(this.val$id);
               this.val$dao.deleteById(this.val$id);
            } catch (SQLException var11) {
               var10000 = var11;
               var10001 = false;
               break label34;
            }

            try {
               ItemDAO var6 = ItemDAO.newInstance();
               AssinaturaDAO var7 = AssinaturaDAO.newInstance();
               var6.alterarPossuiAssinaturaInspetor(var3.getItem().getId().intValue(), false);
               var6.alterarPossuiAssinaturaResponsavel(var3.getItem().getId().intValue(), false);
               var7.deleteAllByIdItem(var3.getItem().getId().intValue());
            } catch (SQLException var10) {
               SQLException var5 = var10;

               try {
                  Logger.error("Erro ao remover assinaturas.", var5);
                  var1.onError(var5);
               } catch (SQLException var9) {
                  var10000 = var9;
                  var10001 = false;
                  break label34;
               }
            }

            try {
               var1.onNext((Object)null);
               break label32;
            } catch (SQLException var8) {
               var10000 = var8;
               var10001 = false;
            }
         }

         SQLException var2 = var10000;
         Logger.error("Erro ao excluir imagem por id.", var2);
         var1.onError(var2);
      }

      var1.onCompleted();
   }
}
