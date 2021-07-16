package hus.censoCamas.service;

import hus.censoCamas.model.Egreso;
import hus.censoCamas.repo.EgresoRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EgresoService {
    private final EgresoRepo egresoRepo;

    public EgresoService(EgresoRepo egresoRepo){
        this.egresoRepo = egresoRepo;
    }

    public Egreso addEgreso(Egreso egreso){
        return egresoRepo.save(egreso);
    }

    public List<Egreso> findAllEgresos(){
        return egresoRepo.findAll();
    }

    public Egreso updateEgreso(Egreso egreso){
        return egresoRepo.save(egreso);
    }

    public void deleteEgresoById(int idEgreso){
        egresoRepo.deleteByIdEgreso(idEgreso);
    }

}
