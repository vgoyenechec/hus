package hus.censoCamas.service;
import hus.censoCamas.exception.ObjectNotFoundException;
import hus.censoCamas.model.Paciente;
import hus.censoCamas.repo.PacienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PacienteService {
    private final PacienteRepo pacienteRepo;

    @Autowired
    public PacienteService(PacienteRepo pacienteRepo){
        this.pacienteRepo = pacienteRepo;
    }

    public Paciente findPacienteById(Integer id){
        return pacienteRepo.findPacienteById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Paciente identificado con el ID "+id+"no se ha encontrado"));
    }

    public List<Paciente> findPacienteByName(String nombrePaciente){
        return pacienteRepo.findPacienteByNombreContaining(nombrePaciente);
    }

    public List<Paciente> findPacienteByDocumento(String documento){
        return pacienteRepo.findByDocumentoStartsWith(documento);
    }
}
