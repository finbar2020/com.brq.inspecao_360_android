package com.brq.inspecao_360_android.presentantion.view;

import com.brq.inspecao_360_android.model.entity.Imagem;

public interface CameraView$Preview$Activity extends CameraView {
   void carregar(Imagem var1);

   void confirmaExcluir();

   void confirmaSalvar();

   void excluir();

   void onBackPressed();

   void onSuccess();

   void salvar();

   void sendRemoveBroadCast(Imagem var1);

   void sendSaveBroadCast(Imagem var1);
}
