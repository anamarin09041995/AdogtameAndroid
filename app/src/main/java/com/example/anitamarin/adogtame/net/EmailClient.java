package com.example.anitamarin.adogtame.net;

import com.example.anitamarin.adogtame.models.Email;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Anita Marin on 17/06/2017.
 */

public interface EmailClient {

    @POST("email")
    Call<SimpleResponse> email(@Body Email email);
}
