package es.saladillo.nicolas.nng_pr10_fct.data.local;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import es.saladillo.nicolas.nng_pr10_fct.data.base.BaseDao;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;
import es.saladillo.nicolas.nng_pr10_fct.data.model.TarjetaEstudiante;

@Dao
public interface EstudianteDao extends BaseDao<Estudiante> {

    @Query("SELECT * FROM estudiante")
    LiveData<List<Estudiante>> consultarCadaEstudiante();

    @Override
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Estudiante model);

    @Override
    @Update(onConflict = OnConflictStrategy.IGNORE)
    int update(Estudiante... model);

    @Query("SELECT * FROM estudiante WHERE id = :idEstudiante")
    LiveData<Estudiante> consultarEstudiante(long idEstudiante);

    @Query("SELECT nombre FROM estudiante WHERE id = :idEstudiante")
    LiveData<String> consultarNombreEstudiante(long idEstudiante);

    @Query("SELECT es.id,es.nombre,em.nombre,es.tutor FROM estudiante es, empresa em WHERE em.id = es.id_empresaAsignada ")
    LiveData<TarjetaEstudiante> consultarInfoBasicaEstudiantes();
}
