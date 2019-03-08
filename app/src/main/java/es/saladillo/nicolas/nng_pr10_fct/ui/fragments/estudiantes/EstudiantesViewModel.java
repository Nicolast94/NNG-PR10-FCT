package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;

public class EstudiantesViewModel extends ViewModel {
    private final Repositorio repositorio;
    private LiveData<List<Estudiante>> listaEstudiantes;


    public EstudiantesViewModel(Repositorio repositorio) {
        this.repositorio = repositorio;
        obtenerTodosEstudiantes();
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        repositorio.deleteEstudiante(estudiante);
    }

    public void insertarEstudiante(Estudiante estudiante) {
        repositorio.insertEstudiante(estudiante);
    }

    public void obtenerTodosEstudiantes(){
        listaEstudiantes = repositorio.consultarCadaEstudiante();
    }

    public LiveData<List<Estudiante>> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(LiveData<List<Estudiante>> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
}
