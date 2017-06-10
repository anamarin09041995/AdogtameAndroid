package com.example.anitamarin.adogtame;

import android.content.DialogInterface;
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
import com.example.anitamarin.adogtame.models.Fundaciones;
import com.example.anitamarin.adogtame.util.Data;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DetallePagoActivity extends AppCompatActivity implements Callback {


    ActivityDetallePagoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detalle_pago);

        int pos = getIntent().getExtras().getInt("pos");
        Fundaciones fundacion = Data.getFundaciones().get(pos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.setFundacion(fundacion);
        binding.setHandler(this);
        Picasso.with(this).load(Uri.parse(fundacion.getImagen())).into(binding.img, this);
        getSupportActionBar().setTitle(fundacion.getNombre());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSuccess() {
        BitmapDrawable drawable = (BitmapDrawable) binding.img.getDrawable();
        Palette palette = new Palette.Builder(drawable.getBitmap()).generate();
    }

    @Override
    public void onError() {

    }

    public void donar(){

        boolean alimento, implementos;
        String selected;
        selected = binding.spinner.getSelectedItem().toString();
        alimento = binding.checkAlimento.isChecked();
        implementos = binding.checkImplementos.isChecked();

        if(selected == null ||((alimento == false)&&(implementos == false))){
            Toast.makeText(this, "Por favor elija una opcion de destino y valor de donacion", Toast.LENGTH_SHORT).show();
        }

        else{

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.confirmacion );

            builder
                    .setMessage("Va a donar " + selected + " destinados a " +(alimento ? "alimento " : " ") + (implementos ? "e implementos de salud" : ""))
                    .setCancelable(false)
                    .setPositiveButton(R.string.confirmar,new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
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
