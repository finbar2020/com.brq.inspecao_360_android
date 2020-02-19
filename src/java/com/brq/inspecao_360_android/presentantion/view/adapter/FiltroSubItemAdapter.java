package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.brq.inspecao_360_android.model.entity.ItemFiltro;
import java.util.ArrayList;
import java.util.List;

public class FiltroSubItemAdapter extends BaseAdapter {
   private Context context;
   private List itens = new ArrayList();
   private List selecteds = new ArrayList();
   private String tipo;

   public FiltroSubItemAdapter(Context var1) {
      this.context = var1;
   }

   public FiltroSubItemAdapter(Context var1, List var2) {
      this.selecteds = var2;
      this.context = var1;
   }

   public void addAll(List var1) {
      this.itens.addAll(var1);
      this.notifyDataSetChanged();
   }

   public int getCount() {
      return this.itens.size();
   }

   @Nullable
   public ItemFiltro getItem(int var1) {
      return (ItemFiltro)this.itens.get(var1);
   }

   public long getItemId(int var1) {
      return 0L;
   }

   public List getSelecteds() {
      return this.selecteds;
   }

   @NonNull
   public View getView(final int var1, View var2, ViewGroup var3) {
      ItemFiltro var4 = (ItemFiltro)this.itens.get(var1);
      if (var2 == null) {
         var2 = LayoutInflater.from(this.context).inflate(2131493037, (ViewGroup)null);
      }

      ((TextView)var2.findViewById(2131296384)).setText(var4.getDescricao());
      CheckBox var5 = (CheckBox)var2.findViewById(2131296352);
      if (this.selecteds.contains(var4)) {
         var5.setChecked(true);
      } else {
         var5.setChecked(false);
      }

      var5.setOnClickListener(new OnClickListener() {
         public void onClick(View var1x) {
            FiltroSubItemAdapter.this.toggle(var1);
         }
      });
      return var2;
   }

   public void toggle(int var1) {
      ItemFiltro var2 = this.getItem(var1);
      if (this.selecteds.contains(var2)) {
         this.selecteds.remove(var2);
      } else {
         this.selecteds.add(var2);
      }

      this.notifyDataSetChanged();
   }
}
