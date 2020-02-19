package com.brq.inspecao_360_android.common.util;

import android.content.Context;
import android.os.Build.VERSION;
import com.brq.inspecao_360_android.model.entity.Usuario;
import com.hypertrack.hyperlog.LogFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomLogMessageFormat extends LogFormat {
   private String userEmail;

   public CustomLogMessageFormat(Context var1) {
      super(var1);
      Usuario var2 = (new SharedPreferenceUtil(var1)).getUsuarioInfo();
      if (!Validator.isNullOrEmpty(var2)) {
         this.userEmail = var2.getEmail();
      }

   }

   public String getFormattedLogMessage(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
      if (var7 == null) {
         var7 = "DeviceUUID";
      }

      if (this.userEmail == null) {
         this.userEmail = "userEmail";
      }

      String var8 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(DateUtil.toBR(new Date()));
      String var9 = VERSION.RELEASE;
      StringBuilder var10 = new StringBuilder();
      var10.append(var8);
      var10.append(" | ");
      var10.append(165);
      var10.append(" | ");
      var10.append(var9);
      var10.append(" | ");
      var10.append(var7);
      var10.append(" | ");
      var10.append(this.userEmail);
      var10.append(" | [");
      var10.append(var1);
      var10.append("]: ");
      var10.append(var3);
      return var10.toString();
   }
}
