package com.brq.inspecao_360_android.service.endpoint;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface ItemInspecaoEndPoint {
   @POST("/inspecao-360-api/v1/inspecoes/{id}/item/{idItem}/aceite")
   Observable aceitar(@Path("id") Long var1, @Path("idItem") Long var2, @Body RequestBody var3);

   @POST("/inspecao-360-api/v1/inspecoes/{id}/lote-aceite")
   Observable aceitar(@Path("id") Long var1, @Body RequestBody var2);

   @POST("/inspecao-360-api/v1/inspecoes/{id}/item/{idItem}/agendamento")
   Observable agendar(@Path("id") Long var1, @Path("idItem") Long var2, @Body RequestBody var3);

   @POST("/inspecao-360-api/v1/inspecoes/{id}/agendamento")
   Observable agendar(@Path("id") Long var1, @Body RequestBody var2);

   @POST("/inspecao-360-api/v1/inspecoes/{id}/lote-agendamento")
   Observable agendarLote(@Path("id") Long var1, @Body RequestBody var2);

   @POST("/inspecao-360-api/v1/inspecoes/{id}/item/{idItem}/alteracaoCroqui")
   Observable alterarCroqui(@Path("id") Long var1, @Path("idItem") Long var2, @Body RequestBody var3);

   @POST("/inspecao-360-api/v1/inspecoes/{id}/item/{idItem}/alteracaoEndereco")
   Observable alterarEndereco(@Path("id") Long var1, @Path("idItem") Long var2, @Body RequestBody var3);

   @POST("/inspecao-360-api/v1/status")
   Response atualizarStatus(@Field("itemInspecao") int var1, @Field("mStatusInspecao") int var2, @Field("observacao") String var3);

   @POST("/inspecao-360-api/v1/inspecoes/{id}/item/{idItem}/devolucao")
   Observable devolver(@Path("id") Long var1, @Path("idItem") Long var2, @Body RequestBody var3);

   @POST("/inspecao-360-api/v1/inspecoes/{id}/lote-devolucao")
   Observable devolver(@Path("id") Long var1, @Body RequestBody var2);

   @PUT("/inspecao-360-api/v1/inspecoes/{id}/item/{idItem}/reenquadramento")
   Observable enquadrar(@Path("id") Long var1, @Path("idItem") Long var2, @Body RequestBody var3);

   @Multipart
   @POST("/inspecao-360-api/v1/log/android/{id-dispositivo}/")
   Call enviarLog(@Path("id-dispositivo") String var1, @Part("arquivo-part\"; filename=\"log.txt\"") RequestBody var2);

   @POST("/inspecao-360-api/v1/laudos/{id}/rastreioLaudoInspecao")
   Observable enviarRastreios(@Path("id") Long var1, @Body RequestBody var2);

   @GET("/inspecao-360-api/v1/horariosAgendamento")
   Call horariosAgendamento(@Query("seguradora") int var1);

   @GET("/inspecao-360-api/v1/inspecoes/{id}")
   Observable inspecoes(@Path("id") Long var1);

   @GET("/inspecao-360-api/v1/inspecoes/{id}/item/{idItem}")
   Observable inspecoes(@Path("id") Long var1, @Path("idItem") Long var2);

   @GET("/inspecao-360-api/v1/inspecoes")
   Observable inspecoes(@Query("status") int[] var1, @Query("page") int var2, @Query("size") int var3, @Query("dataUltimaAtualizacao") String var4, @Query("properties") String[] var5, @Query("direction") String var6);

   @GET("/inspecao-360-api//v1/laudos/{id}/assinaturaResponsavel")
   Observable obterAssinaturaResponsavel(@Path("id") Long var1);

   @GET("/inspecao-360-api/v1/enderecos")
   Observable obterEnderecoPor(@Query("cep") String var1);

   @POST("/inspecao-360-api/v1/inspecoes/{id}/item/{idItem}/recusa")
   Observable recusar(@Path("id") Long var1, @Path("idItem") Long var2, @Body RequestBody var3);

   @POST("/inspecao-360-api/v1/inspecoes/{id}/lote-recusa")
   Observable recusar(@Path("id") Long var1, @Body RequestBody var2);
}
