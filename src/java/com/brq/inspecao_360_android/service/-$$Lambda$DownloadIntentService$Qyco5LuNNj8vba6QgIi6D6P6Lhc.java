package com.brq.inspecao_360_android.service;

import retrofit2.Response;
import rx.functions.Func1;

// $FF: synthetic class
public final class -$$Lambda$DownloadIntentService$Qyco5LuNNj8vba6QgIi6D6P6Lhc implements Func1 {
   // $FF: synthetic field
   private final String f$0;

   // $FF: synthetic method
   public _$$Lambda$DownloadIntentService$Qyco5LuNNj8vba6QgIi6D6P6Lhc/* $FF was: -$$Lambda$DownloadIntentService$Qyco5LuNNj8vba6QgIi6D6P6Lhc*/(String var1) {
      this.f$0 = var1;
   }

   public final Object call(Object var1) {
      return DownloadIntentService.lambda$getFile$0(this.f$0, (Response)var1);
   }
}
