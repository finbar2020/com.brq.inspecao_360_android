package com.brq.inspecao_360_android.service.impl;

import dagger.internal.Factory;

public enum CommonServiceImpl_Factory implements Factory {
   INSTANCE;

   static {
      CommonServiceImpl_Factory[] var0 = new CommonServiceImpl_Factory[]{INSTANCE};
   }

   public static Factory create() {
      return INSTANCE;
   }

   public CommonServiceImpl get() {
      return new CommonServiceImpl();
   }
}
