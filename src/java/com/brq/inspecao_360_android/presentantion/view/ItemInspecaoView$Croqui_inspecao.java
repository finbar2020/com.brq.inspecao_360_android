package com.brq.inspecao_360_android.presentantion.view;

import com.brq.inspecao_360_android.model.entity.Item;

public interface ItemInspecaoView$Croqui_inspecao extends ItemInspecaoView {
   public interface Activity extends ItemInspecaoView$Activity {
      void carregar();

      void onError();

      void onSuccess();

      void preencherECarregarMapa(Item var1);

      void salvarOff();

      void salvarOn();
   }
}
