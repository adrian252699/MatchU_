package itson.matchu_dominio.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(
    name = "matches",
    uniqueConstraints = @UniqueConstraint(
        name = "uk_match",
        columnNames = {"id_estudiante1", "id_estudiante2"}
    )
)
public class Match implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_match")
    private Long idMatch;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estudiante1", nullable = false)
    private Estudiante estudiante1;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estudiante2", nullable = false)
    private Estudiante estudiante2;

    @Column(name = "fecha_match", nullable = false)
    private LocalDateTime fechaMatch;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("fechaEnvio ASC")
    private List<Mensaje> mensajes = new ArrayList<>();

    public Match() {}

    public Match(Estudiante e1, Estudiante e2) {
        this.estudiante1 = e1;
        this.estudiante2 = e2;
        this.fechaMatch  = LocalDateTime.now();
    }
    
    
    //no me jala esta madre no se pq
//    public Estudiante getOtroEstudiante(Estudiante yo) {
//        if (estudiante1 != null && estudiante1.getIdEstudiante() != null
//            && estudiante1.getIdEstudiante().equals(yo.getIdEstudiante())) {
//        return estudiante2;
//    }
//    return estudiante1;
//}

    public Long getIdMatch() {
        return idMatch;
    }
    
    public void setIdMatch(Long id) {
        this.idMatch = id;
    }
    
    public Estudiante getEstudiante1() {
        return estudiante1;
    }
    
    public void setEstudiante1(Estudiante e) {
        this.estudiante1 = e;}
    
    public Estudiante getEstudiante2() {
        return estudiante2;
    }
    
    public void setEstudiante2(Estudiante e) {
        this.estudiante2 = e;
    }
    
    public LocalDateTime getFechaMatch() {
        return fechaMatch;
    }
    
    public void setFechaMatch(LocalDateTime dt) {
        this.fechaMatch = dt;
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public List<Mensaje> getMensajes() {
        return mensajes;
    }
    
    public void setMensajes(List<Mensaje> m) {
        this.mensajes = m;
    }
}