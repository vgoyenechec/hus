package hus.censoCamas.service;
import hus.censoCamas.exception.UserNotFoundException;
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

    public Paciente addPaciente(Paciente paciente){
        return pacienteRepo.save(paciente);
    }
    public List<Paciente> findAllPacientes(){
        return pacienteRepo.findAll();
    }
    public Paciente updatePaciente(Paciente paciente){
        return pacienteRepo.save(paciente);
    }

    public Paciente findPacienteById(Integer id){
        return pacienteRepo.findPacienteById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id "+id+" was not found"));
    }

    public void deletePaciente(Integer id){
        pacienteRepo.deletePacienteById(id);
    }

    public List<Paciente> findPacienteByName(String nombrePaciente){
        return pacienteRepo.findPacienteByNombreContaining(nombrePaciente);
    }

    public List<Paciente> findPacienteByDocumento(String documento){
        return pacienteRepo.findByDocumentoContaining(documento);
    }
}