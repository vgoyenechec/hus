package hus.censoCamas.security.service;

import hus.censoCamas.security.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {
    private final UsuarioService usuarioService;
    
    public UsuarioResource(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/home")
    public String showUser(){
        return "Funciona";
    }
    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        return ResponseEntity.ok().body(usuarioService.findAllUsuarios());
    }

    @GetMapping("/find/username={username}")
    public ResponseEntity<Usuario> findUsuariosByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(usuarioService.findUsuariosByUsername(username));
    }

    @PostMapping("/add")
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok().body(usuarioService.saveUsuario(usuario));
    }

    @PutMapping("/update")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok().body(usuarioService.saveUsuario(usuario));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable("id") Long id){
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


