package com.example.anitamarin.adogtame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.anitamarin.adogtame.databinding.ActivityLoginBinding;
import com.example.anitamarin.adogtame.models.Users;
import com.example.anitamarin.adogtame.util.Preference;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    SharedPreferences preferences;

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

    }

    public void goToCatalogo(){

        String email, password;
        email = binding.emailLogin.getText().toString();
        password = binding.passwordLogin.getText().toString();


        if((email.equals("")) || (password.equals("")) ) {
            Toast.makeText(this, "Por favor ingrese datos en todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(Preference.KEY_EMAIL, email);
            editor.putBoolean(Preference.KEY_LOGGED, true);
            editor.apply();
            Users user = new Users(email, password);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void goToRegistro(){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
        finish();
    }
}
