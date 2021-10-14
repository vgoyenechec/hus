package hus.censoCamas.security.service;

import hus.censoCamas.exception.ObjectNotFoundException;
import hus.censoCamas.security.constant.Roles;
import hus.censoCamas.security.entity.Rol;
import hus.censoCamas.security.repo.RolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepo rolRepo;

    public Rol getRolByNombre(Roles nombre){
        return rolRepo.findByNombre(nombre)
                .orElseThrow(()-> new ObjectNotFoundException("El rol "+nombre+" no se ha encontrado"));
    }

    public Rol saveRol(Rol rol){
        return rolRepo.save(rol);
    }
}
