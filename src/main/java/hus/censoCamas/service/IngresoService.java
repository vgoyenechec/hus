package hus.censoCamas.service;

import hus.censoCamas.exception.UserNotFoundException;
import hus.censoCamas.model.Cama;
import hus.censoCamas.model.Ingreso;
import hus.censoCamas.repo.CamaRepo;
import hus.censoCamas.repo.IngresoRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IngresoService {
    private final IngresoRepo ingresoRepo;
    private final CamaRepo camaRepo;


    public IngresoService(IngresoRepo ingresoRepo, CamaRepo camaRepo){
        this.ingresoRepo = ingresoRepo;
        this.camaRepo = camaRepo;
    }

    public List<Ingreso> findAllIngresos(){
        return ingresoRepo.findAll();
    }

    public Ingreso findById(Integer id){
       return ingresoRepo.findById(id)
                .orElseThrow(()-> new UserNotFoundException("No se ha encontrado el ingreso con número "+id));
    }

    public Ingreso findByIdIngreso(int idIng){
        return ingresoRepo.findIngresoByIdIngreso(idIng)
                .orElseThrow(()-> new UserNotFoundException("No se ha encontrado el ingreso con número "+idIng));
    }

   public Ingreso updateIngresoCama(Integer id, String codigo){
        Ingreso ingreso = ingresoRepo.findIngresoById(id)
                .orElseThrow(()-> new UserNotFoundException("No se encuentra un ingreso con este codigo: "+id));
        Cama nuevaCama = camaRepo.findByCodigo(codigo);
        ingreso.setCama(nuevaCama);
        return ingresoRepo.save(ingreso);
    }




}