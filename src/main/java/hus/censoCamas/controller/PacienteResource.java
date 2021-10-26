package hus.censoCamas.controller;

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

    @GetMapping("/find/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(pacienteService.findPacienteById(id));
    }

    @GetMapping("/encontrar/nombre/{nombrePaciente}")
    public ResponseEntity<List<Paciente>> getPacienteByName(@PathVariable("nombrePaciente") String nombrePaciente){
        return ResponseEntity.ok().body(pacienteService.findPacienteByName(nombrePaciente));
    }

    @GetMapping("/encontrar/documento/{documento}")
    public ResponseEntity<List<Paciente>> getPacienteByDocumento(@PathVariable("documento") String documento){
        return ResponseEntity.ok().body(pacienteService.findPacienteByDocumento(documento));
    }
}
