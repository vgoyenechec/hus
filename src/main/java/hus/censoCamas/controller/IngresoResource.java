package hus.censoCamas.controller;

import hus.censoCamas.model.Cama;
import hus.censoCamas.model.Ingreso;
import hus.censoCamas.dtos.IngresoDTO;
import hus.censoCamas.service.IngresoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return ResponseEntity.ok().body(ingresoService.updateIngresoCamaParaTraslado(ing, cama));
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update/ingreso={ing}")
    public ResponseEntity<Cama> liberarCamaEnIngreso(@PathVariable("ing") int ing){
        ingresoService.liberarCamaIngreso(ing);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
