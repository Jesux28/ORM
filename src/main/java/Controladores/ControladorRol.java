package Controladores;
import Controladores.InterceptorLog;
import Modelo.Rol;
import Modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ControladorRol {
    InterceptorLog interceptor = new InterceptorLog();
    //Tomamos de la configuracion, creamos una instancia de sesion
    SessionFactory miSesion = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
    //Para abrir Sesion 
    Session sesion = miSesion.withOptions().interceptor(interceptor).openSession();
    
    public String createRol(String nombre){
         try{
            interceptor.setSession(sesion);
            Rol rol = new Rol(nombre);
            //Abre el puente de transacciones entre la App Java y la BD
            sesion.beginTransaction();
            //Guardar todo en la BD
            sesion.saveOrUpdate(rol);
            //Tomar la transaccion hasta donde esta en ese momento y hacer un commit
            sesion.getTransaction().commit();
            //Cerramos la conexion
            miSesion.close();
            return "Usuario Creado";
        }catch(Exception e){ 
            e.printStackTrace();
            return "Error al Registrar Rol";   
        }
    }
    
    public String deleteRol(String nombre){
        try{
            return "Usuario Creado";
        }catch(Exception e){
            e.printStackTrace();
            return "Error al ELiminar Rol";  
        }
    }
}
