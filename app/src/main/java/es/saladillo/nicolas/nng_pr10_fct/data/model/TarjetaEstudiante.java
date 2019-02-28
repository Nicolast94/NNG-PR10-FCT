package es.saladillo.nicolas.nng_pr10_fct.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class TarjetaEstudiante {
    private long id_estudiante;
    private String nombre_estudiante;
    private String nombre_empresa;
    private String tutor;

    public TarjetaEstudiante(long id_estudiante, String nombre_estudiante, String nombre_empresa, String tutor) {
        this.id_estudiante = id_estudiante;
        this.nombre_estudiante = nombre_estudiante;
        this.nombre_empresa = nombre_empresa;
        this.tutor = tutor;
    }

    public long getId_estudiante() {
        return id_estudiante;
    }

    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
}
