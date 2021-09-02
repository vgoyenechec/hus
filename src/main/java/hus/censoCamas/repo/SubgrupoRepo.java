package hus.censoCamas.repo;

import hus.censoCamas.model.Subgrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubgrupoRepo extends JpaRepository<Subgrupo, Integer> {
    List<Subgrupo> findAll();

    Subgrupo findByNombre(String nombre);

    @Query(value = "select distinct s.hsunombre as nombreSubgrupo\n" +
            "from HPNDEFCAM as c\n" +
            "join HPNSUBGRU as s\n" +
            "on c.HPNSUBGRU = s.oid\n" +
            "JOIN HPNGRUPOS as g\n" +
            "on c.HPNGRUPOS = g.oid\n" +
            "where g.HGRNOMBRE like ?1 ", nativeQuery = true)
    List<String> findByGrupo(String grupo);
}