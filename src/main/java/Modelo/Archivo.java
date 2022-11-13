package Modelo;

import Controladores.IAuditLog;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Archivo")
public class Archivo implements Serializable,IAuditLog{
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codArchivo",updatable = false, nullable = false)
    private int codArchivo;
    
    @Column(name = "nombreArchivo")
    private String nombreArchivo;
    
    @Column(name = "fechaCreacion")
    private Date fechaCreacion;
    
    @Column(name = "horaCreacion")
    private Time horaCreacion;
    
    @ManyToOne
    @JoinColumn(name = "codD",referencedColumnName = "codDirectorio",insertable = false,updatable = false)
    private Directorio codDirectorio;
    
    @ManyToOne
    @JoinColumn(name = " codF",referencedColumnName = "codFormato",insertable = false,updatable = false)
    private Formato codFormato;
    
    @Column(name = "binario")
    private byte[] binario;

    public Archivo() {
    }

    public Archivo(int codArchivo, String nombreArchivo, int codDirectorio, int codFormato, byte[] binario) {
        this.codArchivo = codArchivo;
        this.nombreArchivo = nombreArchivo;
        fechaCreacion = new Date(LocalDate.now().getDayOfMonth(),LocalDate.now().getMonthValue(),LocalDate.now().getYear());
        horaCreacion = new Time(LocalDateTime.now().getHour(),LocalDateTime.now().getMinute(),LocalDateTime.now().getSecond());    
        this.codDirectorio.setCodDir(codDirectorio);
        this.codFormato.setCodFormato(codFormato);
        this.binario = binario;
    }

    public void setCodArchivo(int codArchivo) {
        this.codArchivo = codArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }


    public void setBinario(byte[] binario) {
        this.binario = binario;
    }

    public int getCodArchivo() {
        return codArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }


    public byte[] getBinario() {
        return binario;
    }
    
    //Metodos implementados de la Interfaz
    @Transient
    @Override
    public int getId(){
        return this.codArchivo;
    }
    
    @Transient
    @Override
    public String getLogDetail(){
        StringBuilder sb = new StringBuilder();
        sb.append(" ID_ARCHIVO : ").append(codArchivo)
        .append(" Nombre Archivo : ").append(nombreArchivo)
        .append("Cod Directorio : " ).append(codDirectorio)
        .append("Cod Formato : " ).append(codFormato);
        return sb.toString();
    }
    
}
