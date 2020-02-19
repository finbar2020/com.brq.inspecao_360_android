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
import com.brq.inspecao_360_android.model.entity.Cobertura;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CoberturaAdapter extends ArrayAdapter {
   private Context context;
   private List itens = new ArrayList();
   @BindView(2131296900)
   TextView txtCobertura;

   public CoberturaAdapter(@NonNull Context var1) {
      super(var1, 2131493024);
      this.context = var1;
   }

   public void addAll(@NonNull Collection var1) {
      this.itens.addAll(var1);
      this.notifyDataSetChanged();
   }

   public int getCount() {
      return this.itens.size();
   }

   @Nullable
   public Cobertura getItem(int var1) {
      return (Cobertura)this.itens.get(var1);
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      Cobertura var4 = this.getItem(var1);
      if (var2 == null) {
         var2 = LayoutInflater.from(this.context).inflate(2131493024, (ViewGroup)null);
      }

      ButterKnife.bind(this, var2);
      this.txtCobertura.setText(var4.getDescricao());
      return var2;
   }
}
