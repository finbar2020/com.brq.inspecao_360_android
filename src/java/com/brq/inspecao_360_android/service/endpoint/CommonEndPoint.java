package com.brq.inspecao_360_android.service.endpoint;

import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface CommonEndPoint {
   @GET("/inspecao-360-api/v1/agendamentos")
   Observable agendamentos(@Query("itemInspecao") Long var1);

   @GET("/inspecao-360-api/v1/agendamentos")
   Observable agendamentosPorInspecao(@Query("inspecao") Long var1);

   @GET("/inspecao-360-api/public/check-app-version/{id}")
   Observable checkAppVersion(@Path("id") int var1);

   @GET("/inspecao-360-api/v1/horariosAgendamento")
   Observable horarios(@Query("seguradora") Long var1);

   @GET("/inspecao-360-api/v1/motivosDevolucao")
   Observable motivoDevolucao();

   @GET("/inspecao-360-api/v1/motivosFrustro")
   Observable motivoFrustro();

   @GET("/inspecao-360-api/v1/motivosRecusa")
   Observable motivoRecusa();

   @GET("/inspecao-360-api/v1/inspecoes/{id}/item/{idItem}/areasSeguradas")
   Observable obterAreasSeguradas(@Path("id") int var1, @Path("idItem") int var2);

   @GET("/inspecao-360-api/v1/classesConstrucao")
   Observable obterClassesConstrucoes();

   @GET("/inspecao-360-api/v1/produtos/{id}/enquadramentos")
   Observable obterEnquadramentos(@Path("id") int var1);

   @GET("/inspecao-360-api/v1/produtos")
   Observable obterProdutosComerciais();

   @GET("/controle-acesso-360-api/public/version")
   Observable obterStatusServidor();

   @Multipart
   @POST("/inspecao-360-api/v1/app/{id}/log")
   Observable uploadFile(@Path("id") String var1, @Part("arquivo-part\"; filename=\"arquivo.txt\"") RequestBody var2);

   @Multipart
   @POST("/inspecao-360-api/v1/app/{id}/log")
   Observable uploadFileDatabase(@Path("id") String var1, @Part("arquivo-part\"; filename=\"database.sql\"") RequestBody var2);
}
