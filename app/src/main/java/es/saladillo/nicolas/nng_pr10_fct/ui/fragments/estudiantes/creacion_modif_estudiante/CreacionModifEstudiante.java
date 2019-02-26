package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes.creacion_modif_estudiante;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.saladillo.nicolas.nng_pr10_fct.R;

public class CreacionModifEstudiante extends Fragment {

    private CreacionModifEstudianteViewModel mViewModel;

    public static CreacionModifEstudiante newInstance() {
        return new CreacionModifEstudiante();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.creacion_modif_estudiante_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CreacionModifEstudianteViewModel.class);
        // TODO: Use the ViewModel
    }

}
