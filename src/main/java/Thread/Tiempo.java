/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;
import Controller.PedidoController;
import Model.Pedido;
import javax.swing.JOptionPane;

/**
 *
 * @author RICARDO
 */
public class Tiempo extends Thread{
    
    PedidoController c;
    int t;
    Pedido pedido;
   
    public Tiempo(){
        super();
    }
   
    public void setPedido(Pedido pedido){
      this.t = pedido.getTiempoEstimado();
      this.pedido = pedido;
    }
 
    public void setControlador(PedidoController c){
        this.c = c;
    }
    
    public void run(){
        try{
           
            while(t >= 0){
                String n = String.valueOf(t);
                c.tiempo(n);
                sleep(60000);
                t--;
               
               if(t == 0){
                   c.actualizarEstadoPedido(1, pedido, "TRUE", "Pedido entregado");
                   
               }
            }
        }catch(InterruptedException e){
            JOptionPane.showMessageDialog(null, "Error en el tiempo");
        }
    }
}
               
                        
               

