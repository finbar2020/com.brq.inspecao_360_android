package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import com.brq.inspecao_360_android.common.Util;
import com.brq.inspecao_360_android.common.util.ChecklistUtil;
import com.brq.inspecao_360_android.model.entity.ItemTabelaResposta;
import com.brq.inspecao_360_android.model.entity.Resposta;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ItemTabelaRespostaAdapter extends ArrayAdapter {
   private boolean isEnable = false;
   private List itens = new ArrayList();
   private final LayoutParams params = new LayoutParams(-1, -2);

   public ItemTabelaRespostaAdapter(Context var1, int var2, boolean var3) {
      super(var1, var2);
      this.isEnable = var3;
   }

   private OnClickListener onClickEditar(Context var1, int var2, ViewGroup var3) {
      return new -$$Lambda$ItemTabelaRespostaAdapter$ji0zNiB5HVYyU_fap4e9OheFRyQ(this, var2, var3);
   }

   private OnClickListener onClickRemover(Context var1, int var2, ViewGroup var3) {
      return new -$$Lambda$ItemTabelaRespostaAdapter$ks2WyGsawSVjN9BWxTS0Rxvnu_A(this, var1, var2, var3);
   }

   private void sendBroadcastUpadateData(Context var1) {
      Intent var2 = new Intent("br.com.brq.action.ACTION_DATA_HAS_CHANGED");
      Bundle var3 = new Bundle();
      var3.putBoolean("hasChanged", true);
      var2.putExtras(var3);
      var1.sendBroadcast(var2);
   }

   public void add(ItemTabelaResposta var1) {
      this.itens.add(var1);
      this.notifyDataSetChanged();
   }

   public void addAll(List var1) {
      this.itens.addAll(var1);
      this.notifyDataSetChanged();
   }

   public int getCount() {
      return this.itens.size();
   }

   @Nullable
   public ItemTabelaResposta getItem(int var1) {
      return (ItemTabelaResposta)this.itens.get(var1);
   }

   public List getItens() {
      return this.itens;
   }

   @NonNull
   public View getView(int var1, View var2, ViewGroup var3) {
      View var4 = LayoutInflater.from(this.getContext()).inflate(2131493050, (ViewGroup)null);
      ImageView var5 = (ImageView)var4.findViewById(2131296492);
      ImageView var6 = (ImageView)var4.findViewById(2131296495);
      var5.setOnClickListener(this.onClickRemover(this.getContext(), var1, var3));
      var6.setOnClickListener(this.onClickEditar(this.getContext(), var1, var3));
      if (this.isEnable) {
         var5.setVisibility(0);
      } else {
         var5.setVisibility(4);
      }

      LinearLayout var7 = (LinearLayout)var4.findViewById(2131296564);
      ItemTabelaResposta var8 = this.getItem(var1);
      if (var8 != null && var8.getItens() != null) {
         Iterator var9 = var8.getItens().iterator();

         while(var9.hasNext()) {
            Resposta var10 = (Resposta)var9.next();
            TextView var11 = new TextView(this.getContext());
            var11.setPadding(8, 8, 8, 8);
            var11.setLayoutParams(this.params);
            var11.setSingleLine(false);
            var11.setText(var10.getPergunta().getDescricao());
            var7.addView(var11);
            TextView var12 = new TextView(this.getContext());
            var12.setLayoutParams(this.params);
            var12.setPadding(8, 0, 8, 8);
            var12.setTextSize(16.0F);
            var12.setTypeface((Typeface)null, 1);
            var12.setSingleLine(false);
            var12.setText(var10.getValor());
            var7.addView(var12);
            var10.setIdPerguntaPai(var8.getPerguntaPai().getId());
            var10.setLinha(var1);
            var10.setIsChild(1);
         }
      }

      return var4;
   }

   // $FF: synthetic method
   public void lambda$onClickEditar$1$ItemTabelaRespostaAdapter(int var1, ViewGroup var2, View var3) {
      ItemTabelaResposta var4 = this.getItem(var1);
      AlertDialog var5 = ChecklistUtil.newInstance().criarTableComponentAlertDialogEditar(this.getContext(), var2, var4.getGrupoPergunta(), var4.getIdItem(), var4.getIdGrupo(), var4.getIdSecao(), var4.getItens(), var1);
      ((Window)Objects.requireNonNull(var5.getWindow())).setSoftInputMode(16);
      var5.show();
   }

   // $FF: synthetic method
   public void lambda$onClickRemover$0$ItemTabelaRespostaAdapter(final Context var1, final int var2, final ViewGroup var3, View var4) {
      Builder var5 = new Builder(var1);
      var5.setTitle(var1.getString(2131821015));
      var5.setNegativeButton(var1.getString(2131821154), new android.content.DialogInterface.OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
            var1.dismiss();
         }
      });
      var5.setPositiveButton(var1.getString(2131821258), new android.content.DialogInterface.OnClickListener() {
         public void onClick(DialogInterface var1x, int var2x) {
            ItemTabelaResposta var3x = ItemTabelaRespostaAdapter.this.getItem(var2);
            ItemTabelaRespostaAdapter.this.remove(var3x);
            Util.setListViewHeightBasedOnChildren((ListView)var3);
            ItemTabelaRespostaAdapter.this.sendBroadcastUpadateData(var1);
            var1x.dismiss();
         }
      });
      var5.show();
   }

   public void remove(ItemTabelaResposta var1) {
      this.itens.remove(var1);
      this.notifyDataSetChanged();
   }

   public void removeAll() {
      this.itens.clear();
      this.notifyDataSetChanged();
   }
}
