package Modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.sql.Date;

@Entity(name = "MiembroDe")
@Table(name = "Miembro")
public class MiembroDe {
    @EmbeddedId
    private MiembroKey id;
    
    @ManyToOne
    @JoinColumn(name = "codU",referencedColumnName = "cod_usuario",insertable = false,updatable = false)
    private Usuario user;

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Usuario getUser() {
        return user;
    }
    
    @ManyToOne
        @JoinColumn(name = "codE",referencedColumnName = "cod_equipo",insertable = false,updatable = false)    
    private Equipo team;

    public Equipo getTeam() {
        return team;
    }

    public void setTeam(Equipo team) {
        this.team = team;
    }
    
    
    @Column(name = "Fecha_Union")
    private Date fechaUnion;

    public MiembroDe(MiembroKey id, Date fechaUnion) {
        this.id = id;
        this.fechaUnion = fechaUnion;
    }

    public MiembroKey getId() {
        return id;
    }

    public Date getFechaUnion() {
        return fechaUnion;
    }

    public void setId(MiembroKey id) {
        this.id = id;
    }

    public void setFechaUnion(Date fechaUnion) {
        this.fechaUnion = fechaUnion;
    }
    
    
    
}
