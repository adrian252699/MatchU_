/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package itson.interfaces;

import itson.matchu_dominio.models.Hobby;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author jalt2
 */
public interface IHobbyDAO {
    Hobby guardar(Hobby hobby);
    List<Hobby> listarTodos();
    Optional<Hobby> buscarPorNombre(String nombre);
    void inicializarHobbiesPorDefecto();
            
}
