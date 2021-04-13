/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexion;
import Model.ImgTabla;
import View.Pedido;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RICARDO
 */
public class PedidoController {
    
    Pedido p;
    
    public PedidoController(Pedido p){
        this.p = p;
    }
    
     public void buscarImagen(){
        
        try{
            
            String sql="SELECT * FROM \"Producto\" ";

            PreparedStatement ps= new Conexion().getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.close();
            
            boolean find = false; 
            
            while(rs.next()){
                
                find = true;
                
                ByteArrayOutputStream ouput = new ByteArrayOutputStream();
                InputStream isdatos = rs.getBinaryStream("imagen");
                int temp=isdatos.read();
                while(temp>=0)
                {
                   ouput.write((char)temp);
                   temp=isdatos.read();
                }
                 p.jTable1.setDefaultRenderer(Object.class, new ImgTabla());
        
                 JLabel hola = new JLabel();
                
                Image imagen = Toolkit.getDefaultToolkit().createImage(ouput.toByteArray());
                imagen = imagen.getScaledInstance(50,50,1);
                
                hola.setIcon((Icon) imagen);
        
        
               Object row[] = {rs.getString("nombre"),rs.getString("descripcion"),rs.getFloat("precio"), hola};
        
                   p.jTable1.setRowHeight(50);
        
                  ((DefaultTableModel)p.jTable1.getModel()).addRow(row);
                
            }
            
            if(!find){
                JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }
             
            
        }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
            JOptionPane.showMessageDialog(null, x.getMessage());
        }
    }
    
}
