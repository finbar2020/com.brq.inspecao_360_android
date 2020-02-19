package com.brq.inspecao_360_android.service.intent;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat.BigTextStyle;
import android.support.v4.app.NotificationCompat.Builder;
import com.brq.inspecao_360_android.common.enumerator.StatusInspecaoEnum;
import com.brq.inspecao_360_android.common.exception.BusinessException;
import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.configuration.di.App;
import com.brq.inspecao_360_android.configuration.di.module.ChecklistModule;
import com.brq.inspecao_360_android.interactor.ChecklistInteractor;
import com.brq.inspecao_360_android.interactor.EnderecoInteractor;
import com.brq.inspecao_360_android.interactor.EnquadramentoInteractor;
import com.brq.inspecao_360_android.interactor.ItemInspecaoInteractor;
import com.brq.inspecao_360_android.interactor.UsuarioInteractor;
import com.brq.inspecao_360_android.model.db.AssinaturaDAO;
import com.brq.inspecao_360_android.model.db.CroquiDAO;
import com.brq.inspecao_360_android.model.db.ImagemDAO;
import com.brq.inspecao_360_android.model.db.RespostaDAO;
import com.brq.inspecao_360_android.model.entity.Assinatura;
import com.brq.inspecao_360_android.model.entity.BaseEntity;
import com.brq.inspecao_360_android.model.entity.Croqui;
import com.brq.inspecao_360_android.model.entity.Imagem;
import com.brq.inspecao_360_android.model.entity.Item;
import com.brq.inspecao_360_android.model.entity.Resposta;
import com.brq.inspecao_360_android.model.entity.StatusInspecao;
import com.brq.inspecao_360_android.ui.activity.ItemInspecaoDetalheActivity;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class ChecklistIntentService extends Service {
   public static int ID_CHECKLIST_SERVICE;
   public static final int INTERVALO_TENTATIVA = 120;
   public static final int LIMITE_TENTATIVAS = 25;
   private static final String NOTIFICATION_CHANNEL = "APP_360_CHANNEL";
   private AlarmManager alarmMgr;
   @Inject
   ChecklistInteractor checklistInteractor;
   @Inject
   EnderecoInteractor enderecoInteractor;
   @Inject
   EnquadramentoInteractor enquadramentoInteractor;
   @Inject
   ItemInspecaoInteractor itemInspecaoInteractor;
   private String lastAction;
   private Long lastIdInspecao;
   private Long lastIdItem;
   private Subscription lastSubscription;
   private boolean mDeveFinalizar = false;
   private Long mIdChecklist;
   private Long mIdInspecao;
   private Long mIdItem;
   private Long mIdLaudo;
   private Intent mIntentReceiver;
   private Item mItem = null;
   private Bundle mLastArgs;
   private int mQtdAssinaturaEnviada = 0;
   private int mQtdAssinaturaEnviar = 0;
   private int mQtdAssinaturaTotal = 0;
   private int mQtdFotoEnviada = 0;
   private int mQtdFotoEnviar = 0;
   private int mQtdFotoTotal = 0;
   private ChecklistIntentService.ServiceHandler mServiceHandler;
   private Looper mServiceLooper;
   private String mStrAcao;
   private String mStrAcaoAlarm;
   private int mTentativa = 0;
   private String mUID;
   private NotificationManager notificationManager;
   private Map startIdMap;
   private CompositeSubscription subscriptions = new CompositeSubscription();
   @Inject
   UsuarioInteractor usuarioInteractor;

   // $FF: synthetic method
   static Intent access$1100(ChecklistIntentService var0) {
      return var0.mIntentReceiver;
   }

   public static Intent newInstance(Context var0, Long var1, Long var2, String var3, Long var4, String var5, boolean var6, boolean var7, int var8, boolean var9) {
      Intent var10 = new Intent(var0, ChecklistIntentService.class);
      var10.setAction(var5);
      var10.putExtra(var0.getString(2131820730), var1);
      var10.putExtra(var0.getString(2131820731), var2);
      var10.putExtra(var0.getString(2131820728), var4);
      var10.putExtra(var0.getString(2131821316), var3);
      var10.putExtra(var0.getString(2131820742), var6);
      var10.putExtra(var0.getString(2131820744), var7);
      var10.putExtra(var0.getString(2131821274), var8);
      var10.putExtra(var0.getString(2131820667), var9);
      return var10;
   }

   private void notificarAssinatura(Long var1, Item var2, String var3, String var4, StatusInspecao var5, int var6, int var7, int var8) {
      PendingIntent var9 = PendingIntent.getActivity(this, 0, ItemInspecaoDetalheActivity.newInstance(this, var1, var2.getId(), var3), 134217728);
      Builder var10 = (new Builder(this, "APP_360_CHANNEL")).setSmallIcon(2131230982);
      StringBuilder var11 = new StringBuilder();
      var11.append("Inspeção - ");
      var11.append(var3);
      Builder var14 = var10.setContentTitle(var11.toString()).setProgress(var7, var6, false);
      StringBuilder var15 = new StringBuilder();
      var15.append("Enviando assinaturas, ");
      Object[] var17 = new Object[]{String.valueOf(var6), String.valueOf(var7), String.valueOf(var8)};
      var15.append(String.format("%1$2s/%2$2s de %3$2s", var17));
      var14.setContentText(var15.toString()).setSubText(var5.getDescricaoAbreviada()).setContentIntent(var9).setVisibility(1).setOnlyAlertOnce(true).setAutoCancel(false);
      if (this.mQtdAssinaturaEnviada == this.mQtdAssinaturaEnviar && this.mQtdFotoEnviada == this.mQtdFotoEnviar) {
         Builder var20 = (new Builder(this, "APP_360_CHANNEL")).setSmallIcon(2131230901).setProgress(0, 0, false);
         StringBuilder var21 = new StringBuilder();
         var21.append("Inspeção - ");
         var21.append(var3);
         Builder var24 = var20.setContentTitle(var21.toString()).setContentText("Inspeção enviada com sucesso.").setPriority(2).setOnlyAlertOnce(true);
         this.notificationManager.notify(var2.getId().intValue(), var24.build());
      }

   }

   private Subscriber subscriberAtualizar() {
      return new ChecklistIntentService$2(this);
   }

   private Subscriber subscriberAtualizarCancelar() {
      return new ChecklistIntentService$3(this);
   }

   private Subscriber subscriberTerminarFinalizar() {
      return new ChecklistIntentService$4(this);
   }

   protected Observable alterarEndereco() {
      Logger.info("Checklist - Enquadrar!");
      return this.enderecoInteractor.alterarEnderecoOn(this.mIdItem, this.mIdInspecao);
   }

   protected Observable anexar(Long var1, List var2) {
      return Observable.from(var2).flatMap(new -$$Lambda$ChecklistIntentService$pUTm-E9cZYpUvoxCAJVmNr9krkU(this, var1)).doOnNext(new -$$Lambda$ChecklistIntentService$I6j05YeuryJ3mot1gW15EvaBp_k(this)).toList().switchMap(new -$$Lambda$ChecklistIntentService$c8qKwATLZmsUEgrV_5n0TYUbjOw(this));
   }

   protected Observable anexarAssinaturas(Long var1, List var2) {
      return Observable.from(var2).flatMap(new -$$Lambda$ChecklistIntentService$cX_E-tbJwT6ST01Bdy9bEa7S89M(this, var1)).doOnNext(new -$$Lambda$ChecklistIntentService$u7gi1ZX44SgEaRFCQf1EWoLn9vA(this)).toList().switchMap(new -$$Lambda$ChecklistIntentService$qYmPQSJCZVJcwPYq7Jj6AOh_HTs(this));
   }

   protected Observable atualizar(StatusInspecao var1) {
      return this.itemInspecaoInteractor.atualizarStatusOff(this.mIdInspecao, this.mIdItem, var1.getId()).doOnNext(new -$$Lambda$vrnAhPWUGqLzeyK1mCkjklcxPmA(this));
   }

   public boolean checkContemImagemPendente() {
      ImagemDAO var1 = ImagemDAO.newInstance();

      int var9;
      label60: {
         SQLException var10000;
         label59: {
            List var5;
            ArrayList var6;
            Iterator var7;
            boolean var10001;
            try {
               Long var3 = this.mIdItem;
               Object[] var4 = new Object[]{1, -1};
               var5 = var1.getAllByIdItemAndIdStatusForChecklist(var3, var4);
               var6 = new ArrayList();
               var7 = var5.iterator();
            } catch (SQLException var16) {
               var10000 = var16;
               var10001 = false;
               break label59;
            }

            label58:
            while(true) {
               try {
                  while(var7.hasNext()) {
                     Imagem var12 = (Imagem)var7.next();
                     if (!(new File(var12.getFilePath())).exists()) {
                        var6.add(var12);
                     }
                  }
               } catch (SQLException var17) {
                  var10000 = var17;
                  var10001 = false;
                  break;
               }

               Iterator var8;
               try {
                  var8 = var6.iterator();
               } catch (SQLException var14) {
                  var10000 = var14;
                  var10001 = false;
                  break;
               }

               while(true) {
                  try {
                     if (!var8.hasNext()) {
                        break;
                     }

                     var5.remove((Imagem)var8.next());
                  } catch (SQLException var15) {
                     var10000 = var15;
                     var10001 = false;
                     break label58;
                  }
               }

               try {
                  var9 = var5.size();
                  break label60;
               } catch (SQLException var13) {
                  var10000 = var13;
                  var10001 = false;
                  break;
               }
            }
         }

         SQLException var2 = var10000;
         Logger.error("Erro ao obter imagens para envio do frustro.", var2);
         return false;
      }

      boolean var10 = false;
      if (var9 > 0) {
         var10 = true;
      }

      return var10;
   }

   protected Observable enquadrar() {
      Logger.info("Checklist - Enquadrar!");
      return this.enquadramentoInteractor.enquadrarOn(this.mIdItem, this.mIdInspecao);
   }

   protected Observable enviarRastreios() {
      Logger.info("Checklist - Enviar Rastreios!");
      return this.usuarioInteractor.obterPosicoesRastreamento().switchMap(new -$$Lambda$ChecklistIntentService$e0QjOIim96Z7xYTwDFcNDdwDbvs(this));
   }

   protected Observable finalizar() {
      Logger.info("Checklist - Finalizar!");
      return this.checkContemImagemPendente() ? Observable.error(new BusinessException(0, "Existem imagens pendentes de envio.")) : this.checklistInteractor.finalizarOn(this.mIdInspecao, this.mIdItem, this.mIdLaudo, this.mItem).switchMap(new ChecklistIntentService$1(this));
   }

   protected Subscription getSub() {
      Observable var1 = this.processar(this.mIdInspecao, this.mIdItem, this.mUID);
      if (Validator.isNullOrEmpty(this.lastAction)) {
         return this.mDeveFinalizar ? var1.switchMap(new -$$Lambda$ChecklistIntentService$S1AObbVhtE8GYSwWUGQRyEkkfJs(this)).switchMap(new -$$Lambda$ChecklistIntentService$PN_748p7R6PtJE4K-MiNB3bgF9E(this)).switchMap(new -$$Lambda$ChecklistIntentService$TaYMwKtwlb2yeikOn11KKRKrHrs(this)).switchMap(new -$$Lambda$ChecklistIntentService$EMSP3C4VYoW1qIACt5DNGBtqt9Y(this)).switchMap(new -$$Lambda$ChecklistIntentService$goX5mpZEn9gbyD9vS6GB4UQ-IVA(this)).subscribeOn(Schedulers.newThread()).subscribe(this.subscriberTerminarFinalizar()) : var1.switchMap(new -$$Lambda$ChecklistIntentService$aDshCSh-gPcc5EC2VUGE3mEPun0(this)).switchMap(new -$$Lambda$ChecklistIntentService$sQ3RLqIv1cr0lc8lsA1utdDS3O0(this)).switchMap(new -$$Lambda$ChecklistIntentService$MBPIQPmTpe82wKnbNZbVA9mLZss(this)).switchMap(new -$$Lambda$ChecklistIntentService$F0HrRf6QHQU3mqxtNPU5E7IIIFA(this)).subscribeOn(Schedulers.newThread()).subscribe(this.subscriberTerminarFinalizar());
      } else if (!this.mStrAcao.equalsIgnoreCase("br.com.brq.action.ACAO_ENVIAR") && !this.lastAction.equalsIgnoreCase("br.com.brq.action.ACAO_ENVIAR")) {
         return null;
      } else {
         return this.mDeveFinalizar ? var1.switchMap(new -$$Lambda$ChecklistIntentService$qIpKr-JUghkP6aem6rw0lHBnDAo(this)).switchMap(new -$$Lambda$ChecklistIntentService$1eiXoxW5txAtPEU_-GS1ZNlxrWg(this)).switchMap(new -$$Lambda$ChecklistIntentService$apZwcXaN-HDqUckFXPRkvXg7JM4(this)).switchMap(new -$$Lambda$ChecklistIntentService$Ec3xpARanDpRIthllD-cl42Abug(this)).switchMap(new -$$Lambda$ChecklistIntentService$riHs5l1TsBra1-eO5dP0MxeRp1Y(this)).subscribeOn(Schedulers.newThread()).subscribe(this.subscriberTerminarFinalizar()) : var1.switchMap(new -$$Lambda$ChecklistIntentService$jX85ZDgl2_cumTxd_c1nm0kqN9k(this)).switchMap(new -$$Lambda$ChecklistIntentService$KDBKwagH3HkKEWlBhEs-k2EWhjc(this)).switchMap(new -$$Lambda$ChecklistIntentService$MrB3yYzB1mr88sq0UGmLomL7r0M(this)).switchMap(new -$$Lambda$ChecklistIntentService$IHgnuLHN5DpKQBGRQHWf4fAiFVM(this)).subscribeOn(Schedulers.newThread()).subscribe(this.subscriberTerminarFinalizar());
      }
   }

   protected Observable iniciar(Long var1, Long var2, String var3, List var4, Croqui var5) {
      return this.checklistInteractor.iniciarOn(var1, var2, var4, this.mQtdFotoTotal, var5).flatMap(new -$$Lambda$ChecklistIntentService$E8_a03ytM6845v0R6EXsNR_7DyY(this));
   }

   // $FF: synthetic method
   public Observable lambda$anexar$21$ChecklistIntentService(Long var1, Imagem var2) {
      Logger.info("Checklist - Enviando Foto...");
      return this.checklistInteractor.anexarOn(var1, var2);
   }

   // $FF: synthetic method
   public void lambda$anexar$22$ChecklistIntentService(Imagem var1) {
      ++this.mQtdFotoEnviada;
      StringBuilder var2 = new StringBuilder();
      var2.append("Checklist - TOTAL DE FOTO(S) ENVIADA(S): ");
      var2.append(this.mQtdFotoEnviada);
      Logger.info(var2.toString());
      this.throwItem(var1);
   }

   // $FF: synthetic method
   public Observable lambda$anexar$23$ChecklistIntentService(List var1) {
      return this.itemInspecaoInteractor.obterOff(this.mIdInspecao, this.mIdItem);
   }

   // $FF: synthetic method
   public Observable lambda$anexarAssinaturas$24$ChecklistIntentService(Long var1, Assinatura var2) {
      Logger.info("Checklist - Enviando Foto...");
      return this.checklistInteractor.anexarAssinaturaOn(var1, var2);
   }

   // $FF: synthetic method
   public void lambda$anexarAssinaturas$25$ChecklistIntentService(Assinatura var1) {
      ++this.mQtdAssinaturaEnviada;
      StringBuilder var2 = new StringBuilder();
      var2.append("Checklist - TOTAL DE ASSINATURA(S) ENVIADA(S): ");
      var2.append(this.mQtdAssinaturaEnviada);
      Logger.info(var2.toString());
      this.throwItem(var1);
   }

   // $FF: synthetic method
   public Observable lambda$anexarAssinaturas$26$ChecklistIntentService(List var1) {
      return this.itemInspecaoInteractor.obterOff(this.mIdInspecao, this.mIdItem);
   }

   // $FF: synthetic method
   public Observable lambda$enviarRastreios$30$ChecklistIntentService(List var1) {
      return !Validator.isNullOrEmpty(var1) ? this.usuarioInteractor.enviarPosicoesRastreamento(var1).switchMap(new -$$Lambda$ChecklistIntentService$E7Lrcx78XE-iLVf_MMQ5h6kFclo(this)) : this.itemInspecaoInteractor.enviarRastreamentos(this.mIdLaudo, this.mIdItem).switchMap(new -$$Lambda$ChecklistIntentService$b64-Rh4hRYy2CsK0aegdvYRHFV8(this));
   }

   // $FF: synthetic method
   public Observable lambda$getSub$0$ChecklistIntentService(Item var1) {
      return this.enquadrar();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$1$ChecklistIntentService(Item var1) {
      return this.alterarEndereco();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$10$ChecklistIntentService(Item var1) {
      return this.alterarEndereco();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$11$ChecklistIntentService(Item var1) {
      return this.enviarRastreios();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$12$ChecklistIntentService(Item var1) {
      return this.terminar();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$13$ChecklistIntentService(Item var1) {
      return this.finalizar();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$14$ChecklistIntentService(Item var1) {
      return this.enquadrar();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$15$ChecklistIntentService(Item var1) {
      return this.alterarEndereco();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$16$ChecklistIntentService(Item var1) {
      return this.enviarRastreios();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$17$ChecklistIntentService(Item var1) {
      return this.terminar();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$2$ChecklistIntentService(Item var1) {
      return this.enviarRastreios();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$3$ChecklistIntentService(Item var1) {
      return this.terminar();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$4$ChecklistIntentService(Item var1) {
      return this.finalizar();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$5$ChecklistIntentService(Item var1) {
      return this.enquadrar();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$6$ChecklistIntentService(Item var1) {
      return this.alterarEndereco();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$7$ChecklistIntentService(Item var1) {
      return this.enviarRastreios();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$8$ChecklistIntentService(Item var1) {
      return this.terminar();
   }

   // $FF: synthetic method
   public Observable lambda$getSub$9$ChecklistIntentService(Item var1) {
      return this.enquadrar();
   }

   // $FF: synthetic method
   public Observable lambda$iniciar$20$ChecklistIntentService(BaseEntity var1) {
      this.mIdLaudo = var1.getId();
      return this.atualizar(StatusInspecaoEnum.get(StatusInspecaoEnum.PROCESSANDO_CHECKLIST.getId()));
   }

   // $FF: synthetic method
   public Observable lambda$null$27$ChecklistIntentService(Void var1) {
      return this.itemInspecaoInteractor.obterOff(this.mIdInspecao, this.mIdItem);
   }

   // $FF: synthetic method
   public Observable lambda$null$28$ChecklistIntentService(Void var1) {
      return this.itemInspecaoInteractor.enviarRastreamentos(this.mIdLaudo, this.mIdItem).switchMap(new -$$Lambda$ChecklistIntentService$e3lEcNB9r6Sp4mqHx5TbQIO2QVc(this));
   }

   // $FF: synthetic method
   public Observable lambda$null$29$ChecklistIntentService(Void var1) {
      return this.itemInspecaoInteractor.obterOff(this.mIdInspecao, this.mIdItem);
   }

   // $FF: synthetic method
   public Observable lambda$processar$18$ChecklistIntentService(List var1, Long var2, Long var3, Item var4) {
      return this.mQtdFotoEnviar > 0 ? this.anexar(this.mIdLaudo, var1) : this.itemInspecaoInteractor.obterOff(var2, var3);
   }

   // $FF: synthetic method
   public Observable lambda$processar$19$ChecklistIntentService(List var1, Long var2, Long var3, Item var4) {
      return this.mQtdAssinaturaEnviar > 0 ? this.anexarAssinaturas(this.mIdLaudo, var1) : this.itemInspecaoInteractor.obterOff(var2, var3);
   }

   // $FF: synthetic method
   public Observable lambda$terminar$31$ChecklistIntentService(Item var1) {
      return this.atualizar(var1.getStatusVigente());
   }

   public void notificar(Long var1, Long var2, String var3, Long var4, String var5, StatusInspecao var6, int var7, int var8, int var9, boolean var10) {
      PendingIntent var11 = PendingIntent.getActivity(this, 0, ItemInspecaoDetalheActivity.newInstance(this, var1, var2, var3), 134217728);
      Builder var12 = new Builder(this, "APP_360_CHANNEL");
      Builder var13 = var12.setSmallIcon(2131230982);
      StringBuilder var14 = new StringBuilder();
      var14.append("Inspeção - ");
      var14.append(var3);
      Builder var17 = var13.setContentTitle(var14.toString()).setProgress(var8, var7, false);
      StringBuilder var18 = new StringBuilder();
      var18.append("Enviando fotos, ");
      Object[] var20 = new Object[]{String.valueOf(var7), String.valueOf(var8), String.valueOf(var9)};
      var18.append(String.format("%1$2s/%2$2s de %3$2s", var20));
      var17.setContentText(var18.toString()).setSubText(var6.getDescricaoAbreviada()).setContentIntent(var11).setVisibility(1).setOnlyAlertOnce(true).setAutoCancel(false);
      String var23;
      boolean var28;
      if (StatusInspecaoEnum.ERRO_ENVIAR_CHECKLIST.getId() != var6.getId() && StatusInspecaoEnum.ERRO_FINALIZAR_CHECKLIST.getId() != var6.getId()) {
         this.notificationManager.notify(var2.intValue(), var12.build());
         var23 = "Inspeção - ";
         var28 = true;
      } else {
         var23 = "Inspeção - ";
         Intent var24 = newInstance(this, var1, var2, var3, var4, "br.com.brq.action.ACAO_REENVIAR", false, true, 0, var10);
         PendingIntent var25 = PendingIntent.getService(this, var2.intValue(), var24, 1207959552);
         Intent var26 = newInstance(this, var1, var2, var3, var4, "br.com.brq.action.ACAO_CANCELAR", false, true, 0, var10);
         PendingIntent var27 = PendingIntent.getService(this, var2.intValue(), var26, 1207959552);
         Builder var31;
         if (this.mTentativa > 25) {
            var28 = true;
            ArrayList var29 = var12.mActions;
            boolean var30 = Validator.isNullOrEmpty(var29);
            var31 = null;
            if (var30) {
               int var37 = var29.size();
               var31 = null;
               if (var37 <= 0) {
                  Builder var38 = (new Builder(this, "APP_360_CHANNEL")).setSmallIcon(2131230894).setProgress(0, 0, false);
                  StringBuilder var39 = new StringBuilder();
                  var39.append(var23);
                  var39.append(var3);
                  var31 = var38.setContentTitle(var39.toString()).setStyle((new BigTextStyle()).bigText("Limite de tentativas de envio automáticas atingido. Você pode reiniciar o processo manualmente, ou se preferir, entre em contato com nossa central de atendimento.")).addAction(2131230982, this.getString(2131821244), var25).setPriority(2).setOnlyAlertOnce(var28);
               }
            }
         } else {
            ArrayList var42 = var12.mActions;
            Builder var43;
            if (Validator.isNullOrEmpty(var42) && var42.size() <= 0) {
               Builder var49 = (new Builder(this, "APP_360_CHANNEL")).setSmallIcon(2131230894).setProgress(0, 0, false);
               StringBuilder var50 = new StringBuilder();
               var50.append(var23);
               var50.append(var3);
               Builder var53 = var49.setContentTitle(var50.toString()).setStyle((new BigTextStyle()).bigText("O envio do checklist falhou e será executado novamente em 2 minutos.")).addAction(2131230982, this.getString(2131821244), var25).addAction(2131230989, this.getString(2131820811), var27).setPriority(2);
               var28 = true;
               var43 = var53.setOnlyAlertOnce(var28);
            } else {
               var28 = true;
               var43 = null;
            }

            Intent var44 = newInstance(this, var1, var2, var3, var4, "br.com.brq.action.ACAO_REENVIAR", true, false, 1 + this.mTentativa, var10);
            if (PendingIntent.getService(this, var2.intValue(), var44, 536870912) == null) {
               PendingIntent var45 = PendingIntent.getService(this, var2.intValue(), var44, 134217728);
               this.alarmMgr = (AlarmManager)this.getBaseContext().getSystemService("alarm");
               Calendar var46 = Calendar.getInstance();
               var46.add(13, 120);
               long var47 = var46.getTimeInMillis();
               this.alarmMgr.setInexactRepeating(0, var47, 120000L, var45);
               Logger.debug("Alarme criado.");
            }

            var31 = var43;
         }

         this.notificationManager.notify(var2.intValue(), var31.build());
      }

      if (this.mQtdAssinaturaEnviada == this.mQtdAssinaturaEnviar && this.mQtdFotoEnviada == this.mQtdFotoEnviar && StatusInspecaoEnum.ERRO_ENVIAR_CHECKLIST.getId() != var6.getId() && StatusInspecaoEnum.ERRO_FINALIZAR_CHECKLIST.getId() != var6.getId()) {
         Builder var32 = (new Builder(this, "APP_360_CHANNEL")).setSmallIcon(2131230901).setProgress(0, 0, false);
         StringBuilder var33 = new StringBuilder();
         var33.append(var23);
         var33.append(var3);
         Builder var36 = var32.setContentTitle(var33.toString()).setContentText("Inspeção enviada com sucesso.").setPriority(2).setOnlyAlertOnce(var28);
         this.notificationManager.notify(var2.intValue(), var36.build());
      }

   }

   public Notification notificarInicio() {
      Builder var1 = new Builder(this, "APP_360_CHANNEL");
      var1.setSmallIcon(2131230940).setContentTitle(this.getString(2131820597)).setProgress(0, 0, true).setContentText("Serviço de transmissão de checklist em execução.").setContentInfo("Checklist").setAutoCancel(false);
      return var1.build();
   }

   public void notificarInspecaoStatusInvalido(String var1, Long var2) {
      Builder var3 = (new Builder(this, "APP_360_CHANNEL")).setSmallIcon(2131230894).setProgress(0, 0, false);
      StringBuilder var4 = new StringBuilder();
      var4.append("Inspeção - ");
      var4.append(var1);
      Builder var7 = var3.setContentTitle(var4.toString()).setContentText("Inspeção com status não permitido para envio de checklist").setPriority(2).setOnlyAlertOnce(true);
      this.notificationManager.notify(var2.intValue(), var7.build());
   }

   @Nullable
   public IBinder onBind(Intent var1) {
      return null;
   }

   public void onCreate() {
      super.onCreate();
      App.get(this).getAppComponent().plus(new ChecklistModule()).inject(this);
      this.notificationManager = (NotificationManager)this.getSystemService("notification");
      HandlerThread var1 = new HandlerThread("ServiceStartArguments", -2);
      var1.start();
      if (VERSION.SDK_INT >= 26) {
         NotificationChannel var2 = new NotificationChannel("APP_360_CHANNEL", this.getString(2131820597), 4);
         var2.enableLights(true);
         var2.enableVibration(true);
         var2.setLightColor(-256);
         var2.setLockscreenVisibility(1);
         this.notificationManager.createNotificationChannel(var2);
      }

      this.mServiceLooper = var1.getLooper();
      this.mServiceHandler = new ChecklistIntentService.ServiceHandler(this.mServiceLooper);
      this.alarmMgr = (AlarmManager)this.getBaseContext().getSystemService("alarm");
   }

   public void onDestroy() {
      super.onDestroy();
   }

   public int onStartCommand(Intent var1, int var2, int var3) {
      this.mIntentReceiver = new Intent("br.com.brq.action.ACTION_UPDATE_ITEM");
      this.mIntentReceiver.putExtra(this.getString(2131821261), "br.com.brq.action.ACTION_START");
      this.sendBroadcast(this.mIntentReceiver);
      if (this.startIdMap == null) {
         this.startIdMap = new HashMap();
      }

      boolean var6;
      boolean var7;
      boolean var8;
      label62: {
         this.startIdMap.put((int)var1.getExtras().getLong(this.getString(2131820731)), var3);
         var6 = var1.getExtras().getBoolean(this.getString(2131820742));
         var7 = var1.getExtras().getBoolean(this.getString(2131820744));
         this.mStrAcaoAlarm = var1.getAction();
         if (this.startIdMap.size() <= 1) {
            boolean var17 = this.subscriptions.hasSubscriptions();
            var8 = false;
            if (!var17) {
               break label62;
            }
         }

         var8 = true;
      }

      if (var6 || var7) {
         var1.setAction("br.com.brq.action.ACAO_REENVIAR");
      }

      if (PendingIntent.getService(this, (int)var1.getExtras().getLong(this.getString(2131820731)), var1, 536870912) != null && (var6 && !var8 || var7)) {
         PendingIntent var16 = PendingIntent.getService(this, (int)var1.getExtras().getLong(this.getString(2131820731)), var1, 134217728);
         var16.cancel();
         this.alarmMgr.cancel(var16);
      }

      if ((var8 || this.subscriptions.hasSubscriptions()) && var6) {
         var1.setAction("br.com.brq.action.ACAO_ESPERAR");
      }

      if (!var8 && var1.getAction().equalsIgnoreCase("br.com.brq.action.ACAO_REENVIAR")) {
         var1.setAction("br.com.brq.action.ACAO_ENVIAR");
      }

      if (this.mStrAcaoAlarm.equalsIgnoreCase("br.com.brq.action.ACAO_CANCELAR")) {
         var1.setAction("br.com.brq.action.ACAO_CANCELAR");
      }

      Bundle var10 = var1.getExtras();
      var10.putString(this.getString(2131820586), var1.getAction());
      if (!var1.getAction().equalsIgnoreCase("br.com.brq.action.ACAO_CANCELAR") && !var1.getAction().equalsIgnoreCase("br.com.brq.action.ACAO_ESPERAR")) {
         this.mStrAcao = var1.getAction();
         this.mIdInspecao = var10.getLong(this.getString(2131820730));
         this.mIdItem = var10.getLong(this.getString(2131820731));
         this.mUID = var10.getString(this.getString(2131821316));
         this.mIdChecklist = var10.getLong(this.getString(2131820728));
         this.mTentativa = var10.getInt(this.getString(2131821274));
         this.mDeveFinalizar = var10.getBoolean(this.getString(2131820667));
      }

      Message var11 = this.mServiceHandler.obtainMessage();
      var11.arg1 = var3;
      var11.setData(var10);
      this.mServiceHandler.sendMessage(var11);
      Logger.info("Checklist - Running!");
      return 3;
   }

   protected Observable processar(Long var1, Long var2, String var3) {
      RespostaDAO var4 = RespostaDAO.newInstance();
      ImagemDAO var5 = ImagemDAO.newInstance();
      CroquiDAO var6 = CroquiDAO.newInstance();
      AssinaturaDAO var7 = AssinaturaDAO.newInstance();
      ArrayList var8 = new ArrayList();
      ArrayList var9 = new ArrayList();

      SQLException var10000;
      boolean var10001;
      label259: {
         label258: {
            List var11;
            Iterator var12;
            try {
               var11 = var4.getByItem(var2);
               var12 = var11.iterator();
            } catch (SQLException var72) {
               var10000 = var72;
               var10001 = false;
               break label258;
            }

            label257:
            while(true) {
               boolean var13;
               try {
                  var13 = var12.hasNext();
               } catch (SQLException var71) {
                  var10000 = var71;
                  var10001 = false;
                  break;
               }

               byte var14 = 6;
               byte var15 = 5;
               if (!var13) {
                  try {
                     if (!Validator.isNullOrEmpty(var9)) {
                        var11.removeAll(var9);
                     }
                  } catch (SQLException var70) {
                     var10000 = var70;
                     var10001 = false;
                     break;
                  }

                  Iterator var19;
                  try {
                     var19 = var11.iterator();
                  } catch (SQLException var69) {
                     var10000 = var69;
                     var10001 = false;
                     break;
                  }

                  while(true) {
                     label265: {
                        Resposta var48;
                        label278: {
                           try {
                              if (!var19.hasNext()) {
                                 break label259;
                              }

                              var48 = (Resposta)var19.next();
                              if (var48.getTipo() == 3 || var48.getTipo() == var15 || var48.getTipo() == var14) {
                                 break label278;
                              }
                           } catch (SQLException var68) {
                              var10000 = var68;
                              var10001 = false;
                              break label257;
                           }

                           try {
                              var8.add(var48);
                              break label265;
                           } catch (SQLException var66) {
                              var10000 = var66;
                              var10001 = false;
                              break label257;
                           }
                        }

                        Iterator var49;
                        try {
                           var49 = var8.iterator();
                        } catch (SQLException var65) {
                           var10000 = var65;
                           var10001 = false;
                           break label257;
                        }

                        boolean var50 = true;

                        label199:
                        while(true) {
                           Resposta var52;
                           try {
                              do {
                                 do {
                                    if (!var49.hasNext()) {
                                       break label199;
                                    }

                                    var52 = (Resposta)var49.next();
                                 } while(var52.getIdPergunta().intValue() != var48.getIdPergunta().intValue());
                              } while(var52.getOpcao().intValue() != var48.getOpcao().intValue());
                           } catch (SQLException var67) {
                              var10000 = var67;
                              var10001 = false;
                              break label257;
                           }

                           var50 = false;
                        }

                        if (var50) {
                           try {
                              var8.add(var48);
                           } catch (SQLException var64) {
                              var10000 = var64;
                              var10001 = false;
                              break label257;
                           }
                        }
                     }

                     var14 = 6;
                     var15 = 5;
                  }
               }

               Resposta var16;
               label273: {
                  try {
                     var16 = (Resposta)var12.next();
                     if (var16.getTipo() != 3 && var16.getTipo() != 4 && var16.getTipo() != var15 && var16.getTipo() != var14) {
                        break label273;
                     }
                  } catch (SQLException var76) {
                     var10000 = var76;
                     var10001 = false;
                     break;
                  }

                  try {
                     if (Validator.isNullOrEmpty(var16.getOpcao())) {
                        var9.add(var16);
                     }
                     continue;
                  } catch (SQLException var74) {
                     var10000 = var74;
                     var10001 = false;
                     break;
                  }
               }

               try {
                  if (var16.getTipo() != 2 && var16.getTipo() != 1) {
                     continue;
                  }
               } catch (SQLException var75) {
                  var10000 = var75;
                  var10001 = false;
                  break;
               }

               try {
                  if (Validator.isNullOrEmpty(var16.getValor())) {
                     var9.add(var16);
                  }
               } catch (SQLException var73) {
                  var10000 = var73;
                  var10001 = false;
                  break;
               }
            }
         }

         SQLException var10 = var10000;
         Logger.error("Service - Erro ao obter respostas do processar.", var10);
         return Observable.error(var10);
      }

      List var22;
      label174: {
         label269: {
            ArrayList var23;
            Iterator var24;
            try {
               Object[] var21 = new Object[]{1, -1};
               var22 = var5.getAllByIdItemAndIdStatus(var2, var21);
               var23 = new ArrayList();
               var24 = var22.iterator();
            } catch (SQLException var62) {
               var10000 = var62;
               var10001 = false;
               break label269;
            }

            while(true) {
               try {
                  if (!var24.hasNext()) {
                     break;
                  }

                  Imagem var46 = (Imagem)var24.next();
                  if (!(new File(var46.getFilePath())).exists()) {
                     var23.add(var46);
                  }
               } catch (SQLException var63) {
                  var10000 = var63;
                  var10001 = false;
                  break label269;
               }
            }

            Iterator var25;
            try {
               var25 = var23.iterator();
            } catch (SQLException var60) {
               var10000 = var60;
               var10001 = false;
               break label269;
            }

            while(true) {
               try {
                  if (!var25.hasNext()) {
                     break;
                  }

                  var22.remove((Imagem)var25.next());
               } catch (SQLException var61) {
                  var10000 = var61;
                  var10001 = false;
                  break label269;
               }
            }

            try {
               this.mQtdFotoEnviada = 0;
               this.mQtdFotoEnviar = var22.size();
               Object[] var26 = new Object[]{1, -1};
               this.mQtdFotoTotal = (int)var5.countOfByIdItemAndStatus(var2, var26);
               StringBuilder var27 = new StringBuilder();
               var27.append("Checklist - TOTAL DE FOTOS: ");
               var27.append(this.mQtdFotoEnviar);
               Logger.info(var27.toString());
               break label174;
            } catch (SQLException var59) {
               var10000 = var59;
               var10001 = false;
            }
         }

         SQLException var20 = var10000;
         Logger.error("Service - Erro ao obter imagens do processar.", var20);
         return Observable.error(var20);
      }

      List var32;
      label146: {
         label271: {
            ArrayList var33;
            Iterator var34;
            try {
               Object[] var31 = new Object[]{1, -1};
               var32 = var7.getAllByIdItemAndIdStatus(var2, var31);
               var33 = new ArrayList();
               var34 = var32.iterator();
            } catch (SQLException var57) {
               var10000 = var57;
               var10001 = false;
               break label271;
            }

            while(true) {
               try {
                  if (!var34.hasNext()) {
                     break;
                  }

                  Assinatura var43 = (Assinatura)var34.next();
                  if (!var43.getResponsavelRecusouAssinar() && !(new File(var43.getFilePath())).exists()) {
                     var33.add(var43);
                  }
               } catch (SQLException var58) {
                  var10000 = var58;
                  var10001 = false;
                  break label271;
               }
            }

            Iterator var35;
            try {
               var35 = var33.iterator();
            } catch (SQLException var55) {
               var10000 = var55;
               var10001 = false;
               break label271;
            }

            while(true) {
               try {
                  if (!var35.hasNext()) {
                     break;
                  }

                  var32.remove((Assinatura)var35.next());
               } catch (SQLException var56) {
                  var10000 = var56;
                  var10001 = false;
                  break label271;
               }
            }

            try {
               this.mQtdAssinaturaEnviada = 0;
               this.mQtdAssinaturaEnviar = var32.size();
               Object[] var36 = new Object[]{1, -1};
               this.mQtdAssinaturaTotal = (int)var7.countOfByIdItemAndStatus(var2, var36);
               StringBuilder var37 = new StringBuilder();
               var37.append("Checklist - TOTAL DE ASSINATURAS: ");
               var37.append(this.mQtdAssinaturaEnviar);
               Logger.info(var37.toString());
               break label146;
            } catch (SQLException var54) {
               var10000 = var54;
               var10001 = false;
            }
         }

         SQLException var30 = var10000;
         Logger.error("Service - Erro ao obter assinaturas do processar.", var30);
         return Observable.error(var30);
      }

      Croqui var41;
      try {
         var41 = var6.getByIdItem(var2);
      } catch (SQLException var53) {
         Logger.error("Service - Erro ao obter croqui.", var53);
         return Observable.error(var53);
      }

      return this.iniciar(var1, var2, var3, var8, var41).switchMap(new -$$Lambda$ChecklistIntentService$Ue5yQBPqbPi6XOvL_isCgHSVf-4(this, var22, var1, var2)).switchMap(new -$$Lambda$ChecklistIntentService$9a0EUBhdviYeE9vz6YLsrbXVYI0(this, var32, var1, var2));
   }

   public void setServiceForeground() {
      this.startForeground(-1, this.notificarInicio());
   }

   public boolean stopService(Intent var1) {
      Object[] var2 = new Object[]{this.mIdLaudo};
      Logger.error(String.format("Checklist - Serviço enterrompido para o processar s%", var2));
      return super.stopService(var1);
   }

   protected Observable terminar() {
      Logger.info("Checklist - Terminar!");
      return this.checkContemImagemPendente() ? Observable.error(new BusinessException(0, "Existem imagens pendentes de envio.")) : this.checklistInteractor.terminar(this.mIdInspecao, this.mIdItem, this.mIdLaudo).switchMap(new -$$Lambda$ChecklistIntentService$nAb3QtqXRE14iPJ7jAB4V5jbk4o(this));
   }

   protected void throwError(String var1, Throwable var2) {
      Logger.error(var1, var2);
      if (var2 instanceof BusinessException && ((BusinessException)var2).getCodMessage() == 75) {
         this.itemInspecaoInteractor.obterOn(this.mIdInspecao, this.mIdItem, true).subscribeOn(Schedulers.immediate()).subscribe(this.subscriberAtualizar());
         this.notificarInspecaoStatusInvalido(this.mUID, this.mIdItem);
      } else {
         this.mIntentReceiver.putExtra(this.getString(2131821316), this.mUID);
         this.mIntentReceiver.putExtra(this.getString(2131821261), "br.com.brq.action.ACTION_ERROR");
         this.mIntentReceiver.putExtra(this.getString(2131820678), var2);
         this.sendBroadcast(this.mIntentReceiver);
         this.stopForeground(false);
         StatusInspecao var6;
         if (this.mDeveFinalizar) {
            var6 = StatusInspecaoEnum.get(StatusInspecaoEnum.ERRO_FINALIZAR_CHECKLIST.getId());
         } else {
            var6 = StatusInspecaoEnum.get(StatusInspecaoEnum.ERRO_ENVIAR_CHECKLIST.getId());
         }

         this.itemInspecaoInteractor.atualizarStatusOff(this.mIdInspecao, this.mIdItem, var6.getId()).subscribeOn(Schedulers.immediate()).subscribe(this.subscriberAtualizar());
         this.stopSelf();
      }
   }

   protected void throwItem(Assinatura var1) {
      try {
         if (Validator.isNullOrEmpty(var1.getItem())) {
            this.itemInspecaoInteractor.obterOff(this.mIdInspecao, this.mIdItem).subscribeOn(Schedulers.immediate()).subscribe(this.subscriberAtualizar());
         } else {
            this.notificarAssinatura(var1.getItem().getInspecao().getId(), var1.getItem(), var1.getItem().getUid(), this.mStrAcao, var1.getItem().getStatusVigente(), this.mQtdAssinaturaEnviada, this.mQtdAssinaturaEnviar, this.mQtdAssinaturaTotal);
         }
      } catch (Exception var3) {
         Logger.error("Erro throw imagem", var3);
      }
   }

   protected void throwItem(Imagem var1) {
      try {
         if (Validator.isNullOrEmpty(var1.getItem())) {
            this.itemInspecaoInteractor.obterOff(this.mIdInspecao, this.mIdItem).subscribeOn(Schedulers.immediate()).subscribe(this.subscriberAtualizar());
         } else {
            this.notificar(var1.getItem().getInspecao().getId(), var1.getItem().getId(), var1.getItem().getUid(), var1.getItem().getChecklistId(), this.mStrAcao, var1.getItem().getStatusVigente(), this.mQtdFotoEnviada, this.mQtdFotoEnviar, this.mQtdFotoTotal, this.mDeveFinalizar);
         }
      } catch (Exception var3) {
         Logger.error("Erro throw imagem", var3);
      }
   }

   protected void throwItem(Item var1) {
      try {
         if (Validator.isNullOrEmpty(var1)) {
            this.itemInspecaoInteractor.obterOff(this.mIdInspecao, this.mIdItem).subscribeOn(Schedulers.immediate()).subscribe(this.subscriberAtualizar());
            return;
         }

         this.mItem = var1;
         this.mIntentReceiver.putExtra(this.getString(2131821261), "br.com.brq.action.ACTION_UPDATE_ITEM");
         this.mIntentReceiver.putExtra(this.getString(2131821191), var1);
         this.sendBroadcast(this.mIntentReceiver);
         if (var1.getStatusVigente().getId() != StatusInspecaoEnum.AGUARDANDO_ENVIAR_DADOS.getId()) {
            this.notificar(var1.getInspecao().getId(), var1.getId(), var1.getUid(), var1.getChecklistId(), this.mStrAcao, var1.getStatusVigente(), this.mQtdFotoEnviada, this.mQtdFotoEnviar, this.mQtdFotoTotal, this.mDeveFinalizar);
            return;
         }
      } catch (Exception var3) {
         Logger.error("Erro throw item", var3);
      }

   }

   protected void throwMessage(String var1) {
      this.mIntentReceiver.putExtra(this.getString(2131821261), "br.com.brq.action.ACTION_MESSAGE");
      this.mIntentReceiver.putExtra(this.getString(2131820853), var1);
      this.sendBroadcast(this.mIntentReceiver);
   }

   private final class ServiceHandler extends Handler {
      public ServiceHandler(Looper var2) {
         super(var2);
      }

      public void handleMessage(Message var1) {
         Exception var10000;
         label93: {
            int var3;
            Bundle var4;
            String var5;
            boolean var6;
            boolean var10001;
            try {
               var3 = var1.arg1;
               var4 = var1.getData();
               var5 = var4.getString(ChecklistIntentService.this.getString(2131820586));
               var6 = var5.equalsIgnoreCase("br.com.brq.action.ACAO_ENVIAR");
            } catch (Exception var20) {
               var10000 = var20;
               var10001 = false;
               break label93;
            }

            if (!var6) {
               label92: {
                  try {
                     if (var5.equalsIgnoreCase("br.com.brq.action.ACAO_REENVIAR")) {
                        break label92;
                     }
                  } catch (Exception var19) {
                     var10000 = var19;
                     var10001 = false;
                     break label93;
                  }

                  try {
                     if (var5.equalsIgnoreCase("br.com.brq.action.ACAO_CANCELAR")) {
                        ChecklistIntentService.this.notificationManager.cancel((int)var4.getLong(ChecklistIntentService.this.getString(2131820731)));
                        ChecklistIntentService.this.stopSelf(var3);
                        return;
                     }

                     return;
                  } catch (Exception var18) {
                     var10000 = var18;
                     var10001 = false;
                     break label93;
                  }
               }
            }

            try {
               if (ChecklistIntentService.this.subscriptions.hasSubscriptions()) {
                  ChecklistIntentService.this.subscriptions.remove(ChecklistIntentService.this.lastSubscription);
                  ChecklistIntentService.this.subscriptions.clear();
               }
            } catch (Exception var17) {
               var10000 = var17;
               var10001 = false;
               break label93;
            }

            try {
               Item var7 = ChecklistIntentService.this.itemInspecaoInteractor.obterOff(ChecklistIntentService.this.mIdItem);
               if (!StatusInspecaoEnum.isEditar(var7.getStatusVigente().getId()) && !StatusInspecaoEnum.isCancelada(var7.getStatusVigente().getId())) {
                  ChecklistIntentService.this.notificationManager.cancel((int)var4.getLong(ChecklistIntentService.this.getString(2131820731)));
                  ChecklistIntentService.this.stopSelf(var3);
                  return;
               }
            } catch (Exception var16) {
               var10000 = var16;
               var10001 = false;
               break label93;
            }

            try {
               if (ChecklistIntentService.this.mStrAcao.equalsIgnoreCase("br.com.brq.action.ACAO_ENVIAR")) {
                  ChecklistIntentService.this.lastAction = String.valueOf(ChecklistIntentService.this.mStrAcao);
               }
            } catch (Exception var15) {
               var10000 = var15;
               var10001 = false;
               break label93;
            }

            try {
               if (ChecklistIntentService.this.mStrAcao.equalsIgnoreCase("br.com.brq.action.ACAO_REENVIAR") && !Validator.isNullOrEmpty(ChecklistIntentService.this.mLastArgs) && ChecklistIntentService.this.mIdItem != ChecklistIntentService.this.mLastArgs.getLong(ChecklistIntentService.this.getString(2131820731))) {
                  ChecklistIntentService.this.lastIdItem = ChecklistIntentService.this.mLastArgs.getLong(ChecklistIntentService.this.getString(2131820731));
                  ChecklistIntentService.this.lastIdInspecao = ChecklistIntentService.this.mLastArgs.getLong(ChecklistIntentService.this.getString(2131820730));
                  StatusInspecao var12 = StatusInspecaoEnum.get(StatusInspecaoEnum.AGUARDANDO_ENVIAR_CHECKLIST.getId());
                  ChecklistIntentService.this.itemInspecaoInteractor.atualizarStatusOff(ChecklistIntentService.this.lastIdInspecao, ChecklistIntentService.this.lastIdItem, var12.getId()).subscribeOn(Schedulers.immediate()).subscribe(ChecklistIntentService.this.subscriberAtualizarCancelar());
                  ChecklistIntentService.this.stopForeground(true);
                  ChecklistIntentService.this.stopSelf((Integer)ChecklistIntentService.this.startIdMap.get(ChecklistIntentService.this.lastIdItem.intValue()));
               }
            } catch (Exception var14) {
               var10000 = var14;
               var10001 = false;
               break label93;
            }

            try {
               ChecklistIntentService.this.mLastArgs = var4;
               ChecklistIntentService.this.lastSubscription = ChecklistIntentService.this.getSub();
               ChecklistIntentService.this.subscriptions.add(ChecklistIntentService.this.lastSubscription);
               ChecklistIntentService.this.setServiceForeground();
               return;
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
            }
         }

         Exception var2 = var10000;
         Logger.error("Erro ao criar Thread de serviço de transmissão.", var2);
         Thread.currentThread().interrupt();
      }
   }
}
