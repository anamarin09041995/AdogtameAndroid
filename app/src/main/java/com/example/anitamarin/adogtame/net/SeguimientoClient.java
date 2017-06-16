package com.example.anitamarin.adogtame.net;

import com.example.anitamarin.adogtame.models.Mascotas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface SeguimientoClient {

    @GET("seguimiento/{id}")
    Call<List<Mascotas>> all(@Path("id") String userId);

}
