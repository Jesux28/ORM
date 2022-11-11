package Controladores;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import Modelo.Usuario;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.query.Query;

public class ControladorUsuario{
    InterceptorLog interceptor = new InterceptorLog();
    //Tomamos de la configuracion, creamos una instancia de sesion
    SessionFactory miSesion = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Usuario.class).buildSessionFactory();
    //Para abrir Sesion 
    Session sesion = miSesion.withOptions().interceptor(interceptor).openSession();
    
    public String createUsuario(String nombre,String pass){
        
        try{
            interceptor.setSession(sesion);
            Usuario user = new Usuario(nombre,pass);
            //Abre el puente de transacciones entre la App Java y la BD
            sesion.beginTransaction();
            //Guardar todo en la BD
            sesion.saveOrUpdate(user);
            //Tomar la transaccion hasta donde esta en ese momento y hacer un commit
            sesion.getTransaction().commit();
            //Cerramos la conexion
            miSesion.close();
            return "Usuario Creado";
        }catch(Exception e){ 
            e.printStackTrace();
            return "Error al Registrar Usuario";   
        }
    }
    
    public String updateUsuario(String nombreOld,String passOld,String nombre,String pass){
        try{
            interceptor.setSession(sesion);
            //Primero debemos obtener el usuario donde haya ese nombre y password
            //La sesion retorna una instancia de CriteriaBuilder usando el metodo getCriteriaBUilder()
            CriteriaBuilder cb= sesion.getCriteriaBuilder();
            //EL objeto CriteriaBuilder usa el metodo createQuery(), crea un objeeto que a futuro regresara una instancia Query
            CriteriaQuery<Usuario> cr = cb.createQuery(Usuario.class);
            Root<Usuario> root = cr.from(Usuario.class);
            cr.select(root).where(cb.equal(root.get("nombre_Usuario"),nombreOld),cb.equal(root.get("pass"),passOld));
            Query<Usuario> query = sesion.createQuery(cr);
            List<Usuario> resultados = query.getResultList();
            if(!resultados.isEmpty()){
                Usuario user = resultados.get(0);
                sesion.beginTransaction();
                user.setNombre_Usuario(nombre);
                user.setPass(pass);
                sesion.saveOrUpdate(user);
                sesion.getTransaction().commit();
                System.out.println("Se actualizo");
            }
            miSesion.close();
            return "Usuario Actualizado";
        }catch(Exception e){
            System.out.println(e.toString());
            return "Error al actualizar Usuario";
        }
    }

    public String eliminarUsuario(String nombre,String pass){
        try{
            interceptor.setSession(sesion);
            //Primero debemos obtener el usuario donde haya ese nombre y password
            //La sesion retorna una instancia de CriteriaBuilder usando el metodo getCriteriaBUilder()
            CriteriaBuilder cb= sesion.getCriteriaBuilder();
            //EL objeto CriteriaBuilder usa el metodo createQuery(), crea un objeeto que a futuro regresara una instancia Query
            CriteriaQuery<Usuario> cr = cb.createQuery(Usuario.class);
            Root<Usuario> root = cr.from(Usuario.class);
            cr.select(root).where(cb.equal(root.get("nombre_Usuario"),nombre),cb.equal(root.get("pass"),pass));
            Query<Usuario> query = sesion.createQuery(cr);
            List<Usuario> resultados = query.getResultList();
            if(!resultados.isEmpty()){
                Usuario user = resultados.get(0);
                sesion.beginTransaction();
                sesion.delete(user);
                sesion.getTransaction().commit();
                System.out.println("Se elimino");
            }
            miSesion.close();
            return "Usuario Actualizado";
        }catch(Exception e){
            return "Error al Eliminar";
        }
    }
}
