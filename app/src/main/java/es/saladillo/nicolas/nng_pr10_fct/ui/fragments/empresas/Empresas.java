package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.empresas;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.saladillo.nicolas.nng_pr10_fct.R;

public class Empresas extends Fragment {

    private EmpresasViewModel mViewModel;

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
        // TODO: Use the ViewModel
    }

}
