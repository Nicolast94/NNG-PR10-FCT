package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes.creacion_modif_estudiante.seleccionEmpresaEstudiante;

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
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;
import es.saladillo.nicolas.nng_pr10_fct.ui.activity.MainActivityViewModel;
import es.saladillo.nicolas.nng_pr10_fct.utils.Utilidades;

public class SeleccionEmpresaEstudiante extends Fragment {

    private SeleccionEmpresaEstudianteViewModel vm;
    private RecyclerView lstEmpresasParaSeleccionar;
    private SeleccionEmpresaEstudianteAdapter estudiantesAdapter;
    private TextView lblSinEmpresasParaSeleccionar;
    private MainActivityViewModel vmMain;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.seleccion_empresa_estudiante_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = ViewModelProviders.of(this, new SeleccionEmpresaEstudianteViewModelFactory(Utilidades.obtenerRepositorioBD(getContext()))).get(SeleccionEmpresaEstudianteViewModel.class);
        vmMain = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);
        setupViews();
        vm.getEmpresasAseleccionar().observe(this, this::actualizarListaEmpresas);
    }

    private void setupViews() {
        lstEmpresasParaSeleccionar = ViewCompat.requireViewById(Objects.requireNonNull(getView()), R.id.lstSeleccionEmpresa);
        lblSinEmpresasParaSeleccionar = ViewCompat.requireViewById(getView(), R.id.lblSinEmpresasParaSeleccionar);

        setupRecyclerView();

    }

    private void setupRecyclerView() {
        estudiantesAdapter = new SeleccionEmpresaEstudianteAdapter(vmMain);

        lstEmpresasParaSeleccionar.setHasFixedSize(true);
        lstEmpresasParaSeleccionar.setLayoutManager(new GridLayoutManager(requireContext(), 1));
        lstEmpresasParaSeleccionar.setItemAnimator(new DefaultItemAnimator());
        lstEmpresasParaSeleccionar.setAdapter(estudiantesAdapter);
    }

    private void actualizarListaEmpresas(List<Empresa> empresas) {
        estudiantesAdapter.submitList(empresas);
        if (empresas.size() == 0) {
            lblSinEmpresasParaSeleccionar.setVisibility(View.VISIBLE);
        } else {
            lblSinEmpresasParaSeleccionar.setVisibility(View.INVISIBLE);
        }

    }
}
