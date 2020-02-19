package com.brq.inspecao_360_android.common.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeserializer implements JsonDeserializer {
   public Date deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      String var4 = var1.getAsString();
      SimpleDateFormat var5;
      if (this.isDataHora(var4)) {
         var5 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      } else {
         var5 = new SimpleDateFormat("dd/MM/yyyy");
      }

      try {
         Date var7 = var5.parse(var4);
         return var7;
      } catch (ParseException var8) {
         Logger.error(var8.getMessage(), var8);
         return null;
      }
   }

   public boolean isDataHora(String var1) {
      return var1 != null && !var1.matches("^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$");
   }
}
