package com.brq.inspecao_360_android.service.endpoint;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

public interface DispositivoEndPoint {
   @POST("/inspecao-360-api/v1/app/rastreioDispositivo")
   Observable enviarRastreioEmLote(@Body RequestBody var1);

   @PUT("/controle-acesso-360-api/v1/dispositivos/{id}")
   Observable registrar(@Path("id") String var1, @Body RequestBody var2);
}
