package com.brq.inspecao_360_android.common.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class EnquadramentoFragment_ViewBinding implements Unbinder {
   protected EnquadramentoFragment target;

   @UiThread
   public EnquadramentoFragment_ViewBinding(EnquadramentoFragment var1, View var2) {
      this.target = var1;
      var1.txtTitulo = (TextView)Utils.findRequiredViewAsType(var2, 2131296928, "field 'txtTitulo'", TextView.class);
      var1.recyclcer = (RecyclerView)Utils.findRequiredViewAsType(var2, 2131296700, "field 'recyclcer'", RecyclerView.class);
   }

   @CallSuper
   public void unbind() {
      EnquadramentoFragment var1 = this.target;
      if (var1 != null) {
         var1.txtTitulo = null;
         var1.recyclcer = null;
         this.target = null;
      } else {
         throw new IllegalStateException("Bindings already cleared.");
      }
   }
}
