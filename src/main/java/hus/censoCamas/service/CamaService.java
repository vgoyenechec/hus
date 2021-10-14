package hus.censoCamas.service;

import hus.censoCamas.exception.ObjectNotFoundException;
import hus.censoCamas.model.Cama;
import hus.censoCamas.dtos.CamaDTO;
import hus.censoCamas.dtos.PacienteDTO;
import hus.censoCamas.repo.CamaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CamaService {
    private final CamaRepo camaRepo;

    @Autowired
    public CamaService(CamaRepo camaRepo){
        this.camaRepo = camaRepo;
    }

    public Cama findByCodigoCama(String codigo){
        return camaRepo.findByCodigo(codigo)
                .orElseThrow(()-> new ObjectNotFoundException("no encontro cama con codigo "+ codigo));
    }

    public List<Cama> findAllNude(){
        return camaRepo.findAll();
    }

    public List<CamaDTO> findAll(){
        List<Cama> camas = camaRepo.findAll();
        return queryCamas(camas);
    }

    public List<CamaDTO> findCamaByGrupoSubTipoEstado(String grupo, String subgrupo, String tipo, String estado){
        List<Cama> camas = camaRepo.findByGrupoAndSubgrupoAndTipoAndEstado(grupo, subgrupo, tipo, estado);
        return queryCamas(camas);
    }

    public List<CamaDTO> findCamaByGrupoSubTipo(String grupo, String subgrupo, String tipo){
        List<Cama> camas = camaRepo.findByGrupoAndSubgrupoAndTipo(grupo, subgrupo, tipo);
        return queryCamas(camas);
    }

    public List<CamaDTO> findCamaByGrupoSub(String grupo, String subgrupo){
        List<Cama> camas = camaRepo.findByGrupoAndSubgrupo(grupo, subgrupo);
        return queryCamas(camas);
    }

    public List<CamaDTO> findCamaByGrupo(String grupo){
        List<Cama> camas = camaRepo.findByGrupo(grupo);
        return queryCamas(camas);
    }

    private List<CamaDTO> queryCamas(List<Cama> camas){
        List<CamaDTO> camasDTO = new ArrayList<>();
        camas.forEach(cama -> camasDTO.add(mapCama(cama)));
        return camasDTO;
    }

    private CamaDTO mapCama(Cama cama){
        PacienteDTO paciente = setPacienteInCama(cama);
        CamaDTO dto = new CamaDTO();
        dto.mapDTO(cama, paciente);
        return dto;
    }

    private PacienteDTO setPacienteInCama(Cama cama){
        PacienteDTO paciente = new PacienteDTO();
        try {
            if(cama.isOcupada()){
                paciente = getPacienteInfo(cama);
            }
        }
        catch (Exception e){
            System.out.println("\n\nUltimo ingreso en cama "+cama.getCodigoCama()+" diferente a Registrado!! ");
        }
        return paciente;
    }

    private PacienteDTO getPacienteInfo(Cama cama){
        PacienteDTO paciente = new PacienteDTO();
        if(comparePacienteRegistradoAndFinal(cama)){
            paciente = new PacienteDTO(camaRepo.findPaciente(cama.getIdCama()).split(",", 4));
        }
        return paciente;
    }

    private boolean comparePacienteRegistradoAndFinal(Cama cama){
        PacienteDTO pacienteRegistrado =  new PacienteDTO(camaRepo.findPaciente(cama.getIdCama()).split(",", 4));
        PacienteDTO pacienteFinal =  new PacienteDTO(camaRepo.findPacienteFinal(cama.getIdCama()).split(",", 4));
        return pacienteFinal.getPaciente().equals(pacienteRegistrado.getPaciente());
    }
}
