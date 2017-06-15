package com.example.anitamarin.adogtame.net;

import com.example.anitamarin.adogtame.models.Mascotas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Anita Marin on 13/06/2017.
 */

public interface MascotasClient {

    @GET("mascotas")
    Call<List<Mascotas>> all();

}
