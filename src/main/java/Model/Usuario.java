/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.CrearMesero;
import View.Menu;
import View.Producto.GestionProductos1;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author RICARDO
 */
public class Usuario {
    
    private String nombre,contrasena;
    int tipo;

    public Usuario() {
        
    }

    public Usuario(String nombre, String contraseña, int tipo) {
        this.nombre = nombre;
        this.contrasena = contraseña;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  "nombre =" + nombre + "\ncontraseña =" + contrasena ;
    }
   
   
}
