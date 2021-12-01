package hus.censoCamas.dtos;

import java.time.LocalDateTime;

public class IngresoDTO {
    private String documento;
    private String paciente;
    private String cama;
    private int consecutivo;
    private LocalDateTime fechaIngreso;
    private String estado;
    private String tipoIngreso;
    private String causaIngreso;
    private String tipoRiesgo;

    public IngresoDTO(){}

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }

    public String getCausaIngreso() {
        return causaIngreso;
    }

    public void setCausaIngreso(String causaIngreso) {
        this.causaIngreso = causaIngreso;
    }

    public String getTipoRiesgo() {
        return tipoRiesgo;
    }

    public void setTipoRiesgo(String tipoRiesgo) {
        this.tipoRiesgo = tipoRiesgo;
    }

    public void setCama(String cama) { this.cama = cama;  }

    public String getCama() {
        return cama;
    }

    @Override
    public String toString() {
        return "IngresoDTO{" +
                "documento='" + documento + '\'' +
                ", paciente='" + paciente + '\'' +
                ", cama='" + cama + '\'' +
                ", consecutivo=" + consecutivo +
                ", fechaIngreso=" + fechaIngreso +
                ", estado='" + estado + '\'' +
                ", tipoIngreso='" + tipoIngreso + '\'' +
                ", causaIngreso='" + causaIngreso + '\'' +
                ", tipoRiesgo='" + tipoRiesgo + '\'' +
                '}';
    }
}

