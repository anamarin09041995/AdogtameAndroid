package com.example.anitamarin.adogtame.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Mascotas {

    @Id(autoincrement = true)
    private Long id;

    String _id, nombre, descripcion, fundacion, tamanio, edad, raza, imagen;
    Long contacto;



    @Generated(hash = 300620838)
    public Mascotas(Long id, String _id, String nombre, String descripcion,
            String fundacion, String tamanio, String edad, String raza,
            String imagen, Long contacto) {
        this.id = id;
        this._id = _id;
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



    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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

    public Long getContacto() {
        return contacto;
    }

    public void setContacto(Long contacto) {
        this.contacto = contacto;
    }
}
