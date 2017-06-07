package com.example.anitamarin.adogtame;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.MenuItem;

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int pos = getIntent().getExtras().getInt("pos");
        Fundaciones fundacion = Data.getFundaciones().get(pos);

        binding.setFundacion(fundacion);

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
}
