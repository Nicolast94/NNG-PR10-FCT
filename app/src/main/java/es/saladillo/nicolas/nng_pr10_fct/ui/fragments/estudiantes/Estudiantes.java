package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes;

import androidx.core.app.ActivityCompat;
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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Objects;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import es.saladillo.nicolas.nng_pr10_fct.R;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;
import es.saladillo.nicolas.nng_pr10_fct.utils.Utilidades;

public class Estudiantes extends Fragment {

    private EstudiantesViewModel vm;
    private RecyclerView lstEstudiantes;
    private EstudiantesAdapter estudiantesAdapter;
    private TextView lblSinEstudiantes;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.estudiantes_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = ViewModelProviders.of(this,new EstudiantesViewModelFactory(Utilidades.obtenerRepositorioBD(getContext()))).get(EstudiantesViewModel.class);
        setupViews();
        vm.getListaEstudiantes().observe(this, this::actualizarListaEstudiantes);
    }

    private void setupViews() {
        FloatingActionButton fab = ActivityCompat.requireViewById(requireActivity(), R.id.fabCrearEstudiante);
        fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.actionEstudianteToCreacionModifEstudiante));

        lstEstudiantes = ViewCompat.requireViewById(Objects.requireNonNull(getView()),R.id.lstEstudiantes);
        lblSinEstudiantes = ViewCompat.requireViewById(getView(),R.id.lblSinEstudiantes);

        setupRecyclerView();

    }

    private void setupRecyclerView() {
        ItemTouchHelper itemTouchHelper;
        estudiantesAdapter = new EstudiantesAdapter();

        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                vm.eliminarEstudiante(estudiantesAdapter.getItem(viewHolder.getAdapterPosition()));
            }
        });

        lstEstudiantes.setHasFixedSize(true);
        lstEstudiantes.setLayoutManager(new GridLayoutManager(requireContext(),1));
        lstEstudiantes.setItemAnimator(new DefaultItemAnimator());
        lstEstudiantes.setAdapter(estudiantesAdapter);
        itemTouchHelper.attachToRecyclerView(lstEstudiantes);
    }

    private void actualizarListaEstudiantes(List<Estudiante> estudiantes) {
        estudiantesAdapter.submitList(estudiantes);
        if(estudiantes.size() == 0){
            lblSinEstudiantes.setVisibility(View.VISIBLE);
        }else{
            lblSinEstudiantes.setVisibility(View.INVISIBLE);
        }

    }



}
