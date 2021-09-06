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

    @Autowired
    public IngresoService(IngresoRepo ingresoRepo, CamaRepo camaRepo, PacienteRepo pacienteRepo){
        this.ingresoRepo = ingresoRepo;
        this.camaRepo = camaRepo;
        this.pacienteRepo = pacienteRepo;
    }

    public IngresoPaciente mapIngreso(Paciente pac, Ingreso i, IngresoPaciente nuevo){
        nuevo.setDocumento(pac.getDocumento());
        nuevo.setPaciente(pac.getNombreCompleto().toUpperCase(Locale.ROOT));
        nuevo.setConsecutivo(i.getConsecutivo());
        nuevo.setFechaIngreso(i.getFechaIngreso().toLocalDate());
        System.out.println("causa: "+i.getCausa());
        System.out.println("tipoI: "+i.getTipoIngreso());
        System.out.println("tipoR: "+i.getTipoRiesgo());
        System.out.println("estado: "+i.getEstado());
        System.out.println("consec: "+i.getConsecutivo());
        switch(i.getTipoRiesgo()){
            case 0:
                nuevo.setTipoRiesgo("Ninguna");
                break;
            case 1:
                nuevo.setTipoRiesgo("Accidente_De_Transito");
                break;
            case 2:
                nuevo.setTipoRiesgo("Catastrofe");
                break;
            case 3:
                nuevo.setTipoRiesgo("Enfermedad_General_Y_Maternidad");
                break;
            case 4:
                nuevo.setTipoRiesgo("Accidente_De_Trabajo");
                break;
            case 5:
                nuevo.setTipoRiesgo("Enfermedad_Profesional");
                break;
            case 6:
                nuevo.setTipoRiesgo("Atención_Inicial_De_Urgencias");
                break;
            case 7:
                nuevo.setTipoRiesgo("Otro_Tipo_De_Accidente");
                break;
            case 8:
                nuevo.setTipoRiesgo("Lesión_Por_Agresión");
                break;
            case 9:
                nuevo.setTipoRiesgo("Lesión_Autoinfligida");
                break;
            case 10:
                nuevo.setTipoRiesgo("Maltrato_Físico");
                break;
            case 11:
                nuevo.setTipoRiesgo("Promoción_Y_Prevención");
                break;
            case 12:
                nuevo.setTipoRiesgo("Otro");
                break;
            case 13:
                nuevo.setTipoRiesgo("Accidente_Rábico");
                break;
            case 14:
                nuevo.setTipoRiesgo("Accidente_Ofídico");
                break;
            case 15:
                nuevo.setTipoRiesgo("Sospecha_De_Abuso_Sexual");
                break;
            case 16:
                nuevo.setTipoRiesgo("Sospecha_De_Violencia_Sexual");
                break;
            case 17:
                nuevo.setTipoRiesgo("Sospecha_De_Maltrato_Emocional");
                break;
        }
        switch (i.getCausa()){
            case 0:
                nuevo.setCausaIngreso("Ninguna");
                break;
            case 1:
                nuevo.setCausaIngreso("Enfermedad_Profesional");
                break;
            case 2:
                nuevo.setCausaIngreso("Heridos_En_Combate");
                break;
            case 3:
                nuevo.setCausaIngreso("Enfermedad_General_Adulto");
                break;
            case 4:
                nuevo.setCausaIngreso("Enfermedad_General_Pediatria");
                break;
            case 5:
                nuevo.setCausaIngreso("Odontología");
                break;
            case 6:
                nuevo.setCausaIngreso("Accidente_De_Transito");
                break;
            case 7:
                nuevo.setCausaIngreso("Catastrofe_Fisalud");
                break;
            case 8:
                nuevo.setCausaIngreso("Quemados");
                break;
            case 9:
                nuevo.setCausaIngreso("Maternidad");
                break;
            case 10:
                nuevo.setCausaIngreso("Accidente_Laboral");
                break;
            case 11:
                nuevo.setCausaIngreso("Cirugia_Programada");
                break;
        }
        switch (i.getTipoIngreso()){
            case 1:
                nuevo.setTipoIngreso("Ambulatorio");
                break;
            case 2:
                nuevo.setTipoIngreso("Hospitalario");
                break;
        }
        switch (i.getEstado()){
            case (0):
                nuevo.setEstado("Registrado");
                break;
            case (1):
                nuevo.setEstado("Facturado");
                break;
            case (2):
                nuevo.setEstado("Anulado");
                break;
            case (3):
                nuevo.setEstado("Bloqueado");
                break;
            case (4):
                nuevo.setEstado("Cerrado");
                break;
        }
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
            System.out.println(pac.getId());
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