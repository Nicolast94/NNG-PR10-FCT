package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.ui.fragments.empresas.EmpresasViewModel;

public class EstudiantesViewModelFactory implements ViewModelProvider.Factory {

    private final Repositorio repositorio;

    public EstudiantesViewModelFactory(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new EstudiantesViewModel(repositorio);
    }
}
