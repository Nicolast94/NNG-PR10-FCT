package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.visitas;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.data.model.InfoTarjetaVisita;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Visita;

public class VisitasViewModel extends ViewModel {
    private final Repositorio repositorio;
    private LiveData<List<Visita>> listaVisitas;
    private LiveData<List<InfoTarjetaVisita>> tarjetasVisita;
    private LiveData<Visita> visitaAeliminar = new MutableLiveData<>();
    private MediatorLiveData<Visita> eliminadorVisita = new MediatorLiveData();
    private MediatorLiveData<Boolean> visitaCargada = new MediatorLiveData();

    public VisitasViewModel(Repositorio repositorio) {
        this.repositorio = repositorio;
        visitaCargada.addSource(visitaAeliminar,visita -> visitaCargada.setValue(true));
        eliminadorVisita.addSource(visitaCargada,visita -> eliminarVisita(visitaAeliminar.getValue()));
        obtenerInfoTarjetasVisitas();
    }

    public void eliminarVisita(Visita visita) {
        repositorio.deleteVisita(visita);
    }

    public Visita obtenerVisita(long idVisita){
        return repositorio.consultarVisita(idVisita).getValue();
    }

    public void obtenerInfoTarjetasVisitas(){
        tarjetasVisita = repositorio.consultarInfoTarjetasVisita();
    }

    public void obtenerYEliminarVisita(long id){
        visitaAeliminar = repositorio.consultarVisita(id);
    }

    public void obtenerTodasLasVisitas(){
        listaVisitas = repositorio.consultarCadaVisita();
    }

    public LiveData<List<Visita>> getListaVisitas() {
        return listaVisitas;
    }

    public void setListaVisitas(LiveData<List<Visita>> listaVisitas) {
        this.listaVisitas = listaVisitas;
    }

    public LiveData<List<InfoTarjetaVisita>> getTarjetasVisita() {
        return tarjetasVisita;
    }

    public void setTarjetasVisita(LiveData<List<InfoTarjetaVisita>> tarjetasVisita) {
        this.tarjetasVisita = tarjetasVisita;
    }
}
