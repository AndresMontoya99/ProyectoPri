/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Andrew
 */
public class Mesa {
    
    private int Id;
    private String nombre;
    private int capacidad;
    private boolean estado;

    public Mesa() {
    }

    public Mesa(int Id, String nombre, int capacidad, boolean estado) {
        this.Id = Id;
        this.nombre = nombre;
        this.capacidad = capacidad;
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
}
