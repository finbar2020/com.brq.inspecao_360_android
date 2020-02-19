package com.brq.inspecao_360_android.presentantion.presenter.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.entity.SubRamo;
import com.brq.inspecao_360_android.presentantion.presenter.impl.EnquadrarDialogFragmentPresenterImpl.3.1;
import java.util.List;
import rx.Subscriber;

class EnquadrarDialogFragmentPresenterImpl$3 extends Subscriber {
   // $FF: synthetic field
   final EnquadrarDialogFragmentPresenterImpl this$0;
   // $FF: synthetic field
   final SubRamo val$subRamo;

   EnquadrarDialogFragmentPresenterImpl$3(EnquadrarDialogFragmentPresenterImpl var1, SubRamo var2) {
      this.this$0 = var1;
      this.val$subRamo = var2;
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
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).addProdutosComerciaisSpinner(var1);
   }

   public void onStart() {
      super.onStart();
      EnquadrarDialogFragmentPresenterImpl.access$000(this.this$0).showProgress(true);
   }
}
