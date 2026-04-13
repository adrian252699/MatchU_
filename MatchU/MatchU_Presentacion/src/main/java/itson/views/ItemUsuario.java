/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.views;


import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jalt2
 */
public class ItemUsuario extends JPanel {

    public ItemUsuario(String nombre, String info, String rutaImagen) {
        setLayout(new BorderLayout());
        setMaximumSize(new Dimension(350, 70));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Imagen
        JLabel lblImagen = new JLabel(new ImageIcon(rutaImagen));

        // Texto
        JLabel lblNombre = new JLabel(nombre);
        JLabel lblInfo = new JLabel(info);

        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new BoxLayout(panelTexto, BoxLayout.Y_AXIS));
        panelTexto.add(lblNombre);
        panelTexto.add(lblInfo);

        // Botón (ejemplo corazón)
        JButton btn = new JButton("❤");

        add(lblImagen, BorderLayout.WEST);
        add(panelTexto, BorderLayout.CENTER);
        add(btn, BorderLayout.EAST);
    }
}
