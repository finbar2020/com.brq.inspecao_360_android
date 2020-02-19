package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.brq.inspecao_360_android.common.enumerator.TipoTelefoneEnum;
import com.brq.inspecao_360_android.model.entity.Pessoa;
import com.brq.inspecao_360_android.model.entity.Telefone;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContatoAdapter extends BaseAdapter {
   private static final int TYPE_HEADER = 0;
   private static final int TYPE_ITEM = 1;
   private Context context;
   private List items = new ArrayList();
   private LayoutInflater mInflater;
   @Nullable
   @BindView(2131296904)
   TextView txtNomeContato;
   @Nullable
   @BindView(2131296925)
   TextView txtTelefone;
   @Nullable
   @BindView(2131296927)
   TextView txtTipoTelefone;

   public ContatoAdapter(Context var1) {
      this.context = var1;
      this.mInflater = (LayoutInflater)var1.getSystemService("layout_inflater");
   }

   public void addAll(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Pessoa var3 = (Pessoa)var2.next();
         this.items.add(var3);
         this.items.addAll(var3.getTelefones());
      }

      this.notifyDataSetChanged();
   }

   public View createItemView(Telefone var1, View var2, ViewGroup var3, int var4) {
      View var5 = this.mInflater.inflate(2131493042, var3, false);
      ButterKnife.bind(this, var5);
      this.txtTelefone.setText(var1.getNumero().toString());
      this.txtTipoTelefone.setText(TipoTelefoneEnum.getValueById(var1.getTipoTelefone()).getDescricao());
      return var5;
   }

   public View createSectionView(Pessoa var1, View var2, ViewGroup var3) {
      View var4 = this.mInflater.inflate(2131493038, var3, false);
      ButterKnife.bind(this, var4);
      this.txtNomeContato.setText(var1.getNome());
      return var4;
   }

   public int getCount() {
      return this.items.size();
   }

   public Object getItem(int var1) {
      return this.items.get(var1);
   }

   public long getItemId(int var1) {
      return 0L;
   }

   public int getItemViewType(int var1) {
      Object var2 = this.getItem(var1);
      if (var2 instanceof Pessoa) {
         return 1;
      } else {
         return var2 instanceof Telefone ? 2 : 0;
      }
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      int var4 = this.getItemViewType(var1);
      if (var4 != 1) {
         return var4 != 2 ? var2 : this.createItemView((Telefone)this.getItem(var1), var2, var3, var1);
      } else {
         return this.createSectionView((Pessoa)this.getItem(var1), var2, var3);
      }
   }
}
