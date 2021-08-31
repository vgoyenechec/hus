package hus.censoCamas.repo;

import hus.censoCamas.model.Tipocama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TipocamaRepo extends JpaRepository<Tipocama, Integer> {
    List<Tipocama> findAll();
    Tipocama findByNombre(String nombre);

    @Query(value = "select distinct s.HTINOMBRE\n" +
            "from HPNDEFCAM as c\n" +
            "join HPNTIPOCA as s\n" +
            "on c.HPNTIPOCA = s.oid \n" +
            "where c.HPNGRUPOS like ?1\n" +
            "and c.HPNSUBGRU like ?2", nativeQuery = true)
    List<Object[]> findByGrupoSubgrupo(int grupo, int subgrupo);

}
