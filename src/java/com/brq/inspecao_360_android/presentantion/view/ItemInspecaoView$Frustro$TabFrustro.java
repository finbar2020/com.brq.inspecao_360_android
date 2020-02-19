package com.brq.inspecao_360_android.presentantion.view;

import java.util.List;

public interface ItemInspecaoView$Frustro$TabFrustro extends ItemInspecaoView {
   public interface Fragment extends ItemInspecaoView$Fragment {
      void addMotivos(List var1);

      void carregar();

      void frustrar();

      void onError();

      void onSuccess();

      void preencherCounterFab(List var1);

      void salvar();

      void salvarSucesso();
   }
}
