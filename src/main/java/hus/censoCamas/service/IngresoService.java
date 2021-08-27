package hus.censoCamas.service;

import hus.censoCamas.exception.UserNotFoundException;
import hus.censoCamas.model.Cama;
import hus.censoCamas.model.Ingreso;
import hus.censoCamas.repo.CamaRepo;
import hus.censoCamas.repo.IngresoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IngresoService {
    private final IngresoRepo ingresoRepo;
    private final CamaRepo camaRepo;

    @Autowired
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

    public List<Object[]>  findByPacienteDoc(String doc){
        return ingresoRepo.findByPacienteDoc(doc)
                .orElseThrow(()-> new UserNotFoundException("No se ha encontrado ningún ingreso relacionado con el documento "+doc));
    }
    public List<Object[]>  findByPacienteNombre(String nombre){
        return ingresoRepo.findByPacienteNombre(nombre)
                .orElseThrow(()-> new UserNotFoundException("No se ha encontrado ningún ingreso relacionado con el nombre: "+nombre));
    }

    public Ingreso findByConsecutivo(int consecutivo){
        return ingresoRepo.findIngresoByConsecutivo(consecutivo)
                .orElseThrow(()-> new UserNotFoundException("No se ha encontrado el ingreso con número "+consecutivo));
    }

   public Ingreso updateIngresoCama(Integer id, String codigo){
        Ingreso ingreso = ingresoRepo.findIngresoById(id)
                .orElseThrow(()-> new UserNotFoundException("No se encuentra un ingreso con este codigo: "+id));
        Cama nuevaCama = camaRepo.findByCodigo(codigo);
        ingreso.setCama(nuevaCama);
        return ingresoRepo.save(ingreso);
    }
}