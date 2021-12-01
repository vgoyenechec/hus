package hus.censoCamas.controller;

import hus.censoCamas.exception.Message;
import hus.censoCamas.model.Cama;
import hus.censoCamas.model.Ingreso;
import hus.censoCamas.dtos.IngresoDTO;
import hus.censoCamas.service.IngresoService;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingreso")
public class IngresoResource {
    private final IngresoService ingresoService;

    public IngresoResource(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    @GetMapping("/find/id={id}")
    public ResponseEntity<IngresoDTO> getIngresoById(@PathVariable("id") int id){
        return ResponseEntity.ok().body(ingresoService.findByConsecutivo(id));
    }

    @GetMapping("/find/documento={doc}")
    public ResponseEntity<List<IngresoDTO>> getIngresoByPacienteDoc(@PathVariable("doc") String doc){
        return ResponseEntity.ok().body(ingresoService.findByPacienteDoc(doc));
    }

    @GetMapping("/find/nombre={nombre}")
    public ResponseEntity<List<IngresoDTO>> getIngresoByPacienteNombre(@PathVariable("nombre") String nombre){
        return ResponseEntity.ok().body(ingresoService.findByPacienteName(nombre));
    }
    
    @PutMapping("update/ingreso={ing}/cama={cama}")
    public ResponseEntity<Ingreso> TrasladoCamaEnIngreso(@PathVariable("ing") int ing, @PathVariable("cama") String cama){
        return ResponseEntity.ok().body(ingresoService.updateCamaEnIngresoParaTraslado(ing, cama));
    }

    @PutMapping("update/ingreso={ing}")
    public ResponseEntity<Message> liberarCamaEnIngreso(@PathVariable("ing") int ing){
        IngresoDTO ingreso = ingresoService.findByConsecutivo(ing);
        ingresoService.liberarCamaIngreso(ing);
        return new ResponseEntity<Message>(new Message("Cama "+ingreso.getCama()+" liberada correctamente."), HttpStatus.OK);
    }
}
