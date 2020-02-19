package com.brq.inspecao_360_android.service.endpoint;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

public interface UsuarioEndPoint {
   @Multipart
   @POST("/controle-acesso-360-api/v1/usuarios/info/")
   Observable atualizarInfo(@Part("usuario-part") RequestBody var1, @Part("imagem-part\"; filename=\"thumb.png\"") RequestBody var2);

   @GET("/controle-acesso-360-api/v1/usuarios/info/imagem")
   Observable obterFoto();

   @GET("/controle-acesso-360-api/v1/usuarios/info/")
   Observable obterInfo();

   @POST("/controle-acesso-360-api/resetar_senha")
   Observable reiniciarSenha(@Body RequestBody var1);
}
