package hus.censoCamas.service;

import hus.censoCamas.exception.ObjectNotFoundException;
import hus.censoCamas.model.*;
import hus.censoCamas.dtos.IngresoDTO;
import hus.censoCamas.repo.*;
import hus.censoCamas.security.entity.Usuario;
import hus.censoCamas.security.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class IngresoService {
    private final IngresoRepo ingresoRepo;
    private final CamaRepo camaRepo;
    private final PacienteRepo pacienteRepo;
    private final UsuarioRepo usuarioRepo;
    private final TrasladoRepo trasladoRepo;
    private final LiberarRepo liberarRepo;
    private static final String[] tipoRiesgo = new String[] {"Ninguna", "Accidente_De_Transito", "Catastrofe", "Enfermedad_General_Y_Maternidad", "Accidente_De_Trabajo", "Enfermedad_Profesional", "Atención_Inicial_De_Urgencias", "Otro_Tipo_De_Accidente", "Lesión_Por_Agresión", "Lesión_Autoinfligida", "Maltrato_Físico", "Promoción_Y_Prevención", "Otro", "Accidente_Rábico", "Accidente_Ofídico", "Sospecha_De_Abuso_Sexual", "Sospecha_De_Violencia_Sexual", "Sospecha_De_Maltrato_Emocional"};
    private static final String[] tipoIngreso = new String[]{"","Ambulatorio", "Hospitalario"};
    private static final String[] causaIngreso = new String[]{"Ninguna","Enfermedad_Profesional", "Heridos_En_Combate","Enfermedad_General_Adulto","Enfermedad_General_Pediatria","Odontología","Accidente_De_Transito","Catastrofe_Fisalud","Quemados","Maternidad","Accidente_Laboral","Cirugia_Programada"};
    private static final String[] estadoIngreso = new String[]{"Registrado", "Facturado", "Anulado", "Bloqueado", "Cerrado"};

    @Autowired
    public IngresoService(IngresoRepo ingresoRepo, CamaRepo camaRepo, PacienteRepo pacienteRepo, UsuarioRepo usuarioRepo, TrasladoRepo trasladoRepo, LiberarRepo liberarRepo){
        this.ingresoRepo = ingresoRepo;
        this.camaRepo = camaRepo;
        this.pacienteRepo = pacienteRepo;
        this.usuarioRepo = usuarioRepo;
        this.trasladoRepo = trasladoRepo;
        this.liberarRepo = liberarRepo;
    }

    public IngresoDTO findByConsecutivo(int consecutivo){
        Ingreso ingreso = getIngresoByConsecutivo(consecutivo);
        Paciente paciente  = pacienteRepo.findPacienteById(ingreso.getIdPaciente())
                .orElseThrow(() -> new ObjectNotFoundException("No se encuentra paciente"));
        return mapIngresoDTO(paciente, ingreso);
    }

    public List<IngresoDTO> findByPacienteName(String nombre){
        List<Ingreso> ingresos  = ingresoRepo.findIngresoRegistradoByPacienteNombre(nombre).orElseThrow(() -> new ObjectNotFoundException("no hay"));
        return findPacientesLista(ingresos);
    }

    public List<IngresoDTO> findByPacienteDoc(String doc){
        List<Ingreso> ingresos  = ingresoRepo.findIngresoRegistradoByPacienteDocumento(doc).orElseThrow(() -> new ObjectNotFoundException("no hay"));
        return findPacientesLista(ingresos);
    }

    private List<IngresoDTO> findPacientesLista(List<Ingreso> ingresos){
        List<IngresoDTO> dtos = new ArrayList<>();
        ingresos.forEach(ingreso -> {
            Paciente paciente = pacienteRepo.findPacienteById(ingreso.getIdPaciente()).orElseThrow(() -> new ObjectNotFoundException("No se encuentra paciente"));
            boolean noDuplicados = dtos.stream().map(IngresoDTO::getPaciente).noneMatch(String.valueOf(paciente.getNombreCompleto())::equals);
            if(noDuplicados){
                dtos.add(mapIngresoDTO(paciente, ingreso));
            }
        });
        return dtos;
    }

    private IngresoDTO mapIngresoDTO(Paciente paciente, Ingreso ingreso){
        IngresoDTO nuevo = new IngresoDTO();
        nuevo.setDocumento(paciente.getDocumento());
        nuevo.setPaciente(paciente.getNombreCompleto().toUpperCase(Locale.ROOT));
        nuevo.setCama(setCamaIngreso(ingreso));
        nuevo.setConsecutivo(ingreso.getConsecutivo());
        nuevo.setFechaIngreso(ingreso.getFechaIngreso().toLocalDate());
        nuevo.setTipoRiesgo(tipoRiesgo[ingreso.getTipoRiesgo()]);
        nuevo.setTipoIngreso(tipoIngreso[ingreso.getTipoIngreso()]);
        nuevo.setCausaIngreso(causaIngreso[ingreso.getCausa()]);
        nuevo.setEstado(estadoIngreso[ingreso.getEstado()]);
        return nuevo;
    }

    private String setCamaIngreso(Ingreso ingreso){
        String currentCama = "";
        Cama cama = ingreso.getCama();
        if(cama!=null){
            if(cama.isOcupada()){
                currentCama = cama.getCodigoCama();
            }
        }
        return currentCama;
    }

   public Ingreso updateCamaEnIngresoParaTraslado(int consecutivo, String codigo, Principal usuario){
        Ingreso ingreso = getIngresoByConsecutivo(consecutivo);
        Cama nuevaCama = camaRepo.findByCodigoAndDesocupada(codigo).orElseThrow(()-> new ObjectNotFoundException("\nNo encontró cama disponible con codigo "+codigo));
        registrarTraslado(ingreso, nuevaCama, usuario);
        ingreso.realizarTraslado(nuevaCama);
        camaRepo.save(nuevaCama);
        return ingreso;
    }
    private void registrarTraslado(Ingreso ingreso, Cama nuevaCama, Principal usuario){
        Usuario user = usuarioRepo.findByUsuario(usuario.getName()).orElseThrow(()->new ObjectNotFoundException("Usuario no existe"));
        Traslado traslado = new Traslado(LocalDateTime.now(), ingreso.getCama(), nuevaCama, user);
        trasladoRepo.save(traslado);
    }

    public void liberarCamaIngreso(int consecutivo, Principal usuario) {
        try{
            Ingreso ingreso = getIngresoByConsecutivo(consecutivo);
            registrarLiberacion(ingreso, usuario);
            ingreso.ifCamaOcupadaLiberar();
        }
        catch (Exception e){
            throw new ObjectNotFoundException("Cama no vinculada a Ingreso "+consecutivo);
        }
    }
    private void registrarLiberacion(Ingreso ingreso, Principal usuario){
        Usuario user = usuarioRepo.findByUsuario(usuario.getName()).orElseThrow(()->new ObjectNotFoundException("Usuario no existe"));
        Liberar liberar = new Liberar(LocalDateTime.now(), ingreso.getCama(), ingreso, user);
        liberarRepo.save(liberar);
    }

    private Ingreso getIngresoByConsecutivo(int consecutivo){
        return ingresoRepo.findIngresoRegistradoByConsecutivo(consecutivo)
                .orElseThrow(()-> new ObjectNotFoundException("\nNo hay ingreso con estado Registrado con ese id "+consecutivo+"\n"));
    }
}