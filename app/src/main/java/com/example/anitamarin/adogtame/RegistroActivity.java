package com.example.anitamarin.adogtame;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.anitamarin.adogtame.databinding.ActivityRegistroBinding;
import com.example.anitamarin.adogtame.models.Users;
import com.example.anitamarin.adogtame.net.RegisterResponse;
import com.example.anitamarin.adogtame.net.UsersClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroActivity extends AppCompatActivity implements Callback<RegisterResponse> {

    ActivityRegistroBinding binding;
    UsersClient client;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registro);
        binding.setHandler(this);
        client = ((App)getApplication()).retrofit.create(UsersClient.class);
    }

    public void goToCatalogo(){

        String email, password, city;
        email = binding.emailRegistro.getText().toString();
        password = binding.passwordRegistro.getText().toString();
        city = binding.ciudadRegistro.getText().toString();

        Users user = new Users(email, password, city);


        if((email.equals("")) || (password.equals("")) || (city.equals(""))){
            Toast.makeText(this, R.string.campos_vacios, Toast.LENGTH_SHORT).show();
        }else {
            Call<RegisterResponse> request = client.register(user);
            request.enqueue(this);
            progressDialog = new ProgressDialog(this);
            progressDialog.show();
            progressDialog.setContentView(R.layout.activity_progress);

            final int totalProgressTime = 100;
            final Thread t = new Thread() {
                @Override
                public void run() {
                    int jumpTime = 0;

                    while(jumpTime < totalProgressTime) {
                        try {
                            sleep(200);
                            jumpTime += 5;
                            progressDialog.setProgress(jumpTime);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            };t.start();
        }
    }

    public void cancelar(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
        if(response.isSuccessful()){
            RegisterResponse registerResponse = response.body();

            if(registerResponse.isSuccess()){
                progressDialog.dismiss();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();

            }else if(registerResponse.isExist()){
                progressDialog.dismiss();
                Toast.makeText(this, R.string.registro_existente, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onFailure(Call<RegisterResponse> call, Throwable t) {
        Toast.makeText(this, R.string.error_servidor_registro, Toast.LENGTH_SHORT).show();
    }
}
