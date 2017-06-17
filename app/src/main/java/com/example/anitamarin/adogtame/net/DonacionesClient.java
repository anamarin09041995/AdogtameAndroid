package com.example.anitamarin.adogtame.net;

import com.example.anitamarin.adogtame.models.Donaciones;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Anita Marin on 17/06/2017.
 */

public interface DonacionesClient {
    @POST("donaciones")
    Call<SimpleResponse> donar(@Body Donaciones donacion);
}
