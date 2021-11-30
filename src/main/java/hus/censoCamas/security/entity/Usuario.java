package hus.censoCamas.security.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "HPNCENSOUSU")
@Table(name = "HPNCENSOUSU")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name="user_generator", sequenceName = "user_sequence", allocationSize=1)
    @Column(name = "OID",updatable = false, nullable = false)
    private Integer id;
    @NotNull @Column(name = "HPNUSUNOMBRE")
    private String usuario;
    @NotNull @Column(name = "HPNUSUDESCRI", nullable = false)
    private String nombre;
    @NotNull @Column(name = "HPNUSUCLAVE")
    private String clave;
    @Column(name = "HPNUSUESTADO")
    private boolean isEnabled;
    @Column(name = "HPNUSUCAMBIOCLAVE")
    private int cambioClave;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "HPNUSUROL", joinColumns = @JoinColumn(name = "OIDUSUARIO"),
            inverseJoinColumns = @JoinColumn(name = "OIDROL") )
    private Set<Rol> roles = new HashSet<>();

    public Usuario(){}

    public Usuario(String usuario, String nombre, String clave) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.clave = clave;
        this.cambioClave = 0;
        this.isEnabled = true;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void disable() {
        this.isEnabled = false;
    }

    public void enable() {
        this.isEnabled = true;
    }

    public int getCambioClave() {
        return cambioClave;
    }

    public void setCambioClave(int cambioClave) {
        this.cambioClave = cambioClave;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
