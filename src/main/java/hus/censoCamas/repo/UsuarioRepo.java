package hus.censoCamas.repo;

import hus.censoCamas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {


    Optional<Usuario> findUsuarioById(Long id);

    void deleteUsuarioById(Long id);

    List<Usuario> findUsuarioByUsuarioContaining(String usuario);
}
