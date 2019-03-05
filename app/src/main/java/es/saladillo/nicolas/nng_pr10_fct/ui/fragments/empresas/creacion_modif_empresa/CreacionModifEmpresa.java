package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.empresas.creacion_modif_empresa;

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
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

import es.saladillo.nicolas.nng_pr10_fct.R;
import es.saladillo.nicolas.nng_pr10_fct.data.RepositorioImpl;
import es.saladillo.nicolas.nng_pr10_fct.data.local.AppDatabase;
import es.saladillo.nicolas.nng_pr10_fct.data.local.EmpresaDao;
import es.saladillo.nicolas.nng_pr10_fct.data.local.EstudianteDao;
import es.saladillo.nicolas.nng_pr10_fct.data.local.VisitaDao;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;
import es.saladillo.nicolas.nng_pr10_fct.ui.fragments.empresas.EmpresasViewModel;
import es.saladillo.nicolas.nng_pr10_fct.ui.fragments.empresas.EmpresasViewModelFactory;

public class CreacionModifEmpresa extends Fragment {

    private CreacionModifEmpresaViewModel vm;
    private RepositorioImpl repositorio;
    private EditText txtNombreEmpresa,txtDireccionEmpresa,txtTelefonoEmpresa,txtCifEmpresa,txtEmailEmpresa,txtPersonaContactoEmpresa;
    private Button btnCrearOEditar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.creacion_modif_empresa_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EstudianteDao estudianteDao = AppDatabase.getInstance(requireContext()).estudianteDao();
        VisitaDao visitaDao = AppDatabase.getInstance(requireContext()).visitaDao();
        EmpresaDao empresaDao = AppDatabase.getInstance(requireContext()).empresaDao();
        repositorio = new RepositorioImpl(estudianteDao, visitaDao, empresaDao);
        vm = ViewModelProviders.of(this, new CreacionModifEmpresaViewModelFactory(repositorio)).get(CreacionModifEmpresaViewModel.class);
        vm.setEmpresaId(getArguments().getLong("idEmpresa"));
        if(vm.getEmpresaId() > 0){
            vm.obtenerEmpresaSeleccionada();
        }

        setupViews();
    }

    private void setupViews() {
        txtNombreEmpresa = ViewCompat.requireViewById(getView(),R.id.txtNombreEmpresa);
        txtDireccionEmpresa = ViewCompat.requireViewById(getView(),R.id.txtDireccionEmpresa);
        txtTelefonoEmpresa = ViewCompat.requireViewById(getView(),R.id.txtTelefonoEmpresa);
        txtCifEmpresa = ViewCompat.requireViewById(getView(),R.id.txtCifEmpresa);
        txtEmailEmpresa = ViewCompat.requireViewById(getView(),R.id.txtEmailEmpresa);
        txtPersonaContactoEmpresa = ViewCompat.requireViewById(getView(),R.id.txtPersonaContactoEmpresa);
        btnCrearOEditar = ViewCompat.requireViewById(getView(),R.id.btnCrearOEditar);

        if(vm.getEmpresaId() == 0){
            btnCrearOEditar.setText("Crear empresa");
            btnCrearOEditar.setOnClickListener(v -> vm.insertarEmpresa(obtenerDatosIntroducidos()));
        }else{
            btnCrearOEditar.setText("Actualizar empresa");
            btnCrearOEditar.setOnClickListener(v -> vm.actualizarEmpresa(obtenerDatosIntroducidos()));
        }

        vm.getEmpresaSeleccionada().observe(Objects.requireNonNull(getActivity()), this::mostrarDatosEmpresa);
    }

    private Empresa obtenerDatosIntroducidos() {
        String nombreEmpresa,cif,direccionSede,telefono,email,nombreContacto;
        long id;

        nombreEmpresa = txtNombreEmpresa.getText().toString();
        cif = txtCifEmpresa.getText().toString();
        direccionSede = txtDireccionEmpresa.getText().toString();
        telefono = txtTelefonoEmpresa.getText().toString();
        email = txtEmailEmpresa.getText().toString();
        nombreContacto = txtPersonaContactoEmpresa.getText().toString();

        return new Empresa(vm.getEmpresaId(),nombreEmpresa,cif,direccionSede,telefono,email,"",nombreContacto);
    }

    private void mostrarDatosEmpresa(Empresa empresa) {
        txtNombreEmpresa.setText(empresa.getNombre());
        txtDireccionEmpresa.setText(empresa.getDireccion_sede());
        txtTelefonoEmpresa.setText(empresa.getTelefono());
        txtCifEmpresa.setText(empresa.getCif());
        txtEmailEmpresa.setText(empresa.getEmail());
        txtPersonaContactoEmpresa.setText(empresa.getNombre_contacto());
    }


}
