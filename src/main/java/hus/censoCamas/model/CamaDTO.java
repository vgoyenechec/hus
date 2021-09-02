package hus.censoCamas.model;

public class CamaDTO {
    private int oid;
    private String codigo;
    private String nombre;
    private String estado;
    private int grupo;
    private int subgrupo;
    private int tipocama;

    public CamaDTO() {
    }

    public CamaDTO(int oid, String codigo, String nombre, String estado, int grupo, int subgrupo, int tipocama) {
        this.oid = oid;
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.tipocama = tipocama;
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

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(int subgrupo) {
        this.subgrupo = subgrupo;
    }

    public int getTipocama() {
        return tipocama;
    }

    public void setTipocama(int tipocama) {
        this.tipocama = tipocama;
    }
}
