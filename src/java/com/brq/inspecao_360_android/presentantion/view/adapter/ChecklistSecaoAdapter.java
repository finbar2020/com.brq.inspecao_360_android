package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.brq.inspecao_360_android.common.view.CircularProgressBar;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.model.entity.Secao;
import java.util.ArrayList;
import java.util.List;

public class ChecklistSecaoAdapter extends BaseAdapter {
   private Context context;
   private List itens = new ArrayList();
   private Item mItem;
   @Nullable
   @BindView(2131296882)
   TextView txtDescricao;
   @BindView(2131296915)
   TextView txtPercentualRespondido;

   public ChecklistSecaoAdapter(Context var1, Item var2) {
      this.context = var1;
      this.mItem = var2;
   }

   public void addAll(List var1) {
      this.itens.addAll(var1);
      this.notifyDataSetChanged();
   }

   public int getCount() {
      return this.itens.size();
   }

   public Secao getItem(int var1) {
      return (Secao)this.itens.get(var1);
   }

   public long getItemId(int var1) {
      return 0L;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      Secao var4 = this.getItem(var1);
      if (var2 == null) {
         var2 = LayoutInflater.from(this.context).inflate(2131493045, (ViewGroup)null);
      }

      ButterKnife.bind(this, var2);
      CircularProgressBar var6 = (CircularProgressBar)var2.findViewById(2131296670);
      int var7 = 100 * var4.getQtdResposta().intValue() / var4.getQtdPergunta().intValue();
      var6.setProgress((float)var7);
      if (var7 == 100) {
         var6.setColor(ContextCompat.getColor(this.context, 2131099814));
      }

      if (this.mItem.getDeveRealcarPerguntas() && var4.getQtdPerguntaObrigatoria() > var4.getQtdRespostaObrigatoria()) {
         this.txtDescricao.setTextColor(ContextCompat.getColor(this.context, 2131099749));
      }

      TextView var8 = this.txtPercentualRespondido;
      StringBuilder var9 = new StringBuilder();
      var9.append(String.valueOf(var7));
      var9.append("%");
      var8.setText(var9.toString());
      this.txtDescricao.setTag(var4.getId());
      this.txtDescricao.setText(var4.getNome());
      return var2;
   }
}
