package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes;

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

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import es.saladillo.nicolas.nng_pr10_fct.R;

public class Estudiantes extends Fragment {

    private EstudiantesViewModel mViewModel;

    public static Estudiantes newInstance() {
        return new Estudiantes();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.estudiantes_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EstudiantesViewModel.class);
        setupViews();
    }

    private void setupViews() {
        FloatingActionButton fab = ActivityCompat.requireViewById(requireActivity(), R.id.fabCrearEstudiante);
        fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.actionEstudianteToCreacionModifEstudiante));

    }



}
