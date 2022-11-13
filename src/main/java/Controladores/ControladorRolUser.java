package Controladores;

import Modelo.RolUser;
import Modelo.RolUserKey;
import Vista.Inicio;
import java.sql.Date;
import java.time.LocalDate;
import org.hibernate.Session;


public class ControladorRolUser {
    //Para abrir Sesion 
    Session sesion = Inicio.sesion;
    
    public String createRolUser(int rol,int codU){
        try{
            RolUser nuevo = new RolUser(new RolUserKey(rol, codU),
                    new Date(LocalDate.now().getYear(),LocalDate.now().getMonthValue(),LocalDate.now().getDayOfMonth()), new Date(2022,12,7) , true);
            sesion.beginTransaction();
            //Guardar todo en la BD
            sesion.saveOrUpdate(nuevo);
            //Tomar la transaccion hasta donde esta en ese momento y hacer un commit
            sesion.getTransaction().commit();
            return "RolUser Creado";
        }catch(Exception e){
           e.printStackTrace();
           return "Error al crear RolUser";
        }
    }
    
    public String updateRolUser(){
        return "Actualizado";
    }
}
