package com.brq.inspecao_360_android.service.impl;

import dagger.internal.Factory;

public enum AnexoServiceImpl_Factory implements Factory {
   INSTANCE;

   static {
      AnexoServiceImpl_Factory[] var0 = new AnexoServiceImpl_Factory[]{INSTANCE};
   }

   public static Factory create() {
      return INSTANCE;
   }

   public AnexoServiceImpl get() {
      return new AnexoServiceImpl();
   }
}
