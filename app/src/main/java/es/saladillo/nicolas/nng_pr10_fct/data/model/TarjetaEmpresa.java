package es.saladillo.nicolas.nng_pr10_fct.data.model;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class TarjetaEmpresa {
    @ColumnInfo(name = "id")
    private long id;
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo(name = "nombre_contacto")
    private String nombre_contacto;
    @ColumnInfo(name = "telefono")
    private String telefono;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
