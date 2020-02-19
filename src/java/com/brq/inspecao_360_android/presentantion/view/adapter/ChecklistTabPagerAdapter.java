package com.brq.inspecao_360_android.presentantion.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.Map;

public class ChecklistTabPagerAdapter extends FragmentStatePagerAdapter {
   private FragmentManager fm;
   private Map fragments;
   private int tabCount;

   public ChecklistTabPagerAdapter(FragmentManager var1, int var2, Map var3) {
      super(var1);
      this.fm = var1;
      this.tabCount = var2;
      this.fragments = var3;
   }

   public int getCount() {
      return this.tabCount;
   }

   public Fragment getItem(int var1) {
      return (Fragment)this.fragments.get(var1);
   }

   public void replace(Integer var1, Fragment var2) {
      this.fragments.remove(var1);
      this.fragments.put(var1, var2);
      this.notifyDataSetChanged();
   }
}
