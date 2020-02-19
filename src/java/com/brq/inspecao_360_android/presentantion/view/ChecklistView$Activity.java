package com.brq.inspecao_360_android.presentantion.view;

import com.brq.inspecao_360_android.model.entity.CombinedResult;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.model.entity.StatusInspecao;
import java.util.List;

public interface ChecklistView$Activity extends ChecklistView {
   void abrirDialogoCoberturaNaoEncontrada();

   void aceitar();

   void alterarEndereco();

   void atualizar(List var1);

   void carregar();

   void devolver();

   void enquadrar();

   void enviar();

   void finalizar();

   void finish();

   void frustrar();

   void iniciar();

   void iniciarInspecao();

   void loadFragment(Object var1);

   void onErrorChecklistNotFound();

   void onSuccessIniciar();

   void onSuccessParar();

   void onSuccessSave();

   void pararInspecao();

   void preencherCounterBottomNav(List var1);

   void preencherDependencias(CombinedResult var1);

   void preencherStatus(Item var1);

   void recusar();

   void reenviar();

   void setStatusInspecao(StatusInspecao var1);
}
