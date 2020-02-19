package com.brq.inspecao_360_android.presentantion.view;

import android.widget.EditText;

public interface LoginView$Activity extends LoginView {
   void carregar();

   void entrar();

   void isShowBtnEntrar(boolean var1);

   void isShowProgressLogin(boolean var1);

   void onSuccess();

   void redefinirSenha(EditText var1);

   void showAlertaRedefinirSenha();

   boolean validar();
}
