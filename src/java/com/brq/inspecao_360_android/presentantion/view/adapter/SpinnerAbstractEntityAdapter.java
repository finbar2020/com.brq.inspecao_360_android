package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.brq.inspecao_360_android.model.entity.BaseEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SpinnerAbstractEntityAdapter extends ArrayAdapter {
   private Context context;
   private List itens = new ArrayList();

   public SpinnerAbstractEntityAdapter(Context var1, int var2) {
      super(var1, var2);
   }

   public SpinnerAbstractEntityAdapter(Context var1, List var2) {
      super(var1, 2131493047, var2);
      this.context = var1;
      this.itens = var2;
   }

   public void add(BaseEntity var1) {
      this.itens.add(var1);
      this.notifyDataSetChanged();
   }

   public void addAll(Collection var1) {
      this.itens.addAll(var1);
      this.notifyDataSetChanged();
   }

   public void clear() {
      this.itens.clear();
      this.notifyDataSetChanged();
   }

   public int getCount() {
      return this.itens.size();
   }

   public View getCusomView(int var1, View var2, ViewGroup var3) {
      if (var2 == null) {
         var2 = LayoutInflater.from(this.getContext()).inflate(2131493047, var3, false);
      }

      BaseEntity var4 = (BaseEntity)this.itens.get(var1);
      TextView var5 = (TextView)var2.findViewById(2131296882);
      var5.setText(var4.getDescricao());
      var5.setTag(var4.getId());
      return var2;
   }

   public View getDropDownView(int var1, View var2, ViewGroup var3) {
      return this.getCusomView(var1, var2, var3);
   }

   public BaseEntity getItem(int var1) {
      return (BaseEntity)this.itens.get(var1);
   }

   public List getItens() {
      return this.itens;
   }

   public int getPosition(BaseEntity var1) {
      for(int var2 = 0; var2 < this.itens.size(); ++var2) {
         if (((BaseEntity)this.itens.get(var2)).getId().equals(var1.getId())) {
            return var2;
         }
      }

      return 0;
   }

   public int getPosition(Long var1) {
      if (this.itens != null) {
         for(int var2 = 0; var2 < this.itens.size(); ++var2) {
            if (((BaseEntity)this.itens.get(var2)).getId().equals(var1)) {
               return var2;
            }
         }
      }

      return 0;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      return this.getCusomView(var1, var2, var3);
   }
}
