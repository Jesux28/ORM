
package Modelo;
import java.sql.Date;
import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;

public class HibernateForwardEngineering {
    public static void main(String args[]){
        final  StandardServiceRegistry registro = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory factory = new MetadataSources(registro).buildMetadata().buildSessionFactory();
        Session sesion = factory.openSession();
        Transaction t = sesion.beginTransaction();
        
        /**Usuario user = new Usuario("Anonimo","");
        Equipo team = new Equipo("Alfa");
        LocalDate hoy = LocalDate.now();
        //
        
        MiembroDe ingreso = new MiembroDe(new MiembroKey(1,1),new Date(hoy.getDayOfMonth(), hoy.getMonthValue(), hoy.getYear()));
        sesion.save(user);
        sesion.save(team);
        sesion.save(ingreso);*/
        t.commit();
        sesion.close();
        factory.close();
    }
}
