package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.db.ChecklistDAO;
import com.brq.inspecao_360_android.model.entity.Checklist;
import java.sql.SQLException;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class ChecklistInteractorImpl$1 implements OnSubscribe {
   // $FF: synthetic field
   final ChecklistInteractorImpl this$0;
   // $FF: synthetic field
   final ChecklistDAO val$checklistDAO;
   // $FF: synthetic field
   final Long val$idChecklist;

   ChecklistInteractorImpl$1(ChecklistInteractorImpl var1, ChecklistDAO var2, Long var3) {
      this.this$0 = var1;
      this.val$checklistDAO = var2;
      this.val$idChecklist = var3;
   }

   public void call(Subscriber var1) {
      try {
         var1.onNext((Checklist)this.val$checklistDAO.getById(this.val$idChecklist));
      } catch (SQLException var3) {
         Logger.error("Erro ao obter checklist Off.", var3);
         var1.onError(var3);
      }

      var1.onCompleted();
   }
}
