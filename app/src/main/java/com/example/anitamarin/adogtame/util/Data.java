package com.example.anitamarin.adogtame.util;

import com.example.anitamarin.adogtame.models.Fundaciones;
import com.example.anitamarin.adogtame.models.Mascotas;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

/**
 * Created by Anita Marin on 25/05/2017.
 */

public class Data {

    private static List<Mascotas> mascotas;
    private static List<Fundaciones> fundaciones;

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
            m1.setImagen("https://s-media-cache-ak0.pinimg.com/736x/6f/7e/41/6f7e41ba3a4bed8ab76836e86e9b1f25.jpg");
            m1.setContacto(8367356);

            Mascotas m2 = new Mascotas();
            m2.setNombre("Lucas");
            m2.setDescripcion("Lucas fue acogido hace dos años en la fundacion y busca un hogar...  ");
            m2.setFundacion("Paz animal");
            m2.setTamanio("Mediano");
            m2.setEdad("4 años");
            m2.setRaza("Criollo");
            m2.setImagen("https://www.petdarling.com/articulos/wp-content/uploads/2016/06/fotos-de-perritos-tiernos.jpg");
            m2.setContacto(8367356);

            mascotas.add(m1);
            mascotas.add(m2);

        }
        return  mascotas;
    }

    public static List<Fundaciones> getFundaciones(){
        if(fundaciones ==  null){
            fundaciones =  new ArrayList<>();

            Fundaciones f1 = new Fundaciones();
            f1.setNombre("Vida animal");
            f1.setDescripcion("Se buscan personas dispuestas a ayudar a pasear los perritos");
            f1.setDireccion("Cra 9 # 67N-78");
            f1.setImagen("https://sites.google.com/site/fundacionvidaanimalpopayan/_/rsrc/1316780706284/config/customLogo.gif?revision=5");
            f1.setHorario("Lunes a Domingo de 8am - 4pm");
            f1.setTelefono(8332567);

            Fundaciones f2 = new Fundaciones();
            f2.setNombre("Paz animal");
            f2.setDescripcion("Se buscan personas dispuestas a ayudar con el aseo de las casas y cobijas de los animales");
            f2.setDireccion("Calle 4 # 8-04");
            f2.setImagen("http://www.defensacali.org/wp-content/uploads/foto-paz-animal.jpg");
            f2.setHorario("Sabados y Domingos de 10am - 5pm");
            f2.setTelefono(8327867);


            fundaciones.add(f1);
            fundaciones.add(f2);

        }
        return  fundaciones;
    }
}

