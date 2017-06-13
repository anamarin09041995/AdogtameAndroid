package com.example.anitamarin.adogtame.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Mascotas {

    @Id(autoincrement = true)
    private Long id;
    String nombre, descripcion, fundacion, tamanio, edad, raza, imagen;
    Integer contacto;

    @Generated(hash = 1921089432)
    public Mascotas(Long id, String nombre, String descripcion, String fundacion,
            String tamanio, String edad, String raza, String imagen,
            Integer contacto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fundacion = fundacion;
        this.tamanio = tamanio;
        this.edad = edad;
        this.raza = raza;
        this.imagen = imagen;
        this.contacto = contacto;
    }

    @Generated(hash = 963208691)
    public Mascotas() {
    }

    public Long getId() { return id;}

    public void setId(Long id) { this.id = id; }

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

    public String getFundacion() {
        return fundacion;
    }

    public void setFundacion(String fundacion) {
        this.fundacion = fundacion;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(Integer contacto) {
        this.contacto = contacto;
    }
}
