package hus.censoCamas.service;

import hus.censoCamas.exception.UserNotFoundException;
import hus.censoCamas.model.Usuario;
import hus.censoCamas.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepo usuarioRepo;

    @Autowired
    public UsuarioService(UsuarioRepo usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }


    public Usuario addUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }

    public List<Usuario> findAllUsuarios(){
        return usuarioRepo.findAll();
    }

    public Usuario updateUsuario(Usuario usuario){
        return usuarioRepo.save(usuario);
    }

    public Usuario findUsuarioById(Long id){
        return usuarioRepo.findUsuarioById(id)
                .orElseThrow(()-> new UserNotFoundException("El usuario con id "+id+" no se ha encontrado"));
    }

    public void deleteUsuario(Long id) {
        usuarioRepo.deleteUsuarioById(id);
    }

    public List<Usuario> findUsuariosByUsername(String username){
        return usuarioRepo.findUsuarioByUsuarioContaining(username);
    }
}
