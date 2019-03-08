package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.visitas.creacion_modif_visita;

import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import es.saladillo.nicolas.nng_pr10_fct.R;
import es.saladillo.nicolas.nng_pr10_fct.data.RepositorioImpl;
import es.saladillo.nicolas.nng_pr10_fct.data.base.DatePickerDialogFragment;
import es.saladillo.nicolas.nng_pr10_fct.data.base.TimePickerDialogFragment;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Visita;
import es.saladillo.nicolas.nng_pr10_fct.ui.activity.MainActivityViewModel;
import es.saladillo.nicolas.nng_pr10_fct.utils.Utilidades;

public class CreacionModifVisita extends Fragment implements DatePickerDialog.OnDateSetListener{

    private CreacionModifVisitaViewModel vm;
    private MainActivityViewModel vmMain;
    private RepositorioImpl repositorio;
    private NavController navController;
    private TextInputLayout tilEstudianteVisitado;
    private EditText txtEstudianteVisitado,txtFecha,txtHoraInicio,txtHoraFin,txtObservaciones;
    String nombreEstudianteSeleccionado;
    private static final String TAG_DIALOG_FRAGMENT = "TAG_DIALOG_FRAGMENT",TAG_TP_DIALOG_FRAGMENT = "TAG_TP_DIALOG_FRAGMENT";
    private static final int RC_DIALOG_FRAGMENT = 1,TP_DIALOG_FRAGMENT = 2;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.creacion_modif_visita_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        vm = ViewModelProviders.of(this, new CreacionModifVisitaViewModelFactory(Utilidades.obtenerRepositorioBD(getContext()))).get(CreacionModifVisitaViewModel.class);
        vmMain = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);

        vm.setVisitaId(getArguments().getLong("idVisita"));

        if (vm.getVisitaId() > 0) {
            vm.obtenerVisitaSeleccionada();
        }

        setupViews();


    }

    @Override
    public void onResume() {
        if(vmMain.isSeHaSeleccionadoEstudianteVisitado()){
            if(vmMain.getEstudianteVisitadoSeleccionado() != null){
                nombreEstudianteSeleccionado = vmMain.getEstudianteVisitadoSeleccionado().getNombre();

                txtEstudianteVisitado.setText(nombreEstudianteSeleccionado);
            }
        }
        super.onResume();
    }

    private void setupViews() {
        Button btnCrearOEditar;

        txtEstudianteVisitado = ViewCompat.requireViewById(getView(), R.id.txtEstudianteVisitado);
        tilEstudianteVisitado = ViewCompat.requireViewById(getView(),R.id.tilEstudianteVisitado);
        txtFecha = ViewCompat.requireViewById(getView(), R.id.txtFecha);
        txtHoraInicio = ViewCompat.requireViewById(getView(), R.id.txtHoraInicio);
        txtHoraFin = ViewCompat.requireViewById(getView(), R.id.txtHoraFin);
        txtObservaciones = ViewCompat.requireViewById(getView(), R.id.txtObservaciones);

        btnCrearOEditar = ViewCompat.requireViewById(getView(), R.id.btnCrearOEditarVisita);

        navController = Navigation.findNavController(getView());

        if (vm.getVisitaId() == 0) {
            btnCrearOEditar.setText(getString(R.string.btnCrearVisita_text));
            btnCrearOEditar.setOnClickListener(v -> {
                if(comprobarDatos()){
                    vm.insertarVisita(obtenerDatosIntroducidos());
                    terminarCreacion_o_Actualizacion();
                }
            });
        } else {
            btnCrearOEditar.setText(getString(R.string.btnActualizarVisita_text));
            btnCrearOEditar.setOnClickListener(v -> {
                if(comprobarDatos()){
                    vm.insertarVisita(obtenerDatosIntroducidos());
                    terminarCreacion_o_Actualizacion();
                }
            });
        }

        tilEstudianteVisitado.setOnClickListener(v -> navController.navigate(R.id.action_creacionModifVisita_to_seleccionEstudianteVisitado));
        txtEstudianteVisitado.setOnClickListener(v -> navController.navigate(R.id.action_creacionModifVisita_to_seleccionEstudianteVisitado));
        txtFecha.setOnClickListener(v -> showDatePickerDialog());
        txtHoraInicio.setOnClickListener(v -> {
            showTimePickerDialog(txtHoraInicio);
        });
        txtHoraFin.setOnClickListener(v -> {
            showTimePickerDialog(txtHoraFin);
        });

        vm.getVisitaSeleccionada().observe(Objects.requireNonNull(getActivity()), this::mostrarDatosVisita);

    }

    private boolean comprobarDatos() {
        return !txtEstudianteVisitado.getText().toString().isEmpty() &&
                !txtFecha.getText().toString().isEmpty() &&
                !txtHoraInicio.getText().toString().isEmpty() &&
                !txtObservaciones.getText().toString().isEmpty();
    }

    private void terminarCreacion_o_Actualizacion() {
        vmMain.setSeHaSeleccionadoEstudianteVisitado(false);
        navController.navigateUp();
    }

    private Visita obtenerDatosIntroducidos() {
        String fecha, horaInicio, horaFin, observaciones;
        SimpleDateFormat sdf;
        Date date;
        long startDate = 0l;

        //La conversion de date a long falla, guarda los datos incorrectos

        try {
            fecha = txtFecha.getText().toString();
            sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);
            date = sdf.parse(fecha);

            startDate = date.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
        }

        horaInicio = txtHoraInicio.getText().toString();
        horaFin = txtHoraFin.getText().toString();
        observaciones = txtObservaciones.getText().toString();

        return new Visita(vm.getVisitaId(),vmMain.getEstudianteVisitadoSeleccionado().getId(),startDate,horaInicio,horaFin,observaciones);
    }

    private void mostrarDatosVisita(Visita visita) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        long dia = visita.getDia();
        Date d = new Date(dia);

        txtFecha.setText(format.format(d));
        txtHoraFin.setText(visita.getHora_fin());
        txtHoraInicio.setText(visita.getHora_inicio());
        txtObservaciones.setText(visita.getObservaciones());

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        txtFecha.setText(String.format("%d/%d/%d",dayOfMonth,month,year));
    }

    private void showDatePickerDialog() {
        DatePickerDialogFragment datePickerDialogFragment = DatePickerDialogFragment.newInstance();

        datePickerDialogFragment.setTargetFragment(this,RC_DIALOG_FRAGMENT);
        datePickerDialogFragment.show(getFragmentManager(),
                TAG_DIALOG_FRAGMENT);


    }


    private void showTimePickerDialog(EditText editText) {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                editText.setText(String.format ("%02d:%02d", selectedHour, selectedMinute));
            }
        }, hour, minute, true);
        mTimePicker.show();
    }
}
