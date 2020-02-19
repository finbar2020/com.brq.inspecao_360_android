package com.brq.inspecao_360_android.service.endpoint;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import rx.Observable;

public interface AnexoEndPoint {
   @GET("/inspecao-360-api/v1/anexos/{idAnexo}")
   Observable obterAnexo(@Path("idAnexo") Long var1, @Header("download-identifier") String var2);

   @GET("/inspecao-360-api/v1/inspecoes/{id}/anexos/{idAnexo}")
   Observable obterAnexoPelaInspecao(@Path("id") Long var1, @Path("idAnexo") Long var2, @Header("download-identifier") String var3);

   @GET("/inspecao-360-api/v1/inspecoes/{id}/item/{idItem}/anexos")
   Observable obterListaAnexos(@Path("id") Long var1, @Path("idItem") Long var2);

   @GET("/inspecao-360-api/v1/inspecoes/{id}/anexos")
   Observable obterListaAnexosPorInspecao(@Path("id") Long var1);
}
