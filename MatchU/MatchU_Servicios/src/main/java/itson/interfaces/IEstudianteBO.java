/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.interfaces;

import dtos.EstudianteDTO;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author jalt2
 */
public interface IEstudianteBO {
    EstudianteDTO guardar(EstudianteDTO estudiante);
    Optional<EstudianteDTO> buscarPorId(Long id);
    Optional<EstudianteDTO> buscarPorCorreo(String correo);
    List<EstudianteDTO> listarTodosExcepto(Long idExcluido);
    List<EstudianteDTO> listarPendientesDeEvaluar(Long idEmisor);
    EstudianteDTO actualizar(EstudianteDTO estudiante);
    void eliminar(Long id);
}
