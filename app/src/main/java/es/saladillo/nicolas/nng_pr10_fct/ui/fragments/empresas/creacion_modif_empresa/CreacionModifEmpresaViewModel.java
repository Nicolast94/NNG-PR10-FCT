package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.empresas.creacion_modif_empresa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;

public class CreacionModifEmpresaViewModel extends ViewModel {
    private long empresaId;
    private LiveData<Empresa> empresaSeleccionada = new MutableLiveData<>();

    private final Repositorio repositorio;

    public CreacionModifEmpresaViewModel(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    void insertarEmpresa(Empresa empresa) {
        repositorio.insertEmpresa(empresa);
    }
    void actualizarEmpresa(Empresa empresa) {
        repositorio.updateEmpresa(empresa);
    }


    public long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(long empresaId) {
        this.empresaId = empresaId;
    }

    public void obtenerEmpresaSeleccionada(){
        empresaSeleccionada = repositorio.consultarEmpresa(empresaId);
    }

    public LiveData<Empresa> getEmpresaSeleccionada() {
        return empresaSeleccionada;
    }

    public void setEmpresaSeleccionada(LiveData<Empresa> empresaSeleccionada) {
        this.empresaSeleccionada = empresaSeleccionada;
    }
}
