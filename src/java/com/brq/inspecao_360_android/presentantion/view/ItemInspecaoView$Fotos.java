package com.brq.inspecao_360_android.presentantion.view;

import com.brq.inspecao_360_android.model.entity.Imagem;

public interface ItemInspecaoView$Fotos extends ItemInspecaoView {
   public interface Activity extends ItemInspecaoView$Activity {
      void abrirCamera();

      void aceitar();

      void alterarEndereco();

      void carregar();

      void devolver();

      void enquadrar();

      void enviar();

      void frustrar();

      void iniciarInspecao();

      void onError();

      void onSuccess();

      void onSuccessIniciar();

      void pararInspecao();

      void preencherContador(int var1);

      void recusar();

      void reenviar();

      void sendRemoveBroadCast(Imagem var1);
   }
}
