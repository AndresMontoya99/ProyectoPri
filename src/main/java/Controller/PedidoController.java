/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Conexion;
import Model.ImgTabla;
import Model.Producto;
import View.Pedido;
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
    
    Pedido p;
    Producto pr = new Producto();
    DefaultTableModel mModeloTabla = new DefaultTableModel();
    
    public PedidoController(Pedido p){
        this.p = p;
    }
    
    public void iniciar(){
        mModeloTabla.addColumn("nombre");
        mModeloTabla.addColumn("descripcion");
        mModeloTabla.addColumn("precio");
        mModeloTabla.addColumn("imagen");
        CargarImagenes();
    }
    
      public ArrayList buscarImagen(){
         ArrayList<Producto>pro = new ArrayList<Producto>();
        try{
             
            String sql="SELECT * FROM \"Producto\" ";

            PreparedStatement ps= new Conexion().getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.close();
            
            boolean find = false; 
            
            while(rs.next()){
                
                find = true;
               
                pr.setId(rs.getInt("id"));
                pr.setNombre(rs.getString("nombre"));
                pr.setDescripcion(rs.getString("descripcion"));
                pr.setPrecio(rs.getFloat("precio"));
                
                ByteArrayOutputStream ouput = new ByteArrayOutputStream();
                InputStream isdatos = rs.getBinaryStream("imagen");
                int temp=isdatos.read();
                pro.add(pr);
                while(temp>=0)
                {
                   ouput.write((char)temp);
                   temp=isdatos.read();
                }
                
                Image imagen = Toolkit.getDefaultToolkit().createImage(ouput.toByteArray());
                imagen = imagen.getScaledInstance(50,50,1);  
            }
            
            if(!find){
               JOptionPane.showMessageDialog(null, "Producto no encontrado");
            }
             
            
        }catch(SQLException | NumberFormatException | HeadlessException | IOException x){
            JOptionPane.showMessageDialog(null, x.getMessage());
        }
        return pro;
    }
       private void CargarImagenes() {
        p.jTable1.setDefaultRenderer(Object.class, new RenderImagen());

        ArrayList Imagenes;
        Producto mImagenAlmacen;

       
            Object Datos[] = new Object[4];
            Imagenes = buscarImagen();

            if (Imagenes != null) {
                for (int i = 0; i < Imagenes.size(); i++) {
                    mImagenAlmacen = (Producto) Imagenes.get(i);
                    Datos[0] = mImagenAlmacen.getNombre();
                    Datos[1] = mImagenAlmacen.getDescripcion();
                    Datos[2] = mImagenAlmacen.getPrecio();
                    try {
                        ByteArrayOutputStream ouput = new ByteArrayOutputStream();
                        InputStream imagen = mImagenAlmacen.getImagen();
                        BufferedImage bufferedImage = null;
                        //InputStream inputStream = new ByteArrayInputStream(imagen);
                        bufferedImage = ImageIO.read(imagen);
                        ImageIcon mIcono = new ImageIcon(bufferedImage.getScaledInstance(60, 60, 0));
                        Datos[3] = new JLabel(mIcono);
                    } catch (Exception e) {
                        Datos[3] = new JLabel("No imagen");
                    }
                    
                    
                    mModeloTabla.addRow(Datos);
                }

                p.jTable1.setModel(mModeloTabla);
                p.jTable1.setRowHeight(60);
                p.jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
                p.jTable1.getColumnModel().getColumn(1).setPreferredWidth(60);
                p.jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);

            }
        }

    
}
