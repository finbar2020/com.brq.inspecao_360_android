package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.Map;

public class ChecklistGrupoTabPagerAdapter extends FragmentStatePagerAdapter {
   private Map fragments;
   private int tabCount;

   public ChecklistGrupoTabPagerAdapter(FragmentManager var1, int var2, Map var3) {
      super(var1);
      this.tabCount = var2;
      this.fragments = var3;
   }

   public int getCount() {
      return this.tabCount;
   }

   public Fragment getItem(int var1) {
      return (Fragment)this.fragments.get(var1);
   }
}
