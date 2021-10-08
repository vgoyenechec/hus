package hus.censoCamas.service;

import hus.censoCamas.exception.ObjectNotFoundException;
import hus.censoCamas.model.Cama;
import hus.censoCamas.model.CamaDTO;
import hus.censoCamas.model.PacienteDTO;
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

    private CamaDTO mapCama(Cama cama, CamaDTO dto){
        PacienteDTO paciente = new PacienteDTO(setPacienteInCama(cama));

        dto.setOid(cama.getIdCama());
        dto.setCodigo(cama.getCodigoCama());
        dto.setNombre(cama.getNombreCama());
        dto.setGrupo(camaRepo.findGrupo(cama.getGrupo()));
        dto.setSubgrupo(camaRepo.findSubgrupo(cama.getSubgrupo()));
        dto.setTipocama(camaRepo.findTipo(cama.getTipoCama()));
        dto.setEstado(setEstadoCamaDTO(cama, paciente.getPaciente()));
        dto.setPaciente(paciente.getPaciente());
        dto.setDocumento(paciente.getDocumento());
        dto.setIngreso(paciente.getConsecutivo());
        dto.setFechaIngreso(paciente.getFechaIngreso());
        return dto;
    }

    private String setEstadoCamaDTO(Cama cama, String paciente){
        String estado = "";
        switch (cama.getEstadoCama()){
            case 1:
                estado = "Desocupada";
                break;
            case 2:
                estado = checkEstadoOcupado(cama, paciente);
                break;
            case 3:
                estado = "Bloqueada";
                break;
        }
        return estado;
    }

    private String checkEstadoOcupado(Cama cama, String paciente){
        String estado;
        if(checkIfPacienteIsRegistrado(paciente)){
            estado = "Ocupada";
        }
        else{
            estado = "Desocupada";
            cama.setEstadoCama(1);
            camaRepo.save(cama);
        }
        return estado;
    }

    private boolean checkIfPacienteIsRegistrado(String paciente){
        return !paciente.equals("");
    }
    private String[] setPacienteInCama(Cama cama){
        String[] paciente = setPacienteNull();
        try {
            if(cama.getEstadoCama()==2){
               paciente = getPacienteInfo(cama, paciente);
            }
        }
        catch (Exception e){
            System.out.println("\n\nUltimo ingreso en cama "+cama.getCodigoCama()+" diferente a Registrado!! ");
        }
        return paciente;
    }

    private String[] getPacienteInfo(Cama cama, String[] paciente){
        if(comparePacienteRegistradoAndFinal(cama)){
            paciente = camaRepo.findPaciente(cama.getIdCama()).split(",", 4);
        }
        return paciente;
    }

    private String[] setPacienteNull(){
        return new String[]{"", "", "", ""};
    }

    private boolean comparePacienteRegistradoAndFinal(Cama cama){
        String[] pacienteRegistrado = camaRepo.findPaciente(cama.getIdCama()).split(",", 4);
        String[] pacienteFinal = camaRepo.findPacienteFinal(cama.getIdCama()).split(",", 4);
        return pacienteFinal[2].equals(pacienteRegistrado[2]);
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
        camas.forEach(cama -> camasDTO.add(mapCama(cama, new CamaDTO())));
        return camasDTO;
    }

    public List<Cama> findCamaByEstado(int estado){
        return camaRepo.findByEstado(estado);
    }

    public Cama findByCodigoCama(String codigo){
        return camaRepo.findByCodigo(codigo)
                .orElseThrow(()-> new ObjectNotFoundException("no encontro cama con codigo "+ codigo));
    }
}
