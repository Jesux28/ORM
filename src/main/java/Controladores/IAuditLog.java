package Controladores;


/**CREAMOS UNA INTERFAZ, la cual cada clase que la implementa sera revisada*/
public interface IAuditLog {
    //Exponer su identificador
    public int getId();
    //El contenido
    public String getLogDetail();  
}
