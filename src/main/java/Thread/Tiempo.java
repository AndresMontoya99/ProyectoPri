/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;
import Controller.PedidoController;
import javax.swing.JOptionPane;

/**
 *
 * @author RICARDO
 */
public class Tiempo extends Thread{
    
     PedidoController c;
    int t;
   
    public Tiempo(){
        super();
    }
   
    public void setTiempo(int t){
      this.t = t;
    }
 
    public void setControlador(PedidoController c){
        this.c = c;
    }
    
    public void run(){
           // t++;
        try{
           
            while(t >= 0){
                String n = String.valueOf(t);
                c.tiempo(n);
                sleep(60000);
                t--;
               
               if(t == 0){
                   JOptionPane.showMessageDialog(null, "El pedido esta listo");
               }
            }
        }catch(InterruptedException e){
            JOptionPane.showMessageDialog(null, "Error en el tiempo");
        }
    }
}
               
                        
               

