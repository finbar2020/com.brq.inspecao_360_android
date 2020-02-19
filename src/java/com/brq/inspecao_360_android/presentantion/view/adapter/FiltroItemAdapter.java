package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FiltroItemAdapter extends BaseAdapter {
   private Context context;
   private Drawable defaultIcon;
   private String[] itens;
   @BindView(2131296384)
   TextView txtDescricao;

   public FiltroItemAdapter(Context var1) {
      this.context = var1;
      this.itens = var1.getResources().getStringArray(2130903040);
      this.defaultIcon = var1.getResources().getDrawable(2131230930);
   }

   public int getCount() {
      return this.itens.length;
   }

   public Object getItem(int var1) {
      return this.itens[var1];
   }

   public long getItemId(int var1) {
      return 0L;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      String var4 = this.itens[var1];
      if (var2 == null) {
         var2 = LayoutInflater.from(this.context).inflate(2131493027, (ViewGroup)null);
      }

      ButterKnife.bind(this, var2);
      this.txtDescricao.setText(var4);
      this.txtDescricao.setCompoundDrawablePadding(8);
      this.txtDescricao.setCompoundDrawablesWithIntrinsicBounds(this.defaultIcon, (Drawable)null, (Drawable)null, (Drawable)null);
      return var2;
   }
}
