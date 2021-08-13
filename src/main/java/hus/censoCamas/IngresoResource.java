package hus.censoCamas;

import hus.censoCamas.model.Ingreso;
import hus.censoCamas.service.IngresoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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




}
