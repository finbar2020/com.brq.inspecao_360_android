package com.brq.inspecao_360_android.ui.fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.brq.inspecao_360_android.common.util.NetworkEvaluator;
import com.brq.inspecao_360_android.common.util.Validator;
import com.brq.inspecao_360_android.configuration.di.App;
import com.brq.inspecao_360_android.configuration.di.module.AgendarDialogModule;
import com.brq.inspecao_360_android.model.entity.Horario;
import com.brq.inspecao_360_android.presentantion.presenter.AgendarDialogFragmentPresenter;
import com.brq.inspecao_360_android.presentantion.view.adapter.HorarioArrayAdapter;
import com.brq.inspecao_360_android.ui.activity.ItemInspecaoAgendarActivity;
import com.brq.inspecao_360_android.ui.fragment.-..Lambda.AgendarDialogFragment.-xQaiuY5Qlb5So2Gq9unEoOTDpo;
import com.brq.inspecao_360_android.ui.fragment.-..Lambda.AgendarDialogFragment.Uog0mPQhIH0u7v-ebAB4WE-ssQs;
import com.brq.inspecao_360_android.ui.fragment.-..Lambda.AgendarDialogFragment.jOYV9CEqWhSC1_K2Ss0en8rsbH0;
import com.brq.inspecao_360_android.ui.fragment.-..Lambda.AgendarDialogFragment.xAXAq0KvoCdnMAt-5h97E6zNG3c;
import com.brq.inspecao_360_android.ui.fragment.AgendarDialogFragment.1;
import com.brq.inspecao_360_android.ui.fragment.AgendarDialogFragment.2;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class AgendarDialogFragment extends DialogFragment implements com.brq.inspecao_360_android.presentantion.view.AgendarDialogView.DialogFragment {
   private static final int DATE_DIALOG_ID;
   public Activity activity;
   private Builder dateBuilder;
   @BindView(2131296403)
   EditText editDataAgendamento;
   @BindView(2131296415)
   EditText editObsAgendamento;
   private HorarioArrayAdapter horarioAdapter;
   private Date mDataLimite;
   private OnDateSetListener mDateSetListener = new 2(this);
   private DialogInterface mDialog;
   private AlertDialog mDialogAgendar;
   private final OnClickListener mEditTextHorarioAgendamentoListener = new xAXAq0KvoCdnMAt-5h97E6zNG3c(this);
   private Long mIdChecklist;
   private Long mIdHorarioAgendamento = 0L;
   private Long mIdInspecao;
   private Long mIdItem;
   private Long mIdSeguradora;
   private boolean mIsGroupAction = false;
   private final OnItemSelectedListener mOnItemSelectedListener = new 1(this);
   @Nullable
   @BindView(2131296706)
   View mRootView;
   private String mUID;
   @Inject
   AgendarDialogFragmentPresenter presenter;
   @Nullable
   @BindView(2131296679)
   ProgressBar progress;
   @BindView(2131296737)
   Spinner spinner;

   // $FF: synthetic method
   static Long access$002(AgendarDialogFragment var0, Long var1) {
      var0.mIdHorarioAgendamento = var1;
      return var1;
   }

   public static AgendarDialogFragment newInstance(Long var0, Long var1, String var2, Long var3, Long var4, boolean var5, Date var6) {
      AgendarDialogFragment var7 = new AgendarDialogFragment();
      Bundle var8 = new Bundle();
      var8.putSerializable(App.getContext().getString(2131820730), var0);
      var8.putSerializable(App.getContext().getString(2131820731), var1);
      var8.putSerializable(App.getContext().getString(2131821316), var2);
      var8.putSerializable(App.getContext().getString(2131820728), var3);
      var8.putSerializable(App.getContext().getString(2131820736), var4);
      var8.putSerializable(App.getContext().getString(2131820747), var5);
      var8.putSerializable(App.getContext().getString(2131820655), var6);
      var7.setArguments(var8);
      return var7;
   }

   private boolean validar() {
      if (this.mIdHorarioAgendamento == 0L) {
         String var3 = this.getString(2131821116);
         Object[] var4 = new Object[]{this.getString(2131820842)};
         this.showSnackbar(String.format(var3, var4));
         return false;
      } else if (Validator.isNullOrEmpty(this.editDataAgendamento.getText().toString())) {
         String var1 = this.getString(2131821116);
         Object[] var2 = new Object[]{this.getString(2131820805)};
         this.showSnackbar(String.format(var1, var2));
         return false;
      } else {
         return true;
      }
   }

   public void addHorarios(List var1) {
      if (!Validator.isNullOrEmpty(var1)) {
         this.horarioAdapter.add(new Horario(0L, this.getString(2131821253)));
         this.horarioAdapter.addAll(var1);
      }

      if (this.mIdHorarioAgendamento != 0L) {
         int var2 = this.horarioAdapter.getItemPosition(new Horario(this.mIdHorarioAgendamento, ""));
         this.spinner.setSelection(var2);
      }

   }

   public void agendar() {
      if (!NetworkEvaluator.isConnected()) {
         this.mDialog.dismiss();
         this.showSnackbar(this.getString(2131821092));
      } else {
         if (this.validar()) {
            String var1 = this.editObsAgendamento.getText().toString();
            String var2 = this.editDataAgendamento.getText().toString();
            if (this.mIsGroupAction) {
               this.presenter.agendar(this.mIdInspecao, var2, this.mIdHorarioAgendamento, var1);
               return;
            }

            this.presenter.agendar(this.mIdInspecao, this.mIdItem, var2, this.mIdHorarioAgendamento, var1);
         }

      }
   }

   public void carregar() {
      if (this.mIsGroupAction) {
         this.presenter.carregar(this.mIdInspecao, this.mIdSeguradora);
      } else {
         this.presenter.carregar(this.mIdInspecao, this.mIdItem, this.mUID, this.mIdSeguradora);
      }
   }

   protected void createDialog() {
      Calendar var1 = Calendar.getInstance();
      int var2 = var1.get(1);
      int var3 = var1.get(2);
      int var4 = var1.get(5);
      DatePickerDialog var5 = new DatePickerDialog(this.getContext(), this.mDateSetListener, var2, var3, var4);
      var5.show();
   }

   public void hideKeyboard() {
      if (this.mRootView != null && !Validator.isNullOrEmpty(this.getActivity())) {
         InputMethodManager var1 = (InputMethodManager)this.getActivity().getSystemService("input_method");
         if (var1 != null) {
            var1.hideSoftInputFromWindow(this.mRootView.getWindowToken(), 0);
         }
      }

   }

   // $FF: synthetic method
   public void lambda$new$0$AgendarDialogFragment(View var1) {
      this.createDialog();
   }

   // $FF: synthetic method
   public void lambda$null$1$AgendarDialogFragment(View var1) {
      this.agendar();
   }

   // $FF: synthetic method
   public void lambda$null$2$AgendarDialogFragment(View var1) {
      this.mDialogAgendar.dismiss();
   }

   // $FF: synthetic method
   public void lambda$onCreateDialog$3$AgendarDialogFragment(DialogInterface var1) {
      this.mDialogAgendar.getButton(-1).setOnClickListener(new jOYV9CEqWhSC1_K2Ss0en8rsbH0(this));
      this.mDialogAgendar.getButton(-2).setOnClickListener(new Uog0mPQhIH0u7v-ebAB4WE-ssQs(this));
   }

   public void onAttach(Activity var1) {
      super.onAttach(var1);
      this.activity = var1;
   }

   public void onCreate(@Nullable Bundle var1) {
      super.onCreate(var1);
      if (this.getArguments() != null) {
         this.mIdInspecao = this.getArguments().getLong(this.getString(2131820730));
         this.mIdItem = this.getArguments().getLong(this.getString(2131820731));
         this.mUID = this.getArguments().getString(this.getString(2131821316));
         this.mIdChecklist = this.getArguments().getLong(this.getString(2131820728), 0L);
         this.mIdSeguradora = this.getArguments().getLong(this.getString(2131820736));
         this.mIsGroupAction = this.getArguments().getBoolean(this.getString(2131820747));
         this.mDataLimite = (Date)this.getArguments().getSerializable(this.getString(2131820655));
      }

   }

   public Dialog onCreateDialog(Bundle var1) {
      View var2 = this.getActivity().getLayoutInflater().inflate(2131492990, (ViewGroup)null);
      ButterKnife.bind(this, var2);
      App.get(this.getContext()).getAppComponent().plus(new AgendarDialogModule(this)).inject(this);
      this.horarioAdapter = new HorarioArrayAdapter(this.getContext());
      this.spinner.setAdapter(this.horarioAdapter);
      this.spinner.setOnItemSelectedListener(this.mOnItemSelectedListener);
      this.editDataAgendamento.setOnClickListener(this.mEditTextHorarioAgendamentoListener);
      Builder var4 = new Builder(this.getActivity());
      var4.setTitle(this.getString(2131820593));
      var4.setView(var2);
      var4.setPositiveButton(this.getString(2131820763), (android.content.DialogInterface.OnClickListener)null);
      var4.setNegativeButton(this.getString(2131820782), (android.content.DialogInterface.OnClickListener)null);
      this.carregar();
      this.mDialogAgendar = var4.create();
      this.mDialogAgendar.setOnShowListener(new -xQaiuY5Qlb5So2Gq9unEoOTDpo(this));
      this.mDialogAgendar.setCanceledOnTouchOutside(false);
      AlertDialog var9 = this.mDialogAgendar;
      this.mDialog = var9;
      return var9;
   }

   public void onError() {
   }

   public void onSuccess() {
   }

   public void sair() {
      if (!this.mIsGroupAction) {
         ((ItemInspecaoAgendarActivity)this.activity).carregar();
      }

      this.mDialog.dismiss();
   }

   public void showProgress(boolean var1) {
      ProgressBar var2 = this.progress;
      if (var2 != null) {
         if (var1) {
            this.mRootView.setVisibility(8);
            this.progress.setVisibility(0);
            if (!Validator.isNullOrEmpty(this.mDialogAgendar)) {
               this.mDialogAgendar.getButton(-1).setEnabled(false);
               return;
            }
         } else {
            var2.setVisibility(8);
            this.mRootView.setVisibility(0);
            if (!Validator.isNullOrEmpty(this.mDialogAgendar)) {
               this.mDialogAgendar.getButton(-1).setEnabled(true);
            }
         }

      }
   }

   public void showSnackbar(@NonNull String var1) {
      Activity var2 = this.activity;
      if (var2 != null) {
         Snackbar.make(var2.findViewById(2131296706), var1, 0).show();
      }
   }

   public void showSnackbar(String var1, String var2, OnClickListener var3) {
      Activity var4 = this.activity;
      if (var4 != null) {
         Snackbar.make(var4.findViewById(2131296706), var1, -2).setAction(var2, var3).show();
      }
   }

   public void showToastLongTime(String var1) {
      Toast.makeText(App.getContext(), var1, 1).show();
   }
}
