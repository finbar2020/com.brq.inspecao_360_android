package com.brq.inspecao_360_android.presentantion.view;

public interface ItemInspecaoView$Assinatura_inspecao extends ItemInspecaoView {
   public interface Activity extends ItemInspecaoView$Activity {
      void carregar();

      void onError();

      void onSuccess();

      void onSuccessSalvarRecusa();

      void sair();

      void salvarOff();

      void salvarOn();
   }
}
