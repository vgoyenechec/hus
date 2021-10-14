package hus.censoCamas.security.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "HPNCENSOUSU")
@Table(name = "HPNCENSOUSU")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "OID",updatable = false,nullable = false)
    private Integer id;
    @NotNull @Column(name = "HPNUSUNOMBRE")
    private String usuario;
    @NotNull @Column(name = "HPNUSUDESCRI", nullable = false)
    private String nombre;
    @NotNull @Column(name = "HPNUSUCLAVE")
    private String clave;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "HPNUSUROL", joinColumns = @JoinColumn(name="OIDROL", referencedColumnName = "OID"),
            inverseJoinColumns = @JoinColumn(name = "OIDUSUARIO", referencedColumnName = "OID") )
    private Set<Rol> roles = new HashSet<>();

    public Usuario(){}

    public Usuario(String usuario, String nombre, String clave) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.clave = clave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
