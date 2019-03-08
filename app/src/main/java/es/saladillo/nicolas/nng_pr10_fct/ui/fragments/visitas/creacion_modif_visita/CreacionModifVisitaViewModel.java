package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.visitas.creacion_modif_visita;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Visita;

public class CreacionModifVisitaViewModel extends ViewModel {
    private long visitaId;

    private LiveData<Visita> visitaSeleccionada = new MutableLiveData<>();
    private MutableLiveData<String> estudianteVisitado = new MutableLiveData<>();


    private final Repositorio repositorio;

    public CreacionModifVisitaViewModel(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void setVisitaId(long visitaId) {
        this.visitaId = visitaId;
    }

    public long getVisitaId() {
        return visitaId;
    }

    public void consultarEstudiante(long id){

    }

    public void obtenerVisitaSeleccionada(){
        visitaSeleccionada = repositorio.consultarVisita(visitaId);
    }

    public LiveData<Visita> getVisitaSeleccionada() {
        return visitaSeleccionada;
    }

    public void setVisitaSeleccionada(LiveData<Visita> visitaSeleccionada) {
        this.visitaSeleccionada = visitaSeleccionada;
    }

    void insertarVisita(Visita visita) {
        repositorio.insertVisita(visita);
    }
    void actualizarVisita(Visita visita) {
        repositorio.updateVisita(visita);
    }

    public MutableLiveData<String> getEstudianteVisitado() {
        return estudianteVisitado;
    }

    public void setEstudianteVisitado(MutableLiveData<String> estudianteVisitado) {
        this.estudianteVisitado = estudianteVisitado;
    }

    public void obtenerEstudianteVisitado(long idEstudiante){
        estudianteVisitado.setValue(repositorio.consultarEstudiante(idEstudiante).getValue().getNombre());
    }


}
