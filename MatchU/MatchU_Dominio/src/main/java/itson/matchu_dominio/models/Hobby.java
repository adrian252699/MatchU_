package itson.matchu_dominio.models;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo
 */
@Entity
@Table(name = "hobbies")
public class Hobby implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hobby")
    private Long idHobby;

    @Column(name = "nombre", nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(name = "categoria", length = 80)
    private String categoria;

    @ManyToMany(mappedBy = "hobbies")
    private List<Estudiante> estudiantes = new ArrayList<>();

    public Hobby() {}

    public Hobby(String nombre, String categoria) {
        this.nombre    = nombre;
        this.categoria = categoria;
    }

    public Long getIdHobby() {
        return idHobby;
    }

    public void setIdHobby(Long idHobby) {
        this.idHobby = idHobby;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override public String toString() { return nombre; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hobby)) return false;
        Hobby other = (Hobby) o;
        return idHobby != null && idHobby.equals(other.idHobby);
    }

    @Override
    public int hashCode() { return idHobby != null ? idHobby.hashCode() : 0; }
}