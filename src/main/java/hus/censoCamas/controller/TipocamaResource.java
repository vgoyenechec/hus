package hus.censoCamas.controller;

import hus.censoCamas.model.Tipocama;
import hus.censoCamas.service.TipocamaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipocama")
public class TipocamaResource {
    private final TipocamaService tipocamaService;

    public TipocamaResource(TipocamaService tipocamaService) {
        this.tipocamaService = tipocamaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tipocama>> findAllTipocamas(){
        return ResponseEntity.ok().body(tipocamaService.findAllTipos());
    }

    @GetMapping("/find/nombre={nombre}")
    public ResponseEntity<Tipocama> findByNameTipocama(@PathVariable("nombre") String nombre){
        return ResponseEntity.ok().body(tipocamaService.findTipoByNombre(nombre));
    }

    @GetMapping("/find/grupo={g}&subgrupo={s}")
    public ResponseEntity<List<String>> findByGrupoSubgrupo(@PathVariable("g") String g, @PathVariable("s") String s){
        return ResponseEntity.ok().body(tipocamaService.findByGrupoSubgrupo(g,s));
    }
}
