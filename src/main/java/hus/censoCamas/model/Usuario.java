package hus.censoCamas.model;

import javax.persistence.*;

@Entity(name = "GENUSUARIO")
public class Usuario {
    @Id
    @Column(updatable = false,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String usuario;
    private String nombreUsuario;
    private String tipoUsuario;
    private String clave;

    public Usuario(){}

    public Usuario(int id, String usuario, String nombreUsuario, String tipoUsuario, String clave) {
        this.id = id;
        this.usuario = usuario;
        this.nombreUsuario = nombreUsuario;
        this.tipoUsuario = tipoUsuario;
        this.clave = clave;
    }

    public int getIdUsuario() {
        return id;
    }

    public void setIdUsuario(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }
}
