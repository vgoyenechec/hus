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

    public List<Usuario> findAllUsuarios(){
        return usuarioRepo.findAll();
    }

    public boolean existeUsuario(String usuario){
        return usuarioRepo.existsByUsuario(usuario);
    }

    public void deleteUsuario(int id) {
        usuarioRepo.deleteUsuarioById(id);
    }

    public Usuario findUsuariosByUsername(String username){
        return usuarioRepo.findByUsuario(username)
                .orElseThrow(()-> new ObjectNotFoundException("El usuario "+username+" no se ha encontrado"));
    }
}
