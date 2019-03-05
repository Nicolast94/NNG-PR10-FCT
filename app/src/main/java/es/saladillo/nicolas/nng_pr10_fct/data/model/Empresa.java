package es.saladillo.nicolas.nng_pr10_fct.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "empresa",indices = {@Index(value = "nombre",unique = true)})
public class Empresa {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo(name = "cif")
    private String cif;
    @ColumnInfo(name = "direccion_sede")
    private String direccion_sede;
    @ColumnInfo(name = "telefono")
    private String telefono;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "logo")
    private String logo;
    @ColumnInfo(name = "nombre_contacto")
    private String nombre_contacto;

    public Empresa(long id, String nombre, String cif, String direccion_sede, String telefono, String email, String logo, String nombre_contacto) {
        this.id = id;
        this.nombre = nombre;
        this.cif = cif;
        this.direccion_sede = direccion_sede;
        this.telefono = telefono;
        this.email = email;
        this.logo = logo;
        this.nombre_contacto = nombre_contacto;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion_sede() {
        return direccion_sede;
    }

    public void setDireccion_sede(String direccion_sede) {
        this.direccion_sede = direccion_sede;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }
}
