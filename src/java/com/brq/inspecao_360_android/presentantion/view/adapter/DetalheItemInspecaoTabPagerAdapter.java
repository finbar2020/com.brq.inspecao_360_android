package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.ui.fragment.ItemInspecaoTabAnexoFragment;
import com.brq.inspecao_360_android.ui.fragment.ItemInspecaoTabCoberturaFragment;
import com.brq.inspecao_360_android.ui.fragment.ItemInspecaoTabInformacaoFragment;
import com.brq.inspecao_360_android.ui.fragment.ItemInspecaoTabLocalDeRiscoFragment;
import java.util.ArrayList;
import java.util.List;

public class DetalheItemInspecaoTabPagerAdapter extends FragmentStatePagerAdapter {
   public static final int POSITION_ANEXO = 3;
   public static final int POSITION_COBERTURA = 2;
   public static final int POSITION_INFO = 0;
   public static final int POSITION_LOCAL_RISCO = 1;
   private Context context;
   private Item item;
   private int tabCount;

   public DetalheItemInspecaoTabPagerAdapter(FragmentManager var1, Context var2, Item var3, int var4) {
      super(var1);
      this.context = var2;
      this.item = var3;
      this.tabCount = var4;
   }

   public void finishUpdate(ViewGroup var1) {
      try {
         super.finishUpdate(var1);
      } catch (NullPointerException var2) {
         System.out.println("Catch the NullPointerException in FragmentPagerAdapter.finishUpdate");
      }
   }

   public int getCount() {
      return this.tabCount;
   }

   public Fragment getItem(int var1) {
      if (var1 == 0) {
         return ItemInspecaoTabInformacaoFragment.newInstance(this.context, this.item);
      } else {
         if (var1 != 1) {
            if (var1 != 2) {
               if (var1 != 3) {
                  return null;
               }

               return ItemInspecaoTabAnexoFragment.newInstance(this.item);
            }
         } else {
            try {
               if (this.item.getInspecao().getPermiteInclusaoAreaSegurada()) {
                  return ItemInspecaoTabLocalDeRiscoFragment.newInstance(this.context, this.item.getEndereco(), new ArrayList(this.item.getAreaSeguradas()));
               }

               ItemInspecaoTabLocalDeRiscoFragment var3 = ItemInspecaoTabLocalDeRiscoFragment.newInstance(this.context, this.item.getEndereco(), (List)null);
               return var3;
            } catch (Exception var4) {
               Logger.error(var4.getMessage());
            }
         }

         return ItemInspecaoTabCoberturaFragment.newInstance(this.context, this.item.getInspecao().getId(), this.item.getId());
      }
   }

   public Parcelable saveState() {
      Bundle var1 = (Bundle)super.saveState();
      var1.putParcelableArray("states", (Parcelable[])null);
      return var1;
   }
}
