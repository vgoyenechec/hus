package hus.censoCamas;

import hus.censoCamas.model.Cama;
import hus.censoCamas.service.CamaService;
import org.springframework.http.HttpStatus;
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
        List<Cama> camas = camaService.findAllCamas();
        return new ResponseEntity<>(camas, HttpStatus.OK);
    }

    @GetMapping("/find/grupo?={def}")
    public ResponseEntity<List<Cama>> getCamaByGrupo(@PathVariable("def") int grupo){
        List<Cama> camas = camaService.findCamaByGrupo(grupo);
        return new ResponseEntity<>(camas, HttpStatus.OK);
    }

    @GetMapping("/find/grupo?={def}/subgrupo?={sub}")
    public ResponseEntity<List<Cama>> getCamaByGrupoAndSub(@PathVariable("def") int grupo,@PathVariable("sub") int sub){
        List<Cama> camas = camaService.findCamaByGrupoSub(grupo, sub);
        return new ResponseEntity<>(camas, HttpStatus.OK);
    }

    @GetMapping("/find/grupo?={def}/subgrupo?={sub}/tipo?={tipo}")
    public ResponseEntity<List<Cama>> getCamaByGrupoAndSubAndTipo(@PathVariable("def") int grupo,@PathVariable("sub") int sub, @PathVariable("tipo") int tipo){
        List<Cama> camas = camaService.findCamaByGrupoSubTipo(grupo, sub, tipo);
        return new ResponseEntity<>(camas, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Cama> addCama(@RequestBody Cama cama){
        Cama newCama = camaService.addCama(cama);
        return new ResponseEntity<>(newCama, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Cama> updateCama(@RequestBody Cama cama){
        Cama updateCama = camaService.updateCama(cama);
        return new ResponseEntity<>(updateCama, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cama> deleteCama(@PathVariable("id") Integer id){
        camaService.deleteCama(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
