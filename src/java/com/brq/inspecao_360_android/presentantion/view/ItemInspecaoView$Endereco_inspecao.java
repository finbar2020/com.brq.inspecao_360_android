package com.brq.inspecao_360_android.presentantion.view;

import com.brq.inspecao_360_android.model.entity.Endereco;
import com.brq.inspecao_360_android.model.entity.Estado;
import java.util.List;

public interface ItemInspecaoView$Endereco_inspecao extends ItemInspecaoView {
   public interface Activity extends ItemInspecaoView$Activity {
      void addEstadosSpinner(List var1);

      void addMunicipiosSpinner(List var1);

      void alterarEnderecoOff();

      void carregar();

      void carregarMunicipios(Estado var1);

      void onError();

      void onSuccess();

      void preencher();

      void preencherEndereco(Endereco var1);

      void sair();

      void salvar();

      void storeEstados(List var1);

      void storeMunicipios(List var1);
   }
}
