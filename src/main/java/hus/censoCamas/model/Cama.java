package hus.censoCamas.model;

import hus.censoCamas.exception.ObjectNotFoundException;

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
    @Column(name = "HCAESTADO")
    private int estado;

    @OneToOne
    @JoinColumn(name = "HPNGRUPOS", referencedColumnName = "OID")
    private Grupo grupo;

    @OneToOne
    @JoinColumn(name = "HPNSUBGRU", referencedColumnName = "OID")
    private Subgrupo subgrupo;

    @OneToOne
    @JoinColumn(name = "HPNTIPOCA", referencedColumnName = "OID")
    private Tipocama tipo;


    public Cama(){
        
    }

    public Cama(Integer id, String  codigo, String nombre, Grupo grupo, Subgrupo subgrupo, Tipocama tipo, int estado) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.tipo = tipo;
        this.estado = estado;
    }

    public void liberarCama(){ setEstadoCama(1); }

    public void ocuparCama(){ setEstadoCama(2); }

    public void bloquearCama(){ setEstadoCama(3); }

    public boolean isDesocupada(){ return getEstadoCama() == 1; }

    public boolean isOcupada(){
        return getEstadoCama() == 2;
    }

    public boolean isBloqueada(){
        return getEstadoCama() == 3;
    }

    public void checkEstado(){
        if(isBloqueada()){
            throw new ObjectNotFoundException("\nCama Bloqueada!");
        }
        else{ throw new ObjectNotFoundException("\nLa cama "+getCodigoCama()+ " ya está disponible"); }
    }

    public int getIdCama() {
        return id;
    }

    public String getCodigoCama() {
        return codigo;
    }

    public String getNombreCama() {
        return nombre;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public Subgrupo getSubgrupo() {
        return subgrupo;
    }

    public Tipocama getTipoCama() {
        return tipo;
    }

    public int getEstadoCama() { return estado; }

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
