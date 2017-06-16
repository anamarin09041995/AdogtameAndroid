package com.example.anitamarin.adogtame.net;

import com.example.anitamarin.adogtame.RegistroActivity;
import com.example.anitamarin.adogtame.models.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Anita Marin on 13/06/2017.
 */

public interface UsersClient {

    @POST("users/signin")
    Call<RegisterResponse> register(@Body Users user);

    @POST("users/login")
    Call<SimpleResponse> login(@Body Users user);
}
