/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.views;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author jalt2
 */


public class PanelMatches extends JPanel {

    private JPanel panelLista;

    public PanelMatches() {
        setLayout(new BorderLayout());

        // 🔹 Contenedor vertical
        panelLista = new JPanel();
        panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));

        // 🔹 Scroll
        JScrollPane scroll = new JScrollPane(panelLista);
        scroll.setBorder(null);

        add(scroll, BorderLayout.CENTER);

        // 🔥 Agregar datos de prueba
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        panelLista.add(new ItemUsuario("Sofía Ramírez", "2 mutual friends", "img1.png"));
        panelLista.add(new ItemUsuario("Carlos Mendoza", "1 mutual friend", "img2.png"));
        panelLista.add(new ItemUsuario("Ana López", "3 mutual friends", "img3.png"));
    }
}
