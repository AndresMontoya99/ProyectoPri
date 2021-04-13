/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import javax.swing.JProgressBar;

/**
 *
 * @author RICARDO
 */
public class HiloCargar extends Thread{
    JProgressBar progress;
    
    public HiloCargar(JProgressBar progress){
        super();
        this.progress = progress; 
    }
    
    @Override
    public void run(){
        for (int i = 1; i <= 100; i++) {
            progress.setForeground(Color.blue);
            progress.setValue(i);
            pausa(25);
        }
    }
    public void pausa(int mlSeg){
        try {
            Thread.sleep(mlSeg);
        }
        catch(Exception e){
            
        }
    }
    
}
