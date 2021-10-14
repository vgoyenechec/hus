package hus.censoCamas.security.dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {
    @NotBlank
    private String usuario;
    @NotBlank
    private String clave;

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
}
