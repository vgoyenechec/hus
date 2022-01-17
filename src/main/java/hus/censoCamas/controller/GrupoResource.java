package hus.censoCamas.controller;

import hus.censoCamas.model.Grupo;
import hus.censoCamas.service.GrupoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupo")
public class GrupoResource {
    private final GrupoService grupoService;

    public GrupoResource(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> findAllGrupos(){
        return ResponseEntity.ok().body(grupoService.findAllNombres());
    }

    @GetMapping("/find/nombre={nombre}")
    public ResponseEntity<Grupo> findByNameGrupo(@PathVariable("nombre") String nombre){
        return ResponseEntity.ok().body(grupoService.findByName(nombre));
    }
}
