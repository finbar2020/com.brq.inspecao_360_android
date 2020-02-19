package com.brq.inspecao_360_android.presentantion.view;

import android.graphics.Bitmap;
import com.brq.inspecao_360_android.model.entity.Usuario;

public interface ItemInspecaoView$Lista$Activity extends ItemInspecaoView {
   void iniLoginActivity();

   void logout();

   void setUsuarioFoto(Bitmap var1);

   void setUsuarioInfo(Usuario var1);

   void showFloatingActionButton(boolean var1);

   void showProgressFotoPerfil(boolean var1);

   void showToolbar(boolean var1);
}
