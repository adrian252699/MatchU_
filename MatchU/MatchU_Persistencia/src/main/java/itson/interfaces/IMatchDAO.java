/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.interfaces;

import itson.matchu_dominio.models.Match;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jalt2
 */
public interface IMatchDAO {
    Match guardar(Match match);
    Optional<Match> buscarEntre(Long idA, Long idB);
    List<Match> listarMatchesDeEstudiante(Long idEstudiante);
    Optional<Match> buscarPorId(Long idMatch);
}
