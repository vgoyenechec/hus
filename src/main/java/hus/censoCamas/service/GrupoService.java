package hus.censoCamas.service;

import hus.censoCamas.model.Grupo;
import hus.censoCamas.repo.GrupoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GrupoService {
    private final GrupoRepo grupoRepo;

    @Autowired
    public GrupoService(GrupoRepo grupoRepo) {
        this.grupoRepo = grupoRepo;
    }

    public List<Grupo> findAllGrupos(){
        return grupoRepo.findAll();
    }

    public Grupo findByName(String nombre){
        return grupoRepo.findByNombre(nombre);
    }


}
