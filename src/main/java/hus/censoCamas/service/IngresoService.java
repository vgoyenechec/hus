package hus.censoCamas.service;

import hus.censoCamas.model.Ingreso;
import hus.censoCamas.repo.IngresoRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IngresoService {
    private final IngresoRepo ingresoRepo;

    public IngresoService(IngresoRepo ingresoRepo){
        this.ingresoRepo = ingresoRepo;
    }

    public List<Ingreso> findAllIngresos(){
        return ingresoRepo.findAll();
    }

    public Ingreso updateIngreso(Ingreso ingreso){
        return ingresoRepo.save(ingreso);
    }


}