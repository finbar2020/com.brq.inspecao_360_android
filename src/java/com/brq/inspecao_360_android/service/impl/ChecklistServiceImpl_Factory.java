package com.brq.inspecao_360_android.service.impl;

import dagger.internal.Factory;

public enum ChecklistServiceImpl_Factory implements Factory {
   INSTANCE;

   static {
      ChecklistServiceImpl_Factory[] var0 = new ChecklistServiceImpl_Factory[]{INSTANCE};
   }

   public static Factory create() {
      return INSTANCE;
   }

   public ChecklistServiceImpl get() {
      return new ChecklistServiceImpl();
   }
}
