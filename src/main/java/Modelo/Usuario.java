package Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Transient;
import java.io.Serializable;
import Controladores.IAuditLog;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable,IAuditLog {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_usuario",updatable = false, nullable = false)
      private int id_Usuario;

    @Column(name = "nombre_usuario")
      private String nombre_Usuario;

    @Column(name = "password")
     private String pass;

     public Usuario(String nombre_Usuario, String pass) {
         this.nombre_Usuario = nombre_Usuario;
         this.pass = pass;
     }

     public void setId_Usuario(int id_Usuario) {
         this.id_Usuario = id_Usuario;
     }

    public Usuario() {
    }

     public void setNombre_Usuario(String nombre_Usuario) {
         this.nombre_Usuario = nombre_Usuario;
     }

     public void setPass(String pass) {
         this.pass = pass;
     }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public String getNombre_Usuario() {
        return nombre_Usuario;
    }

    public String getPass() {
        return pass;
    }
    
    @Override
    public String toString(){
            String res = "Usuario [id= " + id_Usuario + ", nombre = " + nombre_Usuario + ", password" + pass;
            System.out.println(res);
            return res;
    }
    
    //Metodos implementados de la Interfaz
    @Transient
    @Override
    public int getId(){
        return this.id_Usuario;
    }
    
    @Transient
    @Override
    public String getLogDetail(){
        StringBuilder sb = new StringBuilder();
        sb.append(" ID_USUARIO : ").append(id_Usuario)
        .append(" Nombre Usuario: ").append(nombre_Usuario)
        .append("Contrasena : " ).append(pass);
        return sb.toString();
    }
       
}