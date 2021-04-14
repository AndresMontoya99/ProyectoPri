/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import Controller.ProductoController;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Andrew
 */
public class ValidarProducto extends Thread {
    
    private ProductoController pc;
    private String nombre;
    
    public ValidarProducto(){
        super();
    }
    
    public void setController(ProductoController pc){
        this.pc = pc;
    }
    
    public void setNombre(String n){
        this.nombre = n;
    }

    @Override
    public void run() {
        
        if(!nombre.isEmpty()){
            if(pc.buscarImagenPorNombre() > 0){
                JOptionPane.showMessageDialog(null, "El producto ya se encuentra registrado");
            }
        }
    }
    
    
}
