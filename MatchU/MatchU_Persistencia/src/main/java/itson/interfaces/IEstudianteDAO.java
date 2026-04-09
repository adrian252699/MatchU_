/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.interfaces;

import itson.matchu_dominio.models.Estudiante;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jalt2
 */
public interface IEstudianteDAO {
    Estudiante guardar(Estudiante estudiante);
    Optional<Estudiante> buscarPorId(Long id);
    Optional<Estudiante> buscarPorCorreo(String correo);
    List<Estudiante> listarTodosExcepto(Long idExcluido);
    List<Estudiante> listarPendientesDeEvaluar(Long idEmisor);
    boolean existeCorreo(String correo);
    Estudiante actualizar(Estudiante estudiante);
    void eliminar(Long id);
}
