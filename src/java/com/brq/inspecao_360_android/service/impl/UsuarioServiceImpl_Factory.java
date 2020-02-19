package com.brq.inspecao_360_android.service.impl;

import dagger.internal.Factory;

public enum UsuarioServiceImpl_Factory implements Factory {
   INSTANCE;

   static {
      UsuarioServiceImpl_Factory[] var0 = new UsuarioServiceImpl_Factory[]{INSTANCE};
   }

   public static Factory create() {
      return INSTANCE;
   }

   public UsuarioServiceImpl get() {
      return new UsuarioServiceImpl();
   }
}
