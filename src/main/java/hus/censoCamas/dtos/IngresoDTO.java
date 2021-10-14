package hus.censoCamas.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class IngresoDTO {
    private String documento;
    private String paciente;
    private int consecutivo;
    private LocalDate fechaIngreso;
    private String estado;
    private String tipoIngreso;
    private String causaIngreso;
    private String tipoRiesgo;

    public IngresoDTO(){}

    public IngresoDTO(String documento, String paciente, int consecutivo, LocalDate fechaIngreso, String estado, String tipoIngreso, String causaIngreso, String tipoRiesgo) {
        this.documento = documento;
        this.paciente = paciente;
        this.consecutivo = consecutivo;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.tipoIngreso = tipoIngreso;
        this.causaIngreso = causaIngreso;
        this.tipoRiesgo = tipoRiesgo;
    }

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

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
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
}
