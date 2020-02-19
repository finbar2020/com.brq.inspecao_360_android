package com.brq.inspecao_360_android.service.endpoint;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import rx.Observable;

public interface FrustroEndPoint {
   @Multipart
   @POST("/inspecao-360-api/v1/laudosFrustro/{id}/imagem")
   Observable anexar(@Path("id") Long var1, @Part("imagem-part\"; filename=\"frustro.png\"") RequestBody var2, @Part("meta-part") RequestBody var3);

   @Multipart
   @POST("/inspecao-360-api/v1/laudosFrustro/{id}/assinatura")
   Observable anexarAssinatura(@Path("id") Long var1, @Part("arquivo-part\"; filename=\"processar.png\"") RequestBody var2, @Part("meta-part") RequestBody var3);

   @POST("/inspecao-360-api/v1/laudosFrustro/{id}/termino")
   Observable frustrarTermino(@Path("id") Long var1);

   @POST("/inspecao-360-api/v1/laudosFrustro")
   Observable iniciar(@Body RequestBody var1);
}
