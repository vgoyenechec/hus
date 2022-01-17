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
    @Column(name = "PACPRINOM")
    private String prinom;
    @Column(name = "PACSEGNOM")
    private String segnom;
    @Column(name = "PACPRIAPE")
    private String priape;
    @Column(name = "PACSEGAPE")
    private String segape;


    public Paciente() {
    }

    public Paciente(Integer id, String documento, String prinom, String segnom, String priape, String segape) {
        this.id = id;
        this.documento = documento;
        this.prinom = prinom;
        this.segnom = segnom;
        this.priape = priape;
        this.segape = segape;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getDocumento() {
        return documento;
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

    public String getNombreCompleto(){
        return getPrimerNombre()+' '+getSegundoNombre()+' '+getPrimerApellido()+' '+getSegundoApellido();
    }

}
