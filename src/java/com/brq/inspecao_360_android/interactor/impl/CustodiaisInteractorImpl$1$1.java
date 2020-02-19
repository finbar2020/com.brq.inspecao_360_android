package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.interactor.impl.CustodiaisInteractorImpl.1;
import com.brq.inspecao_360_android.model.entity.ClasseConstrucao;
import com.brq.inspecao_360_android.model.entity.ProdutoComercial;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import rx.Subscriber;
import rx.Observable.OnSubscribe;
import rx.exceptions.Exceptions;

class CustodiaisInteractorImpl$1$1 implements OnSubscribe {
   // $FF: synthetic field
   final 1 this$1;
   // $FF: synthetic field
   final List val$classesConstrucoes;
   // $FF: synthetic field
   final List val$produtoComercials;

   CustodiaisInteractorImpl$1$1(1 var1, List var2, List var3) {
      this.this$1 = var1;
      this.val$produtoComercials = var2;
      this.val$classesConstrucoes = var3;
   }

   public void call(Subscriber var1) {
      try {
         this.this$1.val$estadoDAO.config();
      } catch (SQLException var16) {
         Logger.error("Erro configurar estados!", var16);
         Exceptions.propagate(var16);
      }

      try {
         this.this$1.val$municipioDAO.config();
      } catch (SQLException var15) {
         Logger.error("Erro configurar municipios!", var15);
         Exceptions.propagate(var15);
      }

      Iterator var6 = this.val$produtoComercials.iterator();

      while(var6.hasNext()) {
         ProdutoComercial var11 = (ProdutoComercial)var6.next();

         try {
            this.this$1.val$produtoComercialDAO.inserir(var11);
         } catch (SQLException var14) {
            Logger.error("Erro inserir  produto Comercial!", var14);
            Exceptions.propagate(var14);
         }
      }

      Iterator var7 = this.val$classesConstrucoes.iterator();

      while(var7.hasNext()) {
         ClasseConstrucao var8 = (ClasseConstrucao)var7.next();

         try {
            this.this$1.val$classeConstrucaoDAO.insert(var8);
         } catch (SQLException var13) {
            Logger.error("Erro inserir  classe construcao!", var13);
            Exceptions.propagate(var13);
         }
      }

      var1.onCompleted();
   }
}
