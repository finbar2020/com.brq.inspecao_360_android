package com.brq.inspecao_360_android.presentantion.view;

import java.util.List;

public interface ItemInspecaoView$Devolver$Activity extends ItemInspecaoView$Activity {
   void addAll(List var1);

   void carregar();

   void devolver();

   void finalizar();

   void onError(String var1);

   void onSuccess();

   void onSuccessDevolver();

   void preencher(List var1);

   void sair();
}
