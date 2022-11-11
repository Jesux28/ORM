package Controladores;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import Modelo.Equipo;

public class ControladorEquipo {
    
    public String createEquipo(String nombre){
         InterceptorLog interceptor = new InterceptorLog();
        //Tomamos de la configuracion
        SessionFactory miSesion = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Equipo.class).buildSessionFactory();
        //Para abrir Sesion 
        Session sesion = miSesion.withOptions().interceptor(interceptor).openSession();
        try{
            interceptor.setSession(sesion);
            Equipo team = new Equipo(nombre);
            //Abre el puente de transacciones entre la App Java y la BD
            sesion.beginTransaction();
            //Guardar todo en la BD
            sesion.saveOrUpdate(team);
            //Tomar la transaccion hasta donde esta en ese momento y hacer un commit
            sesion.getTransaction().commit();
           
            return "Equipo Creado";
        }catch(Exception e){
                e.printStackTrace();
                return "Error al Registrar Equipo";
        }
    }
}
