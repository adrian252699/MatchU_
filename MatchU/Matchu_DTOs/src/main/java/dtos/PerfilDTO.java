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
public class PerfilDTO {
    private Long id;
    private String nombre;
    private String carrera;
    private Integer semestre;
    private String bio;
    private byte[] fotoPerfil;
    private List<String> hobbie;

    public PerfilDTO(Long id, String nombre, String carrera, Integer semestre, String bio, byte[] fotoPerfil, List<String> hobbie) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
        this.bio = bio;
        this.fotoPerfil = fotoPerfil;
        this.hobbie = hobbie;
    }

    public PerfilDTO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public List<String> getHobbie() {
        return hobbie;
    }

    public void setHobbie(List<String> hobbie) {
        this.hobbie = hobbie;
    }
    
    
            
            
}
