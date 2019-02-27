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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.saladillo.nicolas.nng_pr10_fct.R;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;

public class Empresas extends Fragment {

    private EmpresasViewModel mViewModel;
    private EmpresasAdapter empresasAdapter;
    RecyclerView listaEmpresas;

    public static Empresas newInstance() {
        return new Empresas();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.empresas_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EmpresasViewModel.class);
        setupViews();
    }

    private void setupViews() {
        FloatingActionButton fab = ActivityCompat.requireViewById(requireActivity(), R.id.fabCrearEmpresa);
        listaEmpresas = ActivityCompat.requireViewById(requireActivity(),R.id.lstEmpresas);

        fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.actionEmpresasToCreacionModifEmpresa));

        setupRecyclerView();
        List<Empresa> empresas = new ArrayList<>();
        empresas.add(new Empresa(1,"Yen Sid","77202334M","Pepe landia","987586868","@melapela.com","asdasd","Pepe"));
        empresas.add(new Empresa(2,"Electronic Shit","45702334M","Greed Land","987586868","@melapela.com","asdasd","Satanas"));
        empresasAdapter.submitList(empresas);
    }

    private void setupRecyclerView() {
        empresasAdapter = new EmpresasAdapter();

        listaEmpresas.setHasFixedSize(true);
        listaEmpresas.setLayoutManager(new GridLayoutManager(requireContext(),1));
        listaEmpresas.setItemAnimator(new DefaultItemAnimator());
        listaEmpresas.setAdapter(empresasAdapter);
    }

}
