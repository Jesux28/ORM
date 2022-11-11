package Modelo;

import Controladores.IAuditLog;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.awt.List;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

@Entity
@Table(name = "Directorio")
public class Directorio implements Serializable,IAuditLog{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codDirectorio",updatable = false, nullable = false)
    private int codDir;
    
    @Column(name = "NombreDirectorio")
    private String nombre;
    
    @Column(name = "FechaCreacion")
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "Directorio Padre",nullable = true)
    private Directorio padre;
    
    @OneToMany(mappedBy = "padre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ArrayList<Directorio> subDirectorios = new ArrayList<>();
    
    
    public Directorio(){
    
    }
    
    public Directorio(String nombre,Date fecha,int dirPadre){
        this.nombre = nombre;
        this.fecha = fecha;
        this.padre.codDir = dirPadre;
    }

    public int getCodDir() {
        return codDir;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public Directorio getPadre() {
        return padre;
    }

    public ArrayList<Directorio> getSubDirectorios() {
        return subDirectorios;
    }

    public void setCodDir(int codDir) {
        this.codDir = codDir;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setPadre(Directorio padre) {
        this.padre = padre;
    }

    public void setSubDirectorios(ArrayList<Directorio> subDirectorios) {
        this.subDirectorios = subDirectorios;
    }
    
    
    //Metodos implementados de la Interfaz
    @Transient
    @Override
    public int getId(){
        return this.codDir;
    }
    
    @Transient
    @Override
    public String getLogDetail(){
        StringBuilder sb = new StringBuilder();
        sb.append(" COD_DIRECTORIO : ").append(codDir)
        .append(" Nombre Carpeta: ").append(nombre)
        .append("Fecha Creacion : " ).append(fecha)
        .append("COD PADRE : " ).append(padre.codDir);
        return sb.toString();
    }
    
}





























