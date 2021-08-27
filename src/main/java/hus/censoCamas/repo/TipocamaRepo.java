package hus.censoCamas.repo;

import hus.censoCamas.model.Tipocama;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TipocamaRepo extends JpaRepository<Tipocama, Integer> {
    List<Tipocama> findAll();
    Tipocama findByNombre(String nombre);

}
