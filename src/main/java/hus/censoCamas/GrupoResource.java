package hus.censoCamas;

import hus.censoCamas.model.Grupo;
import hus.censoCamas.service.GrupoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grupo")
public class GrupoResource {
    private final GrupoService grupoService;

    public GrupoResource(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Grupo>> findAllGrupos(){
        List<Grupo> grupos = grupoService.findAllGrupos();
        return new ResponseEntity<>(grupos, HttpStatus.OK);
    }

    @GetMapping("/find/nombre={nombre}")
    public ResponseEntity<Grupo> findByNameGrupo(@PathVariable("nombre") String nombre){
        Grupo grupo = grupoService.findByName(nombre);
        return new ResponseEntity<>(grupo, HttpStatus.OK);
    }
}
