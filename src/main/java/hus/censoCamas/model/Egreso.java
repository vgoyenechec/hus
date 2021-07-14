package hus.censoCamas.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "ADNEGRESO")
public class Egreso {
    @Id
    @Column(updatable = false,nullable = false)
    private Long idEgreso;
    private int idPaciente;
    private int idCama;
    private LocalDateTime fechaEgreso;

    public Egreso(){

    }

    public Egreso(Long idEgreso, int idPaciente, int idCama, LocalDateTime fechaEgreso) {
        this.idEgreso = idEgreso;
        this.idPaciente = idPaciente;
        this.idCama = idCama;
        this.fechaEgreso = fechaEgreso;
    }

    public Long getIdEgreso() {
        return idEgreso;
    }

    public void setIdEgreso(Long idEgreso) {
        this.idEgreso = idEgreso;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdCama() {
        return idCama;
    }

    public void setIdCama(int idCama) {
        this.idCama = idCama;
    }

    public LocalDateTime getFechaRgreso() {
        return fechaEgreso;
    }

    public void setFechaRgreso(LocalDateTime fechaRgreso) {
        this.fechaEgreso = fechaRgreso;
    }

    @Override
    public String toString() {
        return "Egreso{" +
                "idEgreso=" + idEgreso +
                ", idPaciente=" + idPaciente +
                ", idCama=" + idCama +
                ", fechaRgreso=" + fechaEgreso +
                '}';
    }

}
