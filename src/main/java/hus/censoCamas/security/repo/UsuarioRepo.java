package hus.censoCamas.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
    void deleteUsuarioById(Long id);

    Optional<Usuario> findByUsuario(String usuario);

}
