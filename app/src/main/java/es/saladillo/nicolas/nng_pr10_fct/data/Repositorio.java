package es.saladillo.nicolas.nng_pr10_fct.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import es.saladillo.nicolas.nng_pr10_fct.data.base.Resource;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;
import es.saladillo.nicolas.nng_pr10_fct.data.model.InfoTarjetaVisita;
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

    LiveData<Resource<Long>> insertVisita(Visita visita);

    LiveData<Resource<Integer>> updateVisita(Visita visita);

    LiveData<Resource<Integer>> deleteVisita(Visita visita);

    LiveData<List<Visita>> consultarCadaVisita();

    LiveData<Visita> consultarVisita(long idVisita);

    LiveData<TarjetaEstudiante> consultarInfoBasicaVisita();


    //Metodos de Join
    LiveData<InfoTarjetaVisita> consultarInfoDeEstudianteParaVisita(long id);

    LiveData<List<InfoTarjetaVisita>> consultarInfoTarjetasVisita();


}
