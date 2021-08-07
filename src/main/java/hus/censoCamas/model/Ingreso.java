
package hus.censoCamas.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ADNINGRESO")
public class Ingreso {
    @Id
    @Column(name = "OID", updatable = false,nullable = false)
    private Integer id;
    @Column(name = "AINCONSEC")
    private int consecutivo;
    @Column(name = "ADNCENATE")
    private String centroAtencion;
    @Column(name = "AINTIPING")
    private String tipoIngreso;
    @Column(name = "AINCAUING")
    private String causa;
    @Column(name = "AINTIPRIE")
    private String tipoRiesgo;
    @Column(name = "AINFECING")
    private LocalDateTime fechaIngreso;
    @Column(name = "AINESTADO")
    private int estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="GENPACIEN", referencedColumnName = "OID",nullable=false)
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "HPNDEFCAM", referencedColumnName = "OID")
    private Cama cama;

    @OneToOne(mappedBy="ingreso", fetch = FetchType.LAZY)
    private Egreso egreso;


    public Ingreso(){

    }

    public Ingreso(Integer id, int consecutivo, String centroAtencion, String tipoIngreso, String causa, String tipoRiesgo, Paciente paciente, Cama cama, LocalDateTime fechaIngreso, int estado) {
        this.id = id;
        this.consecutivo = consecutivo;
        this.centroAtencion = centroAtencion;
        this.tipoIngreso = tipoIngreso;
        this.causa = causa;
        this.tipoRiesgo = tipoRiesgo;
        this.paciente = paciente;
        this.cama = cama;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getConsecutivo() { return consecutivo; }

    public void setConsecutivo(int consecutivo) { this.consecutivo = consecutivo; }

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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCentroAtencion() {
        return centroAtencion;
    }

    public void setCentroAtencion(String centroAtencion) {
        this.centroAtencion = centroAtencion;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getTipoRiesgo() {
        return tipoRiesgo;
    }

    public void setTipoRiesgo(String tipoRiesgo) {
        this.tipoRiesgo = tipoRiesgo;
    }

    public Egreso getEgreso() {
        return egreso;
    }

    public void setEgreso(Egreso egreso) {
        this.egreso = egreso;
    }

    @Override
    public String toString() {
        return "Ingreso{" +
                "consecutivo=" + id +
                ", idPaciente=" + paciente +
                ", idCama=" + cama.getCodigoCama() +
                ", fechaIngreso=" + fechaIngreso +
                ", estado=" + estado +
                '}';
    }
}

