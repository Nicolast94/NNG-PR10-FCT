package es.saladillo.nicolas.nng_pr10_fct.ui.activity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;

public class MainActivityViewModel extends ViewModel {
    private long id_empresa_a_editar;
    private long id_estudiante_a_editar;
    private long id_visita_a_editar;

    public long getId_empresa_a_editar() {
        return id_empresa_a_editar;
    }

    public void setId_empresa_a_editar(long id_empresa_a_editar) {
        this.id_empresa_a_editar = id_empresa_a_editar;
    }
}
