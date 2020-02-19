package com.brq.inspecao_360_android.service.endpoint;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import rx.Observable;

public interface ChecklistEndPoint {
   @Multipart
   @POST("/inspecao-360-api/v1/laudos/{id}/imagem")
   Call anexar(@Path("id") int var1, @Part("arquivo-part\"; filename=\"processar.png\"") RequestBody var2, @Part("meta-part") RequestBody var3);

   @Multipart
   @POST("/inspecao-360-api/v1/laudos/{id}/imagem")
   Observable anexar(@Path("id") Long var1, @Part("arquivo-part\"; filename=\"processar.png\"") RequestBody var2, @Part("meta-part") RequestBody var3);

   @Multipart
   @POST("/inspecao-360-api/v1/laudos/{id}/assinatura")
   Observable anexarAssinatura(@Path("id") Long var1, @Part("arquivo-part\"; filename=\"processar.png\"") RequestBody var2, @Part("meta-part") RequestBody var3);

   @POST("/inspecao-360-api/v1/laudos/{id}/emissao")
   Observable finalizar(@Path("id") Long var1, @Body RequestBody var2);

   @POST("/inspecao-360-api/v1/laudos")
   Observable iniciar(@Body RequestBody var1);

   @GET("/inspecao-360-api/v3/checklists/{id}")
   Observable obter(@Path("id") Long var1);

   @POST("/inspecao-360-api/v1/laudos/{id}/termino")
   Observable terminar(@Path("id") Long var1);
}
