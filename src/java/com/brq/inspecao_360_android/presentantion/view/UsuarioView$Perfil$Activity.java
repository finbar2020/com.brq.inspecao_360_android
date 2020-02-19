package com.brq.inspecao_360_android.presentantion.view;

import android.graphics.Bitmap;
import com.brq.inspecao_360_android.model.entity.Usuario;
import java.io.File;

public interface UsuarioView$Perfil$Activity extends UsuarioView {
   void carregar();

   File getThumbFile();

   void onSucessoSalvar();

   void setFotoUsuario(Bitmap var1);

   void setUsuarioInfo(Usuario var1);
}
