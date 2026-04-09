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
@Table(name = "estudiantes")
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstudiante;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 150)
    private String apellidos;

    @Column(name = "correo", nullable = false, unique = true, length = 200)
    private String correo;

    @Column(name = "contrasena", nullable = false, length = 200)
    private String contrasena;

    @Column(name = "carrera", length = 150)
    private String carrera;

    @Column(name = "semestre")
    private Integer semestre;

    @Column(name = "bio", length = 500)
    private String bio;

    @Lob
    @Column(name = "foto_perfil")
    private byte[] fotoPerfil;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "estudiante_hobby",
        joinColumns        = @JoinColumn(name = "id_estudiante"),
        inverseJoinColumns = @JoinColumn(name = "id_hobby")
    )
    private List<Hobby> hobbies = new ArrayList<>();

    @OneToMany(mappedBy = "emisor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Interaccion> interaccionesEnviadas = new ArrayList<>();

    @OneToMany(mappedBy = "receptor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Interaccion> interaccionesRecibidas = new ArrayList<>();

    @OneToMany(mappedBy = "estudiante1", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Match> matchesComoEstudiante1 = new ArrayList<>();

    @OneToMany(mappedBy = "estudiante2", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Match> matchesComoEstudiante2 = new ArrayList<>();

    public Estudiante() {}

    public Estudiante(String nombre, String apellidos, String correo, String contrasena, String carrera, Integer semestre) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public byte[] getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(byte[] fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }
    
    public List<Interaccion> getInteraccionesEnviadas() 
    { return interaccionesEnviadas;
    }
    public List<Interaccion> getInteraccionesRecibidas() { 
        return interaccionesRecibidas;
    }
    public List<Match> getMatchesComoEstudiante1() { 
        return matchesComoEstudiante1;
    }
    public List<Match> getMatchesComoEstudiante2() { 
        return matchesComoEstudiante2;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    @Override
    public String toString() {
        return getNombreCompleto() + " <" + correo + ">";
    }
}