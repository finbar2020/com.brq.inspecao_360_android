package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.brq.inspecao_360_android.model.entity.AreaSegurada;

class AreaSeguradaRecycler$1 implements OnClickListener {
   // $FF: synthetic field
   final AreaSeguradaRecycler this$0;
   // $FF: synthetic field
   final AreaSegurada val$areaSegurada;

   AreaSeguradaRecycler$1(AreaSeguradaRecycler var1, AreaSegurada var2) {
      this.this$0 = var1;
      this.val$areaSegurada = var2;
   }

   public void onClick(View var1) {
      Object[] var2 = new Object[]{String.valueOf(this.val$areaSegurada.getLatitude()), String.valueOf(this.val$areaSegurada.getLongitude()), String.valueOf(this.val$areaSegurada.getLatitude()), String.valueOf(this.val$areaSegurada.getLongitude())};
      Uri var3 = Uri.parse(String.format("geo:%1s,%1s?q=%1s,%1s", var2));
      Intent var4 = new Intent("android.intent.action.VIEW", var3);
      var4.setPackage("com.google.android.apps.maps");
      if (var4.resolveActivity(AreaSeguradaRecycler.access$000(this.this$0).getPackageManager()) != null) {
         AreaSeguradaRecycler.access$000(this.this$0).startActivity(var4);
      } else {
         try {
            Intent var6 = new Intent("android.intent.action.VIEW", var3);
            AreaSeguradaRecycler.access$000(this.this$0).startActivity(var6);
         } catch (ActivityNotFoundException var10) {
            try {
               Object[] var7 = new Object[]{String.valueOf(this.val$areaSegurada.getLatitude()), String.valueOf(this.val$areaSegurada.getLongitude())};
               Intent var8 = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?q=loc:%1s,%1s", var7)));
               AreaSeguradaRecycler.access$000(this.this$0).startActivity(var8);
            } catch (ActivityNotFoundException var9) {
               Toast.makeText(AreaSeguradaRecycler.access$000(this.this$0), "Não é possível iniciar o Google Maps.", 1).show();
            }
         }
      }
   }
}
