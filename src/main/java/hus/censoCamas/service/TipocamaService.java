package hus.censoCamas.service;

import hus.censoCamas.model.Tipocama;
import hus.censoCamas.repo.TipocamaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TipocamaService {
    private TipocamaRepo tipocamaRepo;

    @Autowired
    public TipocamaService(TipocamaRepo tipocamaRepo) {
        this.tipocamaRepo = tipocamaRepo;
    }

    public List<Tipocama> findAllTipos(){
        return tipocamaRepo.findAll();
    }
    public Tipocama findTipoByNombre(String nombre){
        return tipocamaRepo.findByNombre(nombre);
    }
}
