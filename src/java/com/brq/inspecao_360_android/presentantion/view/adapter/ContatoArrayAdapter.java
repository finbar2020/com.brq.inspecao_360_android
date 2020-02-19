package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.model.entity.Pessoa;
import com.brq.inspecao_360_android.model.entity.Telefone;
import com.brq.inspecao_360_android.presentantion.view.adapter.-..Lambda.ContatoArrayAdapter.9r-lBnRY8eOwWN_J3QCp2RNLPIs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ContatoArrayAdapter extends ArrayAdapter {
   public static final int TYPE_MESSAGE = 0;
   public static final int TYPE_MESSAGE_AND_PHONE = 2;
   public static final int TYPE_PHONE = 1;
   private List contatos = new ArrayList();
   private Context context;
   @BindView(2131296496)
   ImageView icEmail;
   private TelefoneArrayAdapter telefoneAdapter;
   @BindView(2131296887)
   TextView txtEmail;
   @BindView(2131296904)
   TextView txtNome;
   private int type;
   @BindView(2131296558)
   View viewEmail;
   @BindView(2131296947)
   LinearLayout viewTelefone;

   public ContatoArrayAdapter(Context var1, int var2) {
      super(var1, 2131493038);
      this.context = var1;
      this.type = var2;
   }

   public void addAll(Collection var1) {
      this.contatos.addAll(var1);
      this.notifyDataSetChanged();
   }

   public int getCount() {
      return this.contatos.size();
   }

   public Pessoa getItem(int var1) {
      return (Pessoa)this.contatos.get(var1);
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      Pessoa var4 = this.getItem(var1);
      if (var2 == null) {
         var2 = LayoutInflater.from(this.getContext()).inflate(2131493038, var3, false);
      }

      ButterKnife.bind(this, var2);
      this.txtNome.setText(var4.getNome());
      if (!Validator.isNullOrEmpty(var4.getEmail())) {
         this.viewEmail.setVisibility(0);
         this.txtEmail.setText(var4.getEmail());
         this.icEmail.setOnClickListener(new 9r-lBnRY8eOwWN_J3QCp2RNLPIs(this, var4));
      }

      Iterator var6 = var4.getTelefones().iterator();

      while(var6.hasNext()) {
         Telefone var7 = (Telefone)var6.next();
         TextView var8 = (TextView)LayoutInflater.from(this.context).inflate(2131493042, this.viewTelefone, false).findViewById(2131296925);
         Object[] var9 = new Object[]{var7.getDdi(), var7.getDdd(), var7.getNumero()};
         var8.setText(String.format("+%s (%s) %s", var9));
         this.viewTelefone.addView(var2);
      }

      return var2;
   }

   // $FF: synthetic method
   public void lambda$getView$0$ContatoArrayAdapter(Pessoa var1, View var2) {
      Intent var3 = new Intent("android.intent.action.SEND");
      var3.setType("text/plain");
      var3.putExtra("android.intent.extra.EMAIL", var1.getEmail());
      this.context.startActivity(var3);
   }
}
