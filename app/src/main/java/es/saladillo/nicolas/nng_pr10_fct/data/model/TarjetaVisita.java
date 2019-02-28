package es.saladillo.nicolas.nng_pr10_fct.data.model;

import java.time.LocalTime;

public class TarjetaVisita {
    private long id_visita;
    private String dia;
    private String horaDeVisita;
    private String nombre_estudiante;
    private String nombre_empresa;

    public TarjetaVisita(long id_visita, LocalTime hora_inicio, LocalTime hora_fin, String horaDeVisita, String nombre_estudiante, String nombre_empresa) {
        this.id_visita = id_visita;
        this.dia = dia;
        this.horaDeVisita = horaDeVisita;
        this.nombre_estudiante = nombre_estudiante;
        this.nombre_empresa = nombre_empresa;

    }

    public long getId_visita() {
        return id_visita;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraDeVisita() {
        return horaDeVisita;
    }

    public void setHoraDeVisita(String horaDeVisita) {
        this.horaDeVisita = horaDeVisita;
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
}
