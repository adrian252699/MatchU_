/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.bo;

import dtos.EstudianteDTO;
import excepciones.NegocioException;
import itson.daos.EstudianteDAO;
import itson.interfaces.IEstudianteBO;
import itson.interfaces.IEstudianteDAO;
import itson.matchu_dominio.models.Estudiante;
import java.util.List;
import java.util.Optional;
import mapper.EstudianteMapper;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author jalt2
 */
public class EstudianteBO implements IEstudianteBO{
    private final IEstudianteDAO estudianteDAO;

    public EstudianteBO(IEstudianteDAO estudianteDAO) {
        this.estudianteDAO = new EstudianteDAO();
    }

    @Override
    public EstudianteDTO guardar(EstudianteDTO estudianteDTO) {
        
        validarEstudiante(estudianteDTO);
        
        Estudiante estudiante = EstudianteMapper.toEntity(estudianteDTO);
        
        //Encriptar contraseña
        if (!estudiante.getContrasena().startsWith("$2a$")) {
            String hash = BCrypt.hashpw(estudiante.getContrasena(), BCrypt.gensalt());
            estudiante.setContrasena(hash);
        }
        
        Estudiante guardado = estudianteDAO.guardar(estudiante);
        
        return EstudianteMapper.toDTO(guardado);
    }

    @Override
    public Optional<EstudianteDTO> buscarPorId(Long id) {

        if (id == null || id <= 0) {
            throw new NegocioException("ID inválido");
        }

        return estudianteDAO.buscarPorId(id)
                .map(EstudianteMapper::toDTO);
    }

    @Override
    public Optional<EstudianteDTO> buscarPorCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            throw new NegocioException("Correo vacío");
        }

        return estudianteDAO.buscarPorCorreo(correo)
                .map(EstudianteMapper::toDTO);
    }

    @Override
    public List<EstudianteDTO> listarTodosExcepto(Long idExcluido) {
        if (idExcluido == null || idExcluido <= 0) {
            throw new NegocioException("ID inválido");
        }

        return EstudianteMapper.toDTOList(
                estudianteDAO.listarTodosExcepto(idExcluido)
        );
    }

    @Override
    public List<EstudianteDTO> listarPendientesDeEvaluar(Long idEmisor) {
        if (idEmisor == null || idEmisor <= 0) {
            throw new NegocioException("ID inválido");
        }

        return EstudianteMapper.toDTOList(
                estudianteDAO.listarPendientesDeEvaluar(idEmisor)
        );
    }


    @Override
    public EstudianteDTO actualizar(EstudianteDTO estudianteDTO) {
        if (estudianteDTO.getId() == null) {
            throw new NegocioException("ID requerido");
        }

        Estudiante existente = estudianteDAO.buscarPorId(estudianteDTO.getId())
                .orElseThrow(() -> new NegocioException("No encontrado"));

        // Validar cambio de correo
        if (!existente.getCorreo().equals(estudianteDTO.getCorreo())) {
            if (estudianteDAO.existeCorreo(estudianteDTO.getCorreo())) {
                throw new NegocioException("Correo ya registrado");
            }
        }

        validarEstudiante(estudianteDTO);

        // Mapper update
        EstudianteMapper.updateEntity(existente, estudianteDTO);

        Estudiante actualizado = estudianteDAO.actualizar(existente);

        return EstudianteMapper.toDTO(actualizado);
    }

    @Override
    public void eliminar(Long id) {
        if (id == null || id <= 0) {
            throw new NegocioException("ID inválido");
        }

        if (estudianteDAO.buscarPorId(id).isEmpty()) {
            throw new NegocioException("No existe");
        }

        estudianteDAO.eliminar(id);
    }
    
    
    
    private void validarEstudiante(EstudianteDTO estudiante){
        if (estudiante == null) {
        throw new NegocioException("El estudiante no puede ser null");
        }

        // Nombre
        if (estudiante.getNombre() == null || estudiante.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre no puede estar vacío");
        }

        // Apellidos
        if (estudiante.getApellidos() == null || estudiante.getApellidos().trim().isEmpty()) {
            throw new NegocioException("Los apellidos no pueden estar vacíos");
        }

        // Correo
        if (estudiante.getCorreo() == null || estudiante.getCorreo().trim().isEmpty()) {
            throw new NegocioException("El correo no puede estar vacío");
        }

        // Formato de correo
        if (!estudiante.getCorreo().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new NegocioException("El formato del correo no es válido");
        }

        // Carrera
        if (estudiante.getCarrera() == null || estudiante.getCarrera().trim().isEmpty()) {
            throw new NegocioException("La carrera no puede estar vacía");
        }

        // Semestre
        if (estudiante.getSemestre() == null || estudiante.getSemestre() < 1) {
            throw new NegocioException("El semestre debe ser mayor a 0");
        }

        // Contraseña
        if (estudiante.getContrasena() == null || estudiante.getContrasena().trim().isEmpty()) {
            throw new NegocioException("La contraseña no puede estar vacía");
        }

        if (estudiante.getContrasena().length() < 6) {
            throw new NegocioException("La contraseña debe tener al menos 6 caracteres");
        }
        
        
    }
}
