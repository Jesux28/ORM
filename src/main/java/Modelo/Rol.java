
package Modelo;

import Controladores.IAuditLog;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;

@Entity
@Table(name = "Rol")
public class Rol implements Serializable,IAuditLog{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_rol",updatable = false, nullable = false)
    private int id_rol;
    
    @Column(name = "nombre_rol")
    private String nombreRol;

    public Rol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Rol() {
    }

    public int getId_rol() {
        return id_rol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
    
       //Metodos implementados de la Interfaz
    @Transient
    @Override
    public int getId(){
        return this.id_rol;
    }
    
    @Transient
    @Override
    public String getLogDetail(){
        StringBuilder sb = new StringBuilder();
        sb.append(" ID_ROL : ").append(id_rol)
        .append(" Nombre Rol: ").append(nombreRol);
        return sb.toString();
    
    }
}
