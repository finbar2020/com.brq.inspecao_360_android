package com.brq.inspecao_360_android.presentantion.view;

import com.brq.inspecao_360_android.model.entity.CardItemInspecao;
import com.brq.inspecao_360_android.model.entity.SchemaItem;
import java.util.List;

public interface ItemInspecaoView$ListaGrupo$Fragment extends ItemInspecaoView$Fragment {
   void addAll(List var1);

   void addItem(CardItemInspecao var1);

   void addOrUpdateItem(CardItemInspecao var1);

   void atualizar();

   void carregar();

   void filtrar();

   void limparFiltro();

   void onSuccessAceitar(boolean var1);

   void preencher(SchemaItem var1);

   void recarregar();

   void showSwipe(boolean var1);
}
