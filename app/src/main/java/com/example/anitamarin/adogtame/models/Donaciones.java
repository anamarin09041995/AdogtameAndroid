package com.example.anitamarin.adogtame.models;

/**
 * Created by Anita Marin on 17/06/2017.
 */

public class Donaciones {
    String value, idUsuario;
    boolean alimento, salud;

    public Donaciones(String value, String idUsuario, boolean alimento, boolean salud) {
        this.value = value;
        this.idUsuario = idUsuario;
        this.alimento = alimento;
        this.salud = salud;
    }
}
