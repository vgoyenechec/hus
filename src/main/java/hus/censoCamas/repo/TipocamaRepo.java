package hus.censoCamas.repo;

import hus.censoCamas.model.Tipocama;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface TipocamaRepo extends JpaRepository<Tipocama, Integer> {
    List<Tipocama> findAll();
    Tipocama findByNombre(String nombre);

    @Query(value = "select distinct t.HTINOMBRE\n" +
            "from HPNDEFCAM as c\n" +
            "join HPNTIPOCA as t\n" +
            "on c.HPNTIPOCA = t.oid \n" +
            "join HPNSUBGRU as s\n" +
            "on c.HPNSUBGRU = s.oid\n" +
            "JOIN HPNGRUPOS as g\n" +
            "on c.HPNGRUPOS = g.oid\n" +
            "where g.HGRNOMBRE like ?1\n" +
            "and s.hsunombre like ?2\n", nativeQuery = true)
    List<String> findByGrupoSubgrupo(String grupo, String subgrupo);


}
