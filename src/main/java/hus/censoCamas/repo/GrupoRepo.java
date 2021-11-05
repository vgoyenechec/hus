package hus.censoCamas.repo;

import hus.censoCamas.model.Grupo;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface GrupoRepo extends JpaRepository<Grupo, Integer> {
    List<Grupo> findAll();
    Grupo findByNombre(String nombre);
    @Query(value = "Select DISTINCT g.HGRNOMBRE from HPNGRUPOS as g", nativeQuery = true)
    List<String>findAllNombre();
}

