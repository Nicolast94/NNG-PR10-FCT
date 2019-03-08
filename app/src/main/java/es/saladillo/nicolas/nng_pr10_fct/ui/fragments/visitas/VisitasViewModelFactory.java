package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.visitas;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes.EstudiantesViewModel;

public class VisitasViewModelFactory implements ViewModelProvider.Factory {

    private final Repositorio repositorio;

    public VisitasViewModelFactory(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new VisitasViewModel(repositorio);
    }
}
