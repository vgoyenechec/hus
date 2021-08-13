package hus.censoCamas;

import hus.censoCamas.model.Estancia;
import hus.censoCamas.service.EstanciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estancias")
public class EstanciaResource {
    private final EstanciaService estanciaService;

    public EstanciaResource(EstanciaService estanciaService) {
        this.estanciaService = estanciaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Estancia>> getAllEstancias() {
        List<Estancia> estancias = estanciaService.findAllEstancias();
        return new ResponseEntity<>(estancias, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Estancia> addEstancia(@RequestBody Estancia estancia){
        Estancia nuevaEstancia = estanciaService.addEstancia(estancia);
        return new ResponseEntity<>(nuevaEstancia, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Estancia> updateEstancia(@RequestBody Estancia estancia){
        Estancia updEstancia = estanciaService.updateEstancia(estancia);
        return new ResponseEntity<>(updEstancia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Estancia> deleteEstancia(@PathVariable("id") Integer id){
        estanciaService.deleteEstancia(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
