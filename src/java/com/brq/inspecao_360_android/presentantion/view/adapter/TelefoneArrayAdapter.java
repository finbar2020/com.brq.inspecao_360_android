package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.brq.inspecao_360_android.common.enumerator.TipoTelefoneEnum;
import com.brq.inspecao_360_android.model.entity.Telefone;
import java.util.ArrayList;
import java.util.Collection;

public class TelefoneArrayAdapter extends ArrayAdapter {
   private Context context;
   private ArrayList telefones = new ArrayList();
   @BindView(2131296925)
   TextView txtTelefone;
   @BindView(2131296927)
   TextView txtTipoTelefone;
   private int type;

   public TelefoneArrayAdapter(Context var1, int var2) {
      super(var1, 2131493042);
      this.context = var1;
      this.type = var2;
   }

   private OnClickListener mEnviarSmsOnClickListener(String var1) {
      return new -$$Lambda$TelefoneArrayAdapter$DLpsu1cp-NzALrEvBYSHv7w8rs0(this, var1);
   }

   private OnClickListener mLigarOnClickListener(String var1) {
      return new -$$Lambda$TelefoneArrayAdapter$rPXyySPwqP8V0viYy-yhN1cYPc4(this, var1);
   }

   public void addAll(Collection var1) {
      this.telefones.addAll(var1);
      this.notifyDataSetChanged();
   }

   public int getCount() {
      return this.telefones.size();
   }

   public Telefone getItem(int var1) {
      return (Telefone)this.telefones.get(var1);
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      Telefone var4 = this.getItem(var1);
      if (var2 == null) {
         var2 = LayoutInflater.from(this.getContext()).inflate(2131493042, (ViewGroup)null);
      }

      ButterKnife.bind(this, var2);
      this.txtTelefone.setText(var4.toString());
      this.txtTipoTelefone.setText(TipoTelefoneEnum.getValueById(Integer.valueOf(var4.getTipoTelefone())).getDescricao());
      ImageView var6 = (ImageView)var2.findViewById(2131296517);
      var6.setOnClickListener(this.mLigarOnClickListener(var4.toString()));
      ImageView var7 = (ImageView)var2.findViewById(2131296514);
      var7.setOnClickListener(this.mEnviarSmsOnClickListener(var4.toString()));
      int var8 = this.type;
      if (var8 != 0) {
         if (var8 != 1) {
            if (var8 != 2) {
               var6.setVisibility(0);
               var7.setVisibility(0);
               return var2;
            } else {
               var6.setVisibility(0);
               var7.setVisibility(0);
               return var2;
            }
         } else {
            var6.setVisibility(0);
            var7.setVisibility(8);
            return var2;
         }
      } else {
         var6.setVisibility(8);
         var7.setVisibility(0);
         return var2;
      }
   }

   // $FF: synthetic method
   public void lambda$mEnviarSmsOnClickListener$1$TelefoneArrayAdapter(String var1, View var2) {
      Intent var3 = new Intent("android.intent.action.VIEW");
      StringBuilder var4 = new StringBuilder();
      var4.append("sms:");
      var4.append(var1);
      var3.setData(Uri.parse(var4.toString()));
      this.context.startActivity(var3);
   }

   // $FF: synthetic method
   public void lambda$mLigarOnClickListener$0$TelefoneArrayAdapter(String var1, View var2) {
      Intent var3 = new Intent("android.intent.action.CALL");
      StringBuilder var4 = new StringBuilder();
      var4.append("tel:");
      var4.append(var1);
      var3.setData(Uri.parse(var4.toString()));
      if (ActivityCompat.checkSelfPermission(this.context, "android.permission.CALL_PHONE") != 0) {
         ActivityCompat.requestPermissions((Activity)this.context, new String[]{"android.permission.CALL_PHONE"}, 0);
      } else {
         this.context.startActivity(var3);
      }
   }
}
