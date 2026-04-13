/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.controllers;


import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jalt2
 */
public class ControlNavegacion {
    
    private JPanel contenedor;
    private CardLayout layout;
    private JFrame frame;

    public ControlNavegacion(JPanel contenedor, JFrame frame) {
        this.contenedor = contenedor;
        this.layout = (CardLayout) contenedor.getLayout();
        this.frame = frame;
    }

    public void agregarPanel(JPanel panel, String nombre) {
        contenedor.add(panel, nombre);
    }

    public void mostrarPanel(String nombre) {
        layout.show(contenedor, nombre);

        switch(nombre) {
            case "login":
                frame.setSize(566, 712);
                break;
            case "bienvenida":
                frame.setSize(990, 642);
                break;
            case "registro":
                frame.setSize(566, 830);
                break;
                
            case "matches":
                frame.setSize(566, 830);
                break;
                
            case "explorar":
                frame.setSize(566, 830);
                break;   
                
            case "miPerfil":
                frame.setSize(566, 830);
                break;    
        }

        frame.revalidate();
        frame.repaint();
        frame.setLocationRelativeTo(null);
    }

    public void resize(int ancho, int alto) {
        frame.setPreferredSize(new Dimension(ancho, alto));
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
}
