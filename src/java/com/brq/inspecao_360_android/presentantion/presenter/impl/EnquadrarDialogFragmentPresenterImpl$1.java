package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.presentantion.presenter.impl.EnquadrarDialogFragmentPresenterImpl.1.1;
import java.util.List;
import rx.Subscriber;

class EnquadrarDialogFragmentPresenterImpl$1 extends Subscriber {
   // $FF: synthetic field
   final EnquadrarDialogFragmentPresenterImpl this$0;
   // $FF: synthetic field
   final Long val$idInspecao;
   // $FF: synthetic field
   final Long val$idItem;
   // $FF: synthetic field
   final Long val$idSeguradora;
   // $FF: synthetic field
   final String val$uid;

   EnquadrarDialogFragmentPresenterImpl$1(EnquadrarDialogFragmentPresenterImpl var1, Long var2, Long var3, Long var4, String var5) {
      this.this$0 = var1;
      this.val$idInspecao = var2;
      this.val$idItem = var3;
      this.val$idSeguradora = var4;
      this.val$uid = var5;
   }

   public void onCompleted() {
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
   }

   public void onError(Throwable var1) {
      Logger.error("Erro ao carregar enquadramentos.", var1);
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).showProgress(false);
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).onError();
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).showSnackbar(EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).getStringFragment(2131821066), EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).getStringFragment(2131820915), new 1(this));
   }

   public void onNext(List var1) {
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).addSubRamosSpinner(var1);
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).onSuccess();
   }

   public void onStart() {
      super.onStart();
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).showProgress(true);
   }
}
