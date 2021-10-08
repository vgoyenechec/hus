package hus.censoCamas.model;

public class PacienteDTO {
    private String paciente;
    private String documento;
    private String consecutivo;
    private String fechaIngreso;

    public PacienteDTO(String[] paciente) {
        this.paciente = paciente[0];
        this.documento = paciente[1];
        this.consecutivo = paciente[2];
        this.fechaIngreso = paciente[3];
    }

    public String getPaciente() {
        return paciente;
    }

    public String getDocumento() {
        return documento;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }
}
