package com.example.anitamarin.adogtame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.anitamarin.adogtame.R;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void goToCatalogo(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
