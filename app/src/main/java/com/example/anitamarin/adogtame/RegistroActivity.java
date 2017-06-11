package com.example.anitamarin.adogtame;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.anitamarin.adogtame.R;
import com.example.anitamarin.adogtame.databinding.ActivityRegistroBinding;

public class RegistroActivity extends AppCompatActivity {

    ActivityRegistroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registro);
    }

    public void goToCatalogo(){

        String email, password, city;
        email = binding.emailRegistro.getText().toString();
        password = binding.passwordRegistro.getText().toString();
        city = binding.ciudadRegistro.getText().toString();

        if((email.equals("")) && (password.equals("")) && (city.equals(""))){
            Toast.makeText(this, "Por favor ingrese datos en todos los campos", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
