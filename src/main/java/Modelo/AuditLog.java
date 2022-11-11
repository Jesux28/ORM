package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Log")
public class AuditLog implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id",updatable = false, nullable = false)
    private int log_id;
    
    @Column(name = "Accion")
    private String accion;
    
    @Column(name = "Detalle")
    private String detalle;
    
    @Column(name = "Fecha")
    private Date fechaCreada;
    
    @Column(name = "Id_Entidad")
    private int IdEntidad;

    @Column(name = "Nombre_Tabla")
    private String NombreEntidad;
    
    public AuditLog(String accion, String detalle, Date fechaCreada, int IdEntidad, String NombreEntidad) {
        this.accion = accion;
        this.detalle = detalle;
        this.fechaCreada = fechaCreada;
        this.IdEntidad = IdEntidad;
        this.NombreEntidad = NombreEntidad;
    }

    public int getLog_id() {
        return log_id;
    }

    public String getAccion() {
        return accion;
    }

    public String getDetalle() {
        return detalle;
    }

    public Date getFechaCreada() {
        return fechaCreada;
    }

    public int getIdEntidad() {
        return IdEntidad;
    }

    public String getNombreEntidad() {
        return NombreEntidad;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setFechaCreada(Date fechaCreada) {
        this.fechaCreada = fechaCreada;
    }

    public void setIdEntidad(int IdEntidad) {
        this.IdEntidad = IdEntidad;
    }

    public void setNombreEntidad(String NombreEntidad) {
        this.NombreEntidad = NombreEntidad;
    }
    
    
    
    
}
