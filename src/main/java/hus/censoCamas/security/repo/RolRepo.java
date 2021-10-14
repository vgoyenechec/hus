package hus.censoCamas.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepo extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByNombre(String nombre);
}
