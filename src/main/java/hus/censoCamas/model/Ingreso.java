/*
package hus.censoCamas.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "ADNINGRESO")
public class Ingreso {
    @Id
    @Column(updatable = false,nullable = false)
    private int id;

    @OneToMany
    @JoinColumn(name = "PACNUMDOC")
    private Paciente paciente;

    @OneToMany
    @JoinColumn(name = "idCama")
    private Cama cama;

    private LocalDateTime fechaIngreso;

    public Ingreso(){

    }
    public Ingreso(int id, Paciente paciente, Cama cama, LocalDateTime fechaIngreso) {
        this.id = id;
        this.paciente = paciente;
        this.cama = cama;
        this.fechaIngreso = fechaIngreso;
    }

    public int getId() {
        return id;
    }

    public void setId(int idIngreso) {
        this.id = idIngreso;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Cama getIdCama() {
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
                ", idCama=" + cama +
                ", fechaIngreso=" + fechaIngreso +
                '}';
    }
}

*/