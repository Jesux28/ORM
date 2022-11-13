package Modelo;

import Controladores.IAuditLog;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.sql.Date;
import org.hibernate.annotations.CollectionId;

@Entity
@Table(name = "Rol_User")
public class RolUser implements Serializable,IAuditLog{
    @EmbeddedId
    private RolUserKey id;
    
    //Hacemos los Joins respectivos
    public RolUser(RolUserKey id, Date fechaDesde, Date fechaHasta, boolean activo) {
        this.id = id;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.activo = activo;
    }

    public RolUser() {
    }
    
    @ManyToOne
    @JoinColumn(name = "idRol",referencedColumnName = "cod_rol",insertable = false,updatable = false)
    private Rol rol;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    @ManyToOne
    @JoinColumn(name = "idUser",referencedColumnName = "cod_usuario",insertable = false,updatable = false)
    private Usuario user;

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Usuario getUser() {
        return user;
    }
    
    @Column(name = "FechaDesde")
    private Date fechaDesde;
    
    @Column(name = "FechaHasta")
    private Date fechaHasta;
    
    @Column(name = "Rol_Activo")
    private boolean activo;
    
    @Transient
    @Override
    public int getId(){
        return this.id.getIdUser();
    }
    
    @Transient
    @Override
    public String getLogDetail(){
        StringBuilder sb = new StringBuilder();
        sb.append(" ID_USUARIO : ").append(id.getIdRol())
        .append(" ID_ROL: ").append(id.getIdRol())
        .append(" FECHA INICIO : " ).append(fechaDesde)
        .append(" FECHA FINAL : " ).append(fechaHasta);
        return sb.toString();
    }
}
