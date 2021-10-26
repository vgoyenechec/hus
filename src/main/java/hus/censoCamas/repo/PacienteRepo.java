package hus.censoCamas.repo;

import hus.censoCamas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PacienteRepo extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findPacienteById(Integer id);

    @Query(value = "select * \n" +
            "FROM [GENPACIEN]\n" +
            "where replace(ISNULL(PACPRINOM,'')+' '+ISNULL(PACSEGNOM,'')+' '+ISNULL(PACPRIAPE,'')+' '+ISNULL(PACSEGAPE,''), '   ',' ') LIKE %?1% \n",
            nativeQuery = true)
    List<Paciente> findPacienteByNombreContaining(String nombre);

    @Query(value = "select * \n" +
            "FROM [GENPACIEN]\n" +
            "where PACNUMDOC like ?1% \n",
            nativeQuery = true)
    Optional<List<Paciente>> findByDocumentoStartsWith(String documento);

    Optional<Paciente> findByDocumento(String documento);
}
