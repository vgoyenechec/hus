package hus.censoCamas;

import hus.censoCamas.model.Paciente;
import hus.censoCamas.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteResource {
    private final PacienteService pacienteService;

    public PacienteResource(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Paciente>> getAllPacientes(){
        List<Paciente> pacientes = pacienteService.findAllPacientes();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @GetMapping("/top/{tp}")
    public ResponseEntity<List<Paciente>> getTopPacientes(@PathVariable("tp") int top){
        List<Paciente> pacientes = pacienteService.findTopPacientes(top);
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable("id") Integer id){
        Paciente paciente = pacienteService.findPacienteById(id);
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @GetMapping("/encontrar/nombre/{nombrePaciente}")
    public ResponseEntity<List<Paciente>> getPacienteByName(@PathVariable("nombrePaciente") String nombrePaciente){
        List<Paciente> pacientes = pacienteService.findPacienteByName(nombrePaciente);
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @GetMapping("/encontrar/documento/{documento}")
    public ResponseEntity<List<Paciente>> getPacienteByDocumento(@PathVariable("documento") String documento){
        List<Paciente> pacientes = pacienteService.findPacienteByDocumento(documento);
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Paciente> addPaciente(@RequestBody Paciente paciente){
        Paciente nuevoPaciente = pacienteService.addPaciente(paciente);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Paciente> updatePaciente(@RequestBody Paciente paciente){
        Paciente updatePaciente = pacienteService.updatePaciente(paciente);
        return new ResponseEntity<>(updatePaciente, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Paciente> deletePaciente(@PathVariable("id") Integer id){
        pacienteService.deletePaciente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
