/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Conexion;
import Model.Producto;
import Model.Usuario;
import Thread.Tiempo;
import View.PedidoVistas.Pedido;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
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
    
    public List<Model.Pedido> buscarPedidos(String cond){
        
        List<Model.Pedido> pedidos = new ArrayList<>();
        
        try{
            String sql="SELECT * FROM \"Pedido\" "+ cond + " ;";

            PreparedStatement ps= new Conexion().getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.close();
            
            while(rs.next()){
                
                pe = new Model.Pedido();
                
                pe.setId(rs.getInt("id"));
                pe.setIdMesa(rs.getInt("idMesa"));
                pe.setIdMesero(rs.getInt("idMesero"));
                pe.setTiempoEstimado(rs.getInt("tiempoEstimado"));
                pe.setFecha(rs.getDate("fecha"));
                pe.setHora(rs.getTime("hora"));
                pe.setEstado(rs.getInt("estado"));
                
                pedidos.add(pe);                
            }
             
            
        }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
            JOptionPane.showMessageDialog(p, x.getMessage());
        }
        
        return pedidos;
    }
    
    public void realizarPedido(){
        
        Vector productos = ((DefaultTableModel)(p.getTabla().getModel())).getDataVector();
        
        if(productos.size() == 0){
            JOptionPane.showMessageDialog(p, "No se ha seleccionado ningún producto");
        }else{
            pe = new Model.Pedido();
        
            pe.setIdMesero(p.getMesero());
            pe.setIdMesa(p.getMesa());
            pe.setTiempoEstimado(p.getTiempo());
            pe.setEstado(p.getEstado());
            pe.setFecha(new Date(System.currentTimeMillis()));
            pe.setHora(new Time(System.currentTimeMillis()));
            
            guardarPedidoProducto(guardarPedido().getId(), productos);
        }
    }
      
    public Model.Pedido guardarPedido(){
        
        try{
            
            String sql="INSERT INTO \"Pedido\" (\"idMesa\", \"idMesero\", \"tiempoEstimado\", \"estado\", \"fecha\", \"hora\") VALUES (?, ?, ?, ?, ?, ?);";
            
            PreparedStatement ps= new Conexion().getConexion().prepareStatement(sql);
            ps.setInt(1, pe.getIdMesa());
            ps.setInt(2, pe.getIdMesero());
            ps.setInt(3, pe.getTiempoEstimado());
            ps.setInt(4, pe.getEstado());
            ps.setDate(5, pe.getFecha());
            ps.setTime(6, pe.getHora());
            
            ps.execute();
            //ps.close();
            sql = "SELECT max(id) as id FROM  \"Pedido\";";
                    
            ps = new Conexion().getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                pe.setId(rs.getInt("id"));
            }
            
            Tiempo h = new Tiempo();
            h.setControlador(this);
            h.setPedido(pe);
            h.start(); 
            
            //ps.close();
            
            
            sql = " UPDATE \"Mesa\" SET estado=FALSE WHERE id="+ pe.getIdMesa() +";";
            
            ps = new Conexion().getConexion().prepareStatement(sql);
            
            ps.execute();
            ps.close();
            
        }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
            JOptionPane.showMessageDialog(p, x.getMessage());
        }
        
        return pe;
    
    }

    public Model.Pedido actualizarEstadoPedido(int estado, Model.Pedido pe, String estadoMesa){
        
        try{
            int es = -1;
            
            String sql=" SELECT estado FROM \"Pedido\" WHERE id="+ pe.getId() +";";
            
            PreparedStatement ps= new Conexion().getConexion().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                es = rs.getInt("estado");
            }
            
            //ps.close();
            
            
            if(!(estado == 1 && es != 0)){
                sql = " UPDATE \"Pedido\" SET estado="+ estado +" WHERE id="+ pe.getId() +";";
            
                ps = new Conexion().getConexion().prepareStatement(sql);

                ps.execute();
                //ps.close();

                if(!estadoMesa.isEmpty()){
                    sql = " UPDATE \"Mesa\" SET estado="+ estadoMesa +" WHERE id="+ pe.getIdMesa() +";";

                    ps= new Conexion().getConexion().prepareStatement(sql);

                    ps.execute();
                    ps.close();
                }
                
                JOptionPane.showMessageDialog(null, "Pedido entregado");
            }
                
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
    
    
    public void tiempo(String n){
       
      String nuevo = n;
      p.setTiempo(Integer.parseInt(n));
    } 
}
