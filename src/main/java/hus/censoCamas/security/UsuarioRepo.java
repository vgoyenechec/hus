package hus.censoCamas.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {


    Optional<Usuario> findUsuarioById(Long id);

    void deleteUsuarioById(Long id);

    Optional<Usuario> findByUsuario(String usuario);

}
