package hus.censoCamas;

import hus.censoCamas.model.Tipocama;
import hus.censoCamas.service.TipocamaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        List<Tipocama> tipocamas = tipocamaService.findAllTipos();
        return new ResponseEntity<>(tipocamas, HttpStatus.OK);
    }

    @GetMapping("/find/nombre={nombre}")
    public ResponseEntity<Tipocama> findByNameTipocama(@PathVariable("nombre") String nombre){
        Tipocama tipocama = tipocamaService.findTipoByNombre(nombre);
        return new ResponseEntity<>(tipocama, HttpStatus.OK);
    }

    @GetMapping("/find/grupo={g}&subgrupo={s}")
    public ResponseEntity<List<String>> findByGrupoSubgrupo(@PathVariable("g") String g, @PathVariable("s") String s){
        List<String> tipocama = tipocamaService.findByGrupoSubgrupo(g,s);
        return new ResponseEntity<>(tipocama, HttpStatus.OK);
    }
}
