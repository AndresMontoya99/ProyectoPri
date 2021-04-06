/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.FileInputStream;

/**
 *
 * @author Andrew
 */
public class Producto {
    private int Id;
    private String nombre;
    private String descripcion;
    private FileInputStream imagen;
    private float precio;

    public Producto() {
    }

    public Producto(int Id, String nombre, String descripcion, FileInputStream imagen, float precio) {
        this.Id = Id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
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

    public FileInputStream getImagen() {
        return imagen;
    }

    public void setImagen(FileInputStream imagen) {
        this.imagen = imagen;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Id:" + Id + "\nnombre:" + nombre + "\ndescripcion: " + descripcion + "\nimagen:" + imagen + "\nprecio: " + precio;
    }
    
    
    
}
