package com.example.anitamarin.adogtame;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.anitamarin.adogtame.databinding.ActivityDetallePagoBinding;
import com.example.anitamarin.adogtame.fragments.CatalogoFragment;
import com.example.anitamarin.adogtame.fragments.SeguimientoFragment;
import com.example.anitamarin.adogtame.models.Donaciones;
import com.example.anitamarin.adogtame.models.Fundaciones;
import com.example.anitamarin.adogtame.net.DonacionesClient;
import com.example.anitamarin.adogtame.net.SimpleResponse;
import com.example.anitamarin.adogtame.util.Data;
import com.example.anitamarin.adogtame.util.Preference;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Response;

public class DetallePagoActivity extends AppCompatActivity  {


    ActivityDetallePagoBinding binding;
    DonacionesClient client;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detalle_pago);

        int pos = getIntent().getExtras().getInt("pos");
        Fundaciones fundacion = Data.fundaciones.get(pos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.setFundacion(fundacion);
        binding.setHandler(this);
        Picasso.with(this).load(Uri.parse(fundacion.getImagen())).into(binding.img);
        getSupportActionBar().setTitle(fundacion.getNombre());

        preferences = getSharedPreferences(Preference.PREFERENCE_NAME, MODE_PRIVATE);
        client = App.retrofit.create(DonacionesClient.class);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    public void donar(){

        boolean alimento, salud;
        String value;
        value = binding.spinner.getSelectedItem().toString();
        alimento = binding.checkAlimento.isChecked();
        salud = binding.checkImplementos.isChecked();

        if(value == null ||((alimento == false)&&(salud == false))){
            Toast.makeText(this, R.string.validacion_donacion, Toast.LENGTH_SHORT).show();
        }

        else{

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.confirmacion );

            builder
                    .setMessage("Va a donar " + value + " destinados a " +(alimento ? "alimento " : " ") + (salud ? "e implementos de salud" : ""))
                    .setCancelable(false)
                    .setPositiveButton(R.string.confirmar,new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            String selected = binding.spinner.getSelectedItem().toString();
                            boolean alimento = binding.checkAlimento.isChecked();
                            boolean salud = binding.checkAlimento.isChecked();
                            String _id = preferences.getString(Preference.KEY_ID, "");
                            Donaciones donar = new Donaciones(selected, _id, alimento, salud);
                            Call<SimpleResponse> request = client.donar(donar);
                            request.enqueue(new retrofit2.Callback<SimpleResponse>()
                            {
                                @Override
                                public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {

                                }

                                @Override
                                public void onFailure(Call<SimpleResponse> call, Throwable t) {

                                }
                            });
                        }
                    })
                    .setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}
