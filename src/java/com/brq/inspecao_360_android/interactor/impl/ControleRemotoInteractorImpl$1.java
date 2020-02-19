package com.brq.inspecao_360_android.interactor.impl;

import com.brq.inspecao_360_android.common.util.Logger;
import com.brq.inspecao_360_android.model.db.ImagemDAO;
import com.brq.inspecao_360_android.model.entity.Imagem;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Subscriber;
import rx.Observable.OnSubscribe;

class ControleRemotoInteractorImpl$1 implements OnSubscribe {
   // $FF: synthetic field
   final ControleRemotoInteractorImpl this$0;
   // $FF: synthetic field
   final Long val$idItem;

   ControleRemotoInteractorImpl$1(ControleRemotoInteractorImpl var1, Long var2) {
      this.this$0 = var1;
      this.val$idItem = var2;
   }

   public void call(Subscriber var1) {
      label80: {
         SQLException var24;
         label79: {
            IOException var10000;
            label82: {
               List var4;
               ArrayList var5;
               Iterator var6;
               boolean var10001;
               try {
                  var4 = ImagemDAO.newInstance().obter(this.val$idItem);
                  var5 = new ArrayList();
                  var6 = var4.iterator();
               } catch (SQLException var20) {
                  var24 = var20;
                  var10001 = false;
                  break label79;
               } catch (IOException var21) {
                  var10000 = var21;
                  var10001 = false;
                  break label82;
               }

               while(true) {
                  try {
                     if (!var6.hasNext()) {
                        break;
                     }

                     Imagem var11 = (Imagem)var6.next();
                     if (!(new File(var11.getFilePath())).exists()) {
                        var5.add(var11);
                     }
                  } catch (SQLException var22) {
                     var24 = var22;
                     var10001 = false;
                     break label79;
                  } catch (IOException var23) {
                     var10000 = var23;
                     var10001 = false;
                     break label82;
                  }
               }

               Iterator var7;
               try {
                  var7 = var5.iterator();
               } catch (SQLException var16) {
                  var24 = var16;
                  var10001 = false;
                  break label79;
               } catch (IOException var17) {
                  var10000 = var17;
                  var10001 = false;
                  break label82;
               }

               while(true) {
                  try {
                     if (!var7.hasNext()) {
                        break;
                     }

                     var4.remove((Imagem)var7.next());
                  } catch (SQLException var18) {
                     var24 = var18;
                     var10001 = false;
                     break label79;
                  } catch (IOException var19) {
                     var10000 = var19;
                     var10001 = false;
                     break label82;
                  }
               }

               Iterator var8;
               try {
                  var8 = var4.iterator();
               } catch (SQLException var14) {
                  var24 = var14;
                  var10001 = false;
                  break label79;
               } catch (IOException var15) {
                  var10000 = var15;
                  var10001 = false;
                  break label82;
               }

               while(true) {
                  try {
                     if (!var8.hasNext()) {
                        break label80;
                     }

                     File var9 = new File(((Imagem)var8.next()).getFilePath());
                     this.this$0.copy(var9, this.val$idItem);
                  } catch (SQLException var12) {
                     var24 = var12;
                     var10001 = false;
                     break label79;
                  } catch (IOException var13) {
                     var10000 = var13;
                     var10001 = false;
                     break;
                  }
               }
            }

            IOException var3 = var10000;
            Logger.error("Service - Erro ao decriptar imagens.", var3);
            var1.onError(var3);
            break label80;
         }

         SQLException var2 = var24;
         Logger.error("Service - Erro ao obter imagens do item.", var2);
         var1.onError(var2);
      }

      var1.onCompleted();
   }
}
