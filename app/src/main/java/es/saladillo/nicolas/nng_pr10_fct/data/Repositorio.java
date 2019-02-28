package es.saladillo.nicolas.nng_pr10_fct.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import es.saladillo.nicolas.nng_pr10_fct.data.base.Resource;
import es.saladillo.nicolas.nng_pr10_fct.data.local.EmpresaDao;
import es.saladillo.nicolas.nng_pr10_fct.data.local.EstudianteDao;
import es.saladillo.nicolas.nng_pr10_fct.data.local.VisitaDao;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;
import es.saladillo.nicolas.nng_pr10_fct.data.model.TarjetaEmpresa;
import es.saladillo.nicolas.nng_pr10_fct.data.model.TarjetaEstudiante;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Visita;

public interface Repositorio {

    //Metodos empresa
    LiveData<List<Empresa>> consultarCadaEmpresa();

    LiveData<Resource<Long>> insertEmpresa(Empresa empresa);

    LiveData<Resource<Integer>> updateEmpresa(Empresa empresa);

    LiveData<Resource<Integer>> deleteEmpresa(Empresa empresa);

    LiveData<Empresa> consultarEmpresa(long idEmpresa);

    LiveData<String> consultarNombreEmpresa(long idEmpresa);

    LiveData<TarjetaEmpresa> consultarInfoBasicaEmpresas();

    //Metodos estudiante

    LiveData<List<Estudiante>> consultarCadaEstudiante();

    LiveData<Resource<Long>> insertEstudiante(Estudiante student);

    LiveData<Resource<Integer>> updateEstudiante(Estudiante student);

    LiveData<Resource<Integer>> deleteEstudiante(Estudiante student);

    LiveData<Estudiante> consultarEstudiante(long idEstudiante);

    LiveData<String> consultarNombreEstudiante(long idEstudiante);

    LiveData<TarjetaEstudiante> consultarInfoBasicaEstudiantes();

    //Metodos visita

    LiveData<Resource<Long>> insertVisita(Visita student);

    LiveData<Resource<Integer>> updateVisita(Estudiante student);

    LiveData<Resource<Integer>> deleteVisita(Estudiante student);

    LiveData<List<Visita>> consultarCadaVisita();

    LiveData<Estudiante> consultarVisita(long idVisita);

    LiveData<TarjetaEstudiante> consultarInfoBasicaVisita();
}
