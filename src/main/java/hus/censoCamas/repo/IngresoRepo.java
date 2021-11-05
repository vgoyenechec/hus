package hus.censoCamas.repo;

import hus.censoCamas.model.Ingreso;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface IngresoRepo extends JpaRepository<Ingreso, Integer> {
    @Query(value = "Select * from ADNINGRESO \n" +
            "where AINCONSEC LIKE ?1 \n" +
            "and AINESTADO like '0'", nativeQuery = true)
    Optional<Ingreso> findIngresoRegistradoByConsecutivo(int consecutivo);

    @Query(value = "Select i.*\n" +
            "from ADNINGRESO as i \n" +
            "join GENPACIEN as p\n" +
            "on i.genpacien = p.oid\n" +
            "where replace(ISNULL(PACPRINOM,'')+' '+ISNULL(PACSEGNOM,'')+' '+ISNULL(PACPRIAPE,'')+' '+ISNULL(PACSEGAPE,''), '   ',' ') LIKE %?1% \n" +
            "and i.ainestado like '0'\n" +
            "order by i.ainfecing desc", nativeQuery = true)
    Optional<List<Ingreso>> findIngresoRegistradoByPacienteNombre(String nombre);

    @Query(value = "Select i.*\n" +
            "from ADNINGRESO as i \n" +
            "join GENPACIEN as p\n" +
            "on i.genpacien = p.oid\n" +
            "where p.PACNUMDOC LIKE %?1% \n" +
            "and i.ainestado like '0'\n" +
            "order by i.ainfecing desc", nativeQuery = true)
    Optional<List<Ingreso>> findIngresoRegistradoByPacienteDocumento(String documento);

    @Query(value = "Select top(1) i.* from ADNINGRESO as i\n" +
            "join GENPACIEN as p \n" +
            "on p.oid = i.GENPACIEN  \n" +
            "where i.GENPACIEN LIKE ?1 \n" +
            "and i.AINESTADO like '0' \n" +
            "Order by i.AINFECING desc", nativeQuery = true)
    Optional<Ingreso> findByPacienteOrderByFechaIngresoDesc(int paciente);
}
