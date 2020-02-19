package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.model.entity.Agendamento;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AgendamentoArrayAdapter extends ArrayAdapter {
   private List itens = new ArrayList();
   @BindView(2131296883)
   TextView txtDescData;
   @Nullable
   @BindView(2131296886)
   TextView txtDia;
   @Nullable
   @BindView(2131296898)
   TextView txtHorario;
   @Nullable
   @BindView(2131296943)
   View viewAtivo;

   public AgendamentoArrayAdapter(Context var1, int var2) {
      super(var1, var2);
   }

   public void addAll(Collection var1) {
      if (!Validator.isNullOrEmpty(this.itens)) {
         this.itens.clear();
         this.notifyDataSetChanged();
      }

      this.itens.addAll(var1);
      this.notifyDataSetChanged();
   }

   public int getCount() {
      return this.itens.size();
   }

   @Nullable
   public Agendamento getItem(int var1) {
      return (Agendamento)this.itens.get(var1);
   }

   public long getItemId(int var1) {
      return (long)((Agendamento)this.itens.get(var1)).getId();
   }

   public List getItens() {
      return this.itens;
   }

   @NonNull
   public View getView(int var1, View var2, ViewGroup var3) {
      Agendamento var4 = this.getItem(var1);
      if (var4.isAgendamentoAtivo()) {
         View var9 = LayoutInflater.from(this.getContext()).inflate(2131493022, var3, false);
         ButterKnife.bind(this, var9);
         this.txtDia.setText(var4.getDiaMes());
         TextView var11 = this.txtDescData;
         Object[] var12 = new Object[]{var4.getDiaSemana(), var4.getMesPorExtenso(), String.valueOf(var4.getAno())};
         var11.setText(String.format("%s - %s, %s", var12));
         this.txtHorario.setText(var4.getHorario().getTexto());
         return var9;
      } else {
         View var5 = LayoutInflater.from(this.getContext()).inflate(2131493021, var3, false);
         ButterKnife.bind(this, var5);
         TextView var7 = this.txtDescData;
         Object[] var8 = new Object[]{var4.getDataFormatada(), var4.getHorario().getTexto(), var4.getDiaSemana()};
         var7.setText(String.format("%s, %s - %s", var8));
         return var5;
      }
   }
}
