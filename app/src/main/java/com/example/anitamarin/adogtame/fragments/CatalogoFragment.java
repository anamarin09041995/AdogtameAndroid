package com.example.anitamarin.adogtame.fragments;


import android.app.Application;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anitamarin.adogtame.App;
import com.example.anitamarin.adogtame.DetalleCatalogoActivity;
import com.example.anitamarin.adogtame.R;
import com.example.anitamarin.adogtame.adapters.CatalogoAdapter;
import com.example.anitamarin.adogtame.databinding.FragmentCatalogoBinding;
import com.example.anitamarin.adogtame.models.Mascotas;
import com.example.anitamarin.adogtame.net.MascotasClient;
import com.example.anitamarin.adogtame.util.Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatalogoFragment extends Fragment implements CatalogoAdapter.onMascotasListener {

    FragmentCatalogoBinding binding;
    CatalogoAdapter adapter;
    MascotasClient client;

    public static CatalogoFragment instance() {
        return new CatalogoFragment();
    }

    public CatalogoFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_catalogo, container, false);
        //adapter = new CatalogoAdapter(getLayoutInflater(null), Data.getMascotas(), this);
        adapter = new CatalogoAdapter(getLayoutInflater(null), new ArrayList<Mascotas>(), this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        client = App.retrofit.create(MascotasClient.class);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadMascotas();
    }

    private void loadMascotas(){
        Call<List<Mascotas>> request = client.all();
        request.enqueue(new Callback<List<Mascotas>>() {
            @Override
            public void onResponse(Call<List<Mascotas>> call, Response<List<Mascotas>> response) {
                if(response.isSuccessful()){
                    List<Mascotas> data = response.body();
                    adapter.setData(data);
                }
            }

            @Override
            public void onFailure(Call<List<Mascotas>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onMascotasClick(int position) {
        Intent intent = new Intent(getActivity(), DetalleCatalogoActivity.class);
        intent.putExtra("pos", position);
        startActivity(intent);
    }

}
