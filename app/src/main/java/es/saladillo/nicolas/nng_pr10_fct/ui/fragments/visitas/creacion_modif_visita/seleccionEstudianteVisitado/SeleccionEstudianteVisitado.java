package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.visitas.creacion_modif_visita.seleccionEstudianteVisitado;

import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.saladillo.nicolas.nng_pr10_fct.R;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;
import es.saladillo.nicolas.nng_pr10_fct.ui.activity.MainActivityViewModel;
import es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes.creacion_modif_estudiante.seleccionEmpresaEstudiante.SeleccionEmpresaEstudianteAdapter;
import es.saladillo.nicolas.nng_pr10_fct.utils.Utilidades;

public class SeleccionEstudianteVisitado extends Fragment {

    private SeleccionEstudianteVisitadoViewModel vm;
    private RecyclerView lstEmpresasParaSeleccionar;
    private SeleccionEstudianteVisitadoAdapter estudiantesAdapter;
    private TextView lblSinEstudiantesParaSeleccionar;
    private MainActivityViewModel vmMain;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.seleccion_estudiante_visitado_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = ViewModelProviders.of(this, new SeleccionEstudianteVisitadoViewModelFactory(Utilidades.obtenerRepositorioBD(getContext()))).get(SeleccionEstudianteVisitadoViewModel.class);
        vmMain = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        setupViews();
        vm.getEstudianteAseleccionar().observe(this, this::actualizarListaEmpresas);
    }

    private void setupViews() {
        lstEmpresasParaSeleccionar = ViewCompat.requireViewById(Objects.requireNonNull(getView()), R.id.lstSeleccionEstudianteVisitado);
        lblSinEstudiantesParaSeleccionar = ViewCompat.requireViewById(getView(), R.id.lblSinEstudiantesParaSeleccionar);

        setupRecyclerView();

    }

    private void setupRecyclerView() {
        estudiantesAdapter = new SeleccionEstudianteVisitadoAdapter(vmMain);

        lstEmpresasParaSeleccionar.setHasFixedSize(true);
        lstEmpresasParaSeleccionar.setLayoutManager(new GridLayoutManager(requireContext(), 1));
        lstEmpresasParaSeleccionar.setItemAnimator(new DefaultItemAnimator());
        lstEmpresasParaSeleccionar.setAdapter(estudiantesAdapter);
    }

    private void actualizarListaEmpresas(List<Estudiante> estudiantes) {
        estudiantesAdapter.submitList(estudiantes);
        if (estudiantes.size() == 0) {
            lblSinEstudiantesParaSeleccionar.setVisibility(View.VISIBLE);
        } else {
            lblSinEstudiantesParaSeleccionar.setVisibility(View.INVISIBLE);
        }

    }

}
