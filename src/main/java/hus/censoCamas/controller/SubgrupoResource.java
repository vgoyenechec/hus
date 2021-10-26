package hus.censoCamas.controller;

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
        return ResponseEntity.ok().body(subgrupoService.findAllSubgrupos());
    }

    @GetMapping("/find/nombre={nombre}")
    public ResponseEntity<Subgrupo> findByNameSubgrupo(@PathVariable("nombre") String nombre){
        return ResponseEntity.ok().body(subgrupoService.findByName(nombre));
    }
    @GetMapping("/find/grupo={gr}")
    public ResponseEntity<List<String>> findByGrupo(@PathVariable("gr") String gr){
        return ResponseEntity.ok().body(subgrupoService.findByGrupo(gr));
    }

}
