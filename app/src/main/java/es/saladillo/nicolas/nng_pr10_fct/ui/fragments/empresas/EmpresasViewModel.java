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
        todasLasEmpresas = repositorio.consultarCadaEmpresa();
    }

    void insertarEmpresa(Empresa empresa) {
        repositorio.insertEmpresa(empresa);
    }


    public LiveData<List<Empresa>> getTodasLasEmpresas() {
        return todasLasEmpresas;
    }
}
