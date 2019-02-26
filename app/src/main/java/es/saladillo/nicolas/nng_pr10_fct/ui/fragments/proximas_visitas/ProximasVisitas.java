package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.proximas_visitas;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.saladillo.nicolas.nng_pr10_fct.R;

public class ProximasVisitas extends Fragment {

    private ProximasVisitasViewModel mViewModel;

    public static ProximasVisitas newInstance() {
        return new ProximasVisitas();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.proximas_visitas_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ProximasVisitasViewModel.class);
        // TODO: Use the ViewModel
    }

}
