/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author Andrew
 */
public class Producto {
    private int Id;
    private String nombre;
    private String descripcion;
    private InputStream imagen;
    private float precio;
    private boolean estado;

    public Producto() {
    }

    public Producto(int Id, String nombre, String descripcion, InputStream imagen, float precio, boolean estado) {
        this.Id = Id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.estado = estado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Id:" + Id + "\nnombre:" + nombre + "\ndescripcion: " + descripcion + "\nimagen:" + imagen + "\nprecio: " + precio;
    }
    
    
    
}
