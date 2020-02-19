package com.brq.inspecao_360_android.common.fragment.dialog;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class OrigemImagemDialogFragment extends AlertDialog {
   private OnClickListener listenerButtonCamera;
   private OnClickListener listenerButtonGaleria;

   public OrigemImagemDialogFragment(Context var1) {
      super(var1);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2131493017);
      ImageView var2 = (ImageView)this.findViewById(2131296309);
      ImageView var3 = (ImageView)this.findViewById(2131296308);
      var2.setOnClickListener(this.listenerButtonGaleria);
      var3.setOnClickListener(this.listenerButtonCamera);
      this.getWindow().getAttributes().windowAnimations = 2131886286;
      this.getWindow().getAttributes().gravity = 48;
      TypedArray var4 = this.getContext().getTheme().obtainStyledAttributes(new int[]{16843499});
      this.getWindow().getAttributes().y = (int)var4.getDimension(0, 0.0F);
      var4.recycle();
   }

   public void setCameraButton(OnClickListener var1) {
      this.listenerButtonCamera = var1;
   }

   public void setGaleriaButton(OnClickListener var1) {
      this.listenerButtonGaleria = var1;
   }
}
