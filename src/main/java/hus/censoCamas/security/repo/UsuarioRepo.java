package hus.censoCamas.security.repo;

import hus.censoCamas.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
    void deleteByUsuario(String usuario);

    Optional<Usuario> findByUsuario(String usuario);

    boolean existsByUsuario(String usuario);

}
