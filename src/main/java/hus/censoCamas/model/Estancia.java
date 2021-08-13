package hus.censoCamas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "HPNESTANC")
public class Estancia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ADNINGRES", referencedColumnName = "OID",nullable=false)
    private Ingreso ingreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="HPNDEFCAM", referencedColumnName = "OID",nullable=false)
    private Cama cama;

    @Column(name = "HESFECING")
    private LocalDateTime fechaIngresoCama;
    @Column(name = "HESTIPOES")
    private int tipoEstancia;
    @Column(name = "HESFECSAL")
    private LocalDateTime fechaEgresoCama;
    @Column(name = "HESTRAURG")
    private boolean trasladoUrg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="GENUSUARIO", referencedColumnName = "OID",nullable=false)
    private Usuario usuario;

    public Estancia(){

    }

    public Estancia(Ingreso ingreso, Cama cama, LocalDateTime fechaIngresoCama, int tipoEstancia, LocalDateTime fechaEgresoCama, boolean trasladoUrg, Usuario usuario) {
        this.ingreso = ingreso;
        this.cama = cama;
        this.fechaIngresoCama = fechaIngresoCama;
        this.tipoEstancia = tipoEstancia;
        this.fechaEgresoCama = fechaEgresoCama;
        this.trasladoUrg = trasladoUrg;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    public Cama getCama() {
        return cama;
    }

    public void setCama(Cama cama) {
        this.cama = cama;
    }

    public LocalDateTime getFechaIngresoCama() {
        return fechaIngresoCama;
    }

    public void setFechaIngresoCama(LocalDateTime fechaIngresoCama) {
        this.fechaIngresoCama = fechaIngresoCama;
    }

    public int getTipoEstancia() {
        return tipoEstancia;
    }

    public void setTipoEstancia(int tipoEstancia) {
        this.tipoEstancia = tipoEstancia;
    }

    public LocalDateTime getFechaEgresoCama() {
        return fechaEgresoCama;
    }

    public void setFechaEgresoCama(LocalDateTime fechaEgresoCama) {
        this.fechaEgresoCama = fechaEgresoCama;
    }

    public boolean isTrasladoUrg() {
        return trasladoUrg;
    }

    public void setTrasladoUrg(boolean trasladoUrg) {
        this.trasladoUrg = trasladoUrg;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
