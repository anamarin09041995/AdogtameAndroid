package com.example.anitamarin.adogtame.net;

import com.example.anitamarin.adogtame.models.Fundaciones;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Anita Marin on 15/06/2017.
 */

public interface FundacionesClient {
    @GET("fundaciones")
    Call<List<Fundaciones>> all();
}
