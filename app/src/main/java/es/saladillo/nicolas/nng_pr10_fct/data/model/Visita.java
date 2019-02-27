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
    private LocalDate dia;
    @ColumnInfo(name = "hora_inicio")
    private LocalTime hora_inicio;
    @ColumnInfo(name = "hora_fin")
    private LocalTime hora_fin;
    @ColumnInfo(name = "observaciones")
    private LocalDate observaciones;

    public Visita(long id_visita,long id_estudiante, LocalDate dia, LocalTime hora_inicio, LocalTime hora_fin, LocalDate observaciones) {
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

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public LocalDate getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(LocalDate observaciones) {
        this.observaciones = observaciones;
    }

    public long getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }
}
