package hus.censoCamas.model;

import hus.censoCamas.security.entity.Usuario;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CAMALIBERADA")
public class Liberar {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "liberar_generator")
    @SequenceGenerator(name="liberar_generator", sequenceName = "liberar_sequence", allocationSize=1)
    @Column(name="OID",updatable = false,nullable = false)
    private Integer id;
    @Column(name = "FECHALIB")
    private LocalDateTime fechaLiberacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="HPNDEFCAM", referencedColumnName = "OID")
    private Cama camaLiberada;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ADNINGRESO", referencedColumnName = "OID")
    private Ingreso ingreso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="HPNCENSOUSU", referencedColumnName = "OID")
    private Usuario usuario;

    public Liberar(LocalDateTime fechaLiberacion, Cama camaLiberada, Ingreso ingreso, Usuario usuario) {
        this.fechaLiberacion = fechaLiberacion;
        this.camaLiberada = camaLiberada;
        this.ingreso = ingreso;
        this.usuario = usuario;
    }

}
