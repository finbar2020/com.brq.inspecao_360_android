package com.brq.inspecao_360_android.presentantion.view;

import com.brq.inspecao_360_android.model.entity.Item;
import java.util.List;

public interface ChecklistView$Pergunta$Lista$Fragment extends ChecklistView {
   void atualizar(Item var1);

   void carregar(boolean var1);

   void carregarInterdependencias(List var1);

   void iniciar();

   void montarQuestionario(List var1, boolean var2);

   void onSalvarSucesso(List var1);

   void onSuccessSave();

   void salvar(boolean var1);

   List shouldDeleteResponses();

   void verificarShowHideComponents();
}
