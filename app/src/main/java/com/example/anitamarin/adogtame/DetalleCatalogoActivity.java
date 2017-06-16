package com.example.anitamarin.adogtame;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.MenuItem;


import com.example.anitamarin.adogtame.databinding.ActivityDetalleCatalogoBinding;
import com.example.anitamarin.adogtame.models.Mascotas;
import com.example.anitamarin.adogtame.util.Data;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DetalleCatalogoActivity extends AppCompatActivity implements Callback {

    ActivityDetalleCatalogoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detalle_catalogo);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int pos = getIntent().getExtras().getInt("pos");
        Mascotas mascota = Data.mascotas.get(pos);

        binding.setMascota(mascota);

        Picasso.with(this).load(Uri.parse(mascota.getImagen())).into(binding.img, this);
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

        int colorDefault = ContextCompat.getColor(this, R.color.colorPrimary);
        int color = palette.getVibrantColor(colorDefault);
        binding.collapsingToolbar.setBackgroundColor(color);
    }
    @Override
    public void onError() {

    }

}

