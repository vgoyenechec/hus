package hus.censoCamas.security;

import hus.censoCamas.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepo usuarioRepo;
    private final RolRepo rolRepo;

    @Autowired
    public UsuarioService(UsuarioRepo usuarioRepo, RolRepo rolRepo){
        this.usuarioRepo = usuarioRepo;
        this.rolRepo = rolRepo;
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }

    public Rol saveRol(Rol rol){
        return rolRepo.save(rol);
    }
    public List<Usuario> findAllUsuarios(){
        return usuarioRepo.findAll();
    }
    public void addRoleToUser(String username, String rolename){
        Usuario usuario = usuarioRepo.findByUsuario(username)
                .orElseThrow(()->new ObjectNotFoundException("No se encontro usuario con este nombre"));
        Rol rol = rolRepo.findByNombre(rolename)
                .orElseThrow(()->new ObjectNotFoundException("No se encontro usuario con este nombre"));
        usuario.getRoles().add(rol);
    }

    public void deleteUsuario(Long id) {
        usuarioRepo.deleteUsuarioById(id);
    }

    public Usuario findUsuariosByUsername(String username){
        return usuarioRepo.findByUsuario(username)
                .orElseThrow(()-> new ObjectNotFoundException("El usuario "+username+" no se ha encontrado"));
    }
}
