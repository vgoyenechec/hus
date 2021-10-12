package hus.censoCamas.security;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "GENUSUARIO")
public class Usuario implements Serializable{
    @Id
    @Column(name = "OID",updatable = false,nullable = false)
    private Integer id;
    @Column(name = "GENROL")
    private int rol;
    @Column(name = "USUNOMBRE")
    private String usuario;
    @Column(name = "USUDESCRI")
    private String descripcion;
    @Column(name = "USUCLAVE")
    private String clave;
    @Column(name = "USUESTADO")
    private int estado;
    @Column(name = "USUULTAUT")
    private LocalDateTime ultimaAutenticacion;
    @Column(name = "USUFALLO1")
    private int fallosClave;
    @Column(name = "USUAUTENT")
    private boolean autenticado;
    @Transient
    private String[] permisos;


    public Usuario(){}

    public Usuario(int rol, String usuario, String descripcion, String clave, int estado, LocalDateTime ultimaAutenticacion, int fallosClave, boolean autenticado, String[] permisos) {
        this.rol = rol;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.clave = clave;
        this.estado = estado;
        this.ultimaAutenticacion = ultimaAutenticacion;
        this.fallosClave = fallosClave;
        this.autenticado = autenticado;
        this.permisos = permisos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String[] getPermisos() {
        return permisos;
    }

    public void setPermisos(String[] permisos) {
        this.permisos = permisos;
    }
}
