package Modelo;

import Controladores.IAuditLog;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RolUserKey implements Serializable,IAuditLog{
    @Column(name = "IdRol")
    private int idRol;
    
    @Column(name = "IdUser")
    private int idUser;

    public RolUserKey(int idRol, int idUser) {
        this.idRol = idRol;
        this.idUser = idUser;
    }

    public int getIdRol() {
        return idRol;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        
        if(!(obj instanceof RolUserKey)){
            return false;
        }
        RolUserKey that = (RolUserKey) obj;
        return Objects.equals(getIdRol(), that.getIdRol()) &&
                Objects.equals(getIdUser(), that.getIdUser());
    }

    public RolUserKey() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdRol(),getIdUser());
    }

    @Transient
    @Override
    public int getId(){
        return this.idUser;
    }
    
    @Transient
    @Override
    public String getLogDetail(){
        StringBuilder sb = new StringBuilder();
        sb.append(" ID USUARIO : ").append(idUser)
        .append(" ID ROL: ").append(idRol);
        return sb.toString();
    }
}
