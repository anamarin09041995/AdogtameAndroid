package com.example.anitamarin.adogtame;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.anitamarin.adogtame.databinding.ActivityDetalleCatalogoBinding;
import com.example.anitamarin.adogtame.models.Apadrinado;
import com.example.anitamarin.adogtame.models.Email;
import com.example.anitamarin.adogtame.models.Mascotas;
import com.example.anitamarin.adogtame.net.EmailClient;
import com.example.anitamarin.adogtame.net.SeguimientoClient;
import com.example.anitamarin.adogtame.net.SimpleResponse;
import com.example.anitamarin.adogtame.util.Data;
import com.example.anitamarin.adogtame.util.Preference;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Response;

public class DetalleCatalogoActivity extends AppCompatActivity implements retrofit2.Callback<SimpleResponse> {

    ActivityDetalleCatalogoBinding binding;
    SeguimientoClient client;
    SharedPreferences preferences;
    EmailClient emailClient;
    int pos;
    Mascotas mascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detalle_catalogo);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         pos = getIntent().getExtras().getInt("pos");
         mascota = Data.mascotas.get(pos);

        binding.setMascota(mascota);
        binding.setHandler(this);

        client = App.retrofit.create(SeguimientoClient.class);
        emailClient = App.retrofit.create(EmailClient.class);
        preferences = getSharedPreferences(Preference.PREFERENCE_NAME, MODE_PRIVATE);

        Picasso.with(this).load(Uri.parse(mascota.getImagen())).into(binding.img);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }


    public void adoptar(){
        String _id = preferences.getString(Preference.KEY_ID, "");
        String email = preferences.getString(Preference.KEY_EMAIL, "");
        Email userEmail = new Email(_id, email);
        Call<SimpleResponse> request = emailClient.email(userEmail);
        request.enqueue(new retrofit2.Callback<SimpleResponse>() {
            @Override
            public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
                if(response.isSuccessful()){

                    AlertDialog.Builder builder = new AlertDialog.Builder(DetalleCatalogoActivity.this);

                    // set title
                    builder.setTitle(getString(R.string.title_adopcion) + mascota.getNombre() );

                    // set dialog message
                    builder
                            .setMessage(R.string.mensaje_adopcion)
                            .setCancelable(false)
                            .setPositiveButton(R.string.ok,new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = builder.create();
                    // show it
                    alertDialog.show();
                }
            }

            @Override
            public void onFailure(Call<SimpleResponse> call, Throwable t) {

            }
        });
    }

    public void apadrinar(){
        final int pos = getIntent().getExtras().getInt("pos");
        final Mascotas mascota = Data.mascotas.get(pos);
        String nombre = mascota.getNombre();
        String descripcion = mascota.getDescripcion();
        String imagen = mascota.getImagen();
        String id = preferences.getString(Preference.KEY_ID, "");
        String email = preferences.getString(Preference.KEY_EMAIL, "");

        Apadrinado.Apadrinante apadrinante = new Apadrinado.Apadrinante(id, email);

        final Apadrinado apadrinado = new Apadrinado(nombre, descripcion, imagen, apadrinante);

        Call<Apadrinado> request = client.verificar(id, mascota.getNombre());
        request.enqueue(new retrofit2.Callback<Apadrinado>() {
            @Override
            public void onResponse(Call<Apadrinado> call, Response<Apadrinado> response) {
                if(response.isSuccessful()){
                    int pos = getIntent().getExtras().getInt("pos");
                    Mascotas mascota = Data.mascotas.get(pos);
                    Toast.makeText(DetalleCatalogoActivity.this, getString(R.string.apadrinaado_existe)+ mascota.getNombre(), Toast.LENGTH_SHORT).show();
                }else{
                    Call<SimpleResponse> request = client.apadrinar(apadrinado);
                    request.enqueue(DetalleCatalogoActivity.this);
                }
            }
            @Override
            public void onFailure(Call<Apadrinado> call, Throwable t) {

            }
        });
    }

    @Override
    public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {

        Toast.makeText(this, getString(R.string.apadrinar_mascota) + mascota.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(Call<SimpleResponse> call, Throwable t) {

    }
}

