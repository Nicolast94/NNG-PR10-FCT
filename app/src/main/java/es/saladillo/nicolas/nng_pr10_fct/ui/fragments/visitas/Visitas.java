package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.visitas;

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
import es.saladillo.nicolas.nng_pr10_fct.data.model.InfoTarjetaVisita;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Visita;
import es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes.EstudiantesAdapter;
import es.saladillo.nicolas.nng_pr10_fct.utils.Utilidades;

public class Visitas extends Fragment {

    private VisitasViewModel vm;

    private RecyclerView lstVisitas;
    private VisitasAdapter visitasAdapter;
    private TextView lblSinVisitas;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.visitas_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = ViewModelProviders.of(this,new VisitasViewModelFactory(Utilidades.obtenerRepositorioBD(getContext()))).get(VisitasViewModel.class);
        setupViews();
        vm.getTarjetasVisita().observe(this, this::actualizarListaVisitas);
    }

    private void setupViews() {
        FloatingActionButton fab = ActivityCompat.requireViewById(requireActivity(), R.id.fabCrearVisita);
        fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.actionVisitasToCreacionModifVisita));

        lstVisitas = ViewCompat.requireViewById(Objects.requireNonNull(getView()),R.id.lstVisitas);
        lblSinVisitas = ViewCompat.requireViewById(getView(),R.id.lblSinVisitas);

        setupRecyclerView();

    }

    private void setupRecyclerView() {
        ItemTouchHelper itemTouchHelper;
        visitasAdapter = new VisitasAdapter(vm);

        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                vm.obtenerYEliminarVisita(visitasAdapter.getItem(viewHolder.getAdapterPosition()).getId());
            }
        });

        lstVisitas.setHasFixedSize(true);
        lstVisitas.setLayoutManager(new GridLayoutManager(requireContext(),1));
        lstVisitas.setItemAnimator(new DefaultItemAnimator());
        lstVisitas.setAdapter(visitasAdapter);
        itemTouchHelper.attachToRecyclerView(lstVisitas);
    }

    private void actualizarListaVisitas(List<InfoTarjetaVisita> visitas) {
        visitasAdapter.submitList(visitas);
        if(visitas.size() == 0){
            lblSinVisitas.setVisibility(View.VISIBLE);
        }else{
            lblSinVisitas.setVisibility(View.INVISIBLE);
        }

    }
}
