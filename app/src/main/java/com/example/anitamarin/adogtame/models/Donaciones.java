package com.example.anitamarin.adogtame.models;

/**
 * Created by Anita Marin on 17/06/2017.
 */

public class Donaciones {
    String value, _id;
    boolean alimento, salud;

    public Donaciones(String value, String _id, boolean alimento, boolean salud) {
        this.value = value;
        this._id = _id;
        this.alimento = alimento;
        this.salud = salud;
    }
}
