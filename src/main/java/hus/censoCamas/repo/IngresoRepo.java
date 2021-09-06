package hus.censoCamas.repo;

import hus.censoCamas.model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IngresoRepo extends JpaRepository<Ingreso, Integer> {
    Optional<Ingreso> findIngresoById(Integer id);

    Optional<Ingreso> findIngresoByConsecutivo(int consecutivo);

    @Query(value = "Select top(1) * from ADNINGRESO \n" +
            "where GENPACIEN LIKE ?1 \n" +
            "Order by AINFECING desc", nativeQuery = true)
    Optional<Ingreso> findByPacienteOrderByFechaIngresoDesc(int paciente);


    void deleteIngresoById(Integer id);

}
