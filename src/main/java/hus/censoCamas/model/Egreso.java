package hus.censoCamas.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "ADNEGRESO")
public class Egreso {
    @Id
    @Column(name = "OID", updatable = false,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ADENUMEGR")
    private int idEgreso;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADNINGRESO", referencedColumnName = "OID")
    private Ingreso ingreso;

    @Column(name = "ADEFECSAL")
    private LocalDateTime fechaEgreso;

    public Egreso(){
    }

    public Egreso(int idEgreso, Ingreso ingreso, LocalDateTime fechaEgreso) {
        this.idEgreso = idEgreso;
        this.ingreso = ingreso;
        this.fechaEgreso = fechaEgreso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(int idEgreso) {
        this.idEgreso = idEgreso;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    public LocalDateTime getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(LocalDateTime fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }
}
