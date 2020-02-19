package com.brq.inspecao_360_android.common.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

public class GcmBroadcastReceiver extends WakefulBroadcastReceiver {
   public void onReceive(Context var1, Intent var2) {
      startWakefulService(var1, var2.setComponent(new ComponentName(var1.getPackageName(), InspecaoGcmListenerService.class.getName())));
      this.setResultCode(-1);
   }
}
