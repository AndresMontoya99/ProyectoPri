/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.sql.Time;
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
    private Time fecha;
    private int cantidad;

    public Pedido() {
    }

    public Pedido(int id, int idMesero, int idMesa, int tiempoEstimado, int estado, List<Producto> productos, Time fecha, int cantidad) {
        this.id = id;
        this.idMesero = idMesero;
        this.idMesa = idMesa;
        this.tiempoEstimado = tiempoEstimado;
        this.estado = estado;
        this.productos = productos;
        this.fecha = fecha;
        this.cantidad = cantidad;
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

    public Time getFecha() {
        return fecha;
    }

    public void setFecha(Time fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
}
