package es.saladillo.nicolas.nng_pr10_fct.data.model;

import java.time.LocalDate;
import java.time.LocalTime;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.RESTRICT;

@Entity(tableName = "visita", foreignKeys = @ForeignKey(entity = Estudiante.class, parentColumns = "id", childColumns = "id_estudiante", onDelete = RESTRICT, onUpdate = RESTRICT))
public class Visita {
    @PrimaryKey(autoGenerate = true)
    private long id_visita;
    @ColumnInfo(name = "id_estudiante")
    private long id_estudiante;
    @ColumnInfo(name = "dia")
    private String dia;
    @ColumnInfo(name = "hora_inicio")
    private String hora_inicio;
    @ColumnInfo(name = "hora_fin")
    private String hora_fin;
    @ColumnInfo(name = "observaciones")
    private String observaciones;

    public Visita(long id_visita, long id_estudiante, String dia, String hora_inicio, String hora_fin, String observaciones) {
        this.id_visita = id_visita;
        this.id_estudiante = id_estudiante;
        this.dia = dia;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.observaciones = observaciones;
    }

    public long getId_visita() {
        return id_visita;
    }

    public void setId_visita(long id_visita) {
        this.id_visita = id_visita;
    }

    public long getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
