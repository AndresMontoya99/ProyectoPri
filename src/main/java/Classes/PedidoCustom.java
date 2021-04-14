/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Classes;

import Model.*;

/**
 *
 * @author Andrew
 */
public class PedidoCustom extends Pedido {
    
    private String Mesero;
    private String Mesa;
    private String NombreProducto;
    private Double Precio;
    private Double Total;

    public String getMesero() {
        return Mesero;
    }

    public void setMesero(String Mesero) {
        this.Mesero = Mesero;
    }

    public String getMesa() {
        return Mesa;
    }

    public void setMesa(String Mesa) {
        this.Mesa = Mesa;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }
    
    
    
    
    
    
    
}
