package com.brq.inspecao_360_android.presentantion.view;

public interface ItemInspecaoView$Enquadramento_inspecao extends ItemInspecaoView {
   public interface Activity extends ItemInspecaoView$Activity {
      void carregar();

      void enquadrarOff();

      void enquadrarOn();

      void onError();

      void onSuccess();

      void sair();

      void salvar();
   }
}
