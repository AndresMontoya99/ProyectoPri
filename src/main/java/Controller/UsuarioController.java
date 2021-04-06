/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import View.Login;
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
    
    public void llenaDatos(){
    
       us = new Usuario();
       lg = new Login();
     
      // us.setUsuario("Administrador");
       //us.setContraseña("admin");
       
       try{
       us.setUsuario(lg.getUsuario());
       //ValidaVacio(us.getUsuario());
       us.setContraseña(lg.getContraseña());
       ValidaVacio(us.getContraseña());
       } catch(ExepcionVacio ex){
           
         JOptionPane.showMessageDialog(null, ex.getMessage());
       }
       
   }
    
    public void EvaluaDatos(){
        
        try{
       
        if( lg.getContraseña().equals(us.getContraseña())){
            JOptionPane.showMessageDialog( null, "La contraseña es incorrecta" );
            lg.txtContraseña.setFocusable(true);
            ValidaVacio(lg.getContraseña());
       }
        if( lg.getUsuario().equals(us.getUsuario()) ){
            JOptionPane.showMessageDialog( null, "El usuario es incorrecta" );
            lg.txtUsuario.setFocusable(true);
            ValidaVacio(lg.getUsuario());
       }
       if(lg.getUsuario().equals(us.getUsuario()) || lg.getContraseña().equals(us.getContraseña())){
           JOptionPane.showMessageDialog( null, us.toString() );
       }
       } catch( ExepcionVacio ex){
        
           JOptionPane.showMessageDialog(null, ex.getMessage());
    }  
    }
    
    public void ValidaVacio(String txt) throws ExepcionVacio{
        
        if(txt.trim().equals("")){
            throw new ExepcionVacio();
        }
    }
}