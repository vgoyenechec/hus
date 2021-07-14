package hus.censoCamas.service;

import hus.censoCamas.exception.UserNotFoundException;
import hus.censoCamas.model.Cama;
import hus.censoCamas.repo.CamaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CamaService {
    private final CamaRepo camaRepo;

    @Autowired
    public CamaService(CamaRepo camaRepo){
        this.camaRepo = camaRepo;
    }

    public Cama addCama(Cama cama){
        return camaRepo.save(cama);
    }

    public List<Cama> findAllCamas(){
        return camaRepo.findAll();
    }

    public Cama updateCama(Cama cama){
        return camaRepo.save(cama);
    }

    public List<Cama> findCamaByGrupoSubTipo(int grupo, int subgrupo, int tipo){
        return camaRepo.findByGrupoAndSubgrupoAndTipo(grupo, subgrupo, tipo);
    }

    public List<Cama> findCamaByGrupoSub(int grupo, int subgrupo){
        return camaRepo.findByGrupoAndSubgrupo(grupo, subgrupo);
    }

    public List<Cama> findCamaByGrupo(int grupo){
        return camaRepo.findByGrupo(grupo);
    }

    public Cama findCamaById(Integer id){
        return camaRepo.findCamaById(id)
                .orElseThrow(()-> new UserNotFoundException("La cama de codigo "+id+"no se encuentra"));
    }

    public void deleteCama(Integer id){
        camaRepo.deleteCamaById(id);
    }

}
