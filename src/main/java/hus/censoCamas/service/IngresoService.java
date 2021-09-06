package hus.censoCamas.service;

import hus.censoCamas.exception.UserNotFoundException;
import hus.censoCamas.model.Cama;
import hus.censoCamas.model.Ingreso;
import hus.censoCamas.model.IngresoPaciente;
import hus.censoCamas.model.Paciente;
import hus.censoCamas.repo.CamaRepo;
import hus.censoCamas.repo.IngresoRepo;
import hus.censoCamas.repo.PacienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class IngresoService {
    private final IngresoRepo ingresoRepo;
    private final CamaRepo camaRepo;
    private final PacienteRepo pacienteRepo;
    private String[] tipoRiesgo = new String[] {"Ninguna", "Accidente_De_Transito", "Catastrofe", "Enfermedad_General_Y_Maternidad", "Accidente_De_Trabajo", "Enfermedad_Profesional", "Atención_Inicial_De_Urgencias", "Otro_Tipo_De_Accidente", "Lesión_Por_Agresión", "Lesión_Autoinfligida", "Maltrato_Físico", "Promoción_Y_Prevención", "Otro", "Accidente_Rábico", "Accidente_Ofídico", "Sospecha_De_Abuso_Sexual", "Sospecha_De_Violencia_Sexual", "Sospecha_De_Maltrato_Emocional"};
    private String[] tipoIngreso = new String[]{"Ambulatorio", "Hospitalario"};
    private String[] causaIngreso = new String[]{"Ninguna","Enfermedad_Profesional", "Heridos_En_Combate","Enfermedad_General_Adulto","Enfermedad_General_Pediatria","Odontología","Accidente_De_Transito","Catastrofe_Fisalud","Quemados","Maternidad","Accidente_Laboral","Cirugia_Programada"};
    private String[] estadoIngreso = new String[]{"Registrado", "Facturado", "Anulado", "Bloqueado", "Cerrado"};

    @Autowired
    public IngresoService(IngresoRepo ingresoRepo, CamaRepo camaRepo, PacienteRepo pacienteRepo){
        this.ingresoRepo = ingresoRepo;
        this.camaRepo = camaRepo;
        this.pacienteRepo = pacienteRepo;
    }

    private IngresoPaciente mapIngreso(Paciente pac, Ingreso i, IngresoPaciente nuevo){
        nuevo.setDocumento(pac.getDocumento());
        nuevo.setPaciente(pac.getNombreCompleto().toUpperCase(Locale.ROOT));
        nuevo.setConsecutivo(i.getConsecutivo());
        nuevo.setFechaIngreso(i.getFechaIngreso().toLocalDate());
        nuevo.setTipoRiesgo(tipoRiesgo[i.getTipoRiesgo()]);
        nuevo.setTipoIngreso(tipoIngreso[i.getTipoIngreso()-1]);
        nuevo.setCausaIngreso(causaIngreso[i.getCausa()]);
        nuevo.setEstado(estadoIngreso[i.getEstado()]);

        return nuevo;
    }

    public List<Ingreso> findAllIngresos(){
        return ingresoRepo.findAll();
    }

    public Ingreso findById(Integer id){
       return ingresoRepo.findById(id)
                .orElseThrow(()-> new UserNotFoundException("No se ha encontrado el ingreso con número "+id));
    }

    public IngresoPaciente findByPacienteDoc(String doc){
        Paciente pac = pacienteRepo.findByDocumento(doc)
        .orElseThrow(()-> new UserNotFoundException("No se ha encontrado ningun paciente con número de documento "+doc));
        Ingreso i = ingresoRepo.findByPacienteOrderByFechaIngresoDesc(pac.getId())
                .orElseThrow(()-> new UserNotFoundException("No se ha encontrado ingreso con número "+doc));
        //Ingreso i = ingresos.get(0);
        return mapIngreso(pac, i, new IngresoPaciente());
    }

    public List<IngresoPaciente>  findByPacienteNombre(String nombre){
        List<Paciente> pacientes = pacienteRepo.findPacienteByNombreContainingIngreso(nombre);
        List<IngresoPaciente> ingresos = new ArrayList<>();
        pacientes.forEach(pac ->{
            Ingreso ingreso = ingresoRepo.findByPacienteOrderByFechaIngresoDesc(pac.getId())
                    .orElseThrow(() -> new UserNotFoundException("no encontró"));
            ingresos.add(mapIngreso(pac, ingreso, new IngresoPaciente()));
        });
        return ingresos;
    }

    public IngresoPaciente findByConsecutivo(int consecutivo){
        Ingreso ingreso = ingresoRepo.findIngresoByConsecutivo(consecutivo)
                .orElseThrow(()-> new UserNotFoundException("No se ha encontrado el ingreso con número "+consecutivo));
        Paciente pac  = pacienteRepo.findPacienteById(ingreso.getPaciente().getId())
                .orElseThrow(() -> new UserNotFoundException("No se encuentra paciente"));
        return mapIngreso(pac, ingreso, new IngresoPaciente());
    }

   public Ingreso updateIngresoCama(Integer id, String codigo){
        Ingreso ingreso = ingresoRepo.findIngresoById(id)
                .orElseThrow(()-> new UserNotFoundException("No se encuentra un ingreso con este codigo: "+id));
        Cama nuevaCama = camaRepo.findByCodigo(codigo);

        if(nuevaCama.getEstadoCama() == 1){ ingreso.setCama(nuevaCama); }
        else{ throw new UserNotFoundException("La cama no está disponible"); }
        return ingresoRepo.save(ingreso);
    }
}