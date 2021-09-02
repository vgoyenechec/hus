package hus.censoCamas.service;

import hus.censoCamas.exception.UserNotFoundException;
import hus.censoCamas.model.Cama;
import hus.censoCamas.model.CamaDTO;
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
        List<CamaDTO> camasDTO = new ArrayList<CamaDTO>();
        camas.forEach(cama -> {
            CamaDTO dto = new CamaDTO();
            dto.setOid(cama.getIdCama());
            dto.setCodigo(cama.getCodigoCama());
            dto.setNombre(cama.getNombreCama());
            dto.setGrupo(cama.getGrupo());
            dto.setSubgrupo(cama.getSubgrupo());
            dto.setTipocama(cama.getTipoCama());
            switch (cama.getEstadoCama()){
                case 1:
                    dto.setEstado("Desocupada");
                case 2:
                    dto.setEstado("Ocupada");
                case 3:
                    dto.setEstado("Bloqueada");
            }

            camasDTO.add(dto);
        });
        return camasDTO;
    }

    public List<CamaDTO> findCamaByGrupoSub(String grupo, String subgrupo){
        List<Cama> camas = camaRepo.findByGrupoAndSubgrupo(grupo, subgrupo);
        List<CamaDTO> camasDTO = new ArrayList<CamaDTO>();
        camas.forEach(cama -> {
            CamaDTO dto = new CamaDTO();
            dto.setOid(cama.getIdCama());
            dto.setCodigo(cama.getCodigoCama());
            dto.setNombre(cama.getNombreCama());
            dto.setGrupo(cama.getGrupo());
            dto.setSubgrupo(cama.getSubgrupo());
            dto.setTipocama(cama.getTipoCama());
            switch (cama.getEstadoCama()){
                case 1:
                    dto.setEstado("Desocupada");
                case 2:
                    dto.setEstado("Ocupada");
                case 3:
                    dto.setEstado("Bloqueada");
            }

            camasDTO.add(dto);
        });
        return camasDTO;
    }

    public List<CamaDTO> findCamaByGrupo(String grupo){
        List<Cama> camas = camaRepo.findByGrupo(grupo);
        List<CamaDTO> camasDTO = new ArrayList<CamaDTO>();
        camas.forEach(cama -> {
            CamaDTO dto = new CamaDTO();
            dto.setOid(cama.getIdCama());
            dto.setCodigo(cama.getCodigoCama());
            dto.setNombre(cama.getNombreCama());
            dto.setGrupo(cama.getGrupo());
            dto.setSubgrupo(cama.getSubgrupo());
            dto.setTipocama(cama.getTipoCama());
            switch (cama.getEstadoCama()){
                case 1:
                    dto.setEstado("Desocupada");
                case 2:
                    dto.setEstado("Ocupada");
                case 3:
                    dto.setEstado("Bloqueada");
            }

            camasDTO.add(dto);
        });
        return camasDTO;

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
