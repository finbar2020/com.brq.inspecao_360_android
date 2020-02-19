package com.brq.inspecao_360_android.ui.activity;

import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.mapbox.mapboxsdk.maps.MapView;

public class ItemInspecaoCroquiActivity_ViewBinding extends BaseActivity_ViewBinding {
   @UiThread
   public ItemInspecaoCroquiActivity_ViewBinding(ItemInspecaoCroquiActivity var1, View var2) {
      super(var1, var2);
      var1.txtDescStatus = (TextView)Utils.findRequiredViewAsType(var2, 2131296880, "field 'txtDescStatus'", TextView.class);
      var1.mViewError = var2.findViewById(2131296945);
      var1.txtErro = (TextView)Utils.findOptionalViewAsType(var2, 2131296895, "field 'txtErro'", TextView.class);
      var1.mapView = (MapView)Utils.findRequiredViewAsType(var2, 2131296607, "field 'mapView'", MapView.class);
      var1.progressBar = (ProgressBar)Utils.findRequiredViewAsType(var2, 2131296680, "field 'progressBar'", ProgressBar.class);
      var1.fabReverter = (FloatingActionButton)Utils.findRequiredViewAsType(var2, 2131296456, "field 'fabReverter'", FloatingActionButton.class);
      var1.fabDone = (FloatingActionButton)Utils.findRequiredViewAsType(var2, 2131296452, "field 'fabDone'", FloatingActionButton.class);
      var1.fabCreatePolygon = (FloatingActionButton)Utils.findRequiredViewAsType(var2, 2131296450, "field 'fabCreatePolygon'", FloatingActionButton.class);
      var1.fabDiscard = (FloatingActionButton)Utils.findRequiredViewAsType(var2, 2131296451, "field 'fabDiscard'", FloatingActionButton.class);
      var1.fabEditLabel = (FloatingActionButton)Utils.findRequiredViewAsType(var2, 2131296453, "field 'fabEditLabel'", FloatingActionButton.class);
   }

   public void unbind() {
      ItemInspecaoCroquiActivity var1 = (ItemInspecaoCroquiActivity)this.target;
      super.unbind();
      var1.txtDescStatus = null;
      var1.mViewError = null;
      var1.txtErro = null;
      var1.mapView = null;
      var1.progressBar = null;
      var1.fabReverter = null;
      var1.fabDone = null;
      var1.fabCreatePolygon = null;
      var1.fabDiscard = null;
      var1.fabEditLabel = null;
   }
}
