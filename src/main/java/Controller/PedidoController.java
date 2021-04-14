/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexion;
import Model.ImgTabla;
import Model.Producto;
import Model.Usuario;
import View.PedidoVistas.Pedido;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RICARDO
 */
public class PedidoController {
    
    public Pedido p;
    
    public PedidoController(Pedido p){
        this.p = p;
    }
    
    
    public void agregarProducto(Producto pro, int cantidad){
        
        Object[] rowData = {pro.getId(),pro.getNombre(),pro.getDescripcion(),pro.getPrecio(), cantidad};
        
        ((DefaultTableModel)p.getTabla().getModel()).addRow(rowData);
    
    }
    
    public void eliminarProducto(){
        
        int row = p.getTabla().getSelectedRow();
        
        if(row == -1){
            JOptionPane.showMessageDialog(p, "No hay un producto seleccionado");
            
        }else if(JOptionPane.showConfirmDialog(p, "¿Desea eliminar el producto?") == 0){
            ((DefaultTableModel)p.getTabla().getModel()).removeRow(row);
            
        } 
    }
    
    public void enviarMesaMesero(Model.Mesa ms, Usuario us){
        
        p.setMesaText(ms.getNombre());
        p.setMeseroText(us.getNombre());
        
        p.setMesa(ms.getId());
        p.setMesero(us.getId());
        
    }
}
