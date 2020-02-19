package com.brq.inspecao_360_android.service;

import com.brq.inspecao_360_android.model.entity.Croqui;
import com.brq.inspecao_360_android.model.entity.Endereco;
import com.brq.inspecao_360_android.model.entity.Token;
import java.util.List;
import rx.Observable;

public interface ItemInspecaoService {
   Observable aceitar(Token var1, String var2, Long var3, Long var4, String var5);

   Observable aceitar(Token var1, String var2, Long var3, List var4, String var5);

   Observable agendar(Token var1, String var2, Long var3, Long var4, String var5, Long var6, String var7);

   Observable agendar(Token var1, String var2, Long var3, String var4, Long var5, String var6);

   Observable agendar(Token var1, String var2, Long var3, List var4, String var5, Long var6, String var7);

   Observable alterarEndereco(Token var1, String var2, Long var3, Long var4, Endereco var5);

   Observable devolver(Token var1, String var2, Long var3, Long var4, Long var5, String var6);

   Observable devolver(Token var1, String var2, Long var3, List var4, Long var5, String var6);

   Observable enquadrar(Token var1, String var2, Long var3, Long var4, List var5);

   Observable enviarRastreios(Long var1, Token var2, String var3, Long var4, List var5);

   Observable obter(Token var1, String var2, Long var3);

   Observable obter(Token var1, String var2, Long var3, Long var4);

   Observable obter(Token var1, String var2, int[] var3, int var4, int var5, String var6, String[] var7, String var8);

   Observable obterAssinaturaResponsavel(Token var1, String var2, Long var3);

   Observable obterEnderecoPorCep(Token var1, String var2, String var3);

   Observable recusar(Token var1, String var2, Long var3, Long var4, Long var5, String var6);

   Observable recusar(Token var1, String var2, Long var3, List var4, Long var5, String var6);

   Observable salvarCroqui(Token var1, String var2, Croqui var3);
}
