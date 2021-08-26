package hus.censoCamas.repo;

import hus.censoCamas.model.Subgrupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubgrupoRepo extends JpaRepository<Subgrupo, Integer> {
    List<Subgrupo> findAll();
    Subgrupo findByNombre(String nombre);
}