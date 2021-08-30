package hus.censoCamas;

import hus.censoCamas.model.Ingreso;
import hus.censoCamas.model.IngresoPaciente;
import hus.censoCamas.service.IngresoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/ingreso")
public class IngresoResource {
    private final IngresoService ingresoService;

    public IngresoResource(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ingreso>> getAllCamas(){
        List<Ingreso> ingresos = ingresoService.findAllIngresos();
        return new ResponseEntity<>(ingresos, HttpStatus.OK);
    }

    @GetMapping("/find/id={id}")
    public ResponseEntity<Ingreso> getIngresoById(@PathVariable("id") int id){
        Ingreso ingreso = ingresoService.findByConsecutivo(id);
        return new ResponseEntity<>(ingreso, HttpStatus.OK);
    }

    @GetMapping("/find/documento={doc}")
    public ResponseEntity<IngresoPaciente> getIngresoByPacienteDoc(@PathVariable("doc") String doc){
        IngresoPaciente ingreso = ingresoService.findByPacienteDoc(doc);
        return new ResponseEntity<>(ingreso, HttpStatus.OK);
    }

    @GetMapping("/find/nombre={nombre}")
    public ResponseEntity<Set<IngresoPaciente>> getIngresoByPacienteNombre(@PathVariable("nombre") String nombre){
        Set<IngresoPaciente> ingresos = ingresoService.findByPacienteNombre(nombre);

        return new ResponseEntity<>(ingresos, HttpStatus.OK);
    }

    @PostMapping("update/ingreso={ing}&cama={cama}")
    public ResponseEntity<Ingreso> updateCamaEnIngreso(@PathVariable("ing") int ing, @PathVariable("cama") String cama){
        Ingreso ingreso = ingresoService.updateIngresoCama(ing, cama);
        return new ResponseEntity<>(ingreso, HttpStatus.OK);

    }




}
