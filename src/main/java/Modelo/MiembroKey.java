package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MiembroKey implements Serializable{
    @Column(name = "codE")
    private int cod_equipo;
    
    @Column(name = "codU")
    private int cod_usuario;

    public MiembroKey() {
    }

    public MiembroKey(int cod_equipo, int cod_usuario) {
        this.cod_equipo = cod_equipo;
        this.cod_usuario = cod_usuario;
    }

    public int getCod_equipo() {
        return cod_equipo;
    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_equipo(int cod_equipo) {
        this.cod_equipo = cod_equipo;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        
        if(!(obj instanceof MiembroKey)){
            return false;
        }
        MiembroKey that = (MiembroKey) obj;
        return Objects.equals(getCod_equipo(), that.getCod_equipo()) &&
                Objects.equals(getCod_usuario(), that.getCod_usuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCod_equipo(),getCod_usuario());
    }
    
    
}
