package com.brq.inspecao_360_android.service.download;

import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

class DownloadProgressResponseBody$1 extends ForwardingSource {
   // $FF: synthetic field
   final DownloadProgressResponseBody this$0;
   long totalBytesRead;

   DownloadProgressResponseBody$1(DownloadProgressResponseBody var1, Source var2) {
      super(var2);
      this.this$0 = var1;
      this.totalBytesRead = 0L;
   }

   public long read(Buffer var1, long var2) throws IOException {
      long var4 = super.read(var1, var2);
      if (var4 != -1L) {
         this.totalBytesRead += var4;
      }

      if (DownloadProgressResponseBody.access$000(this.this$0) != null) {
         DownloadProgressListener var6 = DownloadProgressResponseBody.access$000(this.this$0);
         String var7 = DownloadProgressResponseBody.access$100(this.this$0);
         long var8 = this.totalBytesRead;
         long var10 = DownloadProgressResponseBody.access$200(this.this$0).contentLength();
         boolean var12;
         if (var4 == -1L) {
            var12 = true;
         } else {
            var12 = false;
         }

         var6.update(var7, var8, var10, var12);
      }

      return var4;
   }
}
