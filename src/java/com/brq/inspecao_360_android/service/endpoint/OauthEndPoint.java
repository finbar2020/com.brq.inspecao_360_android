package com.brq.inspecao_360_android.service.endpoint;

import java.util.Map;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

public interface OauthEndPoint {
   @FormUrlEncoded
   @POST("/controle-acesso-360-api/oauth/token/")
   Observable autenticar(@FieldMap Map var1);

   @Headers({"Content-Type: application/json"})
   @POST("/controle-acesso-360-api/oauth/revoke")
   Observable logout();

   @FormUrlEncoded
   @POST("/controle-acesso-360-api/oauth/token/")
   Observable refreshTokenOAuth(@FieldMap Map var1);
}
