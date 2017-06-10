package com.example.anitamarin.adogtame;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.anitamarin.adogtame.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setHandler(this);
    }

    public void goToCatalogo(){

        String email, password;
        email = binding.emailLogin.toString();
        password = binding.passwordLogin.toString();

        if((email == null) || (password ==null)) {

            Toast.makeText(this, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void goToRegistro(){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
}
