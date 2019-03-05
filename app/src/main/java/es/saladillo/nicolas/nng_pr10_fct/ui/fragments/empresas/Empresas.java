package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.empresas;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import es.saladillo.nicolas.nng_pr10_fct.R;
import es.saladillo.nicolas.nng_pr10_fct.data.RepositorioImpl;
import es.saladillo.nicolas.nng_pr10_fct.data.local.AppDatabase;
import es.saladillo.nicolas.nng_pr10_fct.data.local.EmpresaDao;
import es.saladillo.nicolas.nng_pr10_fct.data.local.EstudianteDao;
import es.saladillo.nicolas.nng_pr10_fct.data.local.VisitaDao;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;

public class Empresas extends Fragment {

    private EmpresasViewModel vm;
    private EmpresasAdapter empresasAdapter;
    private RecyclerView listaEmpresas;
    private RepositorioImpl repositorio;
    private TextView lblSinEmpresas;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.empresas_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EstudianteDao estudianteDao = AppDatabase.getInstance(requireContext()).estudianteDao();
        VisitaDao visitaDao = AppDatabase.getInstance(requireContext()).visitaDao();
        EmpresaDao empresaDao = AppDatabase.getInstance(requireContext()).empresaDao();
        repositorio = new RepositorioImpl(estudianteDao, visitaDao, empresaDao);
        vm = ViewModelProviders.of(this, new EmpresasViewModelFactory(repositorio)).get(EmpresasViewModel.class);
        setupViews();
    }

    private void setupViews() {
        FloatingActionButton fab = ActivityCompat.requireViewById(requireActivity(), R.id.fabCrearEmpresa);
        lblSinEmpresas = ActivityCompat.requireViewById(requireActivity(),R.id.lblSinEmpresas);
        listaEmpresas = ActivityCompat.requireViewById(requireActivity(),R.id.lstEmpresas);

        fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.actionEmpresasToCreacionModifEmpresa));
        setupRecyclerView();
        vm.getTodasLasEmpresas().observe(this, this::actualizarListaEmpresas);

    }

    private void actualizarListaEmpresas(List<Empresa> empresas) {
        empresasAdapter.submitList(empresas);
        if(empresas.size() == 0){
            lblSinEmpresas.setVisibility(View.VISIBLE);
        }else{
            lblSinEmpresas.setVisibility(View.INVISIBLE);
        }

    }


    private void setupRecyclerView() {
        ItemTouchHelper itemTouchHelper;
        empresasAdapter = new EmpresasAdapter();

        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                vm.eliminarEmpresa(empresasAdapter.getItem(viewHolder.getAdapterPosition()));
            }
        });

        listaEmpresas.setHasFixedSize(true);
        listaEmpresas.setLayoutManager(new GridLayoutManager(requireContext(),1));
        listaEmpresas.setItemAnimator(new DefaultItemAnimator());
        listaEmpresas.setAdapter(empresasAdapter);
        itemTouchHelper.attachToRecyclerView(listaEmpresas);
    }


}
