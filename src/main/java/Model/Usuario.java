/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.CrearMesero;
import View.Menú;
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
    
    private String usuario,contraseña;

    public Usuario() {
        
    }

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return  "usuario =" + usuario + "\ncontraseña =" + contraseña ;
    }
    
    public int buscarUsuario(){
        int count = -1;
        String n = "";
        try{
            String sql="SELECT count(*) as n FROM \"Usuario\" where nombre = ? and contrasena = ?;";

            PreparedStatement ps= new Conexion().getConexion().prepareStatement(sql);
            ps.setString(1,usuario);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            ps.close();
            
            while(rs.next()){
                count = rs.getInt("n");
            }
            if(usuario.equals("admin")){
                count = 2;
            }
            return count;
           
            
        }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
            JOptionPane.showMessageDialog(null, x.getMessage());
        }
        
        return count;
        
    }
   
}
