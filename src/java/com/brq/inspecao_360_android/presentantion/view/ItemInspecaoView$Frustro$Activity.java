package com.brq.inspecao_360_android.presentantion.view;

import com.brq.inspecao_360_android.model.entity.Imagem;
import java.util.List;

public interface ItemInspecaoView$Frustro$Activity extends ItemInspecaoView$Activity {
   void alterarAssinatura();

   void carregar();

   void onError();

   void onSuccess();

   void preencherContador(Integer var1);

   void preencherCounterFab(List var1);

   void sendRemoveBroadCast(Imagem var1);
}
