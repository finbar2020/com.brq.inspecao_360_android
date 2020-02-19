package com.brq.inspecao_360_android.common.util;

public class MainBus extends RxEventBus {
   private static MainBus instance;

   private MainBus() {
   }

   public static MainBus getInstance() {
      if (instance == null) {
         instance = new MainBus();
      }

      return instance;
   }
}
