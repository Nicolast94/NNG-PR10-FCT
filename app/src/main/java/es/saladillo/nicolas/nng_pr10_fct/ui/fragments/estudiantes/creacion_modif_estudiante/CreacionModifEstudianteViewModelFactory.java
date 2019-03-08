package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes.creacion_modif_estudiante;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.ui.fragments.empresas.creacion_modif_empresa.CreacionModifEmpresaViewModel;

public class CreacionModifEstudianteViewModelFactory implements ViewModelProvider.Factory {

    private final Repositorio repositorio;

    public CreacionModifEstudianteViewModelFactory(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CreacionModifEstudianteViewModel(repositorio);
    }
}
