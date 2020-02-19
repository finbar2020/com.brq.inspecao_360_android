package com.brq.inspecao_360_android.service.endpoint;

import retrofit2.http.GET;
import rx.Observable;

public interface StatusEndPoint {
   @GET("/inspecao-360-api/v1/grupos/status/inspecao")
   Observable obterGrupo();
}
