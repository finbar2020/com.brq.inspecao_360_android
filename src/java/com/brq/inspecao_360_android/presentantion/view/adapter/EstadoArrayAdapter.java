package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.brq.inspecao_360_android.model.entity.Estado;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EstadoArrayAdapter extends ArrayAdapter {
   private Context context;
   private List estados = new ArrayList();

   public EstadoArrayAdapter(@NonNull Context var1) {
      super(var1, 2131493047);
      this.context = var1;
   }

   public void add(Estado var1) {
      this.estados.add(var1);
      this.notifyDataSetChanged();
   }

   public void addAll(@NonNull Collection var1) {
      this.estados.addAll(var1);
      this.notifyDataSetChanged();
   }

   public int getCount() {
      return this.estados.size();
   }

   public View getCusomView(int var1, View var2, ViewGroup var3) {
      if (var2 == null) {
         var2 = LayoutInflater.from(this.context).inflate(2131493048, var3, false);
      }

      Estado var4 = (Estado)this.estados.get(var1);
      TextView var5 = (TextView)var2.findViewById(2131296882);
      var5.setText(var4.getNome());
      var5.setTag(var4.getId());
      return var2;
   }

   public View getDropDownView(int var1, View var2, ViewGroup var3) {
      return this.getCusomView(var1, var2, var3);
   }

   public Estado getItem(int var1) {
      return (Estado)this.estados.get(var1);
   }

   public int getItemPosition(Estado var1) {
      for(int var2 = 0; var2 < this.estados.size(); ++var2) {
         if (((Estado)this.estados.get(var2)).getId().equals(var1.getId())) {
            return var2;
         }
      }

      return 0;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      return this.getCusomView(var1, var2, var3);
   }

   public void removeAll() {
      this.estados = new ArrayList();
      this.notifyDataSetChanged();
   }
}
