/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Conexion;
import Model.Usuario;
import View.Menu;
import View.Login;
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
public class UsuarioController {
    
    private Login lg;
    private Usuario us;
    
    public UsuarioController(Login lg){
        this.lg = lg;
    }
    
    public void buscar(){
        us = buscarUsuario();
        mostrarMenu();
        
    }
    
    public Usuario mostrarMenu(){
        
        Menu ga = new Menu(us);
        
        if(us.getTipo() == 1){
            
            ga.setVisible(true);
            ga.btnPedidos.setEnabled(false);
            ga.btnModificar.setEnabled(false);
            lg.setVisible(false);
        }
        if(us.getTipo() == 2){
            
            ga.btnMeseros.setEnabled(false);
            ga.jcbProducto.setEnabled(false);
            ga.btnMesas.setEnabled(false);
            ga.btnResumen.setEnabled(false);
            ga.btnVer.setEnabled(false);
            ga.setVisible(true);
            lg.setVisible(false);
        }
        if(us.getTipo() == 0){
            JOptionPane.showMessageDialog(lg, "Usuario invalido, Por favor verifique los datos");
            //lg.vaciarUsuario();
        }
        return us;
    }
    
    
     public Usuario buscarUsuario(){
        
        Usuario usu = new Usuario();
        
        try{
            String sql="SELECT * FROM \"Usuario\" where nombre = ? and contrasena = ?;";

            PreparedStatement ps= new Conexion().getConexion().prepareStatement(sql);
            ps.setString(1, lg.getNombre());
            ps.setString(2, lg.getContrasena());
            ResultSet rs = ps.executeQuery();
            ps.close();
            
            while(rs.next()){
                usu.setNombre(rs.getString("nombre"));
                usu.setTipo(rs.getInt("tipo"));
            }
            
            return usu;
           
            
        }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
            JOptionPane.showMessageDialog(null, x.getMessage());
        }
        
        return usu;
        
    }
     
    public List<Usuario> buscarMeseros(){

       List<Usuario> usus = new ArrayList<Usuario>();

       try{
           String sql="SELECT * FROM \"Usuario\" where tipo = 2;";

           PreparedStatement ps = new Conexion().getConexion().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           ps.close();

           while(rs.next()){
               
               Usuario usu = new Usuario();
               
               usu.setId(rs.getInt("id"));
               usu.setNombre(rs.getString("nombre"));
               usu.setTipo(rs.getInt("tipo"));
               
               usus.add(usu);
           }

           return usus;


       }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
           JOptionPane.showMessageDialog(null, x.getMessage());
       }

       return usus;

   }
    
}