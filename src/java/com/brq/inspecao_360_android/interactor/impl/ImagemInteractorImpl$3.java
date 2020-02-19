package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.db.AssinaturaDAO;
import com.brq.inspecao_360_android.model.db.ImagemDAO;
import com.brq.inspecao_360_android.model.db.ItemDAO;
import com.brq.inspecao_360_android.model.entity.Imagem;
import java.io.File;
import java.sql.SQLException;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class ImagemInteractorImpl$3 implements OnSubscribe {
   // $FF: synthetic field
   final ImagemInteractorImpl this$0;
   // $FF: synthetic field
   final ImagemDAO val$dao;
   // $FF: synthetic field
   final Imagem val$imagem;

   ImagemInteractorImpl$3(ImagemInteractorImpl var1, Imagem var2, ImagemDAO var3) {
      this.this$0 = var1;
      this.val$imagem = var2;
      this.val$dao = var3;
   }

   public void call(Subscriber var1) {
      File var2 = new File(this.val$imagem.getFilePath());
      if (var2.exists()) {
         var2.delete();
      }

      try {
         this.val$dao.delete(this.val$imagem);
      } catch (SQLException var8) {
         Logger.error("Erro ao excluirFotoGaleria imagem.", var8);
         var1.onError(var8);
      }

      try {
         ItemDAO var5 = ItemDAO.newInstance();
         AssinaturaDAO var6 = AssinaturaDAO.newInstance();
         var5.alterarPossuiAssinaturaInspetor(this.val$imagem.getItem().getId().intValue(), false);
         var5.alterarPossuiAssinaturaResponsavel(this.val$imagem.getItem().getId().intValue(), false);
         var6.deleteAllByIdItem(this.val$imagem.getItem().getId().intValue());
      } catch (SQLException var7) {
         Logger.error("Erro ao remover assinaturas.", var7);
         var1.onError(var7);
      }

      var1.onNext((Object)null);
      var1.onCompleted();
   }
}
