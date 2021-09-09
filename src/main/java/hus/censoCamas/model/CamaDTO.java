package hus.censoCamas.model;

public class CamaDTO {
    private int oid;
    private String codigo;
    private String nombre;
    private String estado;
    private String grupo;
    private String subgrupo;
    private String tipocama;
    private String paciente;
    private String documento;
    private String ingreso;

    public CamaDTO(){}
    public CamaDTO(int oid, String codigo, String nombre, String estado, String grupo, String subgrupo, String tipocama, String paciente, String documento, String ingreso) {
        this.oid = oid;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.tipocama = tipocama;
        this.paciente = paciente;
        this.documento = documento;
        this.ingreso = ingreso;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

