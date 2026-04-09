/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.interfaces;

import itson.matchu_dominio.models.Interaccion;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jalt2
 */
public interface IInteraccionDAO {
    Interaccion guardar(Interaccion interaccion);
    Optional<Interaccion> buscar(Long idEmisor, Long idReceptor);
    boolean dioCLikeA(Long idEmisor, Long idReceptor);
    List<Interaccion> listarLikesEnviados(Long idEmisor);
    
}
