package hus.censoCamas.dtos;

import hus.censoCamas.model.Cama;

public class CamaDTO {
    private String codigo;
    private String estado;
    private String grupo;
    private String subgrupo;
    private String tipocama;
    private String paciente;
    private String documento;
    private String ingreso;

    public CamaDTO(){}

    public void mapDTO(Cama cama, PacienteDTO pacienteDTO){
        setPaciente(pacienteDTO.getPaciente());
        setDocumento(pacienteDTO.getDocumento());
        setIngreso(pacienteDTO.getConsecutivo());
        setCodigo(cama.getCodigoCama());
        setGrupo(cama.getGrupo().getNombre());
        setSubgrupo(cama.getSubgrupo().getNombre());
        setTipocama(cama.getTipoCama().getNombre());
        setEstadoCamaDTO(cama);
    }

    private void setEstadoCamaDTO(Cama cama){
        switch (cama.getEstadoCama()){
            case 1:
                setEstado("Desocupada");
                break;
            case 2:
                checkEstadoOcupado(cama);
                break;
            case 3:
                setEstado("Bloqueada");
                break;
        }
    }

    private void checkEstadoOcupado(Cama cama){
        if(isPacienteRegistrado()){
            setEstado("Ocupada");
        }
        else{
            setEstado("Desocupada");
            cama.liberarCama();
        }
    }
    private boolean isPacienteRegistrado(){
        return !getPaciente().isEmpty();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    public String getTipocama() {
        return tipocama;
    }

    public void setTipocama(String tipocama) {
        this.tipocama = tipocama;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getDocumento() { return documento; }

    public void setDocumento(String documento) { this.documento = documento; }

    public String getIngreso() { return ingreso; }

    public void setIngreso(String ingreso) { this.ingreso = ingreso; }
}

