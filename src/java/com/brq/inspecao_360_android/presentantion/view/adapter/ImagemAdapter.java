package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.brq.inspecao_360_android.common.util.FileUtil;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.model.entity.Imagem;
import com.brq.inspecao_360_android.presentantion.view.adapter.ImagemAdapter.1;
import com.brq.inspecao_360_android.presentantion.view.adapter.ImagemAdapter.2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImagemAdapter extends BaseAdapter {
   private Context context;
   @BindView(2131296489)
   ImageView icBrokenImage;
   @BindView(2131296497)
   ImageView icErro;
   @BindView(2131296516)
   ImageView icSucesso;
   @BindView(2131296469)
   ImageView imagemView;
   private List itens = new ArrayList();
   @BindView(2131296679)
   ProgressBar progress;
   private SparseBooleanArray selecteds = new SparseBooleanArray();
   @BindView(2131296873)
   TextView txtComentario;

   public ImagemAdapter(Context var1) {
      this.context = var1;
   }

   public void add(Imagem var1) {
      this.itens.add(var1);
      this.notifyDataSetChanged();
   }

   public void addAll(List var1) {
      if (!Validator.isNullOrEmpty(this.itens)) {
         this.itens.clear();
      }

      this.itens.addAll(var1);
      this.notifyDataSetChanged();
   }

   public void clear() {
      this.itens.clear();
   }

   public void clearSelecteds() {
      this.selecteds.clear();
   }

   public boolean contains(Imagem var1) {
      return this.itens.contains(var1);
   }

   public int getCount() {
      return this.itens.size();
   }

   public Imagem getItem(int var1) {
      return (Imagem)this.itens.get(var1);
   }

   public long getItemId(int var1) {
      return ((Imagem)this.itens.get(var1)).getId();
   }

   public List getItens() {
      return this.itens;
   }

   public int getPosition(Imagem var1) {
      return this.itens.indexOf(var1);
   }

   public SparseBooleanArray getSelecteds() {
      return this.selecteds;
   }

   public View getView(int var1, View var2, ViewGroup var3) {
      Imagem var4 = this.getItem(var1);
      if (var2 == null) {
         var2 = LayoutInflater.from(this.context).inflate(2131493029, (ViewGroup)null);
      }

      ButterKnife.bind(this, var2);
      int var6;
      if (this.isSelected(var1)) {
         var6 = 2131099672;
      } else {
         var6 = 17170445;
      }

      var2.setBackgroundResource(var6);
      int var7 = var4.getIdStatus();
      if (var7 != -1) {
         if (var7 != 4) {
            this.icSucesso.setVisibility(8);
            this.icErro.setVisibility(8);
         } else {
            this.icSucesso.setVisibility(0);
         }
      } else {
         this.icErro.setVisibility(0);
      }

      if (!(new File(var4.getFilePath())).exists()) {
         this.icBrokenImage.setVisibility(0);
         this.icSucesso.setVisibility(8);
         this.icErro.setVisibility(8);
      }

      if (var4.getEncrypted()) {
         Glide.with(this.context).load(FileUtil.decodeFile(new File(var4.getFilePath()))).listener(new 1(this)).override(100, 100).thumbnail(0.1F).diskCacheStrategy(DiskCacheStrategy.RESULT).skipMemoryCache(true).into(this.imagemView);
      } else {
         Glide.with(this.context).load(var4.getFilePath()).listener(new 2(this)).override(100, 100).thumbnail(0.1F).diskCacheStrategy(DiskCacheStrategy.RESULT).skipMemoryCache(true).into(this.imagemView);
      }

      this.txtComentario.setText(var4.getDescricao());
      return var2;
   }

   public boolean isSelected(int var1) {
      return this.selecteds.get(var1);
   }

   public void remove(int var1) {
      this.itens.remove(var1);
      this.notifyDataSetChanged();
   }

   public void remove(Object var1) {
      this.itens.remove(var1);
      this.notifyDataSetChanged();
   }

   public void toggle(int var1) {
      if (this.selecteds.get(var1, false)) {
         this.selecteds.delete(var1);
      } else {
         this.selecteds.put(var1, true);
      }

      this.notifyDataSetChanged();
   }

   public void update(int var1, Imagem var2) {
      this.itens.set(var1, var2);
      this.notifyDataSetChanged();
   }
}
