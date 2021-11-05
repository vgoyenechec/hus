package hus.censoCamas.controller;

import hus.censoCamas.model.Cama;
import hus.censoCamas.dtos.CamaDTO;
import hus.censoCamas.service.CamaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camas")
public class
 CamaResource {
    private final CamaService camaService;

    public CamaResource(CamaService camaService){
        this.camaService = camaService;
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<CamaDTO>> findAll(){
        return ResponseEntity.ok().body(camaService.findAll());
    }
    @GetMapping("/find/alln")
    public ResponseEntity<List<Cama>> findAllNude(){
        return ResponseEntity.ok().body(camaService.findAllNude());
    }

    @GetMapping("/find/grupo={def}")
    public ResponseEntity<List<CamaDTO>> getCamaByGrupo(@PathVariable("def") String grupo){
        return ResponseEntity.ok().body(camaService.findCamaByGrupo(grupo));
    }

    @GetMapping("/find/grupo={def}/subgrupo={sub}")
    public ResponseEntity<List<CamaDTO>> getCamaByGrupoAndSub(@PathVariable("def") String grupo,@PathVariable("sub") String sub){
        return ResponseEntity.ok().body(camaService.findCamaByGrupoSub(grupo, sub));
    }

    @GetMapping("/find/grupo={def}/subgrupo={sub}/tipo={tipo}/estado={est}")
    public ResponseEntity<List<CamaDTO>> getCamaByGrupoAndSubAndTipoEstado(@PathVariable("def") String grupo, @PathVariable("sub") String sub, @PathVariable("tipo") String tipo,  @PathVariable("est") String estado){
        return ResponseEntity.ok().body(camaService.findCamaByGrupoSubTipoEstado(grupo, sub, tipo, estado));
    }

    @GetMapping("/find/codigo={codigo}")
    public ResponseEntity<Cama> findByCodigo(@PathVariable("codigo") String codigo){
        return ResponseEntity.ok().body(camaService.findByCodigoCama(codigo));
    }

    @PutMapping("/bloquear/codigo={codigo}")
    public ResponseEntity<Cama> bloquearCama(@PathVariable("codigo") String codigo){
        return ResponseEntity.ok().body(camaService.bloquearCama(codigo));
    }

    @PutMapping("/desbloquear/codigo={codigo}")
    public ResponseEntity<Cama> desbloquearCama(@PathVariable("codigo") String codigo){
        return ResponseEntity.ok().body(camaService.desbloquearCama(codigo));
    }
}
