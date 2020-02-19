package com.brq.inspecao_360_android.service;

import android.location.Location;
import com.brq.inspecao_360_android.model.entity.Token;
import com.brq.inspecao_360_android.model.entity.Usuario;
import java.io.File;
import java.util.List;
import rx.Observable;

public interface UsuarioService {
   Observable atualizar(Token var1, String var2, Usuario var3, File var4);

   Observable autenticar(String var1, String var2, String var3);

   Observable obterFoto(Token var1, String var2);

   Observable obterInfo(Token var1, String var2);

   Observable rastrear(Token var1, String var2, String var3, Location var4);

   Observable rastrearEmLote(Token var1, String var2, List var3);

   Observable redefinirSenha(String var1);

   Observable registrar(Token var1, String var2, String var3);

   Observable sair(Token var1, String var2);
}
