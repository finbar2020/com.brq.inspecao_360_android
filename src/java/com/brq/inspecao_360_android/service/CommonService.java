package com.brq.inspecao_360_android.service;

import com.brq.inspecao_360_android.model.entity.Token;
import java.io.File;
import rx.Observable;

public interface CommonService {
   Observable agendamentos(Token var1, String var2, Long var3);

   Observable agendamentosPorInspecao(Token var1, String var2, Long var3);

   Observable areaSegurada(Token var1, String var2, int var3, int var4);

   Observable checkAppVersion(Token var1, String var2, int var3);

   Observable classeConstrucao(Token var1, String var2);

   Observable enquadramento(Token var1, String var2, Long var3);

   Observable grupoStatus(Token var1, String var2);

   Observable horarios(Token var1, String var2, Long var3);

   Observable motivoDevolucao(Token var1, String var2);

   Observable motivoFrustro(Token var1, String var2);

   Observable motivoRecusa(Token var1, String var2);

   Observable obterStatusServidor();

   Observable produtoComercial(Token var1, String var2);

   Observable uploadFile(Token var1, String var2, File var3);

   Observable uploadFileDatabase(Token var1, String var2, File var3);
}
