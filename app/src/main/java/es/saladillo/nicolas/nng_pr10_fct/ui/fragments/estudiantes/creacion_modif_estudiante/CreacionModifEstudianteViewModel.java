package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes.creacion_modif_estudiante;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;

public class CreacionModifEstudianteViewModel extends ViewModel {
    private long estudianteId;
    private LiveData<Estudiante> estudianteSeleccionado = new MutableLiveData<>();

    private final Repositorio repositorio;

    public CreacionModifEstudianteViewModel(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    void insertarEstudiante(Estudiante estudiante) {
        repositorio.insertEstudiante(estudiante);
    }
    void actualizarEstudiante(Estudiante estudiante) {
        repositorio.updateEstudiante(estudiante);
    }


    public long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public void obtenerEstudianteSeleccionado(){
        estudianteSeleccionado = repositorio.consultarEstudiante(estudianteId);
    }

    public LiveData<Estudiante> getEstudianteSeleccionado() {
        return estudianteSeleccionado;
    }

    public void setEstudianteSeleccionado(LiveData<Estudiante> estudianteSeleccionado) {
        this.estudianteSeleccionado = estudianteSeleccionado;
    }
}
