/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author Andrew
 */
public class Pedido {
    private int id;
    private int idMesero;
    private int idMesa;
    private int tiempoEstimado;
    private int estado;
    private List<Producto> productos;

    public Pedido() {
    }

    public Pedido(int id, int idMesero, int idMesa, int tiempoEstimado, int estado, List<Producto> productos) {
        this.id = id;
        this.idMesero = idMesero;
        this.idMesa = idMesa;
        this.tiempoEstimado = tiempoEstimado;
        this.estado = estado;
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    
}