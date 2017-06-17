package com.example.anitamarin.adogtame.models;


/**
 * Created by Anita Marin on 17/06/2017.
 */

public class Apadrinado {
    String nombre, descripcion, imagen;
    Apadrinante usuario;

    public String getNombre() {
        return nombre;
    }

    public Apadrinado(String nombre, String descripcion, String imagen, Apadrinante usuario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.usuario = usuario;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Apadrinante getUsuario() {
        return usuario;
    }

    public void setUsuario(Apadrinante usuario) {
        this.usuario = usuario;
    }

    public static class Apadrinante{
        String id;
        String email;

        public Apadrinante(String id, String email) {
            this.id = id;
            this.email = email;
        }
    }
}
