package hus.censoCamas.security;

import hus.censoCamas.exception.Message;
import hus.censoCamas.security.constant.Roles;
import hus.censoCamas.security.dto.*;
import hus.censoCamas.security.jwt.JwtProvider;
import hus.censoCamas.security.entity.*;
import hus.censoCamas.security.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class UsuarioResource {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    @PreAuthorize("hasRole('SUPERADMIN')")
    @PostMapping("/signup")
    public ResponseEntity<?> nuevo(@Validated @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>("Todos los campos son obligatorios", HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existeUsuario(nuevoUsuario.getUsuario())){
            return new ResponseEntity<>("Usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        Usuario usuario =
                new Usuario(nuevoUsuario.getUsuario(), nuevoUsuario.getNombre(), passwordEncoder.encode(nuevoUsuario.getClave()));
        Set<Rol> roles = new HashSet<>();
        if(nuevoUsuario.getRoles().contains("admin")){
            roles.add(rolService.getRolByNombre(Roles.ROLE_USER));
            roles.add(rolService.getRolByNombre(Roles.ROLE_ADMIN));
        }
        if(nuevoUsuario.getRoles().contains("superadmin")){
            roles.add(rolService.getRolByNombre(Roles.ROLE_SUPERADMIN));
        }
        usuario.setRoles(roles);
        usuarioService.saveUsuario(usuario);
        return new ResponseEntity<>("Usuario creado correctamente", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Validated @RequestBody LoginUsuario login, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return new ResponseEntity<>("Usuario o contraseña incorrecta", HttpStatus.BAD_REQUEST);
        }
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsuario(),login.getClave()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt =  jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        int cambioClave = usuarioService.findUsuariosByUsername(userDetails.getUsername()).getCambioClave();
        JwtDTO jwtDTO = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities(), cambioClave);
        return new ResponseEntity<>(jwtDTO,HttpStatus.OK);
    }

    @PostMapping("/usuario/cambiar-clave")
    public ResponseEntity<Message> cambiarClave(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, Principal user){
        String username = user.getName();
        Message message;
        Usuario currentUser = usuarioService.findUsuariosByUsername(username);
        if(passwordEncoder.matches(oldPassword, currentUser.getClave())){
            currentUser.setClave(passwordEncoder.encode(newPassword));
            currentUser.setCambioClave(1);
            usuarioService.saveUsuario(currentUser);
            message = new Message("Cambio de contraseña exitoso");
        }
        else{
            message = new Message("Contraseña actual incorrecta");
        }
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PreAuthorize("hasRole('SUPERADMIN')")
    @PostMapping("/reset-clave")
    public ResponseEntity<Message> resetClave(@RequestParam("newPassword")String newPassword,@RequestParam("username") String username){
        Usuario currentUser = usuarioService.findUsuariosByUsername(username);
        currentUser.setClave(passwordEncoder.encode(newPassword));
        currentUser.setCambioClave(0);
        usuarioService.saveUsuario(currentUser);
        return new ResponseEntity<>(new Message("Clave Reseteada"),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('SUPERADMIN')")
    @GetMapping("/find/username={username}")
    public ResponseEntity<Usuario> findUsuariosByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(usuarioService.findUsuariosByUsername(username));
    }

    @PreAuthorize("hasRole('SUPERADMIN')")
    @DeleteMapping("/habilitar/{id}")
    public ResponseEntity<Usuario> habilitarUsuario(@PathVariable("id") int id){
        usuarioService.enableUsuario(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('SUPERADMIN')")
    @DeleteMapping("/deshabilitar/{id}")
    public ResponseEntity<Usuario> deshabilitarUsuario(@PathVariable("id") int id){
        usuarioService.disableUsuario(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('SUPERADMIN')")
    @DeleteMapping("/delete/{usuario}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable("usuario") String usuario){
        usuarioService.deleteUsuario(usuario);
        return ResponseEntity.ok().build();
    }
}


