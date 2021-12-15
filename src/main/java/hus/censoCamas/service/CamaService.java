package hus.censoCamas.service;

import hus.censoCamas.exception.ObjectNotFoundException;
import hus.censoCamas.model.Cama;
import hus.censoCamas.dtos.CamaDTO;
import hus.censoCamas.dtos.PacienteDTO;
import hus.censoCamas.repo.CamaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class CamaService {
    private final CamaRepo camaRepo;

    @Autowired
    public CamaService(CamaRepo camaRepo){
        this.camaRepo = camaRepo;
    }

    public Cama bloquearCama(String codigo){
        Cama cama = findByCodigoCama(codigo);
        cama.bloquearCama();
        return camaRepo.save(cama);
    }

    public Cama desbloquearCama(String codigo){
        Cama cama = findByCodigoCama(codigo);
        cama.desbloquearCama();
        return camaRepo.save(cama);
    }

    public Cama findByCodigoCama(String codigo){
        return camaRepo.findByCodigo(codigo)
                .orElseThrow(()-> new ObjectNotFoundException("no encontro cama con codigo "+ codigo));
    }

    public List<CamaDTO> findAll(){
        List<Cama> camas = camaRepo.findAll();
        return buscarCamas(camas);
    }

    public List<CamaDTO> findCamaByGrupoSubTipoEstado(String grupo, String subgrupo, String tipo, String estado){
        List<Cama> camas = camaRepo.findByGrupoAndSubgrupoAndTipoAndEstado(grupo, subgrupo, tipo, estado);
        return buscarCamas(camas);
    }

    public List<CamaDTO> findCamaByGrupoSub(String grupo, String subgrupo){
        List<Cama> camas = camaRepo.findByGrupoAndSubgrupo(grupo, subgrupo);
        return buscarCamas(camas);
    }

    public List<CamaDTO> findCamaByGrupo(String grupo){
        List<Cama> camas = camaRepo.findByGrupo(grupo);
        return buscarCamas(camas);
    }

    private List<CamaDTO> buscarCamas(List<Cama> camas){
        List<CamaDTO> camasDTO = new ArrayList<>();
        camas.forEach(cama -> camasDTO.add(mapCama(cama)));
        return camasDTO;
    }

    private CamaDTO mapCama(Cama cama){
        PacienteDTO paciente = setPacienteEnCama(cama);
        CamaDTO dto = new CamaDTO();
        dto.mapDTO(cama, paciente);
        return dto;
    }

    private PacienteDTO setPacienteEnCama(Cama cama){
        PacienteDTO paciente = new PacienteDTO();
        try {
            if(cama.isOcupada()){
                paciente = getPacienteRegistrado(cama);
            }
        }
        catch (Exception e){
            System.out.println("\n\nUltimo ingreso en cama "+cama.getCodigoCama()+" tiene un estado diferente a Registrado!! ");
        }
        return paciente;
    }

    private PacienteDTO getPacienteRegistrado(Cama cama){
        PacienteDTO paciente = new PacienteDTO();
        if(isUltimoPacienteEnCamaRegistrado(cama)){
            paciente = new PacienteDTO(camaRepo.findPaciente(cama.getIdCama()).split(",", 4));
        }
        return paciente;
    }

    private boolean isUltimoPacienteEnCamaRegistrado(Cama cama){
        PacienteDTO pacienteRegistrado =  new PacienteDTO(camaRepo.findPaciente(cama.getIdCama()).split(",", 4));
        PacienteDTO pacienteFinal =  new PacienteDTO(camaRepo.findPacienteFinal(cama.getIdCama()).split(",", 4));
        return pacienteFinal.getPaciente().equals(pacienteRegistrado.getPaciente());
    }
}
