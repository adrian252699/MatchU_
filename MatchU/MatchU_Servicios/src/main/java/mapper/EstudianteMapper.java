/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dtos.EstudianteDTO;
import dtos.PerfilDTO;
import itson.matchu_dominio.models.Estudiante;
import itson.matchu_dominio.models.Hobby;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author jalt2
 */
public class EstudianteMapper {
    
    
    public static EstudianteDTO toDTO(Estudiante e) {
        if (e == null) return null;

        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(e.getIdEstudiante());
        dto.setNombre(e.getNombre());
        dto.setApellidos(e.getApellidos());
        dto.setCorreo(e.getCorreo());
        dto.setCarrera(e.getCarrera());
        dto.setSemestre(e.getSemestre());
        dto.setIntereses(e.getIntereses());
        dto.setActivo(e.isActivo());

        return dto;
    }
    
    public static Estudiante toEntity(EstudianteDTO dto) {
        if (dto == null) return null;

        Estudiante e = new Estudiante();
        e.setNombre(dto.getNombre());
        e.setApellidos(dto.getApellidos());
        e.setCorreo(dto.getCorreo());
        e.setContrasena(dto.getContrasena()); // 🔐 se encripta en service
        e.setCarrera(dto.getCarrera());
        e.setSemestre(dto.getSemestre());
        e.setActivo(true);

        return e;
    }

    // 🔹 Entity → PerfilDTO (Tinder)
    public static PerfilDTO toPerfilDTO(Estudiante e) {
        if (e == null) return null;

        PerfilDTO dto = new PerfilDTO();
        dto.setId(e.getIdEstudiante());
        dto.setNombre(e.getNombre());
        dto.setCarrera(e.getCarrera());
        dto.setSemestre(e.getSemestre());
        dto.setBio(e.getIntereses());
        dto.setFotoPerfil(e.getFotoPerfil());

        // 🔥 Mapear hobbies (Entidad → String)
        if (e.getHobbies() != null) {
            dto.setHobbie(
                e.getHobbies().stream()
                    .map(Hobby::getNombre) // ajusta si tu atributo se llama distinto
                    .collect(Collectors.toList())
            );
        } else {
            dto.setHobbie(Collections.emptyList());
        }

        return dto;
    }

    

    // 🔹 Lista Entity → Lista PerfilDTO
    public static List<PerfilDTO> toPerfilDTOList(List<Estudiante> lista) {
        if (lista == null) return Collections.emptyList();

        return lista.stream()
                .map(EstudianteMapper::toPerfilDTO)
                .collect(Collectors.toList());
    }
    
    public static List<EstudianteDTO> toDTOList(List<Estudiante> lista) {
        if (lista == null) return Collections.emptyList();

        return lista.stream()
                .map(EstudianteMapper::toDTO)
                .collect(Collectors.toList());
    }

    
    public static void updateEntity(Estudiante e, EstudianteDTO dto) {
        if (e == null || dto == null) return;

        e.setNombre(dto.getNombre());
        e.setApellidos(dto.getApellidos());
        e.setCorreo(dto.getCorreo());
        e.setCarrera(dto.getCarrera());
        e.setSemestre(dto.getSemestre());
        e.setIntereses(dto.getIntereses());
        e.setActivo(dto.isActivo());
    }
}
