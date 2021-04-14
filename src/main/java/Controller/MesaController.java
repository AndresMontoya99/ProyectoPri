/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Conexion;
import Model.Usuario;
import Model.Mesa;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrew
 */
public class MesaController {
    
    private View.Mesa ms;

    public MesaController(View.Mesa ms) {
        this.ms = ms;
    }
    
    public void cerrar(){
        ms.dispose();
    }
    
    public void guardar(){
        try{
            String sql="INSERT INTO \"Mesa\"(nombre, capacidad, estado) VALUES (?, ?, ?);";
            
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
    
    public List<Mesa> buscarMesas(){

       List<Mesa> mesas = new ArrayList<Mesa>();

       try{
           String sql="SELECT * FROM \"Mesa\" where estado = TRUE;";

           PreparedStatement ps = new Conexion().getConexion().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           ps.close();

           while(rs.next()){
               
               Mesa mesa = new Mesa();
               
               mesa.setId(rs.getInt("id"));
               mesa.setNombre(rs.getString("nombre"));
               mesa.setCapacidad(rs.getInt("capacidad"));
               
               mesas.add(mesa);
           }

           return mesas;


       }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
           JOptionPane.showMessageDialog(null, x.getMessage());
       }

       return mesas;

   }
    
}
