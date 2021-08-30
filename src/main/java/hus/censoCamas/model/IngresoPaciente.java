package hus.censoCamas.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class IngresoPaciente {
    @JsonProperty("documento")
    private String documento;
    @JsonProperty("paciente")
    private String paciente;
    @JsonProperty("consecutivo")
    private int consecutivo;
    @JsonProperty("fechaIngreso")
    private LocalDate fechaIngreso;
    @JsonProperty("estadoIngreso")
    private String estado;
    @JsonProperty("tipoIngreso")
    private String tipoIngreso;
    @JsonProperty("causaIngreso")
    private String causaIngreso;
    @JsonProperty("tipoRiesgo")
    private String tipoRiesgo;

    public IngresoPaciente(){}

    public IngresoPaciente(String documento, String paciente, int consecutivo, LocalDate fechaIngreso, String estado, String tipoIngreso, String causaIngreso, String tipoRiesgo) {
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

