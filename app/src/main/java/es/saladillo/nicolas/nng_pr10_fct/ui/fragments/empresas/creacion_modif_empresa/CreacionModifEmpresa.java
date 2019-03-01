package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.empresas.creacion_modif_empresa;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.saladillo.nicolas.nng_pr10_fct.R;

public class CreacionModifEmpresa extends Fragment {

    private CreacionModifEmpresaViewModel vm;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.creacion_modif_empresa_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = ViewModelProviders.of(this).get(CreacionModifEmpresaViewModel.class);
    }

}
