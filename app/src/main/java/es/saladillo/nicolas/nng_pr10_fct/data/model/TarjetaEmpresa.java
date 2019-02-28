package es.saladillo.nicolas.nng_pr10_fct.data.model;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class TarjetaEmpresa {
    private long id;
    private String nombre;
    private String telefono;
    private String nombre_contacto;
    private String logo;

    public TarjetaEmpresa(long id, String nombre, String nombre_contacto, String telefono, String logo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.nombre_contacto = nombre_contacto;
        this.logo = logo;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
