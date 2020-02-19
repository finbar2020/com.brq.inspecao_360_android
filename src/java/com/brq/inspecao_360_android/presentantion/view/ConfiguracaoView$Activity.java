package com.brq.inspecao_360_android.presentantion.view;

import com.brq.inspecao_360_android.model.entity.Configuracao;

public interface ConfiguracaoView$Activity extends ConfiguracaoView {
   void carregar();

   void onBackPressed();

   void preencher(Configuracao var1);

   void salvar();
}
