/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.interfaces;

import itson.matchu_dominio.models.Mensaje;
import java.util.List;

/**
 *
 * @author jalt2
 */
public interface IMensajeDAO {
    Mensaje guardar(Mensaje mensaje);
    List<Mensaje> listarPorMatch(Long idMatch);
    void marcarComoLeidos(Long idMatch, Long idDestinatario);
    long contarNoLeidos(Long idMatch, Long idDestinatario);
    
}
