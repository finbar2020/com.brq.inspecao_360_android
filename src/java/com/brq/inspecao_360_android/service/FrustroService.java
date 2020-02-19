package com.brq.inspecao_360_android.service;

import com.brq.inspecao_360_android.model.entity.Assinatura;
import com.brq.inspecao_360_android.model.entity.Imagem;
import com.brq.inspecao_360_android.model.entity.Token;
import rx.Observable;

public interface FrustroService {
   Observable anexar(Token var1, String var2, Long var3, Assinatura var4);

   Observable anexar(Token var1, String var2, Long var3, Imagem var4);

   Observable finalizar(Token var1, String var2, Long var3);

   Observable iniciar(Token var1, String var2, Long var3, Long var4, Long var5, String var6);
}
