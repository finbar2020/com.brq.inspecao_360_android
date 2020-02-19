package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.brq.inspecao_360_android.model.entity.Horario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HorarioArrayAdapter extends ArrayAdapter {
   private Context context;
   private List horarios = new ArrayList();

   public HorarioArrayAdapter(@NonNull Context var1) {
      super(var1, 2131493047);
      this.context = var1;
   }

   public void add(Horario var1) {
      this.horarios.add(var1);
      this.notifyDataSetChanged();
   }

   public void addAll(@NonNull Collection var1) {
      this.horarios.addAll(var1);
      this.notifyDataSetChanged();
   }

   public int getCount() {
      return this.horarios.size();
   }

   public View getCusomView(int var1, View var2, ViewGroup var3) {
      if (var2 == null) {
         var2 = LayoutInflater.from(this.context).inflate(2131493047, var3, false);
      }

      Horario var4 = (Horario)this.horarios.get(var1);
      TextView var5 = (TextView)var2.findViewById(2131296882);
      var5.setText(var4.getTexto());
      var5.setTag(var4.getId());
      return var2;
   }

   public View getDropDownView(int var1, View var2, ViewGroup var3) {
      return this.getCusomView(var1, var2, var3);
   }

   public Horario getItem(int var1) {
      return (Horario)this.horarios.get(var1);
   }

   public int getItemPosition(Horario var1) {
      for(int var2 = 0; var2 < this.horarios.size(); ++var2) {
         if (((Horario)this.horarios.get(var2)).getId() == var1.getId()) {
            return var2;
         }
      }

      return 0;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      return this.getCusomView(var1, var2, var3);
   }
}
