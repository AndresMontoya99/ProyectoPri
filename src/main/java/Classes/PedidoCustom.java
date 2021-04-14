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
    
    
    
    
    
}
