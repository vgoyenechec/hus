
package hus.censoCamas.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity(name = "ADNINGRESO")
public class Ingreso {
    @Id
    @Column(name = "OID", updatable = false,nullable = false)
    private Integer id;

    @Column(name = "AINCONSEC")
    private int idIngreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="GENPACIEN", referencedColumnName = "OID",nullable=false)
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "HPNDEFCAM", referencedColumnName = "OID")
    private Cama cama;

    @Column(name = "AINFECING")
    private LocalDateTime fechaIngreso;


    @OneToOne(mappedBy="ingreso", fetch = FetchType.LAZY)
    private Egreso egreso;

    public Ingreso(){

    }
    public Ingreso(Integer id, int idIngreso, Paciente paciente, Cama cama, LocalDateTime fechaIngreso) {
        this.id = id;
        this.idIngreso = idIngreso;
        this.paciente = paciente;
        this.cama = cama;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdIngreso() { return idIngreso; }

    public void setIdIngreso(int idIngreso) { this.idIngreso = idIngreso; }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Cama getCama() {
        return cama;
    }

    public void setCama(Cama cama) {
        this.cama = cama;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "Ingreso{" +
                "idIngreso=" + id +
                ", idPaciente=" + paciente +
                ", idCama=" + cama.getCodigoCama() +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }
}

