package hus.censoCamas.security.model;

import hus.censoCamas.security.constant.Roles;

import javax.persistence.*;

@Entity(name ="HPNCENSOROL" )
@Table(name = "HPNCENSOROL")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OID",updatable = false,nullable = false)
    private Integer id;
    @Column(name = "HPNROLNOMBRE")
    private String nombre;

    public Rol() { }

    public Rol(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Rol(Roles rol) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
