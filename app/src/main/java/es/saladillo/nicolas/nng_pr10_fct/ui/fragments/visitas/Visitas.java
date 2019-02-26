package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.visitas;

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

import androidx.navigation.Navigation;
import es.saladillo.nicolas.nng_pr10_fct.R;

public class Visitas extends Fragment {

    private VisitasViewModel mViewModel;

    public static Visitas newInstance() {
        return new Visitas();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.visitas_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(VisitasViewModel.class);
        setupViews();
    }

    private void setupViews() {
        FloatingActionButton fab = ActivityCompat.requireViewById(requireActivity(), R.id.fabVisitas_CrearVisita);
        fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.actionVisitasToCreacionModifVisita));

    }
}
