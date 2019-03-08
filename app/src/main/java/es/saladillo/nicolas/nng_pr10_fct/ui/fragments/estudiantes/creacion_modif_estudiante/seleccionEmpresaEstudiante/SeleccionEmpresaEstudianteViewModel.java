package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes.creacion_modif_estudiante.seleccionEmpresaEstudiante;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;

public class SeleccionEmpresaEstudianteViewModel extends ViewModel {
    private LiveData<List<Empresa>> empresasAseleccionar = new MutableLiveData<>();

    private final Repositorio repositorio;

    public SeleccionEmpresaEstudianteViewModel(Repositorio repositorio) {
        this.repositorio = repositorio;
        consultarEmpresas();
    }

    public void consultarEmpresas(){
        empresasAseleccionar = repositorio.consultarCadaEmpresa();
    }

    public LiveData<List<Empresa>> getEmpresasAseleccionar() {
        return empresasAseleccionar;
    }

    public void setEmpresasAseleccionar(LiveData<List<Empresa>> empresasAseleccionar) {
        this.empresasAseleccionar = empresasAseleccionar;
    }
}
