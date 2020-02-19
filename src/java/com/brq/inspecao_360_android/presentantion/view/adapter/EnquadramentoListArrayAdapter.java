package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.model.entity.ItemEnquadramento;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class EnquadramentoListArrayAdapter extends ArrayAdapter {
   @BindView(2131296492)
   ImageView icDelete;
   @BindView(2131296495)
   ImageView icEdit;
   @BindView(2131296499)
   ImageView icFile;
   private List itens = new ArrayList();
   private FragmentManager mFm;
   @Nullable
   @BindView(2131296906)
   TextView txtNome;
   @BindView(2131296919)
   TextView txtRubrica;
   @BindView(2131296872)
   TextView txt_classeConstrucao;

   public EnquadramentoListArrayAdapter(Context var1, int var2, FragmentManager var3) {
      super(var1, var2);
      this.mFm = var3;
   }

   private OnClickListener onClickDelete(int var1) {
      return new -$$Lambda$EnquadramentoListArrayAdapter$OgEIzX4Lxx1JoGxxJ-ZpFP0Nj2E(this, var1);
   }

   private OnClickListener onClickEdit(int var1) {
      return new -$$Lambda$EnquadramentoListArrayAdapter$9mzkhKu8olQviG_OS6pSq_3OfpM(this, var1);
   }

   private void sendBroadcastEditData(ItemEnquadramento var1) {
      Intent var2 = new Intent("br.com.brq.action.ACTION_UPDATE_ENQUADRAMENTO");
      Bundle var3 = new Bundle();
      var3.putSerializable(this.getContext().getString(2131820752), var1);
      var2.putExtras(var3);
      this.getContext().sendBroadcast(var2);
   }

   private void sendBroadcastRemoveData(ItemEnquadramento var1) {
      Intent var2 = new Intent("br.com.brq.action.ACTION_REMOVE_ENQUADRAMENTO");
      Bundle var3 = new Bundle();
      var3.putSerializable(this.getContext().getString(2131820752), var1);
      var2.putExtras(var3);
      this.getContext().sendBroadcast(var2);
   }

   public void add(ItemEnquadramento var1) {
      if (!this.itens.contains(var1)) {
         this.itens.add(var1);
         this.notifyDataSetChanged();
      }

   }

   public void addAll(Collection var1) {
      this.itens.addAll(var1);
      this.notifyDataSetChanged();
   }

   public Boolean contains(ItemEnquadramento var1) {
      Iterator var2 = this.itens.iterator();
      if (!var2.hasNext()) {
         return false;
      } else {
         ItemEnquadramento var3 = (ItemEnquadramento)var2.next();
         boolean var4 = true;
         if (var1.getItem().getId().intValue() != var3.getItem().getId().intValue()) {
            var4 = false;
         }

         if (var1.getEnquadramento().getId().intValue() != var3.getEnquadramento().getId().intValue()) {
            var4 = false;
         }

         label28: {
            if (!Validator.isNullOrEmpty(var3.getClasseConstrucao())) {
               if (!Validator.isNullOrEmpty(var1.getClasseConstrucao()) && var1.getClasseConstrucao().getId() == var3.getClasseConstrucao().getId()) {
                  break label28;
               }
            } else if (Validator.isNullOrEmpty(var1.getClasseConstrucao())) {
               break label28;
            }

            var4 = false;
         }

         if (var1.getProdutoComercial().getId() != var3.getProdutoComercial().getId()) {
            var4 = false;
         }

         return var4;
      }
   }

   public int getCount() {
      return this.itens.size();
   }

   @Nullable
   public ItemEnquadramento getItem(int var1) {
      return (ItemEnquadramento)this.itens.get(var1);
   }

   public long getItemId(int var1) {
      return ((ItemEnquadramento)this.itens.get(var1)).getEnquadramento().getId();
   }

   public List getItens() {
      return this.itens;
   }

   @NonNull
   public View getView(int var1, View var2, ViewGroup var3) {
      ItemEnquadramento var4 = this.getItem(var1);
      View var5 = LayoutInflater.from(this.getContext()).inflate(2131493026, var3, false);
      ButterKnife.bind(this, var5);
      this.txtNome.setText(var4.getEnquadramento().getNome());
      TextView var7 = this.txtRubrica;
      String var8 = this.getContext().getString(2131820888);
      Object[] var9 = new Object[]{var4.getEnquadramento().getRubrica()};
      var7.setText(String.format(var8, var9));
      if (!Validator.isNullOrEmpty(var4.getClasseConstrucao())) {
         TextView var10 = this.txt_classeConstrucao;
         String var11 = this.getContext().getString(2131820789);
         Object[] var12 = new Object[]{var4.getClasseConstrucao().getDescricao()};
         var10.setText(String.format(var11, var12));
      } else {
         this.txt_classeConstrucao.setVisibility(8);
      }

      if (var4.getCriacaoPedido()) {
         this.icDelete.setVisibility(8);
         this.icEdit.setVisibility(0);
         this.icEdit.setOnClickListener(this.onClickEdit(var1));
         return var5;
      } else {
         this.icDelete.setOnClickListener(this.onClickDelete(var1));
         return var5;
      }
   }

   // $FF: synthetic method
   public void lambda$onClickDelete$0$EnquadramentoListArrayAdapter(int var1, View var2) {
      this.sendBroadcastRemoveData(this.getItem(var1));
   }

   // $FF: synthetic method
   public void lambda$onClickEdit$1$EnquadramentoListArrayAdapter(int var1, View var2) {
      this.sendBroadcastEditData(this.getItem(var1));
   }

   public void remove(@Nullable ItemEnquadramento var1) {
      Iterator var2 = this.itens.iterator();

      while(var2.hasNext()) {
         ItemEnquadramento var3 = (ItemEnquadramento)var2.next();
         boolean var4 = true;
         if (var1.getItem().getId().intValue() != var3.getItem().getId().intValue()) {
            var4 = false;
         }

         if (var1.getEnquadramento().getId().intValue() != var3.getEnquadramento().getId().intValue()) {
            var4 = false;
         }

         label33: {
            if (!Validator.isNullOrEmpty(var3.getClasseConstrucao())) {
               if (!Validator.isNullOrEmpty(var1.getClasseConstrucao()) && var1.getClasseConstrucao().getId() == var3.getClasseConstrucao().getId()) {
                  break label33;
               }
            } else if (Validator.isNullOrEmpty(var1.getClasseConstrucao())) {
               break label33;
            }

            var4 = false;
         }

         if (var1.getProdutoComercial().getId() != var3.getProdutoComercial().getId()) {
            var4 = false;
         }

         if (var4) {
            this.itens.remove(var3);
            break;
         }
      }

      this.notifyDataSetChanged();
   }

   public void removeAll() {
      this.itens = new ArrayList();
      this.notifyDataSetChanged();
   }
}
