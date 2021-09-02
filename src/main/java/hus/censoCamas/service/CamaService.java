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

    public List<Cama> findCamaByGrupoSubTipo(String grupo, String subgrupo, String tipo){
        return camaRepo.findByGrupoAndSubgrupoAndTipo(grupo, subgrupo, tipo);
    }

    public List<Cama> findCamaByGrupoSub(String grupo, String subgrupo){
        return camaRepo.findByGrupoAndSubgrupo(grupo, subgrupo);
    }

    public List<Cama> findCamaByGrupo(String grupo){
        return camaRepo.findByGrupo(grupo);
    }

    public Cama findCamaById(Integer id){
        return camaRepo.findCamaById(id)
                .orElseThrow(()-> new UserNotFoundException("La cama de codigo "+id+"no se encuentra"));
    }

    public List<Cama> findCamaByEstado(int estado){
        return camaRepo.findByEstado(estado);
    }

    public void deleteCama(Integer id){
        camaRepo.deleteCamaById(id);
    }

    public Cama findByCodigoCama(String codigo){
        return camaRepo.findByCodigo(codigo);
    }
}
