package com.brq.inspecao_360_android.presentantion.view;

import java.util.List;

public interface ItemInspecaoView$Recusa$Activity extends ItemInspecaoView$Activity {
   void addAll(List var1);

   void carregar();

   void finalizar();

   void onError(String var1);

   void onSuccess();

   void onSuccessRecusa();

   void preencher(List var1);

   void recusar();

   void sair();
}
