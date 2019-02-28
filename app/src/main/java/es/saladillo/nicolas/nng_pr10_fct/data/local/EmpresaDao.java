package es.saladillo.nicolas.nng_pr10_fct.data.local;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import es.saladillo.nicolas.nng_pr10_fct.data.base.BaseDao;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;
import es.saladillo.nicolas.nng_pr10_fct.data.model.TarjetaEmpresa;

@Dao
public interface EmpresaDao extends BaseDao<Empresa> {

    @Query("SELECT * FROM empresa")
    LiveData<List<Empresa>> consultarCadaEmpresa();

    @Override
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Empresa model);

    @Override
    @Update(onConflict = OnConflictStrategy.IGNORE)
    int update(Empresa... model);

    @Query("SELECT * FROM empresa WHERE id = :idEmpresa")
    LiveData<Empresa> consultarEmpresa(long idEmpresa);

    @Query("SELECT nombre FROM empresa WHERE id = :idEmpresa")
    LiveData<String> consultarNombreEmpresa(long idEmpresa);

    @Query("SELECT id,nombre,nombre_contacto,telefono,logo FROM empresa ")
    LiveData<TarjetaEmpresa> consultarInfoBasicaEmpresas();

}
