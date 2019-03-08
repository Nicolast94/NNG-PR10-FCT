package es.saladillo.nicolas.nng_pr10_fct.ui.activity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;

public class MainActivityViewModel extends ViewModel {
    private long id_empresa_a_editar,id_empresaItem_seleccionada;
    private long id_estudiante_a_editar;
    private long id_visita_a_editar;

    private Empresa empresaAsignadaSeleccionada;
    private boolean seHaAsignadoEmpresa = false;

    private Estudiante estudianteVisitadoSeleccionado;
    private boolean seHaSeleccionadoEstudianteVisitado = false;


    public MainActivityViewModel() {}

    public long getId_empresaItem_seleccionada() {
        return id_empresaItem_seleccionada;
    }

    public void setId_empresaItem_seleccionada(long id_empresaItem_seleccionada) {
        this.id_empresaItem_seleccionada = id_empresaItem_seleccionada;
    }

    public long getId_empresa_a_editar() {
        return id_empresa_a_editar;
    }

    public void setId_empresa_a_editar(long id_empresa_a_editar) {
        this.id_empresa_a_editar = id_empresa_a_editar;
    }

    public Empresa getEmpresaAsignadaSeleccionada() {
        return empresaAsignadaSeleccionada;
    }

    public void setEmpresaAsignadaSeleccionada(Empresa empresaAsignadaSeleccionada) {
        this.empresaAsignadaSeleccionada = empresaAsignadaSeleccionada;
    }

    public boolean isSeHaAsignadoEmpresa() {
        return seHaAsignadoEmpresa;
    }

    public void setSeHaAsignadoEmpresa(boolean seHaAsignadoEmpresa) {
        this.seHaAsignadoEmpresa = seHaAsignadoEmpresa;
    }

    public Estudiante getEstudianteVisitadoSeleccionado() {
        return estudianteVisitadoSeleccionado;
    }

    public void setEstudianteVisitadoSeleccionado(Estudiante estudianteVisitadoSeleccionado) {
        this.estudianteVisitadoSeleccionado = estudianteVisitadoSeleccionado;
    }

    public boolean isSeHaSeleccionadoEstudianteVisitado() {
        return seHaSeleccionadoEstudianteVisitado;
    }

    public void setSeHaSeleccionadoEstudianteVisitado(boolean seHaSeleccionadoEstudianteVisitado) {
        this.seHaSeleccionadoEstudianteVisitado = seHaSeleccionadoEstudianteVisitado;
    }
}
