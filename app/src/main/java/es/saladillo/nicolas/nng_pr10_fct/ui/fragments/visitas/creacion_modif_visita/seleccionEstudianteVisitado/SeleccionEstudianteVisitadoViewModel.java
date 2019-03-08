package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.visitas.creacion_modif_visita.seleccionEstudianteVisitado;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;

public class SeleccionEstudianteVisitadoViewModel extends ViewModel {
    private LiveData<List<Estudiante>> estudianteAseleccionar = new MutableLiveData<>();

    private final Repositorio repositorio;

    public SeleccionEstudianteVisitadoViewModel(Repositorio repositorio) {
        this.repositorio = repositorio;
        consultarEstudiantes();
    }

    public void consultarEstudiantes(){
        estudianteAseleccionar = repositorio.consultarCadaEstudiante();
    }

    public LiveData<List<Estudiante>> getEstudianteAseleccionar() {
        return estudianteAseleccionar;
    }

    public void setEstudianteAseleccionar(LiveData<List<Estudiante>> estudianteAseleccionar) {
        this.estudianteAseleccionar = estudianteAseleccionar;
    }
}
