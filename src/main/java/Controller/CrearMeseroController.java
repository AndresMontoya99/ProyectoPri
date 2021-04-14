/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Conexion;
import Model.Usuario;
import View.CrearMesero;
import View.Menu;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author RICARDO
 */
public class CrearMeseroController {
    
    Usuario u;
    CrearMesero gm;
    
    public CrearMeseroController(CrearMesero gm){
        this.gm = gm;
    }
    
      public void CrearUsuario(){
        
        try{
            String sql="INSERT INTO \"Usuario\"(nombre, contrasena, tipo) VALUES (?, ?, ?);";
            
            
            PreparedStatement ps= new Conexion().getConexion().prepareStatement(sql);
            ps.setString(1, gm.getNombre());
            ps.setString(2, gm.getPassword());
            ps.setInt(3, 2);
            
            ps.execute();
            ps.close();

            gm.vaciarUsuario();
            
            JOptionPane.showMessageDialog(gm,"Guardado correctamente");
            
        }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
            JOptionPane.showMessageDialog(gm, x.getMessage());
        } 
    }
      
      public void irAtras(){
          gm.dispose();
//          Menu ga = new Menu();
//          ga.setVisible(true);
          
      }
}
