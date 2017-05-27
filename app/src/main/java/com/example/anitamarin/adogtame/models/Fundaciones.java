package com.example.anitamarin.adogtame.models;

/**
 * Created by Anita Marin on 25/05/2017.
 */

public class Fundaciones {
    String nombre, descripcion, direccion, imagen, horario;
    int telefono;

    public Fundaciones(String nombre, String descripcion, String direccion, String imagen, String horario, int telefono) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.imagen = imagen;
        this.horario = horario;
        this.telefono = telefono;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
