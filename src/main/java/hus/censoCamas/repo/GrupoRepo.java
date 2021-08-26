package hus.censoCamas.repo;

import hus.censoCamas.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupoRepo extends JpaRepository<Grupo, Integer> {
    List<Grupo> findAll();
    Grupo findByNombre(String nombre);
}

