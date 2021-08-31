package hus.censoCamas.service;

import hus.censoCamas.model.Subgrupo;
import hus.censoCamas.repo.SubgrupoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SubgrupoService {
    private final SubgrupoRepo subgrupoRepo;

    @Autowired
    public SubgrupoService(SubgrupoRepo subgrupoRepo) {
        this.subgrupoRepo = subgrupoRepo;
    }

    public List<Subgrupo> findAllSubgrupos(){
        return subgrupoRepo.findAll();
    }

    public Subgrupo findByName(String nombre){
        return subgrupoRepo.findByNombre(nombre);
    }

    public List<Object[]> findByGrupo(int grupo){ return subgrupoRepo.findByGrupo(grupo);}

}
