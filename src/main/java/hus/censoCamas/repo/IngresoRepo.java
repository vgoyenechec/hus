package hus.censoCamas.repo;

import hus.censoCamas.model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IngresoRepo extends JpaRepository<Ingreso, Integer> {
    Optional<Ingreso> findIngresoById(Integer id);

    Optional<Ingreso> findIngresoByConsecutivo(int consecutivo);

    void deleteIngresoById(Integer id);

    Optional<Ingreso> findFirstByOrderByFechaIngresoDesc();

    @Query(value = "SELECT p.PACNUMDOC, p.PACPRINOM+' '+p.PACSEGNOM+' '+p.PACPRIAPE+' '+p.PACSEGAPE,i.AINCONSEC, i.AINFECING, i.AINESTADO, i.AINTIPING, i.AINCAUING, i.AINTIPRIE\n" +
            "FROM ADNINGRESO as i\n" +
            "JOIN GENPACIEN as p\n" +
            "on i.GENPACIEN = p.OID\n" +
            "where p.PACNUMDOC  like ?1%",
            nativeQuery = true)
    Optional<List<Object[]>> findByPacienteDoc(String documento);

    @Query(value = "SELECT p.PACNUMDOC, p.PACPRINOM+' '+p.PACSEGNOM+' '+p.PACPRIAPE+' '+p.PACSEGAPE,i.AINCONSEC, i.AINFECING, i.AINESTADO, i.AINTIPING, i.AINCAUING, i.AINTIPRIE\n" +
            "FROM ADNINGRESO as i\n" +
            "JOIN GENPACIEN as p\n" +
            "on i.GENPACIEN = p.OID\n" +
            "where ISNULL(p.PACPRINOM,'') + ' ' + ISNULL(p.PACSEGNOM,'') + ' ' + ISNULL(p.PACPRIAPE,'') + ' ' + ISNULL(p.PACSEGAPE,'')  like %?1%",
            nativeQuery = true)
    Optional<List<Object[]>> findByPacienteNombre(String nombre);



}
