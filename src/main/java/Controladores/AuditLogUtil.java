package Controladores;

import Modelo.AuditLog;
import Vista.Inicio;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;


public class AuditLogUtil {
    
    public static void logIt(String action,IAuditLog entidad,Session con){
        int token = Inicio.token;
        Session sesion = con; 
        
        try{
            LocalDate hoy = LocalDate.now();      
            AuditLog record = new AuditLog(action,entidad.getLogDetail(),new Date(hoy.getYear(), hoy.getMonthValue(), hoy.getDayOfMonth()),entidad.getId(),entidad.getClass().toString(),token);
            sesion.save(record);
            sesion.flush();
        }catch(Exception e){
            System.out.println(e.toString());
        } 
    }
}
