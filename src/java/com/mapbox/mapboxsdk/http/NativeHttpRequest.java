package com.mapbox.mapboxsdk.http;

import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.http.LocalRequestTask.OnLocalRequestResponse;
import java.util.concurrent.locks.ReentrantLock;

@Keep
public class NativeHttpRequest implements HttpResponder {
   private final HttpRequest httpRequest = Mapbox.getModuleProvider().createHttpRequest();
   private final ReentrantLock lock = new ReentrantLock();
   @Keep
   private long nativePtr;

   @Keep
   private NativeHttpRequest(long var1, String var3, String var4, String var5, boolean var6) {
      this.nativePtr = var1;
      if (var3.startsWith("local://")) {
         this.executeLocalRequest(var3);
      } else {
         this.httpRequest.executeRequest(this, var1, var3, var4, var5, var6);
      }
   }

   private void executeLocalRequest(String var1) {
      (new LocalRequestTask(new OnLocalRequestResponse() {
         public void onResponse(@Nullable byte[] var1) {
            if (var1 != null) {
               NativeHttpRequest.this.lock.lock();
               if (NativeHttpRequest.this.nativePtr != 0L) {
                  NativeHttpRequest.this.nativeOnResponse(200, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, var1);
               }

               NativeHttpRequest.this.lock.unlock();
            }

         }
      })).execute(new String[]{var1});
   }

   @Keep
   private native void nativeOnFailure(int var1, String var2);

   @Keep
   private native void nativeOnResponse(int var1, String var2, String var3, String var4, String var5, String var6, String var7, byte[] var8);

   public void cancel() {
      this.httpRequest.cancelRequest();
      this.lock.lock();
      this.nativePtr = 0L;
      this.lock.unlock();
   }

   public void handleFailure(int var1, String var2) {
      this.lock.lock();
      if (this.nativePtr != 0L) {
         this.nativeOnFailure(var1, var2);
      }

      this.lock.unlock();
   }

   public void onResponse(int var1, String var2, String var3, String var4, String var5, String var6, String var7, byte[] var8) {
      this.lock.lock();
      if (this.nativePtr != 0L) {
         this.nativeOnResponse(var1, var2, var3, var4, var5, var6, var7, var8);
      }

      this.lock.unlock();
   }
}
