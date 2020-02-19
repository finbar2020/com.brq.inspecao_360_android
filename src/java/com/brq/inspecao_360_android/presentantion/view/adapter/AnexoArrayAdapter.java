package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.model.entity.Anexo;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.view.adapter.-..Lambda.AnexoArrayAdapter.aB6duTW-vfaQO5nuPkyND9-kyWA;
import com.brq.inspecao_360_android.presentantion.view.adapter.-..Lambda.AnexoArrayAdapter.dKX9_qgpPlP5DFuH1ezkLYIhXDM;
import com.brq.inspecao_360_android.service.DownloadIntentService;
import com.brq.inspecao_360_android.ui.fragment.DetalheAnexoDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AnexoArrayAdapter extends ArrayAdapter {
   @BindView(2131296494)
   ImageView icDownload;
   @BindView(2131296499)
   ImageView icFile;
   @BindView(2131296503)
   ImageView icInfo;
   private List itens = new ArrayList();
   private FragmentManager mFm;
   private Item mItem;
   @BindView(2131296870)
   TextView txtAutor;
   @Nullable
   @BindView(2131296903)
   TextView txtNome;
   @BindView(2131296924)
   TextView txtTamanhoAnexo;

   public AnexoArrayAdapter(Context var1, int var2, Item var3, FragmentManager var4) {
      super(var1, var2);
      this.mItem = var3;
      this.mFm = var4;
   }

   private OnClickListener onClickDownload(int var1) {
      return new dKX9_qgpPlP5DFuH1ezkLYIhXDM(this, var1);
   }

   private OnClickListener onClickInfo(int var1) {
      return new aB6duTW-vfaQO5nuPkyND9-kyWA(this, var1);
   }

   public void addAll(Collection var1) {
      this.itens.addAll(var1);
      this.notifyDataSetChanged();
   }

   public int getCount() {
      return this.itens.size();
   }

   @Nullable
   public Anexo getItem(int var1) {
      return (Anexo)this.itens.get(var1);
   }

   public long getItemId(int var1) {
      return (long)((Anexo)this.itens.get(var1)).getId();
   }

   public List getItens() {
      return this.itens;
   }

   @NonNull
   public View getView(int var1, View var2, ViewGroup var3) {
      Anexo var4 = this.getItem(var1);
      View var5 = LayoutInflater.from(this.getContext()).inflate(2131493023, var3, false);
      ButterKnife.bind(this, var5);
      this.txtNome.setText(var4.getNome());
      Long var7 = var4.getTamanho() / 1024L;
      if (var7 >= 1024L) {
         Long var19 = var7 / 1024L;
         TextView var20 = this.txtTamanhoAnexo;
         String var21 = this.getContext().getString(2131820910);
         Object[] var22 = new Object[1];
         StringBuilder var23 = new StringBuilder();
         var23.append(var19.toString());
         var23.append(" MB");
         var22[0] = var23.toString();
         var20.setText(String.format(var21, var22));
      } else {
         TextView var8 = this.txtTamanhoAnexo;
         String var9 = this.getContext().getString(2131820910);
         Object[] var10 = new Object[1];
         StringBuilder var11 = new StringBuilder();
         var11.append(var7.toString());
         var11.append(" KB");
         var10[0] = var11.toString();
         var8.setText(String.format(var9, var10));
      }

      byte var15;
      label64: {
         String var14 = var4.getNome().substring(var4.getNome().length() - 4);
         switch(var14.hashCode()) {
         case 1468055:
            if (var14.equals(".bmp")) {
               var15 = 4;
               break label64;
            }
            break;
         case 1470026:
            if (var14.equals(".doc")) {
               var15 = 6;
               break label64;
            }
            break;
         case 1475827:
            if (var14.equals(".jpg")) {
               var15 = 0;
               break label64;
            }
            break;
         case 1481220:
            if (var14.equals(".pdf")) {
               var15 = 5;
               break label64;
            }
            break;
         case 1481531:
            if (var14.equals(".png")) {
               var15 = 2;
               break label64;
            }
            break;
         case 1485698:
            if (var14.equals(".txt")) {
               var15 = 10;
               break label64;
            }
            break;
         case 1489169:
            if (var14.equals(".xls")) {
               var15 = 8;
               break label64;
            }
            break;
         case 3088960:
            if (var14.equals("docx")) {
               var15 = 7;
               break label64;
            }
            break;
         case 3559925:
            if (var14.equals("tiff")) {
               var15 = 3;
               break label64;
            }
            break;
         case 3682393:
            if (var14.equals("xlsx")) {
               var15 = 9;
               break label64;
            }
            break;
         case 45750678:
            if (var14.equals(".jpeg")) {
               var15 = 1;
               break label64;
            }
         }

         var15 = -1;
      }

      switch(var15) {
      case 0:
         this.icFile.setImageResource(2131230925);
         break;
      case 1:
         this.icFile.setImageResource(2131230925);
         break;
      case 2:
         this.icFile.setImageResource(2131230925);
         break;
      case 3:
         this.icFile.setImageResource(2131230925);
         break;
      case 4:
         this.icFile.setImageResource(2131230925);
         break;
      case 5:
         this.icFile.setImageResource(2131230926);
         break;
      case 6:
         this.icFile.setImageResource(2131230927);
         break;
      case 7:
         this.icFile.setImageResource(2131230927);
         break;
      case 8:
         this.icFile.setImageResource(2131230924);
         break;
      case 9:
         this.icFile.setImageResource(2131230924);
         break;
      case 10:
         this.icFile.setImageResource(2131230922);
         break;
      default:
         this.icFile.setImageResource(2131230921);
      }

      TextView var16 = this.txtAutor;
      String var17 = this.getContext().getString(2131820773);
      Object[] var18 = new Object[]{var4.getUsuarioCriacao().getNome()};
      var16.setText(String.format(var17, var18));
      this.icDownload.setTag(new Integer(var1));
      this.icDownload.setOnClickListener(this.onClickDownload(var1));
      this.icInfo.setOnClickListener(this.onClickInfo(var1));
      return var5;
   }

   // $FF: synthetic method
   public void lambda$onClickDownload$0$AnexoArrayAdapter(int var1, View var2) {
      Anexo var3 = this.getItem(var1);
      if (!Validator.isNullOrEmpty(var3)) {
         if (var3.getDownloaded()) {
            File var4 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsoluteFile(), var3.getNome());
            if (!var4.exists()) {
               Intent var5 = new Intent(this.getContext(), DownloadIntentService.class);
               var5.putExtra(this.getContext().getString(2131820727), var3.getId().longValue());
               var5.putExtra(this.getContext().getString(2131821162), var3.getNome());
               var5.putExtra(this.getContext().getString(2131820590), "ACTION_DOWNLOAD_SINGLE");
               this.getContext().startService(var5);
               return;
            }

            int var10 = var3.getNome().lastIndexOf(".");
            String var11;
            if (var10 > 0 && var10 < -1 + var3.getNome().length()) {
               var11 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(var3.getNome().substring(var10 + 1));
            } else {
               var11 = "";
            }

            Context var13 = this.getContext();
            this.getContext();
            ((DownloadManager)var13.getSystemService("download")).addCompletedDownload(var4.getName(), var4.getName(), true, var11, var4.getAbsolutePath(), var4.length(), true);
            return;
         }

         Intent var17 = new Intent(this.getContext(), DownloadIntentService.class);
         var17.putExtra(this.getContext().getString(2131820727), var3.getId().longValue());
         var17.putExtra(this.getContext().getString(2131821162), var3.getNome());
         var17.putExtra(this.getContext().getString(2131820590), "ACTION_DOWNLOAD_SINGLE");
         this.getContext().startService(var17);
      }

   }

   // $FF: synthetic method
   public void lambda$onClickInfo$1$AnexoArrayAdapter(int var1, View var2) {
      DetalheAnexoDialog.newInstance(this.getItem(var1)).show(this.mFm, "dialog");
   }
}
