package es.saladillo.nicolas.nng_pr10_fct.data.model;

import java.time.LocalTime;

public class TarjetaVisita {
    private long id_visita;
    private String dia;
    private String hora_inicio;
    private String hora_fin;
    private String nombre_estudiante;

    public TarjetaVisita() {
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

    public long getId_visita() {
        return id_visita;
    }

    public void setId_visita(long id_visita) {
        this.id_visita = id_visita;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getNombre_estudiante() {
        return nombre_estudiante;
    }

    public void setNombre_estudiante(String nombre_estudiante) {
        this.nombre_estudiante = nombre_estudiante;
    }

}
