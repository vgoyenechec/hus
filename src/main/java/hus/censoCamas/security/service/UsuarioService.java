package hus.censoCamas.security.service;

import hus.censoCamas.exception.ObjectNotFoundException;
import hus.censoCamas.security.entity.Usuario;
import hus.censoCamas.security.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRepo usuarioRepo;

    public void saveUsuario(Usuario usuario){
        usuarioRepo.save(usuario);
    }

    public boolean existeUsuario(String usuario){
        return usuarioRepo.existsByUsuario(usuario);
    }

    public void deleteUsuario(String usuario) {
        usuarioRepo.deleteByUsuario(usuario);
    }

    public void disableUsuario(String username){
        Usuario usuario = usuarioRepo.findByUsuario(username)
                .orElseThrow(()-> new ObjectNotFoundException("El usuario "+username+" no se ha encontrado"));
        usuario.disable();
        usuarioRepo.save(usuario);
    }

    public void enableUsuario(String username){
        Usuario usuario = usuarioRepo.findByUsuario(username)
                .orElseThrow(()-> new ObjectNotFoundException("El usuario "+username+" no se ha encontrado"));
        usuario.enable();
        usuarioRepo.save(usuario);
    }


    public Usuario findUsuariosByUsername(String username){
        return usuarioRepo.findByUsuario(username)
                .orElseThrow(()-> new ObjectNotFoundException("El usuario "+username+" no se ha encontrado"));
    }
}
