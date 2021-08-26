package hus.censoCamas.model;

import java.time.LocalDateTime;

public class IngresoPaciente {
    private String documento;
    private String prinom;
    private String segnom;
    private String priape;
    private String segape;
    private int consecutivo;
    private LocalDateTime fechaIngreso;
    private String centroAtencion;
    private int estado;
    private int tipoIngreso;
    private int causa;
    private int tipoRiesgo;

    public IngresoPaciente(String documento, String prinom, String segnom, String priape, String segape, int consecutivo, LocalDateTime fechaIngreso, String centroAtencion, int estado, int tipoIngreso, int causa, int tipoRiesgo) {
        this.documento = documento;
        this.prinom = prinom;
        this.segnom = segnom;
        this.priape = priape;
        this.segape = segape;
        this.consecutivo = consecutivo;
        this.fechaIngreso = fechaIngreso;
        this.centroAtencion = centroAtencion;
        this.estado = estado;
        this.tipoIngreso = tipoIngreso;
        this.causa = causa;
        this.tipoRiesgo = tipoRiesgo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPrinom() {
        return prinom;
    }

    public void setPrinom(String prinom) {
        this.prinom = prinom;
    }

    public String getSegnom() {
        return segnom;
    }

    public void setSegnom(String segnom) {
        this.segnom = segnom;
    }

    public String getPriape() {
        return priape;
    }

    public void setPriape(String priape) {
        this.priape = priape;
    }

    public String getSegape() {
        return segape;
    }

    public void setSegape(String segape) {
        this.segape = segape;
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

    public String getCentroAtencion() {
        return centroAtencion;
    }

    public void setCentroAtencion(String centroAtencion) {
        this.centroAtencion = centroAtencion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

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
}
