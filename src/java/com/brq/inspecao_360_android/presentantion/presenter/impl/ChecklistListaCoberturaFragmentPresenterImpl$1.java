package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.presentantion.presenter.impl.ChecklistListaCoberturaFragmentPresenterImpl.1.1;
import java.util.List;
import rx.Subscriber;

class ChecklistListaCoberturaFragmentPresenterImpl$1 extends Subscriber {
   // $FF: synthetic field
   final ChecklistListaCoberturaFragmentPresenterImpl this$0;
   // $FF: synthetic field
   final Long val$idChecklist;
   // $FF: synthetic field
   final Long val$idInspecao;
   // $FF: synthetic field
   final Item val$item;

   ChecklistListaCoberturaFragmentPresenterImpl$1(ChecklistListaCoberturaFragmentPresenterImpl var1, Long var2, Item var3, Long var4) {
      this.this$0 = var1;
      this.val$idInspecao = var2;
      this.val$item = var3;
      this.val$idChecklist = var4;
   }

   public void onCompleted() {
      ChecklistListaCoberturaFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao carregar os itens", var1);
      ChecklistListaCoberturaFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
      ChecklistListaCoberturaFragmentPresenterImpl.access$000(this.this$0).showSnackbar(ChecklistListaCoberturaFragmentPresenterImpl.access$000(this.this$0).getString(2131821121), ChecklistListaCoberturaFragmentPresenterImpl.access$000(this.this$0).getString(2131820915), new 1(this));
   }

   public void onNext(List var1) {
      if (!Validator.isNullOrEmpty(var1)) {
         ChecklistListaCoberturaFragmentPresenterImpl.access$000(this.this$0).addAll(ChecklistListaCoberturaFragmentPresenterImpl.access$100(this.this$0), var1);
      }

   }

   public void onStart() {
      super.onStart();
      ChecklistListaCoberturaFragmentPresenterImpl.access$000(this.this$0).showProgress(true);
   }
}
