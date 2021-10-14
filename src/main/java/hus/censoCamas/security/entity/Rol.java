package hus.censoCamas.security.entity;

import hus.censoCamas.security.constant.Roles;

import javax.management.relation.Role;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "HPNCENSOROL")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "OID", updatable = false, nullable = false)
    private Integer id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "HPNROLNOMBRE")
    private Roles nombre;

    public Rol() {
    }

    public Rol(@NotNull Roles nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Roles getNombre() {
        return nombre;
    }

    public void setNombre(Roles nombre) {
        this.nombre = nombre;
    }
}
