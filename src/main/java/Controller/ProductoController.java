/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexion;
import Model.Producto;
import View.Producto.GestionProducto;
import View.Producto.GestionProductos1;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Andrew
 */
public class ProductoController {
    
    private GestionProducto gp;
    private Producto pro;
    
    private File file;

    public ProductoController(GestionProducto gp) {
        this.gp = gp;
    }
    
    public void cargarImagen(){
        //this.gp.setImage(null);
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        FileNameExtensionFilter formato = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        j.setFileFilter(formato);
        
        int estado = j.showOpenDialog(null);
        
        if(estado == JFileChooser.APPROVE_OPTION){
           
            file = j.getSelectedFile();

            try {
                Image icono=ImageIO.read(file).getScaledInstance(gp.getImageLabel().getWidth(),gp.getImageLabel().getHeight(),Image.SCALE_DEFAULT);
                this.gp.setImage(new ImageIcon(icono));

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(gp, ex.getMessage());
            }
        }  
    }
    
    public void guardarImagen(){
        try{
            String sql="INSERT INTO \"Producto\"(nombre, descripcion, imagen, precio, estado) VALUES (?, ?, ?, ?, ?);";
            
            FileInputStream fis = new FileInputStream(file);
            
            PreparedStatement ps= new Conexion().getConexion().prepareStatement(sql);
            ps.setString(1,gp.getNombre());
            ps.setString(2,gp.getDescripcion());
            ps.setBinaryStream(3,fis,file.length());
            ps.setFloat(4,gp.getPrecio());
            ps.setBoolean(5,gp.getEstado());
            ps.execute();
            ps.close();

            gp.limpiarProducto();
            
            JOptionPane.showMessageDialog(gp,"Guardado correctamente");
            
        }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
            JOptionPane.showMessageDialog(gp, x.getMessage());
        } 
    }
    
    public int buscarImagenPorNombre(){
        
        int count = -1;
        
        try{
            String sql="SELECT count(*) as n FROM \"Producto\" where nombre = ?;";

            PreparedStatement ps= new Conexion().getConexion().prepareStatement(sql);
            ps.setString(1,gp.getNombre());
            ResultSet rs = ps.executeQuery();
            ps.close();
            
            while(rs.next()){
                count = rs.getInt("n");
            }
             
            return count;
            
        }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
            JOptionPane.showMessageDialog(gp, x.getMessage());
        }
        
        return count;
    }  
    
    public void buscarImagen(){
        
        try{
            
            gp.limpiarBusqueda();
            
            String sql="SELECT * FROM \"Producto\" where nombre = ?;";

            PreparedStatement ps= new Conexion().getConexion().prepareStatement(sql);
            ps.setString(1,gp.getNombreBusqueda());
            ResultSet rs = ps.executeQuery();
            ps.close();
            
            boolean find = false; 
            
            while(rs.next()){
                
                find = true;
                
                gp.setDescripcionBusqueda(rs.getString("descripcion"));
                gp.setPrecioBusqueda(rs.getString("precio"));
                
                
                ByteArrayOutputStream ouput = new ByteArrayOutputStream();
                InputStream isdatos = rs.getBinaryStream("imagen");
                int temp=isdatos.read();
                while(temp>=0)
                {
                   ouput.write((char)temp);
                   temp=isdatos.read();
                }
                
                Image imagen = Toolkit.getDefaultToolkit().createImage(ouput.toByteArray());
                imagen = imagen.getScaledInstance(gp.getImageLabelBusqueda().getWidth(),gp.getImageLabelBusqueda().getHeight(),1);
                
                gp.setImageBusqueda(new ImageIcon(imagen));
                
            }
            
            if(!find){
                JOptionPane.showMessageDialog(gp, "Producto no encontrado");
            }
             
            
        }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
            JOptionPane.showMessageDialog(gp, x.getMessage());
        }
    }
    
}
