package hus.censoCamas.repo;

import hus.censoCamas.model.Cama;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CamaRepo extends JpaRepository<Cama, Integer> {
    Optional<Cama> findCamaById(Integer id);
    void deleteCamaById(Integer id);

    List<Cama> findByGrupoAndSubgrupoAndTipo(int grupo, int subgrupo, int tipo);
    List<Cama> findByGrupoAndSubgrupo(int grupo, int subgrupo);
    List<Cama> findByGrupo(int grupo);
    Cama findByCodigo(int codigo);


}
