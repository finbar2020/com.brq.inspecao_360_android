package com.brq.inspecao_360_android.service;

import com.brq.inspecao_360_android.model.entity.Assinatura;
import com.brq.inspecao_360_android.model.entity.Croqui;
import com.brq.inspecao_360_android.model.entity.Imagem;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.model.entity.Token;
import java.util.List;
import rx.Observable;

public interface ChecklistService {
   Observable anexar(Token var1, String var2, Long var3, Assinatura var4);

   Observable anexar(Token var1, String var2, Long var3, Imagem var4);

   Observable finalizar(Token var1, String var2, Long var3, Item var4);

   Observable iniciar(Token var1, String var2, Long var3, Long var4, List var5, Integer var6, Croqui var7);

   Observable obter(Token var1, String var2, Long var3);

   Observable terminar(Token var1, String var2, Long var3);
}
