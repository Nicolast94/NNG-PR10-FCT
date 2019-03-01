package es.saladillo.nicolas.nng_pr10_fct.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Visita;

@Database(entities = {Estudiante.class, Empresa.class, Visita.class},version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "instituto.db";

    public abstract EstudianteDao estudianteDao();
    public abstract EmpresaDao empresaDao();
    public abstract VisitaDao visitaDao();

    private static volatile AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance =
                            Room.databaseBuilder(
                                    context.getApplicationContext(), AppDatabase.class,
                                    DATABASE_NAME).build();
                }
            }
        }
        return instance;
    }
}
