package hus.censoCamas.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "HPNTIPOCA")
public class Tipocama implements Serializable {
    @Id
    @Column(name = "OID")
    private Integer id;
    @Column(name = "HTICODIGO")
    private String codigo;
    @Column(name = "HTINOMBRE")
    private String nombre;

    public Tipocama() {
    }

    public Tipocama(Integer id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
