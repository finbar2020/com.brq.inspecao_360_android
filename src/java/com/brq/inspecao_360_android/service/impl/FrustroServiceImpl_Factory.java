package com.brq.inspecao_360_android.service.impl;

import dagger.internal.Factory;

public enum FrustroServiceImpl_Factory implements Factory {
   INSTANCE;

   static {
      FrustroServiceImpl_Factory[] var0 = new FrustroServiceImpl_Factory[]{INSTANCE};
   }

   public static Factory create() {
      return INSTANCE;
   }

   public FrustroServiceImpl get() {
      return new FrustroServiceImpl();
   }
}
