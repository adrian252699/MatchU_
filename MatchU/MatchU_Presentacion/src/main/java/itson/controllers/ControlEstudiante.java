/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.controllers;

import dtos.EstudianteDTO;
import fabricaBO.FabricaBO;
import itson.interfaces.IEstudianteBO;


/**
 *
 * @author jalt2
 */
public class ControlEstudiante {
    IEstudianteBO estudianteBO;

    public ControlEstudiante() {
        estudianteBO = FabricaBO.crearEstudianteBO();
    }
    
    public EstudianteDTO registrar(EstudianteDTO nuevoEstudiante){
        return estudianteBO.guardar(nuevoEstudiante);
    }
}
