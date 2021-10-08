package hus.censoCamas;

import hus.censoCamas.model.Cama;
import hus.censoCamas.model.Ingreso;
import hus.censoCamas.model.IngresoPaciente;
import hus.censoCamas.service.IngresoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingreso")
public class IngresoResource {
    private final IngresoService ingresoService;

    public IngresoResource(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    @GetMapping("/find/id={id}")
    public ResponseEntity<IngresoPaciente> getIngresoById(@PathVariable("id") int id){
        IngresoPaciente ingreso = ingresoService.findByConsecutivo(id);
        return new ResponseEntity<>(ingreso, HttpStatus.OK);
    }

    @GetMapping("/find/documento={doc}")
    public ResponseEntity<IngresoPaciente> getIngresoByPacienteDoc(@PathVariable("doc") String doc){
        IngresoPaciente ingreso = ingresoService.findByPacienteDoc(doc);
        return new ResponseEntity<>(ingreso, HttpStatus.OK);
    }

    @PutMapping("update/ingreso={ing}/cama={cama}")
    public ResponseEntity<Ingreso> TrasladoCamaEnIngreso(@PathVariable("ing") int ing, @PathVariable("cama") String cama){
        Ingreso ingreso = ingresoService.updateIngresoCamaParaTraslado(ing, cama);
        return new ResponseEntity<>(ingreso, HttpStatus.OK);

    }
    @PutMapping("update/ingreso={ing}")
    public ResponseEntity<Cama> liberarCamaEnIngreso(@PathVariable("ing") int ing){
        Cama cama = ingresoService.liberarCamaIngreso(ing);
        return new ResponseEntity<>(cama, HttpStatus.OK);

    }




}
