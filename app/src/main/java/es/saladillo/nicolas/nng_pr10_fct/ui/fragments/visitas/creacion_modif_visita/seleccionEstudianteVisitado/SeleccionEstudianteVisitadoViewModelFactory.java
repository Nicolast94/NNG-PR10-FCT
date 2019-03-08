package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.visitas.creacion_modif_visita.seleccionEstudianteVisitado;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.ui.fragments.visitas.creacion_modif_visita.CreacionModifVisitaViewModel;

public class SeleccionEstudianteVisitadoViewModelFactory implements ViewModelProvider.Factory {

    private final Repositorio repositorio;

    public SeleccionEstudianteVisitadoViewModelFactory(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SeleccionEstudianteVisitadoViewModel(repositorio);
    }
}
