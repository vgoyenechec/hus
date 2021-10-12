package hus.censoCamas.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "GENPACIEN")
public class Paciente implements Serializable{
    @Id
    @Column(name="OID",updatable = false,nullable = false)
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
    private int sexo;


    public Paciente() {
    }

    public Paciente(Integer id, String documento, int tipoDocumento, String lugarExpedicion, String prinom, String segnom, String priape, String segape, LocalDateTime fechaNacimiento, int sexo) {
        this.id = id;
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

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public String getPrimerNombre() {
        return prinom;
    }

    public String getSegundoNombre() {
        return segnom;
    }

    public String getPrimerApellido() {
        return priape;
    }

    public String getSegundoApellido() { return segape; }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getSexo() {
        return sexo;
    }

    public String getNombreCompleto(){
        return getPrimerNombre()+' '+getSegundoNombre()+' '+getPrimerApellido()+' '+getSegundoApellido();
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
