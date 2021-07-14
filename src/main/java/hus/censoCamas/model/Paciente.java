package hus.censoCamas.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "GENPACIEN")
public class Paciente implements Serializable {
    @Id
    @Column(updatable = false,nullable = false)
    private Integer id;
    @Column(name = "PACNUMDOC")
    private String documento;
    @Column(name = "PACTIPDOC")
    private int tipoDocumento;
    @Column(name = "PACEXPEDI")
    private String lugarExpedicion;
    @Column(name = "PACPRINOM")
    private String prinom;
    @Column(name = "PACSEGNOM")
    private String segnom;
    @Column(name = "PACPRIAPE")
    private String priape;
    @Column(name = "PACSEGAPE")
    private String segape;
    @Column(name = "GPAFECNAC")
    private LocalDateTime fechaNacimiento;
    @Column(name = "GPASEXPAC")
    private String sexo;


    public Paciente() {
    }

    public Paciente(String documento, int tipoDocumento, String lugarExpedicion, String prinom, String segnom, String priape, String segape, LocalDateTime fechaNacimiento, String sexo) {
        this.documento = documento;
        this.tipoDocumento = tipoDocumento;
        this.lugarExpedicion = lugarExpedicion;
        this.prinom = prinom;
        this.segnom = segnom;
        this.priape = priape;
        this.segape = segape;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getPrimerNombre() {
        return prinom;
    }

    public void setPrimerNombre(String prinom) {
        this.prinom = prinom;
    }

    public String getSegundoNombre() {
        return segnom;
    }

    public void setSegundoNombre(String segnom) {
        this.segnom = segnom;
    }

    public String getPrimerApellido() {
        return priape;
    }

    public void setPrimerApellido(String priape) {
        this.priape = priape;
    }

    public String getSegundoApellido() {
        return segape;
    }

    public void setSegundoApellido(String segape) {
        this.segape = segape;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "documento='" + documento + '\'' +
                ", tipoDocumento=" + tipoDocumento +
                ", lugarExpedicion='" + lugarExpedicion + '\'' +
                ", Primer Nombre='" + prinom + '\'' +
                ", Segundo Nombre='" + segnom + '\'' +
                ", Primer Apellido='" + priape + '\'' +
                ", Segundo Apellido='" + segape + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
