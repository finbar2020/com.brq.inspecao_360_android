package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.brq.inspecao_360_android.ui.fragment.GaleriaFrustroFragment;
import com.brq.inspecao_360_android.ui.fragment.ItemInspecaoFrustrarTabFrustroFragment;

public class ItemInspecaoFrustrarTabPagerAdapter extends FragmentStatePagerAdapter {
   public static final int POSITION_FRUSTRAR = 0;
   public static final int POSITION_GALERIA = 1;
   private Context context;
   private Long idChecklist;
   private Long idInspecao;
   private Long idItem;
   private Long idSeguradora;
   private int tabCount;
   private String uid;

   public ItemInspecaoFrustrarTabPagerAdapter(FragmentManager var1, Context var2, Long var3, Long var4, String var5, Long var6, Long var7, int var8) {
      super(var1);
      this.context = var2;
      this.idInspecao = var3;
      this.idItem = var4;
      this.uid = var5;
      this.idChecklist = var6;
      this.idSeguradora = var7;
      this.tabCount = var8;
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
      if (var1 != 0) {
         return var1 != 1 ? null : GaleriaFrustroFragment.newInstance(this.context, this.idInspecao, this.idItem, false, true);
      } else {
         return ItemInspecaoFrustrarTabFrustroFragment.newInstance(this.context, this.idInspecao, this.idItem, this.uid, this.idChecklist, this.idSeguradora);
      }
   }

   public Parcelable saveState() {
      return null;
   }
}
