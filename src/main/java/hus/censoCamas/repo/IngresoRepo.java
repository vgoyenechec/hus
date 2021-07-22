package hus.censoCamas.repo;

import hus.censoCamas.model.Ingreso;
import hus.censoCamas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IngresoRepo extends JpaRepository<Ingreso, Long> {
    Optional<Ingreso> findIngresoById(Long id);

    void deleteIngresoById(Long id);


}
