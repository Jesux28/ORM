package Modelo;

import Controladores.IAuditLog;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;

@Entity
@Table(name = "Formato")
public class Formato {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codFormato",updatable = false, nullable = false)
    private int codFormato;
    
    @Column(name = "nombreFormato")
    private String nombreFormato;

    public Formato() {
    }

    public Formato(int codFormato, String nombreFormato) {
        this.codFormato = codFormato;
        this.nombreFormato = nombreFormato;
    }

    public void setCodFormato(int codFormato) {
        this.codFormato = codFormato;
    }

    public void setNombreFormato(String nombreFormato) {
        this.nombreFormato = nombreFormato;
    }

    public int getCodFormato() {
        return codFormato;
    }

    public String getNombreFormato() {
        return nombreFormato;
    }
    
}
