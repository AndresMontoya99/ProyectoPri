/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import View.Menu;
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
    
    public void buscar(){
        us = new Usuario();
        
        us.setNombre(lg.getNombre());
        us.setContrasena(lg.getContraseña());
        mostrarMenu(us.buscarUsuario());
        
    }
    
    public Usuario mostrarMenu(Usuario usu){
        
        Menu ga = new Menu(usu);
        
        if(usu.getTipo() == 1){
            
            ga.setVisible(true);
            lg.setVisible(false);
        }
        if(usu.getTipo() == 2){
            
            ga.btnMeseros.setEnabled(false);
            ga.jcbProducto.setEnabled(false);
            ga.setVisible(true);
            lg.setVisible(false);
        }
        if(usu.getTipo() == 0){
            JOptionPane.showMessageDialog(lg, "Usuario invalido, Por favor verifique los datos");
            //lg.vaciarUsuario();
        }
        return usu;
    }
    
}