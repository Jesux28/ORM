package Controladores;

import Modelo.AuditLog;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;


public class AuditLogUtil {
    public static void logIt(String action,IAuditLog entidad,Session con){
        
        Session sesion = con; 
        
        try{
            LocalDate hoy = LocalDate.now();      
            AuditLog record = new AuditLog(action,entidad.getLogDetail(),new Date(hoy.getDayOfMonth(), hoy.getMonthValue(), hoy.getYear()),entidad.getId(),entidad.getClass().toString(),0);
            sesion.save(record);
            sesion.flush();
        }catch(Exception e){
            System.out.println(e.toString());
        } finally{
            sesion.close();
        }
    }
}
