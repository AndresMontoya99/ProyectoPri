/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.CrearMesero;
import View.Menu;
import View.Pedido;
import View.Producto.BuscarProducto;
import View.Producto.GestionProductos1;
import javax.swing.JFrame;

/**
 *
 * @author RICARDO
 */
public class MenuController {
    
    CrearMesero gm;
    GestionProductos1 gp;
    BuscarProducto bp;
    Pedido p ;
    Menu ga;
    
    public MenuController(Menu ga){
        this.ga = ga;
    }
    
    public void ventanaProductos(int n){
        
        if(n == 0){
        gp = new GestionProductos1();
        gp.setVisible(true);
        //ga.setVisible(false);
        }
        if(n == 1){
        bp = new BuscarProducto();
        bp.setVisible(true);
        //ga.setVisible(false);
        }
        
    }
    
    public void ventanaMeseros(){
        gm = new CrearMesero();
        gm.setVisible(true);
        //ga.setVisible(false);
    }
    
    public void ventanaPedido(){
        p = new Pedido();
        p.setVisible(true);
        //ga.setVisible(false);
    }
    
   
}
