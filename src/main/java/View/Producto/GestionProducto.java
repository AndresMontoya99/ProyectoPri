/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Producto;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author Andrew
 */
public abstract class GestionProducto extends javax.swing.JFrame {
    
    public abstract String getNombre();
    
    public abstract void setNombre(String valor);
    
    public abstract String getNombreBusqueda();
    
    public abstract void setNombreBusqueda(String valor);
    
    public abstract String getDescripcion();
    
    public abstract void setDescripcion(String valor);
    
    public abstract String getDescripcionBusqueda();
    
    public abstract void setDescripcionBusqueda(String valor);
    
    public abstract float getPrecio();
    
    public abstract void setPrecio(float valor);
    
    public abstract float getPrecioBusqueda();
    
    public abstract void setPrecioBusqueda(String valor);
    
    public abstract Icon getImage();
    
    public abstract void setImage(Icon valor);
    
    public abstract JLabel getImageLabel();
    
    public abstract Icon getImageBusqueda();
    
    public abstract void setImageBusqueda(Icon valor);
    
    public abstract JLabel getImageLabelBusqueda();
    
    public abstract void limpiarProducto();
    
    public abstract void limpiarBusqueda();
    
    public abstract void setEstado(boolean estado);
    
    public abstract boolean getEstado();
    
}
