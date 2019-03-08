package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes.creacion_modif_estudiante;

import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import es.saladillo.nicolas.nng_pr10_fct.R;
import es.saladillo.nicolas.nng_pr10_fct.data.RepositorioImpl;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;
import es.saladillo.nicolas.nng_pr10_fct.ui.activity.MainActivityViewModel;
import es.saladillo.nicolas.nng_pr10_fct.utils.Utilidades;

public class CreacionModifEstudiante extends Fragment {

    private CreacionModifEstudianteViewModel vm;
    private MainActivityViewModel vmMain;
    private RepositorioImpl repositorio;
    private TextView txtNombreEstudiante,txtTelefonoEstudiante,txtCicloFormativoEstudiante,txtEmailEstudiante,txtEmpresaAsignadaEstudiante,txtTutorEstudiante,txtTelefonoTutorEstudiante,txtHoraInicialEstudiante,txtHoraFinEstudiante;
    private NavController navController;
    private TextInputLayout tilEmpresaAsignadaEstudiante;
    String nombreEmpresaSeleccionada;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.creacion_modif_estudiante_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        vm = ViewModelProviders.of(this, new CreacionModifEstudianteViewModelFactory(Utilidades.obtenerRepositorioBD(getContext()))).get(CreacionModifEstudianteViewModel.class);
        vmMain = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);

        vm.setEstudianteId(getArguments().getLong("idEstudiante"));

        if (vm.getEstudianteId() > 0) {
            vm.obtenerEstudianteSeleccionado();
        }

        setupViews();


    }

    @Override
    public void onResume() {
        if(vmMain.isSeHaAsignadoEmpresa()){
            if(vmMain.getEmpresaAsignadaSeleccionada() != null){
                nombreEmpresaSeleccionada = vmMain.getEmpresaAsignadaSeleccionada().getNombre();

                txtEmpresaAsignadaEstudiante.setText(nombreEmpresaSeleccionada);
            }
        }
        super.onResume();
    }

    private void setupViews() {
        Button btnCrearOEditar;

        txtNombreEstudiante = ViewCompat.requireViewById(getView(), R.id.txtNombreEstudiante);
        txtTelefonoEstudiante = ViewCompat.requireViewById(getView(), R.id.txtTelefonoEstudiante);
        txtCicloFormativoEstudiante = ViewCompat.requireViewById(getView(), R.id.txtCicloFormativoEstudiante);
        txtEmailEstudiante = ViewCompat.requireViewById(getView(), R.id.txtEmailEstudiante);
        txtEmpresaAsignadaEstudiante = ViewCompat.requireViewById(getView(), R.id.txtEmpresaAsignadaEstudiante);
        tilEmpresaAsignadaEstudiante = ViewCompat.requireViewById(getView(),R.id.tilEmpresaAsignadaEstudiante);
        txtTutorEstudiante = ViewCompat.requireViewById(getView(), R.id.txtTutorEstudiante);
        txtTelefonoTutorEstudiante = ViewCompat.requireViewById(getView(), R.id.txtTelefonoTutorEstudiante);
        txtHoraInicialEstudiante = ViewCompat.requireViewById(getView(), R.id.txtHoraInicialEstudiante);
        txtHoraFinEstudiante = ViewCompat.requireViewById(getView(), R.id.txtHoraFinEstudiante);
        btnCrearOEditar = ViewCompat.requireViewById(getView(), R.id.btnCrearOEditarEstudiante);

        navController = Navigation.findNavController(getView());

        if (vm.getEstudianteId() == 0) {
            btnCrearOEditar.setText(getString(R.string.btnCrearEstudianteText));
            btnCrearOEditar.setOnClickListener(v -> {
                vm.insertarEstudiante(obtenerDatosIntroducidos());
                terminarCreacion_o_Actualizacion();
            });
        } else {
            btnCrearOEditar.setText(getString(R.string.btnActualizarEstudianteText));
            btnCrearOEditar.setOnClickListener(v -> {
                vm.actualizarEstudiante(obtenerDatosIntroducidos());
                terminarCreacion_o_Actualizacion();
            });
        }

        tilEmpresaAsignadaEstudiante.setOnClickListener(v -> navController.navigate(R.id.actionCreacionModifEstudianteToSeleccionEmpresa));
        txtEmpresaAsignadaEstudiante.setOnClickListener(v -> navController.navigate(R.id.actionCreacionModifEstudianteToSeleccionEmpresa));

        vm.getEstudianteSeleccionado().observe(Objects.requireNonNull(getActivity()), this::mostrarDatosEstudiante);
    }

    private void terminarCreacion_o_Actualizacion() {
        vmMain.setSeHaAsignadoEmpresa(false);
        navController.navigateUp();
    }

    private Estudiante obtenerDatosIntroducidos() {
        String nombreEstudiante, telefono, cicloFormativo, email, empresa_asignada, tutor,telefonoTutor,horaInicio,horaFin,horario;

        nombreEstudiante = txtNombreEstudiante.getText().toString();
        telefono = txtTelefonoEstudiante.getText().toString();
        cicloFormativo = txtCicloFormativoEstudiante.getText().toString();
        email = txtEmailEstudiante.getText().toString();
        empresa_asignada = txtEmpresaAsignadaEstudiante.getText().toString();
        tutor = txtTutorEstudiante.getText().toString();
        telefonoTutor = txtTelefonoTutorEstudiante.getText().toString();
        horaInicio = txtHoraInicialEstudiante.getText().toString();
        horaFin = txtHoraFinEstudiante.getText().toString();
        horario = String.format("%s|%s",horaInicio,horaFin);

        return new Estudiante(vm.getEstudianteId(),vmMain.getEmpresaAsignadaSeleccionada().getId(), nombreEstudiante, telefono, email, cicloFormativo, empresa_asignada, tutor, telefonoTutor,horario);
    }

    private void mostrarDatosEstudiante(Estudiante estudiante) {
        String[] horario = estudiante.getHorario().split("|");
        txtNombreEstudiante.setText(estudiante.getNombre());
        txtTelefonoEstudiante.setText(estudiante.getTelefono());
        txtCicloFormativoEstudiante.setText(estudiante.getCiclo_formativo());
        txtEmailEstudiante.setText(estudiante.getEmail());
        txtEmpresaAsignadaEstudiante.setText(estudiante.getEmpresa_asignada());
        txtTutorEstudiante.setText(estudiante.getTutor());
        txtTelefonoTutorEstudiante.setText(estudiante.getTelefono_tutor());
        txtHoraInicialEstudiante.setText(horario[0]);
        txtHoraFinEstudiante.setText(horario[1]);
    }

}
