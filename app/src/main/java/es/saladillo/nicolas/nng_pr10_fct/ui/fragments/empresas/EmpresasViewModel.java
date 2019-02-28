package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.empresas;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;

public class EmpresasViewModel extends ViewModel {
    private final Repositorio repositorio;
    public LiveData<List<Empresa>> todasLasEmpresas;

    public EmpresasViewModel(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    void insertarEmpresa(Empresa empresa) {
        repositorio.insertEmpresa(empresa);
    }

    void obtenerEmpresasBD(){
        this.todasLasEmpresas = repositorio.consultarCadaEmpresa();
    }

    public List<Empresa> getTodasLasEmpresas() {
        return todasLasEmpresas.getValue();
    }
}
