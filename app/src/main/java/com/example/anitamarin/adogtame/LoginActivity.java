package com.example.anitamarin.adogtame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.anitamarin.adogtame.databinding.ActivityLoginBinding;
import com.example.anitamarin.adogtame.models.Users;
import com.example.anitamarin.adogtame.net.SimpleResponse;
import com.example.anitamarin.adogtame.net.UsersClient;
import com.example.anitamarin.adogtame.util.Preference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements Callback<SimpleResponse> {

    ActivityLoginBinding binding;
    SharedPreferences preferences;
    UsersClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences(Preference.PREFERENCE_NAME, MODE_PRIVATE);
        boolean logged = preferences.getBoolean(Preference.KEY_LOGGED, false);

        /*if(logged){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return;
        }*/

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setHandler(this);

        client = ((App)getApplication()).retrofit.create(UsersClient.class);

    }

    public void goToCatalogo(){

        String email, password;
        email = binding.emailLogin.getText().toString();
        password = binding.passwordLogin.getText().toString();

        if((email.equals("")) || (password.equals("")) ) {
            Toast.makeText(this, R.string.campos_vacios, Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(Preference.KEY_EMAIL, email);
            editor.putBoolean(Preference.KEY_LOGGED, true);
            editor.apply();

            Users user = new Users(email, password);
            Call<SimpleResponse> request = client.login(user);
            request.enqueue(this);
        }
    }

    public void goToRegistro(){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
        if(response.isSuccessful()){
            SimpleResponse simpleResponse = response.body();
            if(simpleResponse.isSuccess()){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, R.string.login_incorrecto, Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<SimpleResponse> call, Throwable t) {
        Toast.makeText(this, R.string.error_servidor_registro, Toast.LENGTH_SHORT).show();
    }
}
