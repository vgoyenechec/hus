
package hus.censoCamas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ADNINGRESO")
public class Ingreso implements Serializable {
    @Id
    @Column(name = "OID", updatable = false,nullable = false)
    private Integer id;
    @Column(name = "AINCONSEC")
    private int consecutivo;
    @Column(name = "ADNCENATE")
    private int centroAtencion;
    @Column(name = "AINTIPING")
    private int tipoIngreso;
    @Column(name = "AINCAUING")
    private int causa;
    @Column(name = "AINTIPRIE")
    private int tipoRiesgo;
    @Column(name = "AINFECING")
    private LocalDateTime fechaIngreso;
    @Column(name = "AINESTADO")
    private int estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="GENPACIEN", referencedColumnName = "OID")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "HPNDEFCAM", referencedColumnName = "OID")
    private Cama cama;

    public Ingreso(){ }

    public Ingreso(Integer id, int consecutivo, int centroAtencion, int tipoIngreso, int causa, int tipoRiesgo, Paciente paciente, Cama cama, LocalDateTime fechaIngreso, int estado) {
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

    public boolean isEstadoRegistrado(){
        return getEstado()==0;
    }

    public boolean isCamaVinculada(){
        return getCama() != null;
    }
    public String getCodigoCamaVinculada(){
        return getCama().getCodigoCama();
    }

    public int getIdPaciente(){
        return getPaciente().getId();
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

    public int getCentroAtencion() {
        return centroAtencion;
    }

    public void setCentroAtencion(int centroAtencion) { this.centroAtencion = centroAtencion; }

    public int getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(int tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public int getCausa() {
        return causa;
    }

    public void setCausa(int causa) {
        this.causa = causa;
    }

    public int getTipoRiesgo() {
        return tipoRiesgo;
    }

    public void setTipoRiesgo(int tipoRiesgo) {
        this.tipoRiesgo = tipoRiesgo;
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

