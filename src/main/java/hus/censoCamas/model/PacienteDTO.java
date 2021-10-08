package hus.censoCamas.model;

public class PacienteDTO {
    private String paciente;
    private String documento;
    private String consecutivo;
    private String fechaIngreso;

    public PacienteDTO() { }

    public PacienteDTO(String paciente, String documento, String consecutivo, String fechaIngreso) {
        this.paciente = paciente;
        this.documento = documento;
        this.consecutivo = consecutivo;
        this.fechaIngreso = fechaIngreso;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
