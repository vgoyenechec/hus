package hus.censoCamas.security.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "HPNCENSOUSU")
@Table(name = "HPNCENSOUSU")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OID",updatable = false,nullable = false)
    private Integer id;
    @Column(name = "HPNUSUNOMBRE")
    private String usuario;
    @Column(name = "HPNUSUDESCRI")
    private String nombre;
    @Column(name = "HPNUSUCLAVE")
    private String clave;
    @Column(name = "HPNUSUESTADO")
    private int estado;
    @Column(name = "HPNUSUULTAUT")
    private LocalDateTime ultimaAutenticacion;
    @Column(name = "HPNUSUFALLO1")
    private int fallosClave;
    @Column(name = "HPNUSUAUTENT")
    private boolean autenticado;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "HPNUSU_ROL", joinColumns = @JoinColumn(name="OIDROL", referencedColumnName = "OID"),
            inverseJoinColumns = @JoinColumn(name = "OIDUSUARIO", referencedColumnName = "OID") )
    private Set<Rol> roles = new HashSet<>();

    public Usuario(){}

    public Usuario(String usuario, String nombre, String clave, int estado,
                   LocalDateTime ultimaAutenticacion, int fallosClave, boolean autenticado) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.clave = clave;
        this.estado = estado;
        this.ultimaAutenticacion = ultimaAutenticacion;
        this.fallosClave = fallosClave;
        this.autenticado = autenticado;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public LocalDateTime getUltimaAutenticacion() {
        return ultimaAutenticacion;
    }

    public void setUltimaAutenticacion(LocalDateTime ultimaAutenticacion) {
        this.ultimaAutenticacion = ultimaAutenticacion;
    }

    public int getFallosClave() {
        return fallosClave;
    }

    public void setFallosClave(int fallosClave) {
        this.fallosClave = fallosClave;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
