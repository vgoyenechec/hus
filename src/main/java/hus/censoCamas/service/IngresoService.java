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
        List<Ingreso> ingresos = ingresoRepo.findByPacienteOrderByFechaIngresoDesc(pac)
                .orElseThrow(()-> new UserNotFoundException("No se ha encontrado ingreso con número "+doc));
        Ingreso i = ingresos.get(0);
        IngresoPaciente nuevo = new IngresoPaciente();
        nuevo.setDocumento(pac.getDocumento());
        nuevo.setPaciente(pac.getNombreCompleto().toUpperCase(Locale.ROOT));
        nuevo.setConsecutivo(i.getConsecutivo());
        nuevo.setFechaIngreso(i.getFechaIngreso().toLocalDate());
        switch(i.getTipoRiesgo()){
            case 0:
                nuevo.setTipoRiesgo("Ninguna");
            case 1:
                nuevo.setTipoRiesgo("Accidente_De_Transito");
            case 2:
                nuevo.setTipoRiesgo("Catastrofe");
            case 3:
                nuevo.setTipoRiesgo("Enfermedad_General_Y_Maternidad");
            case 4:
                nuevo.setTipoRiesgo("Accidente_De_Trabajo");
            case 5:
                nuevo.setTipoRiesgo("Enfermedad_Profesional");
            case 6:
                nuevo.setTipoRiesgo("Atención_Inicial_De_Urgencias");
            case 7:
                nuevo.setTipoRiesgo("Otro_Tipo_De_Accidente");
            case 8:
                nuevo.setTipoRiesgo("Lesión_Por_Agresión");
            case 9:
                nuevo.setTipoRiesgo("Lesión_Autoinfligida");
            case 10:
                nuevo.setTipoRiesgo("Maltrato_Físico");
            case 11:
                nuevo.setTipoRiesgo("Promoción_Y_Prevención");
            case 12:
                nuevo.setTipoRiesgo("Otro");
            case 13:
                nuevo.setTipoRiesgo("Accidente_Rábico");
            case 14:
                nuevo.setTipoRiesgo("Accidente_Ofídico");
            case 15:
                nuevo.setTipoRiesgo("Sospecha_De_Abuso_Sexual");
            case 16:
                nuevo.setTipoRiesgo("Sospecha_De_Violencia_Sexual");
            case 17:
                nuevo.setTipoRiesgo("Sospecha_De_Maltrato_Emocional");
        }
        switch (i.getCausa()){
            case 0:
                nuevo.setCausaIngreso("Ninguna");
            case 1:
                nuevo.setCausaIngreso("Enfermedad_Profesional");
            case 2:
                nuevo.setCausaIngreso("Heridos_En_Combate");
            case 3:
                nuevo.setCausaIngreso("Enfermedad_General_Adulto");
            case 4:
                nuevo.setCausaIngreso("Enfermedad_General_Pediatria");
            case 5:
                nuevo.setCausaIngreso("Odontología");
            case 6:
                nuevo.setCausaIngreso("Accidente_De_Transito");
            case 7:
                nuevo.setCausaIngreso("Catastrofe_Fisalud");
            case 8:
                nuevo.setCausaIngreso("Quemados");
            case 9:
                nuevo.setCausaIngreso("Maternidad");
            case 10:
                nuevo.setCausaIngreso("Accidente_Laboral");
            case 11:
                nuevo.setCausaIngreso("Cirugia_Programada");
        }
        switch (i.getTipoIngreso()){
            case 0:
                nuevo.setTipoIngreso("Ambulatorio");
            case 1:
                nuevo.setTipoIngreso("Hospitalario");
            case 2:
                nuevo.setTipoIngreso("2)");
        }
        switch (i.getEstado()){
            case 0:
                nuevo.setEstado("Registrado");
            case 1:
                nuevo.setEstado("Facturado");
            case 2:
                nuevo.setEstado("Anulado");
            case 3:
                nuevo.setEstado("Bloqueado");
            case 4:
                nuevo.setEstado("Cerrado");
        }
        return nuevo;
    }

    public Set<IngresoPaciente>  findByPacienteNombre(String nombre){
        List<Paciente> pacientes = pacienteRepo.findPacienteByNombreContaining(nombre);
        Set<IngresoPaciente> ingresos = new HashSet<IngresoPaciente>();
        ;
        pacientes.forEach(pac ->{
            List<Ingreso> ingresosP = ingresoRepo.findByPacienteOrderByFechaIngresoDesc(pac)
                    .orElseThrow(()->new UserNotFoundException("no encontró"));
            Ingreso i = ingresosP.get(0);
            //ingresosP.forEach(i -> {
                IngresoPaciente nuevo = new IngresoPaciente();
                nuevo.setDocumento(pac.getDocumento());
                nuevo.setPaciente(pac.getNombreCompleto().toUpperCase(Locale.ROOT));
                nuevo.setConsecutivo(i.getConsecutivo());
                nuevo.setFechaIngreso(i.getFechaIngreso().toLocalDate());
                switch(i.getTipoRiesgo()){
                    case 0:
                        nuevo.setTipoRiesgo("Ninguna");
                    case 1:
                        nuevo.setTipoRiesgo("Accidente_De_Transito");
                    case 2:
                        nuevo.setTipoRiesgo("Catastrofe");
                    case 3:
                        nuevo.setTipoRiesgo("Enfermedad_General_Y_Maternidad");
                    case 4:
                        nuevo.setTipoRiesgo("Accidente_De_Trabajo");
                    case 5:
                        nuevo.setTipoRiesgo("Enfermedad_Profesional");
                    case 6:
                        nuevo.setTipoRiesgo("Atención_Inicial_De_Urgencias");
                    case 7:
                        nuevo.setTipoRiesgo("Otro_Tipo_De_Accidente");
                    case 8:
                        nuevo.setTipoRiesgo("Lesión_Por_Agresión");
                    case 9:
                        nuevo.setTipoRiesgo("Lesión_Autoinfligida");
                    case 10:
                        nuevo.setTipoRiesgo("Maltrato_Físico");
                    case 11:
                        nuevo.setTipoRiesgo("Promoción_Y_Prevención");
                    case 12:
                        nuevo.setTipoRiesgo("Otro");
                    case 13:
                        nuevo.setTipoRiesgo("Accidente_Rábico");
                    case 14:
                        nuevo.setTipoRiesgo("Accidente_Ofídico");
                    case 15:
                        nuevo.setTipoRiesgo("Sospecha_De_Abuso_Sexual");
                    case 16:
                        nuevo.setTipoRiesgo("Sospecha_De_Violencia_Sexual");
                    case 17:
                        nuevo.setTipoRiesgo("Sospecha_De_Maltrato_Emocional");
                }
                switch (i.getCausa()){
                    case 0:
                        nuevo.setCausaIngreso("Ninguna");
                    case 1:
                        nuevo.setCausaIngreso("Enfermedad_Profesional");
                    case 2:
                        nuevo.setCausaIngreso("Heridos_En_Combate");
                    case 3:
                        nuevo.setCausaIngreso("Enfermedad_General_Adulto");
                    case 4:
                        nuevo.setCausaIngreso("Enfermedad_General_Pediatria");
                    case 5:
                        nuevo.setCausaIngreso("Odontología");
                    case 6:
                        nuevo.setCausaIngreso("Accidente_De_Transito");
                    case 7:
                        nuevo.setCausaIngreso("Catastrofe_Fisalud");
                    case 8:
                        nuevo.setCausaIngreso("Quemados");
                    case 9:
                        nuevo.setCausaIngreso("Maternidad");
                    case 10:
                        nuevo.setCausaIngreso("Accidente_Laboral");
                    case 11:
                        nuevo.setCausaIngreso("Cirugia_Programada");
                }
                switch (i.getTipoIngreso()){
                    case 0:
                        nuevo.setTipoIngreso("Ambulatorio");
                    case 1:
                        nuevo.setTipoIngreso("Hospitalario");
                    case 2:
                        nuevo.setTipoIngreso("2)");
                }
                switch (i.getEstado()){
                    case 0:
                        nuevo.setEstado("Registrado");
                    case 1:
                        nuevo.setEstado("Facturado");
                    case 2:
                        nuevo.setEstado("Anulado");
                    case 3:
                        nuevo.setEstado("Bloqueado");
                    case 4:
                        nuevo.setEstado("Cerrado");
                }
                ingresos.add(nuevo);
        });
        
        return ingresos;
    }

    public Ingreso findByConsecutivo(int consecutivo){
        return ingresoRepo.findIngresoByConsecutivo(consecutivo)
                .orElseThrow(()-> new UserNotFoundException("No se ha encontrado el ingreso con número "+consecutivo));
    }

   public Ingreso updateIngresoCama(Integer id, String codigo){
        Ingreso ingreso = ingresoRepo.findIngresoById(id)
                .orElseThrow(()-> new UserNotFoundException("No se encuentra un ingreso con este codigo: "+id));
        Cama nuevaCama = camaRepo.findByCodigo(codigo);

        if(nuevaCama.getEstadoCama() ==1){
            ingreso.setCama(nuevaCama);
        }
        else{
            throw new UserNotFoundException("La cama no está disponible");
        }
        return ingresoRepo.save(ingreso);
    }
}