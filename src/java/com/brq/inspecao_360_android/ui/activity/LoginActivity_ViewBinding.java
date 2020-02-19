package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.brq.inspecao_360_android.ui.activity.LoginActivity_ViewBinding.1;
import com.brq.inspecao_360_android.ui.activity.LoginActivity_ViewBinding.2;
import com.brq.inspecao_360_android.ui.activity.LoginActivity_ViewBinding.3;
import com.brq.inspecao_360_android.ui.activity.LoginActivity_ViewBinding.4;

public class LoginActivity_ViewBinding extends BaseActivity_ViewBinding {
   private View view2131296314;
   private View view2131296315;
   private View view2131296601;

   @UiThread
   public LoginActivity_ViewBinding(LoginActivity var1, View var2) {
      super(var1, var2);
      var1.progressLogin = (ProgressBar)Utils.findRequiredViewAsType(var2, 2131296687, "field 'progressLogin'", ProgressBar.class);
      View var3 = Utils.findRequiredView(var2, 2131296601, "field 'mImgLogoBRQ', method 'logoOnClick', and method 'logoOnLongClick'");
      var1.mImgLogoBRQ = (ImageView)Utils.castView(var3, 2131296601, "field 'mImgLogoBRQ'", ImageView.class);
      this.view2131296601 = var3;
      var3.setOnClickListener(new 1(this, var1));
      var3.setOnLongClickListener(new 2(this, var1));
      var1.editEmail = (EditText)Utils.findRequiredViewAsType(var2, 2131296939, "field 'editEmail'", EditText.class);
      var1.editSenha = (EditText)Utils.findRequiredViewAsType(var2, 2131296668, "field 'editSenha'", EditText.class);
      View var4 = Utils.findRequiredView(var2, 2131296314, "field 'btnEntrar' and method 'btnEntrarOnClick'");
      var1.btnEntrar = (Button)Utils.castView(var4, 2131296314, "field 'btnEntrar'", Button.class);
      this.view2131296314 = var4;
      var4.setOnClickListener(new 3(this, var1));
      View var5 = Utils.findRequiredView(var2, 2131296315, "field 'btnEsqueciSenha' and method 'btnEsqueciSenha'");
      var1.btnEsqueciSenha = (TextView)Utils.castView(var5, 2131296315, "field 'btnEsqueciSenha'", TextView.class);
      this.view2131296315 = var5;
      var5.setOnClickListener(new 4(this, var1));
      var1.mVersion = (TextView)Utils.findRequiredViewAsType(var2, 2131296940, "field 'mVersion'", TextView.class);
   }

   public void unbind() {
      LoginActivity var1 = (LoginActivity)this.target;
      super.unbind();
      var1.progressLogin = null;
      var1.mImgLogoBRQ = null;
      var1.editEmail = null;
      var1.editSenha = null;
      var1.btnEntrar = null;
      var1.btnEsqueciSenha = null;
      var1.mVersion = null;
      this.view2131296601.setOnClickListener((OnClickListener)null);
      this.view2131296601.setOnLongClickListener((OnLongClickListener)null);
      this.view2131296601 = null;
      this.view2131296314.setOnClickListener((OnClickListener)null);
      this.view2131296314 = null;
      this.view2131296315.setOnClickListener((OnClickListener)null);
      this.view2131296315 = null;
   }
}
