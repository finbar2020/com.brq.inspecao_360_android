package com.brq.inspecao_360_android.service.impl;

import dagger.internal.Factory;

public enum ItemInspecaoServiceImpl_Factory implements Factory {
   INSTANCE;

   static {
      ItemInspecaoServiceImpl_Factory[] var0 = new ItemInspecaoServiceImpl_Factory[]{INSTANCE};
   }

   public static Factory create() {
      return INSTANCE;
   }

   public ItemInspecaoServiceImpl get() {
      return new ItemInspecaoServiceImpl();
   }
}
