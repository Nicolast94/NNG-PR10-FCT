package es.saladillo.nicolas.nng_pr10_fct.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.RESTRICT;

@Entity(tableName = "estudiante",foreignKeys = @ForeignKey(entity = Empresa.class,parentColumns = "id",childColumns = "id_empresaAsignada",onDelete = RESTRICT,onUpdate = RESTRICT),indices = {@Index("id_empresaAsignada")})
public class Estudiante {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;
    @ColumnInfo(name = "id_empresaAsignada")
    @NonNull
    private long id_empresaAsignada;
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo(name = "telefono")
    private String telefono;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "ciclo_formativo")
    private String ciclo_formativo;
    @NonNull
    @ColumnInfo(name = "empresa_asignada")
    private String empresa_asignada;
    @ColumnInfo(name = "tutor")
    private String tutor;
    @ColumnInfo(name = "telefono_tutor")
    private String telefono_tutor;
    @ColumnInfo(name = "horario")
    private String horario;

    public Estudiante(long id,long id_empresaAsignada, String nombre, String telefono, String email, String ciclo_formativo, String empresa_asignada, String tutor, String telefono_tutor, String horario) {
        this.id = id;
        this.id_empresaAsignada = id_empresaAsignada;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.ciclo_formativo = ciclo_formativo;
        this.empresa_asignada = empresa_asignada;
        this.tutor = tutor;
        this.telefono_tutor = telefono_tutor;
        this.horario = horario;
    }

    @Ignore
    public Estudiante(long id, long id_empresaAsignada, @NonNull String empresa_asignada) {
        this.id = id;
        this.id_empresaAsignada = id_empresaAsignada;
        this.empresa_asignada = empresa_asignada;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiclo_formativo() {
        return ciclo_formativo;
    }

    public void setCiclo_formativo(String ciclo_formativo) {
        this.ciclo_formativo = ciclo_formativo;
    }

    public String getEmpresa_asignada() {
        return empresa_asignada;
    }

    public void setEmpresa_asignada(String empresa_asignada) {
        this.empresa_asignada = empresa_asignada;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getTelefono_tutor() {
        return telefono_tutor;
    }

    public void setTelefono_tutor(String telefono_tutor) {
        this.telefono_tutor = telefono_tutor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public long getId() {
        return id;
    }

    public long getId_empresaAsignada() {
        return id_empresaAsignada;
    }

    public void setId_empresaAsignada(long id_empresaAsignada) {
        this.id_empresaAsignada = id_empresaAsignada;
    }
}
