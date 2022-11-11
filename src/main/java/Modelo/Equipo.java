package Modelo;
import Controladores.IAuditLog;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Transient;
import java.io.Serializable;

@Entity
@Table(name = "Team")
public class Equipo implements Serializable,IAuditLog{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_equipo",updatable = false, nullable = false)
    private int id_equipo;
    
    @Column(name = "nombre_equipo")
      private String nombre_Equipo;

    public int getId_equipo() {
        return id_equipo;
    }

    public String getNombre_Equipo() {
        return nombre_Equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public void setNombre_Equipo(String nombre_Equipo) {
        this.nombre_Equipo = nombre_Equipo;
    }

    public Equipo(String nombre_Equipo) {
        this.nombre_Equipo = nombre_Equipo;
    }

    @Override
    public String toString() {
        return "Equipo{" + "id_equipo=" + id_equipo + ", nombre_Equipo=" + nombre_Equipo + '}';
    }
    
    //Metodos implementados de la Interfaz
    @Transient
    @Override
    public int getId(){
        return this.id_equipo;
    }
    
    @Transient
    @Override
    public String getLogDetail(){
        StringBuilder sb = new StringBuilder();
        sb.append(" ID_EQUIPO : ").append(id_equipo)
        .append(" Nombre Equipo: ").append(nombre_Equipo);
        return sb.toString();
    }

    public Equipo() {
    }



}
