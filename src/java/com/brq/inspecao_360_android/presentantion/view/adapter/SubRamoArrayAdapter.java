package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.brq.inspecao_360_android.model.entity.SubRamo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SubRamoArrayAdapter extends ArrayAdapter {
   private Context context;
   private List subRamos = new ArrayList();

   public SubRamoArrayAdapter(@NonNull Context var1) {
      super(var1, 2131493049);
      this.context = var1;
   }

   public void add(SubRamo var1) {
      this.subRamos.add(var1);
      this.notifyDataSetChanged();
   }

   public void addAll(@NonNull Collection var1) {
      this.subRamos.addAll(var1);
      this.notifyDataSetChanged();
   }

   public int getCount() {
      return this.subRamos.size();
   }

   public View getCusomView(int var1, View var2, ViewGroup var3) {
      if (var2 == null) {
         var2 = LayoutInflater.from(this.context).inflate(2131493049, var3, false);
      }

      SubRamo var4 = (SubRamo)this.subRamos.get(var1);
      TextView var5 = (TextView)var2.findViewById(2131296882);
      var5.setText(var4.getNome());
      var5.setTag(var4.getId());
      return var2;
   }

   public View getDropDownView(int var1, View var2, ViewGroup var3) {
      return this.getCusomView(var1, var2, var3);
   }

   public SubRamo getItem(int var1) {
      return (SubRamo)this.subRamos.get(var1);
   }

   public int getItemPosition(SubRamo var1) {
      for(int var2 = 0; var2 < this.subRamos.size(); ++var2) {
         if (((SubRamo)this.subRamos.get(var2)).getId().equals(var1.getId())) {
            return var2;
         }
      }

      return 0;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      return this.getCusomView(var1, var2, var3);
   }

   public void removeAll() {
      this.subRamos = new ArrayList();
      List var1 = this.subRamos;
      Long var2 = 0L;
      if (!var1.contains(new SubRamo(var2))) {
         this.subRamos.add(new SubRamo(var2, this.context.getString(2131821253)));
      }

      this.notifyDataSetChanged();
   }
}
