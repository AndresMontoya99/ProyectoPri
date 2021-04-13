/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import View.Menú;
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
        
        us.setUsuario(lg.getUsuario());
        us.setContraseña(lg.getContraseña());
        mostrarMenu(us.buscarUsuario());
        
    }
    
    public int mostrarMenu(int n){
        
        if(n == 1){
            Menú ga = new Menú();
            ga.setVisible(true);
            lg.setVisible(false);
        }
        if(n == 2){
            Menú ga = new Menú();
            ga.btnMeseros.setEnabled(false);
            ga.jcbProducto.setEnabled(false);
            ga.setVisible(true);
            lg.setVisible(false);
        }
        if(n == 0){
            JOptionPane.showMessageDialog(lg, "Usuario invalido, Por favor verifique los datos");
            lg.vaciarUsuario();
        }
        return n;
    }
    
}