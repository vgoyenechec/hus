package hus.censoCamas.service;

import hus.censoCamas.model.Estancia;
import hus.censoCamas.repo.EstanciaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EstanciaService {
    private final EstanciaRepo estanciaRepo;

    @Autowired
    public EstanciaService(EstanciaRepo estanciaRepo){
        this.estanciaRepo = estanciaRepo;
    }

    public List<Estancia> findAllEstancias(){
        return estanciaRepo.findAll();
    }
    public Estancia addEstancia(Estancia estancia){
        return estanciaRepo.save(estancia);
    }
    public Estancia updateEstancia(Estancia estancia){
        return estanciaRepo.save(estancia);
    }
    public void deleteEstancia(Integer id){
        estanciaRepo.deleteById(id);
    }
}
