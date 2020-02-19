package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.brq.inspecao_360_android.model.entity.Enquadramento;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EnquadramentoArrayAdapter extends ArrayAdapter {
   private Context context;
   private List enquadramentos = new ArrayList();

   public EnquadramentoArrayAdapter(@NonNull Context var1) {
      super(var1, 2131493049);
      this.context = var1;
   }

   public void add(Enquadramento var1) {
      this.enquadramentos.add(var1);
      this.notifyDataSetChanged();
   }

   public void addAll(@NonNull Collection var1) {
      this.enquadramentos.addAll(var1);
      this.notifyDataSetChanged();
   }

   public int getCount() {
      return this.enquadramentos.size();
   }

   public View getCusomView(int var1, View var2, ViewGroup var3) {
      if (var2 == null) {
         var2 = LayoutInflater.from(this.context).inflate(2131493049, var3, false);
      }

      Enquadramento var4 = (Enquadramento)this.enquadramentos.get(var1);
      TextView var5 = (TextView)var2.findViewById(2131296882);
      var5.setText(var4.getNome());
      var5.setTag(var4.getId());
      if (var4.getDisabled()) {
         var5.setTextColor(-3355444);
      }

      return var2;
   }

   public View getDropDownView(int var1, View var2, ViewGroup var3) {
      return this.getCusomView(var1, var2, var3);
   }

   public Enquadramento getItem(int var1) {
      return (Enquadramento)this.enquadramentos.get(var1);
   }

   public int getItemPosition(Enquadramento var1) {
      for(int var2 = 0; var2 < this.enquadramentos.size(); ++var2) {
         if (((Enquadramento)this.enquadramentos.get(var2)).getId().equals(var1.getId())) {
            return var2;
         }
      }

      return 0;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      return this.getCusomView(var1, var2, var3);
   }

   public boolean isEnabled(int var1) {
      return true ^ this.getItem(var1).getDisabled();
   }

   public void removeAll() {
      this.enquadramentos = new ArrayList();
      List var1 = this.enquadramentos;
      Long var2 = 0L;
      if (!var1.contains(new Enquadramento(var2))) {
         this.enquadramentos.add(new Enquadramento(var2, this.context.getString(2131821253)));
      }

      this.notifyDataSetChanged();
   }
}
