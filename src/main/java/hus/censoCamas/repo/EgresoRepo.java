package hus.censoCamas.repo;

import hus.censoCamas.model.Egreso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EgresoRepo extends JpaRepository<Egreso, Integer> {
    void deleteByIdEgreso(int idEgreso);
}

