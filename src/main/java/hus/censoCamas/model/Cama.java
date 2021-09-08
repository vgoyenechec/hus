package hus.censoCamas.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "HPNDEFCAM")
public class Cama implements Serializable{
    @Id
    @Column(name = "OID", updatable = false,nullable = false)
    private Integer id;

    @Column(name = "HCACODIGO")
    private String codigo;
    @Column(name = "HCANOMBRE")
    private String nombre;
    @Column(name = "HPNGRUPOS")
    private int grupo;
    @Column(name = "HPNSUBGRU")
    private int subgrupo;
    @Column(name = "HPNTIPOCA")
    private int tipo;
    @Column(name = "HCAESTADO")
    private int estado;

    public Cama(){
        
    }

    public Cama(Integer id, String  codigo, String nombre, int grupo, int subgrupo, int tipo, int estado) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getIdCama() {
        return id;
    }

    public void setIdCama(int idCama) {
        this.id = idCama;
    }

    public String getCodigoCama() {
        return codigo;
    }

    public void setCodigoCama(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreCama() {
        return nombre;
    }

    public void setNombreCama(String nombre) {
        this.nombre = nombre;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(int subgrupo) {
        this.subgrupo = subgrupo;
    }

    public int getTipoCama() {
        return tipo;
    }

    public void setTipoCama(int tipo) {
        this.tipo = tipo;
    }

    public int getEstadoCama() {
        return estado;
    }

    public void setEstadoCama(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Camas{" +
                "codigo=" + codigo +
                ", descripcion='" + nombre + '\'' +
                ", grupo='" + grupo + '\'' +
                ", subgrupo='" + subgrupo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
