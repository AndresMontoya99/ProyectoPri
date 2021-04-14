/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.CrearMesero;
import View.Menu;
import View.Mesa;
import View.PedidoVistas.Pedido;
import View.PedidoVistas.PedidoProductos;
import View.Producto.BuscarProducto;
import View.Producto.GestionProductos;
import javax.swing.JFrame;

/**
 *
 * @author RICARDO
 */
public class MenuController {
    
    CrearMesero gm;
    GestionProductos gp;
    BuscarProducto bp;
    PedidoProductos p ;
    Menu ga;
    Mesa ms;
    
    public MenuController(Menu ga){
        this.ga = ga;
    }
    
    public void ventanaProductos(int n){
        
        if(n == 0){
        gp = new GestionProductos();
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
        p = new PedidoProductos();
        p.setVisible(true);
        //ga.setVisible(false);
    }
    
    public void ventanaMesa(){
        ms = new Mesa();
        ms.setVisible(true);
        //ga.setVisible(false);
    }
    
   
}
