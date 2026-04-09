package itson.matchu_dominio.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(
    name = "interacciones",
    uniqueConstraints = @UniqueConstraint(
        name = "uk_interaccion",
        columnNames = {"id_emisor", "id_receptor"}
    )
)
public class Interaccion implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public enum TipoInteraccion { LIKE, SKIP }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interaccion")
    private Long idInteraccion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_emisor", nullable = false)
    private Estudiante emisor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_receptor", nullable = false)
    private Estudiante receptor;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 10)
    private TipoInteraccion tipo;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    public Interaccion() {}

    public Interaccion(Estudiante emisor, Estudiante receptor, TipoInteraccion tipo) {
        this.emisor    = emisor;
        this.receptor  = receptor;
        this.tipo      = tipo;
        this.fechaHora = LocalDateTime.now();
    }

    public Long getIdInteraccion() {
        return idInteraccion;
    }

    public void setIdInteraccion(Long idInteraccion) {
        this.idInteraccion = idInteraccion;
    }

    public Estudiante getEmisor() {
        return emisor;
    }

    public void setEmisor(Estudiante emisor) {
        this.emisor = emisor;
    }

    public Estudiante getReceptor() {
        return receptor;
    }

    public void setReceptor(Estudiante receptor) {
        this.receptor = receptor;
    }

    public TipoInteraccion getTipo() {
        return tipo;
    }

    public void setTipo(TipoInteraccion tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

}