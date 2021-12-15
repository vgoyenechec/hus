package hus.censoCamas.model;

import hus.censoCamas.security.entity.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRASLADO")
public class Traslado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "traslado_generator")
    @SequenceGenerator(name="traslado_generator", sequenceName = "traslado_sequence", allocationSize=1)
    @Column(name="OID",updatable = false,nullable = false)
    private Integer id;
    @Column(name = "FECHATRAS")
    private LocalDateTime fechaTraslado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="HPNDEFCAM1", referencedColumnName = "OID")
    private Cama camaOriginal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="HPNDEFCAM2", referencedColumnName = "OID")
    private Cama camaTrasladada;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="HPNCENSOUSU", referencedColumnName = "OID")
    private Usuario usuario;

    public Traslado(LocalDateTime fechaTraslado, Cama camaOriginal, Cama camaTrasladada, Usuario usuario) {
        this.fechaTraslado = fechaTraslado;
        this.camaOriginal = camaOriginal;
        this.camaTrasladada = camaTrasladada;
        this.usuario = usuario;
    }

}
