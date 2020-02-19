package com.brq.inspecao_360_android.service;

import com.brq.inspecao_360_android.model.entity.Token;
import rx.Observable;

public interface AnexoService {
   Observable obterAnexo(Token var1, String var2, Long var3);

   Observable obterListaAnexos(Token var1, String var2, Long var3, Long var4);

   Observable obterListaAnexosPorInspecao(Token var1, String var2, Long var3);
}
