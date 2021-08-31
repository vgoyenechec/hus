package hus.censoCamas;

import hus.censoCamas.model.Subgrupo;
import hus.censoCamas.service.SubgrupoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subgrupo")
public class SubgrupoResource {
    private final SubgrupoService subgrupoService;

    public SubgrupoResource(SubgrupoService subgrupoService) {
        this.subgrupoService = subgrupoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Subgrupo>> findAllSubgrupos(){
        List<Subgrupo> subgrupos = subgrupoService.findAllSubgrupos();
        return new ResponseEntity<>(subgrupos, HttpStatus.OK);
    }

    @GetMapping("/find/nombre={nombre}")
    public ResponseEntity<Subgrupo> findByNameSubgrupo(@PathVariable("nombre") String nombre){
        Subgrupo subgrupo = subgrupoService.findByName(nombre);
        return new ResponseEntity<>(subgrupo, HttpStatus.OK);
    }
    @GetMapping("/find/grupo={gr}")
    public ResponseEntity<List<Object[]>> findByGrupo(@PathVariable("gr") int gr){
        List<Object[]> subgrupo = subgrupoService.findByGrupo(gr);
        return new ResponseEntity<>(subgrupo, HttpStatus.OK);
    }

}
