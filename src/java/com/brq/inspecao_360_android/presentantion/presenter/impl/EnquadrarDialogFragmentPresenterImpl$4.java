package com.brq.inspecao_360_android.presentantion.presenter.impl;

import android.view.View;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.presentantion.presenter.impl.-..Lambda.EnquadrarDialogFragmentPresenterImpl.4.3VZrsVJh47unY94hYoigRyAnLGE;
import com.brq.inspecao_360_android.presentantion.view.EnquadrarDialogView.DialogFragment;
import java.util.List;
import rx.Subscriber;

class EnquadrarDialogFragmentPresenterImpl$4 extends Subscriber {
   // $FF: synthetic field
   final EnquadrarDialogFragmentPresenterImpl this$0;
   // $FF: synthetic field
   final Long val$idInspecao;
   // $FF: synthetic field
   final Long val$idItem;
   // $FF: synthetic field
   final List val$itemEnquadramentos;
   // $FF: synthetic field
   final String val$uid;

   EnquadrarDialogFragmentPresenterImpl$4(EnquadrarDialogFragmentPresenterImpl var1, Long var2, Long var3, String var4, List var5) {
      this.this$0 = var1;
      this.val$idItem = var2;
      this.val$idInspecao = var3;
      this.val$uid = var4;
      this.val$itemEnquadramentos = var5;
   }

   // $FF: synthetic method
   public void lambda$onError$0$EnquadrarDialogFragmentPresenterImpl$4(Long var1, Long var2, String var3, List var4, View var5) {
      this.this$0.enquadrarOff(var1, var2, var3, var4);
   }

   public void onCompleted() {
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).recarregarLista();
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao salvar enquadramento.", var1);
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).onError();
      DialogFragment var2 = EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0);
      String var3 = EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).getStringFragment(2131821066);
      String var4 = EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).getStringFragment(2131820915);
      Long var5 = this.val$idItem;
      Long var6 = this.val$idInspecao;
      String var7 = this.val$uid;
      List var8 = this.val$itemEnquadramentos;
      3VZrsVJh47unY94hYoigRyAnLGE var9 = new 3VZrsVJh47unY94hYoigRyAnLGE(this, var5, var6, var7, var8);
      var2.showSnackbar(var3, var4, var9);
   }

   public void onNext(Void var1) {
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).showToastLongTime("Enquadramento salvo com sucesso.");
   }

   public void onStart() {
      super.onStart();
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).showProgress(true);
   }
}
