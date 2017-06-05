package com.example.anitamarin.adogtame.util;

import com.example.anitamarin.adogtame.models.Mascotas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anita Marin on 25/05/2017.
 */

public class Data {

    private static List<Mascotas> mascotas;
    public static List<Mascotas> getMascotas(){
        if(mascotas ==  null){
            mascotas =  new ArrayList<>();

            Mascotas m1 = new Mascotas();
            m1.setNombre("Tango");
            m1.setDescripcion("Tango fue accogido despues de estar en la calle durante ");
            m1.setFundacion("Vida animal");
            m1.setTamanio("Mediano");
            m1.setEdad("6 meses");
            m1.setRaza("Criollo");
            m1.setImagen("");
            m1.setContacto(8367356);

            Mascotas m2 = new Mascotas();
            m2.setNombre("Lucas");
            m2.setDescripcion("Lucas fue acogido hace dos años en la fundacion y busca un hogar...  ");
            m2.setFundacion("Paz animal");
            m2.setTamanio("Mediano");
            m2.setEdad("4 años");
            m2.setRaza("Criollo");
            m2.setImagen("");
            m2.setContacto(8367356);

            mascotas.add(m1);

        }
        return  mascotas;
    }
}

