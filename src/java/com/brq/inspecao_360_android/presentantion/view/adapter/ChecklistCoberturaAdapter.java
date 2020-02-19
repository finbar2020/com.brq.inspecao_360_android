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
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.common.view.CircularProgressBar;
import com.brq.inspecao_360_android.model.entity.ChecklistCombinedItem;
import com.brq.inspecao_360_android.model.entity.CoberturaChecklist;
import com.brq.inspecao_360_android.model.entity.Item;
import java.util.ArrayList;
import java.util.List;

public class ChecklistCoberturaAdapter extends BaseAdapter {
   private Context context;
   private List itens = new ArrayList();
   private Item mItem;
   @Nullable
   @BindView(2131296882)
   TextView txtDescricao;
   @BindView(2131296915)
   TextView txtPercentualRespondido;

   public ChecklistCoberturaAdapter(Context var1, Item var2) {
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

   public ChecklistCombinedItem getItem(int var1) {
      return (ChecklistCombinedItem)this.itens.get(var1);
   }

   public long getItemId(int var1) {
      return 0L;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      ChecklistCombinedItem var4 = this.getItem(var1);
      if (var2 == null) {
         var2 = LayoutInflater.from(this.context).inflate(2131493025, (ViewGroup)null);
      }

      ButterKnife.bind(this, var2);
      CircularProgressBar var6 = (CircularProgressBar)var2.findViewById(2131296670);
      int var7 = var4.getObjectType();
      if (var7 != 1) {
         if (var7 != 2) {
            if (var7 != 3) {
               if (var7 != 4) {
                  if (var7 != 5) {
                     return var2;
                  } else {
                     boolean var32 = Validator.isNullOrEmpty(var4.getItem().getEmailsEnvioLaudo());
                     byte var33 = 0;
                     if (!var32) {
                        int var38 = var4.getItem().getEmailsEnvioLaudo().size();
                        var33 = 0;
                        if (var38 > 0) {
                           var6.setColor(ContextCompat.getColor(this.context, 2131099814));
                           var33 = 100;
                        }
                     }

                     var6.setProgress((float)var33);
                     TextView var34 = this.txtPercentualRespondido;
                     StringBuilder var35 = new StringBuilder();
                     var35.append(String.valueOf(var33));
                     var35.append("%");
                     var34.setText(var35.toString());
                     this.txtDescricao.setText("E-mail para Envio do Laudo");
                     return var2;
                  }
               } else {
                  boolean var26 = var4.getItem().getPossuiAssinaturaResponsavel();
                  byte var27 = 0;
                  if (var26) {
                     var6.setColor(ContextCompat.getColor(this.context, 2131099814));
                     var27 = 100;
                  }

                  var6.setProgress((float)var27);
                  TextView var28 = this.txtPercentualRespondido;
                  StringBuilder var29 = new StringBuilder();
                  var29.append(String.valueOf(var27));
                  var29.append("%");
                  var28.setText(var29.toString());
                  this.txtDescricao.setText("Assinatura do Responsável");
                  return var2;
               }
            } else {
               boolean var20 = var4.getItem().getPossuiAssinaturaInspetor();
               byte var21 = 0;
               if (var20) {
                  var6.setColor(ContextCompat.getColor(this.context, 2131099814));
                  var21 = 100;
               }

               var6.setProgress((float)var21);
               TextView var22 = this.txtPercentualRespondido;
               StringBuilder var23 = new StringBuilder();
               var23.append(String.valueOf(var21));
               var23.append("%");
               var22.setText(var23.toString());
               this.txtDescricao.setText("Assinatura do Inspetor");
               return var2;
            }
         } else {
            boolean var14 = var4.getItem().getCroquiPendente();
            byte var15 = 0;
            if (var14) {
               var6.setColor(ContextCompat.getColor(this.context, 2131099814));
               var15 = 100;
            }

            var6.setProgress((float)var15);
            TextView var16 = this.txtPercentualRespondido;
            StringBuilder var17 = new StringBuilder();
            var17.append(String.valueOf(var15));
            var17.append("%");
            var16.setText(var17.toString());
            this.txtDescricao.setText("Croqui");
            return var2;
         }
      } else {
         CoberturaChecklist var8 = var4.getCoberturaChecklist();
         int var9 = 100 * var8.getQtdResposta().intValue() / var8.getQtdPergunta().intValue();
         var6.setProgress((float)var9);
         if (this.mItem.getDeveRealcarPerguntas() && var8.getQtdPerguntaObrigatoria() > var8.getQtdRespostaObrigatoria()) {
            this.txtDescricao.setTextColor(ContextCompat.getColor(this.context, 2131099749));
         }

         if (var9 == 100) {
            var6.setColor(ContextCompat.getColor(this.context, 2131099814));
         }

         TextView var10 = this.txtPercentualRespondido;
         StringBuilder var11 = new StringBuilder();
         var11.append(String.valueOf(var9));
         var11.append("%");
         var10.setText(var11.toString());
         this.txtDescricao.setTag(var8.getCobertura().getId());
         this.txtDescricao.setText(var8.getCobertura().getDescricao());
         return var2;
      }
   }
}
