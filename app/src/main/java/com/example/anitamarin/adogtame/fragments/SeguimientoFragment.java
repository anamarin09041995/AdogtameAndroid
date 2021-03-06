package com.example.anitamarin.adogtame.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.PermissionChecker;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anitamarin.adogtame.App;
import com.example.anitamarin.adogtame.R;
import com.example.anitamarin.adogtame.adapters.SeguimientoAdapter;
import com.example.anitamarin.adogtame.databinding.FragmentSeguimientoBinding;
import com.example.anitamarin.adogtame.models.Mascotas;
import com.example.anitamarin.adogtame.models.MascotasDao;
import com.example.anitamarin.adogtame.models.Users;
import com.example.anitamarin.adogtame.net.SeguimientoClient;
import com.example.anitamarin.adogtame.util.Data;
import com.example.anitamarin.adogtame.util.Preference;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeguimientoFragment extends Fragment implements SeguimientoAdapter.onMascotasListener {

    SeguimientoAdapter adapter;
    FragmentSeguimientoBinding binding;
    MascotasDao dao;
    SeguimientoClient client;
    SharedPreferences preferences;
    boolean apadrinado = false;

    public static SeguimientoFragment instance() {
        return new SeguimientoFragment();
    }


    public SeguimientoFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getActivity().getSharedPreferences(Preference.PREFERENCE_NAME, Activity.MODE_PRIVATE);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_seguimiento, container, false);
        adapter = new SeguimientoAdapter(getLayoutInflater(null), Data.mascotas, this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        dao = App.session.getMascotasDao();

        client = App.retrofit.create(SeguimientoClient.class);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadSeguimiento();
    }

    public void loadSeguimiento(){
        String userId = preferences.getString(Preference.KEY_ID, "");
        Call<List<Mascotas>> request = client.all(userId);
        request.enqueue(new Callback<List<Mascotas>>() {
            @Override
            public void onResponse(Call<List<Mascotas>> call, Response<List<Mascotas>> response) {
                if(response.isSuccessful()){
                    Data.seguimiento = response.body();
                    adapter.setData(Data.seguimiento);
                }
            }

            @Override
            public void onFailure(Call<List<Mascotas>> call, Throwable t) {

            }
        });

    }

    /*@Override
    public void onResume() {
        super.onResume();
        List<Mascotas> data = dao.loadAll();
        adapter.setData(data);
    }*/

    @Override
    public void onMascotasClick(int position) {

    }
}
