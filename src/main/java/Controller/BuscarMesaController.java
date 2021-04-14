/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Conexion;
import View.Mesa;
import View.MirarMesas;
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
 * @author RICARDO
 */
public class BuscarMesaController {
    
    Mesa m;
    MirarMesas mm;
    
    public BuscarMesaController(MirarMesas mm){
        this.mm = mm;
    }
    
    public List<Mesa> buscarMeseros(){

       List<Mesa> mes = new ArrayList<Mesa>();

       try{
           String sql="SELECT * FROM \"Mesa\" where nombre = ?;";

           PreparedStatement ps = new Conexion().getConexion().prepareStatement(sql);
           ps.setString(1, mm.getNombre());
           ResultSet rs = ps.executeQuery();
           ps.close();

           while(rs.next()){
               
               Mesa me = new Mesa();
               
               me.setEstado(rs.getBoolean("estado"));
               me.setNombre(rs.getString("nombre"));
              
               
               mes.add(me);
           }

           return mes;


       }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
           JOptionPane.showMessageDialog(null, x.getMessage());
       }

       return mes;

   }
    
}
