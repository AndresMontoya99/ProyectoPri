/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Conexion;
import Model.Producto;
import Model.Usuario;
import View.PedidoVistas.Pedido;
import com.mysql.cj.protocol.Resultset;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RICARDO
 */
public class PedidoController {
    
    public View.PedidoVistas.Pedido p;
    public Model.Pedido pe;
    
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
    
    public void realizarPedido(){
        
        pe = new Model.Pedido();
        
        pe.setIdMesero(p.getMesero());
        pe.setIdMesa(p.getMesa());
        pe.setTiempoEstimado(p.getTiempo());
        pe.setEstado(p.getEstado());
        pe.setFecha(new Date(System.currentTimeMillis()));
        
        Vector productos = ((DefaultTableModel)(p.getTabla().getModel())).getDataVector();
        
        guardarPedidoProducto(guardarPedido().getId(), productos);  
        
    }
    
    public Model.Pedido guardarPedido(){
        
        try{
            
            String sql="INSERT INTO \"Pedido\" (\"idMesa\", \"idMesero\", \"tiempoEstimado\", \"estado\", \"fecha\") VALUES (?, ?, ?, ?, ?);";
            
            PreparedStatement ps= new Conexion().getConexion().prepareStatement(sql);
            ps.setInt(1, pe.getIdMesa());
            ps.setInt(2, pe.getIdMesero());
            ps.setInt(3, pe.getTiempoEstimado());
            ps.setInt(4, pe.getEstado());
            ps.setDate(5, pe.getFecha());
            
            ps.execute();
            ps.close();
            
            sql = "SELECT max(id) as id FROM  \"Pedido\";";
                    
            ps = new Conexion().getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                pe.setId(rs.getInt("id"));
            }
            
            ps.close();
        }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
            JOptionPane.showMessageDialog(p, x.getMessage());
        }
        
        return pe;
    
    }
    
    public void guardarPedidoProducto(int idPedido, Vector productos){
        
        try{
            
            String sql="INSERT INTO \"Pedido_Producto\" (\"idPedido\", \"idProducto\", \"cantidad\") VALUES ";
            
            for (int i = 0; i < productos.size(); i++) {
                
                Object producto = productos.get(i);
                sql += " ( " + idPedido + " , "+ ((int)((Vector)producto).get(0)) +" , "+ ((int)((Vector)producto).get(4)) +" )";
                
                if(i < productos.size() - 1){
                    sql += ", ";
                } 
            }
            
            PreparedStatement ps= new Conexion().getConexion().prepareStatement(sql);
            
            ps.execute();
            ps.close();
            
            p.vaciar();
            
            JOptionPane.showMessageDialog(p,"Guardado correctamente");
            
        }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
            JOptionPane.showMessageDialog(p, x.getMessage());
        } 
    
    }
}
