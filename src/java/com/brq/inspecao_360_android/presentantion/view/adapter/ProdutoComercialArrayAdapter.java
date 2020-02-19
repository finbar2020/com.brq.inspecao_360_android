package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.brq.inspecao_360_android.model.entity.ProdutoComercial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProdutoComercialArrayAdapter extends ArrayAdapter {
   private Context context;
   private List produtosComerciais = new ArrayList();

   public ProdutoComercialArrayAdapter(@NonNull Context var1) {
      super(var1, 2131493049);
      this.context = var1;
   }

   public void add(ProdutoComercial var1) {
      this.produtosComerciais.add(var1);
      this.notifyDataSetChanged();
   }

   public void addAll(@NonNull Collection var1) {
      this.produtosComerciais.addAll(var1);
      this.notifyDataSetChanged();
   }

   public int getCount() {
      return this.produtosComerciais.size();
   }

   public View getCusomView(int var1, View var2, ViewGroup var3) {
      if (var2 == null) {
         var2 = LayoutInflater.from(this.context).inflate(2131493049, var3, false);
      }

      ProdutoComercial var4 = (ProdutoComercial)this.produtosComerciais.get(var1);
      TextView var5 = (TextView)var2.findViewById(2131296882);
      var5.setText(var4.getNome());
      var5.setTag(var4.getId());
      return var2;
   }

   public View getDropDownView(int var1, View var2, ViewGroup var3) {
      return this.getCusomView(var1, var2, var3);
   }

   public ProdutoComercial getItem(int var1) {
      return (ProdutoComercial)this.produtosComerciais.get(var1);
   }

   public int getItemPosition(ProdutoComercial var1) {
      for(int var2 = 0; var2 < this.produtosComerciais.size(); ++var2) {
         if (((ProdutoComercial)this.produtosComerciais.get(var2)).getId().equals(var1.getId())) {
            return var2;
         }
      }

      return 0;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      return this.getCusomView(var1, var2, var3);
   }

   public void removeAll() {
      this.produtosComerciais = new ArrayList();
      List var1 = this.produtosComerciais;
      Integer var2 = 0;
      if (!var1.contains(new ProdutoComercial(var2))) {
         this.produtosComerciais.add(new ProdutoComercial(var2, this.context.getString(2131821253)));
      }

      this.notifyDataSetChanged();
   }
}
