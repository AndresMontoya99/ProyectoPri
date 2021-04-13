/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexion;
import View.Mesa;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrew
 */
public class MesaController {
    
    private Mesa ms;

    public MesaController(Mesa ms) {
        this.ms = ms;
    }
    
    public void cerrar(){
        ms.dispose();;
    }
    
    public void guardar(){
        try{
            String sql="INSERT INTO \"Mesa\"(nombre, capacidad, estado) VALUES (?, ?, ?);";
            
            int hola = ms.getCapacidad();
            
            PreparedStatement ps= new Conexion().getConexion().prepareStatement(sql);
            ps.setString(1, ms.getNombre());
            ps.setInt(2, ms.getCapacidad());
            ps.setBoolean(3, ms.getEstado());
            
            ps.execute();
            ps.close();

            ms.vaciar();
            
            JOptionPane.showMessageDialog(ms,"Guardado correctamente");
            
        }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
            JOptionPane.showMessageDialog(ms, x.getMessage());
        } 
    
    }
    
}
