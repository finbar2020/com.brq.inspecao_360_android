package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.model.entity.GrupoPergunta;
import com.brq.inspecao_360_android.model.entity.Pergunta;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

class ChecklistListaPerguntaPresenterImpl$5 implements Func1 {
   // $FF: synthetic field
   final ChecklistListaPerguntaPresenterImpl this$0;
   // $FF: synthetic field
   final Long val$idChecklist;
   // $FF: synthetic field
   final Long val$idGrupo;
   // $FF: synthetic field
   final Long val$idInspecao;
   // $FF: synthetic field
   final Long val$idItem;
   // $FF: synthetic field
   final Long val$idSecao;

   ChecklistListaPerguntaPresenterImpl$5(ChecklistListaPerguntaPresenterImpl var1, Long var2, Long var3, Long var4, Long var5, Long var6) {
      this.this$0 = var1;
      this.val$idInspecao = var2;
      this.val$idItem = var3;
      this.val$idGrupo = var4;
      this.val$idSecao = var5;
      this.val$idChecklist = var6;
   }

   public Observable call(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Pergunta var3 = (Pergunta)var2.next();

         try {
            var3.setRespostas(this.this$0.respostaInteractor.obterPorGrupoPergunta(this.val$idInspecao, this.val$idItem, this.val$idGrupo, this.val$idSecao, var3.getId()));
         } catch (SQLException var14) {
            Logger.error("Erro ao obter respostas por pergunta.", var14);
            Exceptions.propagate(var14);
         }

         GrupoPergunta var6 = var3.getGrupoPergunta();
         if (!Validator.isNullOrEmpty(var6)) {
            List var7 = this.this$0.checklistInteractor.obterPerguntaoPorGrupoPerguntaOff(this.val$idInspecao, this.val$idItem, this.val$idChecklist, this.val$idGrupo, var6.getId().longValue());

            for(int var8 = 0; var8 < var7.size(); ++var8) {
               Long var9 = ((Pergunta)var7.get(var8)).getId();

               try {
                  List var12 = this.this$0.respostaInteractor.obterPorPergunta(this.val$idInspecao, this.val$idItem, var9);
                  ((Pergunta)var7.get(var8)).setRespostas(var12);
               } catch (SQLException var13) {
                  Logger.error("Erro ao obter respostas por grupo pergunta.", var13);
                  Exceptions.propagate(var13);
               }
            }

            var6.setPerguntas(var7);
            var3.setGrupoPergunta(var6);
         }
      }

      return Observable.just(var1);
   }
}
