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
import es.saladillo.nicolas.nng_pr10_fct.data.model.Visita;

@Dao
public interface VisitaDao extends BaseDao<Visita> {
    @Query("SELECT * FROM visita")
    LiveData<List<Visita>> consultarCadaVisita();

    @Override
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Visita model);

    @Override
    @Update(onConflict = OnConflictStrategy.IGNORE)
    int update(Visita... model);

    @Query("SELECT * FROM visita WHERE id_visita = :idVisita")
    LiveData<Estudiante> consultarVisita(long idVisita);

    @Query("SELECT es.id,es.nombre,em.nombre,es.tutor FROM estudiante es, empresa em WHERE em.id = es.id_empresa_asignada ")
    LiveData<TarjetaEstudiante> consultarInfoBasicaVisita();
}
