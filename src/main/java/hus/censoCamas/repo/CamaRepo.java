package hus.censoCamas.repo;

import hus.censoCamas.model.Cama;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface CamaRepo extends JpaRepository<Cama, Integer> {

    @Query(value = "select distinct c.* \n"+
            "from HPNDEFCAM as c                \n"+
            "JOIN HPNTIPOCA as t                \n"+
            "on c.HPNTIPOCA = t.oid             \n"+
            "JOIN HPNSUBGRU as s                \n"+
            "on c.HPNSUBGRU = s.oid             \n"+
            "JOIN HPNGRUPOS as g                \n"+
            "on c.HPNGRUPOS = g.oid             \n"+
            "where g.HGRNOMBRE like ?1       \n"+
            "and s.hsunombre like ?2 \n" +
            "and t.HTINOMBRE like '%'+ ?3 \n" +
            "and (c.HCAESTADO like '%'+ ?4)",nativeQuery = true)
    List<Cama> findByGrupoAndSubgrupoAndTipoAndEstado(String grupo, String subgrupo, String tipo, String estado);

    @Query(value = "select distinct c.* \n"+
            "from HPNDEFCAM as c                \n"+
            "JOIN HPNSUBGRU as s                \n"+
            "on c.HPNSUBGRU = s.oid             \n"+
            "JOIN HPNGRUPOS as g                \n"+
            "on c.HPNGRUPOS = g.oid             \n"+
            "where g.HGRNOMBRE like ?1       \n"+
            "and S.hsunombre like ?2 ",nativeQuery = true)
    List<Cama> findByGrupoAndSubgrupo(String grupo, String subgrupo);

    @Query(value = "select distinct c.* \n"+
            "from HPNDEFCAM as c                \n"+
            "JOIN HPNGRUPOS as g                \n"+
            "on c.HPNGRUPOS = g.oid             \n"+
            "where g.HGRNOMBRE like ?1 ",nativeQuery = true)
    List<Cama> findByGrupo(String grupo);

    Optional<Cama> findByCodigo(String codigo);

    @Query(value = "select * \n"+
            "from HPNDEFCAM as c \n"+
            "where c.HCACODIGO like ?1 \n" +
            "and c.HCAESTADO like '1' ",nativeQuery = true)
    Optional<Cama> findByCodigoAndDesocupada(String codigo);


    @Query(value = "select top (1) replace(ISNULL(PACPRINOM,'')+' '+ISNULL(PACSEGNOM,'')+' '+ISNULL(PACPRIAPE,'')+' '+ISNULL(PACSEGAPE,''), '   ',' ') as paciente, g.pacnumdoc as documento, i.AINCONSEC as consecutivo, i.AINFECING as fechaIngreso\n" +
            "from GENPACIEN as g\n" +
            "join ADNINGRESO as i\n" +
            "on g.oid = i.GENPACIEN\n" +
            "where i.HPNDEFCAM like ?1\n" +
            "and i.AINESTADO like '0'\n"+
            "order by i.AINFECING desc ", nativeQuery = true)
    String findPaciente(int cama);

    @Query(value = "select top (1) replace(ISNULL(PACPRINOM,'')+' '+ISNULL(PACSEGNOM,'')+' '+ISNULL(PACPRIAPE,'')+' '+ISNULL(PACSEGAPE,''), '   ',' ') as paciente, g.pacnumdoc as documento, i.AINCONSEC as consecutivo, i.AINFECING as fechaIngreso\n" +
            "from GENPACIEN as g\n" +
            "join ADNINGRESO as i\n" +
            "on g.oid = i.GENPACIEN\n" +
            "where i.HPNDEFCAM like ?1\n" +
            "order by i.AINFECING desc ", nativeQuery = true)
    String findPacienteFinal(int cama);
}
