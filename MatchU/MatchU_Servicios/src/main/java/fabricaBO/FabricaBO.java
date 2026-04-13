/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricaBO;

import itson.bo.EstudianteBO;
import itson.daos.EstudianteDAO;
import itson.interfaces.IEstudianteBO;
import itson.interfaces.IEstudianteDAO;

/**
 *
 * @author jalt2
 */
public class FabricaBO {
    public static IEstudianteBO crearEstudianteBO(){
        IEstudianteDAO estudianteDAO = new EstudianteDAO();
        IEstudianteBO estudianteBO = new EstudianteBO(estudianteDAO);
        return estudianteBO;
    }
}
