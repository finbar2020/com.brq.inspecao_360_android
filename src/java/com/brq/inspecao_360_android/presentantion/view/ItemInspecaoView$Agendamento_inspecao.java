package com.brq.inspecao_360_android.presentantion.view;

import com.brq.inspecao_360_android.model.entity.Item;
import java.util.List;

public interface ItemInspecaoView$Agendamento_inspecao extends ItemInspecaoView {
   public interface Activity extends ItemInspecaoView$Activity {
      void aceitar();

      void addAll(List var1);

      void agendar();

      void alterarEndereco();

      void carregar();

      void devolver();

      void enquadrar();

      void enviar();

      void frustrar();

      void iniciarInspecao();

      void onError();

      void onError(String var1);

      void onSuccess();

      void onSuccessIniciar();

      void pararInspecao();

      void preencher(Item var1, boolean var2);

      void preencherCounterBottomNav(List var1);

      void recusar();

      void reenviar();

      void sair();
   }
}
