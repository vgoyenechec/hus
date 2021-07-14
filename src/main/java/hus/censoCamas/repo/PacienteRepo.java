package hus.censoCamas.repo;

import hus.censoCamas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PacienteRepo extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findPacienteById(Integer id);

    void deletePacienteById(Integer id);

    @Query(value = "select * \n" +
            "FROM [DGEmpres81].[dbo].[GENPACIEN]\n" +
            "where ISNULL(PACPRINOM,'') + ' ' + ISNULL(PACSEGNOM,'') + ' ' + ISNULL(PACPRIAPE,'') + ' ' + ISNULL(PACSEGAPE,'') LIKE '%?1%';\n",
            nativeQuery = true)
    List<Paciente> findPacienteByNombreContaining(String nombre);

    List<Paciente> findByDocumentoContaining(String documento);
}
