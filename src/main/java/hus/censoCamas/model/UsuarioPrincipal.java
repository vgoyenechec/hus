package hus.censoCamas.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class UsuarioPrincipal implements UserDetails {
    private Usuario usuario;

    public UsuarioPrincipal(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return stream(this.usuario.getPermisos()).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.usuario.getClave();
    }

    @Override
    public String getUsername() {
        return this.usuario.getUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.usuario.getEstado() == 4;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.usuario.getEstado() == 99;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.usuario.isAutenticado();
    }
}
