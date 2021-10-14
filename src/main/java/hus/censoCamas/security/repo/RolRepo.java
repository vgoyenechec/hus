package hus.censoCamas.security.repo;

import hus.censoCamas.security.constant.Roles;
import hus.censoCamas.security.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepo extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByNombre(Roles nombre);
}
