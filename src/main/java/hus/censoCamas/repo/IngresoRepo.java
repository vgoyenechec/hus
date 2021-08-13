package hus.censoCamas.repo;

import hus.censoCamas.model.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngresoRepo extends JpaRepository<Ingreso, Integer> {
    Optional<Ingreso> findIngresoById(Integer id);

    Optional<Ingreso> findIngresoByConsecutivo(int consecutivo);

    void deleteIngresoById(Integer id);

    Optional<Ingreso> findFirstByOrderByFechaIngresoDesc();




}
