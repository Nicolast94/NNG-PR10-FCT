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
import es.saladillo.nicolas.nng_pr10_fct.data.model.TarjetaVisita;
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
    LiveData<Visita> consultarVisita(long idVisita);

    @Query("SELECT v.id_visita, v.dia,v.hora_inicio,v.hora_fin,e.nombre AS nombre_estudiante FROM visita v, estudiante e WHERE v.id_estudiante = e.id")
    LiveData<TarjetaVisita> consultarInfoBasicaVisita();
}
