package hus.censoCamas;

import hus.censoCamas.model.Cama;
import hus.censoCamas.dtos.CamaDTO;
import hus.censoCamas.service.CamaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camas")
public class CamaResource {
    private final CamaService camaService;

    public CamaResource(CamaService camaService){
        this.camaService = camaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cama>> getAllCamas(){
        return ResponseEntity.ok().body(camaService.findAllCamas());
    }

    @GetMapping("/find/grupo={def}")
    public ResponseEntity<List<CamaDTO>> getCamaByGrupo(@PathVariable("def") String grupo){
        return ResponseEntity.ok().body(camaService.findCamaByGrupo(grupo));
    }

    @GetMapping("/find/grupo={def}/subgrupo={sub}")
    public ResponseEntity<List<CamaDTO>> getCamaByGrupoAndSub(@PathVariable("def") String grupo,@PathVariable("sub") String sub){
        return ResponseEntity.ok().body(camaService.findCamaByGrupoSub(grupo, sub));
    }

    @GetMapping("/find/grupo={def}/subgrupo={sub}/tipo={tipo}")
    public ResponseEntity<List<CamaDTO>> getCamaByGrupoAndSubAndTipo(@PathVariable("def") String grupo, @PathVariable("sub") String sub, @PathVariable("tipo") String tipo){
        return ResponseEntity.ok().body(camaService.findCamaByGrupoSubTipo(grupo, sub, tipo));
    }

    @GetMapping("/find/estado={estado}")
    public ResponseEntity<List<Cama>> getCamaByEstado(@PathVariable("estado") int estado){
        return ResponseEntity.ok().body(camaService.findCamaByEstado(estado));
    }

    @GetMapping("/find/codigo={codigo}")
    public ResponseEntity<Cama> findByCodigo(@PathVariable("codigo") String codigo){
        return ResponseEntity.ok().body(camaService.findByCodigoCama(codigo));
    }
}
