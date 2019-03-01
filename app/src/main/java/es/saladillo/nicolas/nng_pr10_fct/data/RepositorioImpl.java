package es.saladillo.nicolas.nng_pr10_fct.data;

import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import es.saladillo.nicolas.nng_pr10_fct.data.base.Resource;
import es.saladillo.nicolas.nng_pr10_fct.data.local.EmpresaDao;
import es.saladillo.nicolas.nng_pr10_fct.data.local.EstudianteDao;
import es.saladillo.nicolas.nng_pr10_fct.data.local.VisitaDao;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;
import es.saladillo.nicolas.nng_pr10_fct.data.model.TarjetaEmpresa;
import es.saladillo.nicolas.nng_pr10_fct.data.model.TarjetaEstudiante;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Visita;

public class RepositorioImpl implements Repositorio {

    private final EstudianteDao estudianteDao;
    private final VisitaDao visitaDao;
    private final EmpresaDao empresaDao;

    public RepositorioImpl(EstudianteDao estudianteDao, VisitaDao visitaDao, EmpresaDao empresaDao) {
        this.estudianteDao = estudianteDao;
        this.visitaDao = visitaDao;
        this.empresaDao = empresaDao;
    }

    //Metodos empresa
    @Override
    public LiveData<List<Empresa>> consultarCadaEmpresa() {
        empresaDao.consultarCadaEmpresa().getValue();
        return empresaDao.consultarCadaEmpresa();
    }

    @Override
    public LiveData<Resource<Long>> insertEmpresa(final Empresa empresa) {
        MutableLiveData<Resource<Long>> result = new MutableLiveData<>();

        AsyncTask.THREAD_POOL_EXECUTOR.execute(() -> empresaDao.insert(empresa));
//        AsyncTask.THREAD_POOL_EXECUTOR.execute(() -> {
//
//            result.postValue(Resource.loading());
//            try {
//                long updated = empresaDao.insert(empresa);
//                result.postValue(Resource.success(updated));
//            } catch (Exception e) {
//                result.postValue(Resource.error(e));
//            }
//        });
        return result;
    }

    @Override
    public LiveData<Resource<Integer>> updateEmpresa(Empresa empresa) {
        MutableLiveData<Resource<Integer>> result = new MutableLiveData<>();

        AsyncTask.THREAD_POOL_EXECUTOR.execute(() -> {

            result.postValue(Resource.loading());
            try {
                int updated = empresaDao.update(empresa);
                result.postValue(Resource.success(updated));
            } catch (Exception e) {
                result.postValue(Resource.error(e));
            }
        });
        return result;
    }

    @Override
    public LiveData<Resource<Integer>> deleteEmpresa(Empresa empresa) {
        MutableLiveData<Resource<Integer>> result = new MutableLiveData<>();

        AsyncTask.THREAD_POOL_EXECUTOR.execute(() -> {

            result.postValue(Resource.loading());
            try {
                int updated = empresaDao.delete(empresa);
                result.postValue(Resource.success(updated));
            } catch (Exception e) {
                result.postValue(Resource.error(e));
            }
        });
        return result;
    }

    @Override
    public LiveData<Empresa> consultarEmpresa(long idEmpresa) {
        return empresaDao.consultarEmpresa(idEmpresa);
    }

    @Override
    public LiveData<String> consultarNombreEmpresa(long idEmpresa) {
        return empresaDao.consultarNombreEmpresa(idEmpresa);
    }

    @Override
    public LiveData<TarjetaEmpresa> consultarInfoBasicaEmpresas() {
        return empresaDao.consultarInfoBasicaEmpresas();
    }

    //Metodos estudiante

    @Override
    public LiveData<List<Estudiante>> consultarCadaEstudiante() {
        return null;
    }

    @Override
    public LiveData<Resource<Long>> insertEstudiante(Estudiante student) {
        return null;
    }

    @Override
    public LiveData<Resource<Integer>> updateEstudiante(Estudiante student) {
        return null;
    }

    @Override
    public LiveData<Resource<Integer>> deleteEstudiante(Estudiante student) {
        return null;
    }

    @Override
    public LiveData<Estudiante> consultarEstudiante(long idEstudiante) {
        return null;
    }

    @Override
    public LiveData<String> consultarNombreEstudiante(long idEstudiante) {
        return null;
    }

    @Override
    public LiveData<TarjetaEstudiante> consultarInfoBasicaEstudiantes() {
        return null;
    }

    //Metodos Visita
    @Override
    public LiveData<Resource<Long>> insertVisita(Visita student) {
        return null;
    }

    @Override
    public LiveData<Resource<Integer>> updateVisita(Estudiante student) {
        return null;
    }

    @Override
    public LiveData<Resource<Integer>> deleteVisita(Estudiante student) {
        return null;
    }

    @Override
    public LiveData<List<Visita>> consultarCadaVisita() {
        return null;
    }

    @Override
    public LiveData<Estudiante> consultarVisita(long idVisita) {
        return null;
    }

    @Override
    public LiveData<TarjetaEstudiante> consultarInfoBasicaVisita() {
        return null;
    }
}
