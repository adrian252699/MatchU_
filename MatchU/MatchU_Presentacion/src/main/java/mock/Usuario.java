/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mock;

/**
 *
 * @author jalt2
 */
public class Usuario {
    private String nombre;
    private String rutaImagen;

    public Usuario(String nombre, String rutaImagen) {
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
    }

    public String getNombre() { return nombre; }
    public String getRutaImagen() { return rutaImagen; }
}
