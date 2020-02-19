package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.brq.inspecao_360_android.model.entity.ItemFiltro;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ItemLabelFiltroArrayAdapter extends ArrayAdapter {
   private Context context;
   private List itens = new ArrayList();

   public ItemLabelFiltroArrayAdapter(Context var1) {
      super(var1, 2131493028);
      this.context = var1;
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

   @Nullable
   public ItemFiltro getItem(int var1) {
      return (ItemFiltro)this.itens.get(var1);
   }

   @NonNull
   public View getView(int var1, View var2, ViewGroup var3) {
      ItemFiltro var4 = (ItemFiltro)this.itens.get(var1);
      if (var2 == null) {
         var2 = LayoutInflater.from(this.context).inflate(2131493028, (ViewGroup)null);
      }

      ((TextView)var2.findViewById(2131296901)).setText(var4.getDescricao());
      return var2;
   }
}
