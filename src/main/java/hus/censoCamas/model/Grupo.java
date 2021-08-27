package hus.censoCamas.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="HPNGRUPOS")
public class Grupo implements Serializable {
    @Id
    @Column(name = "OID")
    private Integer id;
    @Column(name = "HGRCODIGO")
    private String codigo;
    @Column(name = "HGRNOMBRE")
    private String nombre;

    public Grupo() {
    }

    public Grupo(int id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
