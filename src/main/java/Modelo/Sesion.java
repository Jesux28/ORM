package Modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Sesion {
    private static SessionFactory factory;
    private static Session sesion;
    
    //Creamos la factoria de Sesiones
    public static void buildSessionFactory(){
        Configuration configuracion = new Configuration();
        configuracion.configure();
        //Registamos las clases que hay que mapear a cada tabla
        configuracion.addAnnotatedClass(Usuario.class);
        configuracion.addAnnotatedClass(Rol.class);
        configuracion.addAnnotatedClass(Equipo.class);
        configuracion.addAnnotatedClass(Directorio.class);
        
        ServiceRegistry servicio = new StandardServiceRegistryBuilder().applySettings(configuracion.getProperties()).build();
        factory = configuracion.buildSessionFactory(servicio);
    }
    
    //Abrimos una nueva sesion
    public static void openSession(){
        sesion = factory.openSession();
    }
    
    public static Session getCurrentSesion(){
        if((sesion == null) || (sesion.isOpen())){
            openSession();
        }
        return sesion;
    }
    
    public static void closeSessionFactory(){
        if(sesion != null){
            sesion.close();
        }
        if(factory != null){
            factory.close();
        }
    }
}
