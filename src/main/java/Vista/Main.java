package Vista;

import Controladores.ControladorEquipo;
import Controladores.ControladorUsuario;

public class Main {
    public static void main(String[] args){
        String insert = new ControladorUsuario().createUsuario("","");
        String usuario = new ControladorUsuario().updateUsuario("Jesus","1234","Jesus","Funciona");
        String equipo = new ControladorEquipo().createEquipo("");
        String delete = new ControladorUsuario().eliminarUsuario("Stephen", "1234");
        System.out.println(usuario);
        System.out.println(equipo);
    }
}
