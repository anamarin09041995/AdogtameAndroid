package com.example.anitamarin.adogtame.fragments;


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
import com.example.anitamarin.adogtame.DetallePagoActivity;
import com.example.anitamarin.adogtame.R;
import com.example.anitamarin.adogtame.adapters.CatalogoAdapter;
import com.example.anitamarin.adogtame.adapters.DonacionesAdapter;
import com.example.anitamarin.adogtame.databinding.FragmentDonacionesBinding;
import com.example.anitamarin.adogtame.models.Fundaciones;
import com.example.anitamarin.adogtame.net.FundacionesClient;
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
public class DonacionesFragment extends Fragment implements DonacionesAdapter.onFundacionesListener {

    FragmentDonacionesBinding binding;
    DonacionesAdapter adapter;
    FundacionesClient client;

    public static DonacionesFragment instance() {
        return new DonacionesFragment();
    }

    public DonacionesFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_donaciones, container, false);
        adapter = new DonacionesAdapter(getLayoutInflater(null), new ArrayList<Fundaciones>(), this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        client = App.retrofit.create(FundacionesClient.class);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadFundaciones();
    }

    public void loadFundaciones(){
        Call<List<Fundaciones>> request = client.all();
        request.enqueue(new Callback<List<Fundaciones>>() {
            @Override
            public void onResponse(Call<List<Fundaciones>> call, Response<List<Fundaciones>> response) {
                if(response.isSuccessful()){
                    Data.fundaciones = response.body();
                    adapter.setData(Data.fundaciones);
                }
            }

            @Override
            public void onFailure(Call<List<Fundaciones>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onFundacionClick(int position) {
        Intent intent = new Intent(getActivity(), DetallePagoActivity.class);
        intent.putExtra("pos", position);
        startActivity(intent);
    }
}
