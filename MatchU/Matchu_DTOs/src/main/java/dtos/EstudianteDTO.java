/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.List;

/**
 *
 * @author jalt2
 */
public class EstudianteDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String correo;
    private String carrera;
    private Integer semestre;
    private String intereses;
    private String contrasena;
    private List<String> hobbies;
    private boolean activo;

    public EstudianteDTO(Long id, String nombre, String apellidos, String correo, String carrera, Integer semestre, String intereses, String contrsena, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.carrera = carrera;
        this.semestre = semestre;
        this.intereses = intereses;
        this.contrasena = contrsena;
        this.activo = activo;
    }

    public EstudianteDTO(String nombre, String apellidos, String correo, String carrera, Integer semestre, String intereses, String contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.carrera = carrera;
        this.semestre = semestre;
        this.intereses = intereses;
        this.contrasena = contrasena;
        
    }

    public EstudianteDTO(Long id, String nombre, String apellidos, String correo, String carrera, Integer semestre, String intereses, String contrasena, List<String> hobbies, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.carrera = carrera;
        this.semestre = semestre;
        this.intereses = intereses;
        this.contrasena = contrasena;
        this.hobbies = hobbies;
        this.activo = activo;
    }
    
    
    

    public EstudianteDTO(Long id, String nombre, String apellidos, String correo, String carrera, Integer semestre, String intereses, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.carrera = carrera;
        this.semestre = semestre;
        this.intereses = intereses;
        this.activo = activo;
    }

    public EstudianteDTO() {
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    
    
    
    
}
